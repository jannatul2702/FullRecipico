package com.example.recipico;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.example.recipico.model.Category;
import com.example.recipico.model.RecipeCategory;
import com.example.recipico.service.CategoryService;

public class CategoryServiceTest {

    @Test
    public void testGetAllCategory() {
        CategoryService categoryService = Mockito.mock(CategoryService.class);

        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1L, RecipeCategory.BREAD));
        categories.add(new Category(2L, RecipeCategory.DESSERT));

        Mockito.when(categoryService.getAllCategory()).thenReturn(categories);

        List<Category> result = categoryService.getAllCategory();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(RecipeCategory.BREAD, result.get(0).getCategoryName());
        assertEquals(RecipeCategory.DESSERT, result.get(1).getCategoryName());
    }

    @Test
    public void testGetCategoryById() {
        CategoryService categoryService = Mockito.mock(CategoryService.class);

        Category category = new Category(1L, RecipeCategory.BREAD);

        Mockito.when(categoryService.getCategoryById(1L)).thenReturn(category);

        Category result = categoryService.getCategoryById(1L);

        assertNotNull(result);
        assertEquals(RecipeCategory.BREAD, result.getCategoryName());
    }

    @Test
    public void testAddCategory() {
        CategoryService categoryService = Mockito.mock(CategoryService.class);

        Category category = new Category(1L, RecipeCategory.BREAD);

        categoryService.addCategory(category);

        Mockito.verify(categoryService).addCategory(category);
    }

    @Test
    public void testDeleteCategoryyId() {
        CategoryService categoryService = Mockito.mock(CategoryService.class);

        categoryService.deleteCategoryyId(1L);

        Mockito.verify(categoryService).deleteCategoryyId(1L);
    }
}
