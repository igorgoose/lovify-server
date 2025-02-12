package by.lovify.constructor.service.attacher.connector;

import by.lovify.constructor.model.constructor.CharacterBuilderContext;
import by.lovify.constructor.model.constructor.part.CharacterPart;
import by.lovify.constructor.model.constructor.part.Mustache;
import by.lovify.constructor.util.XPathUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.w3c.dom.Element;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import java.util.Optional;


/**
 * The {@code MustacheConnectorResolver} class is responsible for resolving connectors
 * for mustache parts in a character's SVG document based on the specified context.
 *
 * <p>This class implements the {@link ConnectorResolver} interface, providing
 * methods to look up connector elements by their IDs and mouth expressions.
 * The resolution process involves checking for connectors with specific mouth
 * expression classes and defaults to a connector with a 'mouth-expression-none' class
 * if no specific expression is found.
 *
 * <p>It uses XPath expressions to locate these connector elements within the SVG.
 *
 * <p>This class is annotated with {@code @Component} to be managed by the Spring
 * framework as a bean.
 *
 * <p>Logging is facilitated by the {@link Slf4j} annotation for debugging purposes.
 */
@Slf4j
@Component
public class MustacheConnectorResolver implements ConnectorResolver {

    private static final String CONNECTOR_XPATH_EXPRESSION_TEMPLATE =
        "./*[name() = 'circle' and @id='%s' and contains(@class, 'variant-mouth-%s')]";
    private static final String DEFAULT_CONNECTOR_XPATH_EXPRESSION_TEMPLATE =
        "./*[name() = 'circle' and @id='%s' and contains(@class, 'variant-mouth-mouth-expression-none')]";


    /**
     * Resolves the connector for the given part and context by looking up the connector element in the part's SVG
     * document by its id.
     * <p>
     * The method first looks up the connector element with the given id and that contains the mouth expression class.
     * If such an element is found, it is returned. If not, the method looks up the default connector element with the
     * given id and that contains the class of the default mouth expression (mouth-expression-none).
     * <p>
     * If both lookups fail, the method returns an empty optional.
     *
     * @param part      the part to resolve the connector for
     * @param connectorId the id of the connector to resolve
     * @param context   the context of the character builder
     * @return an optional containing the resolved connector element
     */
    @Override
    public Optional<Element> resolveConnector(CharacterPart part, String connectorId, CharacterBuilderContext context) {
        if (!(part instanceof Mustache mustache)) {
            throw new IllegalStateException("Mustache connector can only be resolved for Mustache");
        }
        XPathExpression connectorXPathExpression = XPathUtils.initXPathExpression(
            CONNECTOR_XPATH_EXPRESSION_TEMPLATE.formatted(connectorId, context.getVisualConfig().mouth().getId())
        );
        try {
            Element connector = (Element) connectorXPathExpression.evaluate(mustache.svg(), XPathConstants.NODE);
            if (connector != null) {
                return Optional.of(connector);
            }

            logger.debug(
                "Connector for mouth expression {} not found(mustache={})",
                context.getVisualConfig().mouth(),
                context.getVisualConfig().mustache()
            );

            XPathExpression defaultConnectorXPathExpression = XPathUtils.initXPathExpression(
                DEFAULT_CONNECTOR_XPATH_EXPRESSION_TEMPLATE.formatted(connectorId)
            );
            Element defaultConnector =
                (Element) defaultConnectorXPathExpression.evaluate(mustache.svg(), XPathConstants.NODE);
            if (defaultConnector == null) {
                logger.error(
                    "Default connector for mouth expression {} not found(mustache={})",
                    context.getVisualConfig().mouth(),
                    context.getVisualConfig().mustache()
                );
            }

            return Optional.ofNullable(defaultConnector);
        } catch (XPathExpressionException e) {
            throw new IllegalStateException("Error while finding connector with id %s".formatted(connectorId), e);
        }
    }
}
