package com.example.recipico;

import com.example.recipico.model.*;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTest {

    @Test
    void addRecipeIngredient_ShouldAddRecipeIngredientToSet() {
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientId(1L);
        ingredient.setIngredientName("Salt");

        Recipe recipe = new Recipe();
        recipe.setRecipeId(1L);
        recipe.setRecipeName("Chicken Soup");

        RecipeIngredient recipeIngredient = new RecipeIngredient(recipe, ingredient, 1.0, "teaspoon");

        ingredient.addRecipeIngredient(recipeIngredient);

        Set<RecipeIngredient> expectedRecipeIngredients = new HashSet<>();
        expectedRecipeIngredients.add(recipeIngredient);

        Set<RecipeIngredient> actualRecipeIngredients = ingredient.getRecipeIngredients();
        assertEquals(expectedRecipeIngredients, actualRecipeIngredients);
    }

    @Test
    void removeRecipeIngredient_ShouldRemoveRecipeIngredientFromSet() {
        // Create an ingredient
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientId(1L);
        ingredient.setIngredientName("Salt");

        // Create a recipe
        Recipe recipe = new Recipe();
        recipe.setRecipeId(1L);
        recipe.setRecipeName("Chicken Soup");

        // Create a recipe ingredient
        RecipeIngredient recipeIngredient = new RecipeIngredient(recipe, ingredient, 1.0, "teaspoon");

        // Add the recipe ingredient to the ingredient
        ingredient.addRecipeIngredient(recipeIngredient);

        // Remove the recipe ingredient from the ingredient
        ingredient.removeRecipeIngredient(recipeIngredient);

        // Verify that the recipe ingredient is removed from the ingredient's recipe ingredient set
        Set<RecipeIngredient> expectedRecipeIngredients = new HashSet<>();

        Set<RecipeIngredient> actualRecipeIngredients = ingredient.getRecipeIngredients();
        assertEquals(expectedRecipeIngredients, actualRecipeIngredients);
    }
}
