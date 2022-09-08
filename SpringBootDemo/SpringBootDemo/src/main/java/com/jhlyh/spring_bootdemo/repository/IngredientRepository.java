package com.jhlyh.spring_bootdemo.repository;

import com.jhlyh.spring_bootdemo.entity.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author jhlyh
 */
public interface IngredientRepository extends CrudRepository<Ingredient,Integer>{
}
