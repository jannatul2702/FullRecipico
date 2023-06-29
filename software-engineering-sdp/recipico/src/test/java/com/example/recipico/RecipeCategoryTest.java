package com.example.recipico;

import com.example.recipico.model.RecipeCategory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class RecipeCategoryTest {

    @Test
    void getCategoryName_ShouldReturnCorrectName() {
        RecipeCategory category = RecipeCategory.APPETIZER_AND_SNACK;
        assertEquals("Appetizer and Snack", category.getCategoryName());
    }

    @Test
    void equals_ShouldReturnTrueForEqualCategories() {
        RecipeCategory category1 = RecipeCategory.MAIN_DISH;
        RecipeCategory category2 = RecipeCategory.MAIN_DISH;
        assertEquals(category1, category2);
    }

    @Test
    void equals_ShouldReturnFalseForDifferentCategories() {
        RecipeCategory category1 = RecipeCategory.SALAD;
        RecipeCategory category2 = RecipeCategory.SOUP;
        assertNotEquals(category1, category2);
    }

    @Test
    void hashCode_ShouldReturnSameValueForEqualCategories() {
        RecipeCategory category1 = RecipeCategory.FRUITS_AND_VEGETABLES;
        RecipeCategory category2 = RecipeCategory.FRUITS_AND_VEGETABLES;
        assertEquals(category1.hashCode(), category2.hashCode());
    }

    @Test
    void hashCode_ShouldReturnDifferentValueForDifferentCategories() {
        RecipeCategory category1 = RecipeCategory.DRINKS;
        RecipeCategory category2 = RecipeCategory.SALAD;
        assertNotEquals(category1.hashCode(), category2.hashCode());
    }
}
