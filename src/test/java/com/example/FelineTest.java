package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineTest {

    @Test
    public void eatMeatReturnCorrectValues() throws Exception {
        Feline feline = new Feline();
        List<String> expectedValues = List.of("Животные", "Птицы", "Рыба");

        List<String> actualValues = feline.eatMeat();

        assertEquals(expectedValues, actualValues, "method return incorrect values");
    }

    @Test
    public void getFamilyReturnCorrectValue() {
        Feline feline = new Feline();
        String expected = "Кошачьи";

        String actual = feline.getFamily();

        assertEquals(expected, actual, "method return incorrect value");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -3, Integer.MAX_VALUE})
    public void getKittensWithArgumentReturnCorrectValue(int kittensCount) {
        Feline feline = new Feline();

        int actual = feline.getKittens(kittensCount);

        assertEquals(kittensCount, actual);
    }

    @Test
    public void getKittensWithoutArgumentReturnCorrectValue() {
        Feline feline = new Feline();
        int expected = 1;

        int actual = feline.getKittens();

        assertEquals(expected, actual);
    }
}
