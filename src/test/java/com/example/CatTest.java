package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CatTest {

    @Mock
    private Feline feline;

    @Test
    public void getFoodReturnCorrectValues() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedValues = List.of("Животные", "Птицы", "Рыба");

        List<String> actualValues = cat.getFood();

        assertEquals(expectedValues, actualValues, "method return incorrect values");
    }

    @Test
    public void getSoundReturnCorrectValue() {
        Cat cat = new Cat(feline);
        String expected = "Мяу";

        String actual = cat.getSound();

        assertEquals(expected, actual, "method return incorrect value");
    }
}
