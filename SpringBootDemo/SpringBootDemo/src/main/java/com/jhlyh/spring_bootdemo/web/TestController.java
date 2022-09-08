package com.jhlyh.spring_bootdemo.web;


import com.jhlyh.spring_bootdemo.domainResources.IngredientResource;
import com.jhlyh.spring_bootdemo.domainResources.assembler.IngredientResourceAssembler;
import com.jhlyh.spring_bootdemo.entity.Ingredient;
import com.jhlyh.spring_bootdemo.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


/**
 * @author jhlyh
 */
@RestController
@RequestMapping("/test")
public class TestController {

    IngredientRepository ingredientRepository;

    @Autowired
    public TestController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping
    public EntityModel<Optional<Ingredient>> test() {
        Optional<Ingredient> employee = ingredientRepository.findById(1);

        return EntityModel.of(employee,
                linkTo(methodOn(TestController.class).test()).withSelfRel());
    }

    @PostMapping
    public CollectionModel<EntityModel<Ingredient>> test2() {
       List<Ingredient> ingredients = (List<Ingredient>) ingredientRepository.findAll();
        CollectionModel<EntityModel<Ingredient>> resources = CollectionModel.wrap(ingredients);

        return CollectionModel.of(resources,
                linkTo(methodOn(TestController.class).test2()).withSelfRel());
    }
    @GetMapping("/test")
    public CollectionModel<IngredientResource> ingredients () {
        List<Ingredient> ingredients = (List<Ingredient>) ingredientRepository.findAll();
        CollectionModel<IngredientResource> ingredientResources =
                new IngredientResourceAssembler(TestController.class,IngredientResource.class).toCollectionModel(ingredients);
        ingredientResources.add(linkTo(methodOn(TestController.class).ingredients()).withSelfRel());
        return ingredientResources;
    }



}
