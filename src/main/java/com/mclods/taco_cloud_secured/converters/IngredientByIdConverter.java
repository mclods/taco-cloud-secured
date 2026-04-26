package com.mclods.taco_cloud_secured.converters;

import com.mclods.taco_cloud_secured.entities.Ingredient;
import com.mclods.taco_cloud_secured.services.IngredientService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    private final IngredientService ingredientService;

    public IngredientByIdConverter(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientService.findIngredientById(id).orElse(null);
    }
}
