package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline;

    @Test
    public void getFoodReturnCorrectValues() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedValues = List.of("Животные", "Птицы", "Рыба");

        List<String> actualValues = cat.getFood();

        assertEquals("method return incorrect values", expectedValues, actualValues);
    }

    @Test
    public void getSoundReturnCorrectValue() {
        Cat cat = new Cat(feline);
        String expected = "Мяу";

        String actual = cat.getSound();

        assertEquals("method return incorrect value", expected, actual);
    }
}
