package by.lovify.constructor.service.attacher.connector;

import by.lovify.constructor.model.constructor.CharacterBuilderContext;
import by.lovify.constructor.model.constructor.part.CharacterPart;
import org.w3c.dom.Element;

import java.util.Optional;

public interface ConnectorResolver {

    Optional<Element> resolveConnector(CharacterPart part, String connectorId, CharacterBuilderContext context);

}
