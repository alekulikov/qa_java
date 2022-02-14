package com.example;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class FelineTest {

    @Test
    public void eatMeatReturnCorrectValues() throws Exception {
        Feline feline = new Feline();
        List<String> expectedValues = List.of("Животные", "Птицы", "Рыба");

        List<String> actualValues = feline.eatMeat();

        assertEquals("method return incorrect values", expectedValues, actualValues);
    }

    @Test
    public void getFamilyReturnCorrectValue() {
        Feline feline = new Feline();
        String expected = "Кошачьи";

        String actual = feline.getFamily();

        assertEquals("method return incorrect value", expected, actual);
    }

    @Test
    @Parameters({"0", "-3", "2000000000"})
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
