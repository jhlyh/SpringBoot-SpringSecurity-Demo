package com.jhlyh.spring_bootdemo.domainResources.assembler;

import com.jhlyh.spring_bootdemo.domainResources.IngredientResource;
import com.jhlyh.spring_bootdemo.entity.Ingredient;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

/**
 * @author jhlyh
 */
public class IngredientResourceAssembler extends RepresentationModelAssemblerSupport<Ingredient, IngredientResource> {
    public IngredientResourceAssembler(Class<?> controllerClass, Class<IngredientResource> resourceType) {
        super(controllerClass, resourceType);
    }

    @Override
    protected IngredientResource instantiateModel(Ingredient entity) {
        return new IngredientResource(entity);
    }

    @Override
    public IngredientResource toModel(Ingredient entity) {
        return createModelWithId(entity.getId(),entity);
    }
}
