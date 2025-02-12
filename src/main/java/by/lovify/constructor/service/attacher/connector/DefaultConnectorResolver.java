package by.lovify.constructor.service.attacher.connector;

import by.lovify.constructor.model.constructor.CharacterBuilderContext;
import by.lovify.constructor.model.constructor.part.CharacterPart;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.w3c.dom.Element;

import java.util.Optional;

/**
 * The default implementation of {@link ConnectorResolver}. It resolves connectors for the given part and context by
 * looking up the connector element in the part's SVG document by its id.
 *
 * @see ConnectorResolver
 */
@Slf4j
@Primary
@Component
public class DefaultConnectorResolver implements ConnectorResolver {


    /**
     * Resolves connector for the given part and context. If connector exists, {@link Optional} with connector element
     * is returned, otherwise empty {@link Optional}.
     *
     * @param part        the part to which the connector belongs
     * @param connectorId the id of the connector
     * @param context     the context in which the connector is resolved
     * @return {@link Optional} with connector element or empty {@link Optional}
     */
    @Override
    public Optional<Element> resolveConnector(CharacterPart part, String connectorId, CharacterBuilderContext context) {
        Element connector = part.svg().getElementById(connectorId);
        if (connector == null) {
            logger.error("Connector {} not found in part {}", connectorId, part);
        }
        return Optional.ofNullable(connector);
    }
}
