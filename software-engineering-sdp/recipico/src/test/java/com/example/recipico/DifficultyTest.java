package com.example.recipico;

import com.example.recipico.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifficultyTest {

    @Test
    void getLabel_ShouldReturnCorrectLabel() {
        Difficulty easy = Difficulty.EASY;
        Difficulty moderate = Difficulty.MODERATE;
        Difficulty hard = Difficulty.HARD;

        assertEquals("Easy", easy.getLabel());
        assertEquals("Moderate", moderate.getLabel());
        assertEquals("Hard", hard.getLabel());
    }
}
