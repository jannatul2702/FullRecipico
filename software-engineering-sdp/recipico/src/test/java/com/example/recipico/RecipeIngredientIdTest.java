package com.example.recipico;

import com.example.recipico.model.RecipeIngredientId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class RecipeIngredientIdTest {

    @Test
    void equals_ShouldReturnTrueForEqualObjects() {
        RecipeIngredientId id1 = new RecipeIngredientId(1L, 2L);
        RecipeIngredientId id2 = new RecipeIngredientId(1L, 2L);

        assertEquals(id1, id2);
    }

    @Test
    void equals_ShouldReturnFalseForDifferentObjects() {
        RecipeIngredientId id1 = new RecipeIngredientId(1L, 2L);
        RecipeIngredientId id2 = new RecipeIngredientId(3L, 4L);

        assertNotEquals(id1, id2);
    }

    @Test
    void hashCode_ShouldReturnSameValueForEqualObjects() {
        RecipeIngredientId id1 = new RecipeIngredientId(1L, 2L);
        RecipeIngredientId id2 = new RecipeIngredientId(1L, 2L);

        assertEquals(id1.hashCode(), id2.hashCode());
    }

    @Test
    void hashCode_ShouldReturnDifferentValueForDifferentObjects() {
        RecipeIngredientId id1 = new RecipeIngredientId(1L, 2L);
        RecipeIngredientId id2 = new RecipeIngredientId(3L, 4L);

        assertNotEquals(id1.hashCode(), id2.hashCode());
    }
}
