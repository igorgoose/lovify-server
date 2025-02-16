package by.lovify.constructor.service.builder;

import by.lovify.constructor.model.constructor.AttachedPart;
import by.lovify.constructor.model.constructor.CharacterBuilderContext;

public interface InitialPartBuilder {

    AttachedPart<?> buildInitialPart(CharacterBuilderContext context);

}
