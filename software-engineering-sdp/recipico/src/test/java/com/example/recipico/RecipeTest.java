package com.example.recipico;

import com.example.recipico.model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {

    @Test
    void addRecipeIngredient_ShouldAddIngredientToList() {
        Recipe recipe = new Recipe();

        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientId(1L);
        ingredient.setIngredientName("Salt");

        RecipeIngredient recipeIngredient = new RecipeIngredient(recipe, ingredient, 1.0, "teaspoon");

        recipe.addRecipeIngredient(recipeIngredient);

        List<RecipeIngredient> expectedIngredients = new ArrayList<>(Arrays.asList(recipeIngredient));
        List<RecipeIngredient> actualIngredients = recipe.getRecipeIngredients();
        assertEquals(expectedIngredients, actualIngredients);
    }

    @Test
    void removeRecipeIngredient_ShouldRemoveIngredientFromList() {
        Recipe recipe = new Recipe();

        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientId(1L);
        ingredient.setIngredientName("Salt");

        RecipeIngredient recipeIngredient = new RecipeIngredient(recipe, ingredient, 1.0, "teaspoon");

        recipe.addRecipeIngredient(recipeIngredient);

        recipe.removeRecipeIngredient(recipeIngredient);

        List<RecipeIngredient> expectedIngredients = new ArrayList<>();
        List<RecipeIngredient> actualIngredients = recipe.getRecipeIngredients();
        assertEquals(expectedIngredients, actualIngredients);
    }

    @Test
    void equals_ShouldReturnTrueForEqualRecipes() {
        Recipe recipe1 = new Recipe(1L, "Recipe 1", "Description 1", 10, 30, 4, Difficulty.EASY, RecipeType.DEFAULT, "image1.jpg");
        Recipe recipe2 = new Recipe(1L, "Recipe 1", "Description 1", 10, 30, 4, Difficulty.EASY, RecipeType.DEFAULT, "image1.jpg");
        assertEquals(recipe1, recipe2);
    }

    @Test
    void equals_ShouldReturnFalseForDifferentRecipes() {
        Recipe recipe1 = new Recipe(1L, "Recipe 1", "Description 1", 10, 30, 4, Difficulty.EASY, RecipeType.DEFAULT, "image1.jpg");
        Recipe recipe2 = new Recipe(2L, "Recipe 2", "Description 2", 15, 40, 2, Difficulty.MODERATE, RecipeType.VEGETARIAN, "image2.jpg");
        assertNotEquals(recipe1, recipe2);
    }

    @Test
    void hashCode_ShouldReturnSameValueForEqualRecipes() {
        Recipe recipe1 = new Recipe(1L, "Recipe 1", "Description 1", 10, 30, 4, Difficulty.EASY, RecipeType.DEFAULT, "image1.jpg");
        Recipe recipe2 = new Recipe(1L, "Recipe 1", "Description 1", 10, 30, 4, Difficulty.EASY, RecipeType.DEFAULT, "image1.jpg");
        assertEquals(recipe1.hashCode(), recipe2.hashCode());
    }
}
