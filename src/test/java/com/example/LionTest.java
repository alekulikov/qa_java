package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Test
    public void createLionWithException() {
        String expected = "Используйте допустимые значения пола животного - самец или самка";

        String actual = "";
        try {
            new Lion("test", feline);
        } catch (Exception e) {
            actual = e.getMessage();
        }

        assertEquals("create Lion with incorrect argument", expected, actual);
    }

    @Test
    public void doesHaveManeReturnCorrectValue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        boolean expected = true;

        boolean actual = lion.doesHaveMane();

        assertEquals("method return incorrect value", expected, actual);
    }

    @Test
    public void getKittensReturnCorrectValue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expected = 1;

        int actual = lion.getKittens();

        assertEquals("method return incorrect value", expected, actual);
    }

    @Test
    public void getFoodReturnCorrectValues() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedValues = List.of("Животные", "Птицы", "Рыба");

        List<String> actualValues = lion.getFood();

        assertEquals("method return incorrect values", expectedValues, actualValues);
    }
}
