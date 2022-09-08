package com.jhlyh.spring_bootdemo.web;

import com.jhlyh.spring_bootdemo.entity.Ingredient;
import com.jhlyh.spring_bootdemo.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Optional;

/**
 * @author jhlyh
 */
@RestController
@RequestMapping("/taco")
public class IngredientController {

    IngredientRepository ingredientRepository;

    @Autowired
    public IngredientController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping
    public Optional<Ingredient> get() {
        return ingredientRepository.findById(1);
    }
}
