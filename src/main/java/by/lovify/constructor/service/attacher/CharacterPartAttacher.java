package by.lovify.constructor.service.attacher;

import by.lovify.constructor.model.constructor.Anchor;
import by.lovify.constructor.model.constructor.AttachedPart;
import by.lovify.constructor.model.constructor.CharacterBuilderContext;
import by.lovify.constructor.model.constructor.OpenSvgTransform;
import by.lovify.constructor.model.constructor.part.CharacterPart;
import by.lovify.constructor.service.attacher.connector.ConnectorResolver;
import by.lovify.constructor.service.attacher.positioner.CharacterPartPositioner;
import by.lovify.constructor.service.attacher.positioner.CharacterPartPositioner.Context;
import by.lovify.constructor.service.builder.CharacterPartBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.batik.anim.dom.SVGOMCircleElement;
import org.apache.batik.anim.dom.SVGOMGElement;
import org.apache.batik.util.SVGConstants;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGSVGElement;

import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static by.lovify.constructor.constant.CharacterBuilderConstants.EPSILON;
import static by.lovify.constructor.util.CharacterBuilderUtils.*;
import static java.lang.Math.abs;

/**
 * Attaches source part to destination part. Source part's coordinates are calculated by aligning source part's
 * connector with destination part's anchor.
 *
 * @param <P>  type of the attached(source) part
 * @param <DP> type of the base(destination) part
 */
@Slf4j
@RequiredArgsConstructor
public abstract class CharacterPartAttacher<P extends CharacterPart, DP extends CharacterPart> {

    protected final CharacterPartBuilder<P> partBuilder;
    protected final List<CharacterPartAttacher<?, P>> attachers;
    protected final CharacterPartPositioner characterPartPositioner;
    protected final ConnectorResolver connectorResolver;

    /**
     * @param destinationPart part to attach source part to
     * @param anchor          anchor element to align source part's connector with
     * @param context         builder context
     */
    public void attach(AttachedPart<DP> destinationPart, Anchor anchor, CharacterBuilderContext context) {
        // calculate absolute position of connector element in destination part's coordinate system
        // calculate difference between that and anchor's position
        // insert part into destination part and apply transformations
        logger.debug(
            "{}: attaching part to destinationPart={}, anchor={}",
            getClass().getSimpleName(),
            destinationPart,
            anchor
        );

        P part = partBuilder.build(context);
        AttachedPart<P> attachedPart = doAttach(part, destinationPart, anchor, context);
        context.registerAttachers(attachedPart, attachers);
        context.onPartAttached(attachedPart);
    }

    public abstract String getAnchorId();

    protected abstract String getConnectorId();

    protected abstract String getDestinationGroupId();

    protected AttachedPart<P> doAttach(
        P part,
        AttachedPart<DP> destinationPart,
        Anchor anchor,
        CharacterBuilderContext context
    ) {
        SVGSVGElement sourceSvg = part.svg();
        SVGSVGElement destinationSvg = destinationPart.part().svg();
        Document destinationDocument = destinationSvg.getOwnerDocument();

        String destinationGroupId = getDestinationGroupId();

        SVGSVGElement importedSvg = (SVGSVGElement) destinationDocument.importNode(sourceSvg, true);
        SVGOMGElement destinationGroup = findOrCreateDestinationGroup(destinationSvg, destinationGroupId, anchor);
        destinationGroup.appendChild(importedSvg);

        Element connector = connectorResolver.resolveConnector(part, getConnectorId(), context)
            .orElseThrow(() -> new IllegalStateException("Failed to resolve connector for part " + part));
        List<OpenSvgTransform> transforms = calculateTransforms(part, connector, destinationPart.transform(), anchor);
        transforms.forEach(it -> destinationGroup.getTransform().getBaseVal().appendItem(it));

        AffineTransform newAffineTransform = calculateNewAffineTransform(destinationPart.transform(), transforms);

        return new AttachedPart<>(partBuilder.wrap(importedSvg, Optional.of(part)), newAffineTransform);
    }

    protected SVGOMGElement findOrCreateDestinationGroup(
        SVGSVGElement destinationSvg,
        String groupId,
        Anchor anchor
    ) {
        return findGroupById(destinationSvg, groupId)
            .orElseGet(() -> {
                Element g = destinationSvg.getOwnerDocument().createElementNS(SVGConstants.SVG_NAMESPACE_URI, "g");
                g.setAttribute("id", groupId);

                Context positioningContext = new Context(destinationSvg, anchor);
                characterPartPositioner.positionElement(g, positioningContext);

                return (SVGOMGElement) g;
            });
    }

    protected List<OpenSvgTransform> calculateTransforms(
        P part,
        Element connectorElement,
        AffineTransform parentTransform,
        Anchor targetMarker
    ) {
        SVGOMCircleElement sourceMarker = validatePositionMarker(connectorElement);

        float targetSize = targetMarker.size();
        float targetX = (float) targetMarker.coordinates().getX();
        float targetY = (float) targetMarker.coordinates().getY();

        float srcSize = sourceMarker.getR().getBaseVal().getValue();
        float srcX = sourceMarker.getCx().getBaseVal().getValue();
        float srcY = sourceMarker.getCy().getBaseVal().getValue();

        AffineTransform fullSourcePartTransform = part.initialTransform()
            .map(it -> {
                AffineTransform combinedTransform = new AffineTransform(parentTransform);
                combinedTransform.concatenate(it);
                return combinedTransform;
            })
            .orElse(parentTransform);

        Point2D newSrcPoint = new Point2D.Float(srcX, srcY);
        Point2D originalSrcPoint = fullSourcePartTransform.transform(newSrcPoint, null);

        float originalSrcSize = (float) calculateOriginalSize(srcSize, parentTransform);
        float originalSrcX = (float) originalSrcPoint.getX();
        float originalSrcY = (float) originalSrcPoint.getY();

        ArrayList<OpenSvgTransform> transforms = new ArrayList<>();

        if (abs(targetSize - originalSrcSize) > EPSILON) {
            // todo check radii != 0
            OpenSvgTransform transform = new OpenSvgTransform();
            float scale = targetSize / originalSrcSize;
            transform.setScale(scale, scale);
            transforms.add(transform);

            targetY /= scale;
            targetX /= scale;
        }

        if (abs(targetX - originalSrcX) > EPSILON || abs(targetY - originalSrcY) > EPSILON) {
            OpenSvgTransform transform = new OpenSvgTransform();
            transform.setTranslate(targetX - originalSrcX, targetY - originalSrcY);
            transforms.add(transform);
        }

        return transforms;
    }

    protected static SVGOMCircleElement validatePositionMarker(Element marker) {
        if (marker instanceof SVGOMCircleElement circleElement) {
            return circleElement;
        }
        throw new IllegalArgumentException(
            "Element %s is not SVGOMCircleElement, hence not a valid position marker".formatted(marker)
        );
    }
}
