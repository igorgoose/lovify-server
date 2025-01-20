package by.lovify.model.constructor;

import by.lovify.model.CharacterVisualConfig;
import by.lovify.model.constructor.part.CharacterPart;
import by.lovify.service.constructor.attacher.CharacterPartAttacher;
import by.lovify.util.CharacterBuilderUtils;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import java.util.List;
import java.util.function.Consumer;

/**
 * Holds visual config({@link CharacterBuilderContext#visualConfig}) for building character parts and manages the order
 * of attachers' invocation({@link CharacterBuilderContext#onPartAttached(AttachedPart)}.
 * <p>
 * Attachers which need a specific anchor are invoked upon attaching a part which contains the anchor.
 */
@Slf4j
@RequiredArgsConstructor
public class CharacterBuilderContext {

    private final ArrayListValuedHashMap<String, Consumer<Anchor>> deferredAttachers =
            new ArrayListValuedHashMap<>();
    @Getter
    private final CharacterVisualConfig visualConfig;

    public <DP extends CharacterPart> void registerAttachers(
            AttachedPart<DP> attachedPart,
            List<CharacterPartAttacher<?, DP>> attachers
    ) {
        for (CharacterPartAttacher<?, DP> attacher : attachers) {
            deferredAttachers.put(
                    attacher.getAnchorId(),
                    anchor -> attacher.attach(attachedPart, anchor, this)
            );
        }
    }

    /**
     * Finds anchors of the attached part and invokes all the attachers waiting for the
     * anchor({@link CharacterBuilderContext#deferredAttachers}).
     *
     * @param attachedPart the attached part
     * @param <T>          type of the attached part
     */
    public <T extends CharacterPart> void onPartAttached(AttachedPart<T> attachedPart) {
        CharacterBuilderUtils
                .findAnchors(attachedPart)
                .forEach(this::triggerAttachers);
    }

    private void triggerAttachers(Anchor anchor) {
        logger.debug("Anchor added {}. Triggering attachers", anchor);

        deferredAttachers.get(anchor.id()).forEach(it -> it.accept(anchor));
    }
}
