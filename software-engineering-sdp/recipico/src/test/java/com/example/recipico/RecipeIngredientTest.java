package com.example.recipico;
import com.example.recipico.model.Recipe;
import com.example.recipico.model.RecipeIngredient;
import com.example.recipico.model.RecipeIngredientId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class RecipeIngredientTest {

    @Test
    void equals_ShouldReturnTrueForEqualObjects() {
        RecipeIngredientId id1 = new RecipeIngredientId(1L, 2L);
        RecipeIngredientId id2 = new RecipeIngredientId(1L, 2L);
        Recipe recipe = new Recipe();
        RecipeIngredient ingredient1 = new RecipeIngredient(recipe, null, 1.0, "unit");
        RecipeIngredient ingredient2 = new RecipeIngredient(recipe, null, 1.0, "unit");

        ingredient1.setRecipeIngredientId(id1);
        ingredient2.setRecipeIngredientId(id2);

        assertEquals(ingredient1, ingredient2);
    }

    @Test
    void equals_ShouldReturnFalseForDifferentObjects() {
        RecipeIngredientId id1 = new RecipeIngredientId(1L, 2L);
        RecipeIngredientId id2 = new RecipeIngredientId(3L, 4L);
        Recipe recipe = new Recipe();
        RecipeIngredient ingredient1 = new RecipeIngredient(recipe, null, 1.0, "unit");
        RecipeIngredient ingredient2 = new RecipeIngredient(recipe, null, 1.0, "unit");

        ingredient1.setRecipeIngredientId(id1);
        ingredient2.setRecipeIngredientId(id2);

        assertNotEquals(ingredient1, ingredient2);
    }

    @Test
    void hashCode_ShouldReturnSameValueForEqualObjects() {
        RecipeIngredientId id1 = new RecipeIngredientId(1L, 2L);
        RecipeIngredientId id2 = new RecipeIngredientId(1L, 2L);
        Recipe recipe = new Recipe();
        RecipeIngredient ingredient1 = new RecipeIngredient(recipe, null, 1.0, "unit");
        RecipeIngredient ingredient2 = new RecipeIngredient(recipe, null, 1.0, "unit");

        ingredient1.setRecipeIngredientId(id1);
        ingredient2.setRecipeIngredientId(id2);

        assertEquals(ingredient1.hashCode(), ingredient2.hashCode());
    }

    @Test
    void hashCode_ShouldReturnDifferentValueForDifferentObjects() {
        RecipeIngredientId id1 = new RecipeIngredientId(1L, 2L);
        RecipeIngredientId id2 = new RecipeIngredientId(3L, 4L);
        Recipe recipe = new Recipe();
        RecipeIngredient ingredient1 = new RecipeIngredient(recipe, null, 1.0, "unit");
        RecipeIngredient ingredient2 = new RecipeIngredient(recipe, null, 1.0, "unit");

        ingredient1.setRecipeIngredientId(id1);
        ingredient2.setRecipeIngredientId(id2);

        assertNotEquals(ingredient1.hashCode(), ingredient2.hashCode());
    }
}
