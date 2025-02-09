package by.lovify.service.constructor.builder;

import by.lovify.model.constructor.AttachedPart;
import by.lovify.model.constructor.CharacterBuilderContext;

public interface InitialPartBuilder {

    AttachedPart<?> buildInitialPart(CharacterBuilderContext context);

}
