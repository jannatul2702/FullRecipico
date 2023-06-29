package com.example.recipico;

import com.example.recipico.model.*;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    @Test
    void addRecipeCategory_ShouldAddCategoryToRecipe() {
        Category category = new Category(RecipeCategory.MAIN_DISH);
        Recipe recipe = new Recipe();
        
        category.addRecipeCategory(recipe);

        assertTrue(category.getRecipes().contains(recipe));
        assertTrue(recipe.getRecipeCategories().contains(category));
    }

    @Test
    void removeRecipeCategory_ShouldRemoveCategoryFromRecipe() {
        Category category = new Category(RecipeCategory.APPETIZER_AND_SNACK);
        Recipe recipe = new Recipe();

        category.addRecipeCategory(recipe);
        category.removeRecipeCategory(recipe);

        assertFalse(category.getRecipes().contains(recipe));
        assertFalse(recipe.getRecipeCategories().contains(category));
    }

    @Test
    void equals_ShouldReturnTrueIfCategoriesAreEqual() {
        Category category1 = new Category(1L, RecipeCategory.DESSERT);
        Category category2 = new Category(1L, RecipeCategory.DESSERT);

        assertTrue(category1.equals(category2));
    }

    @Test
    void equals_ShouldReturnFalseIfCategoriesAreNotEqual() {
        Category category1 = new Category(1L, RecipeCategory.APPETIZER_AND_SNACK);
        Category category2 = new Category(2L, RecipeCategory.DESSERT);

        assertFalse(category1.equals(category2));
    }

    @Test
    void hashCode_ShouldReturnSameHashCodeForEqualCategories() {
        Category category1 = new Category(1L, RecipeCategory.BREAKFAST_AND_BRUNCH);
        Category category2 = new Category(1L, RecipeCategory.BREAKFAST_AND_BRUNCH);

        assertEquals(category1.hashCode(), category2.hashCode());
    }

    @Test
    void hashCode_ShouldReturnDifferentHashCodeForDifferentCategories() {
        Category category1 = new Category(1L, RecipeCategory.BREAKFAST_AND_BRUNCH);
        Category category2 = new Category(2L, RecipeCategory.DRINKS);

        assertNotEquals(category1.hashCode(), category2.hashCode());
    }
}

