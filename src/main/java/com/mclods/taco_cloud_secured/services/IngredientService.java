package com.mclods.taco_cloud_secured.services;

import com.mclods.taco_cloud_secured.entities.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientService {
    List<Ingredient> findAllIngredients();

    Optional<Ingredient> findIngredientById(String id);
}
