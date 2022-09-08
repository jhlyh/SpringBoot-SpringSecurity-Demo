package com.jhlyh.spring_bootdemo.domainResources;

import com.jhlyh.spring_bootdemo.entity.Ingredient;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

/**
 * @author jhlyh
 */
@Data
@Relation(value = "ingredient",collectionRelation = "ingredients")
public class IngredientResource extends RepresentationModel<IngredientResource> {
    private final String name;


    public IngredientResource(Ingredient ingredient) {
        this.name = ingredient.getName();
    }
}
