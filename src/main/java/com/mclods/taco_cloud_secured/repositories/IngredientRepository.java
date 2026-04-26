package com.mclods.taco_cloud_secured.repositories;

import com.mclods.taco_cloud_secured.entities.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
