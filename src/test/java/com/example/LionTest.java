package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class LionTest {

    @Mock
    private Feline feline;

    private static Stream<Arguments> provideArgsForConstructor() {
        return Stream.of(
                Arguments.of("Самец", true),
                Arguments.of("Самка", false)
        );
    }

    @Test
    public void createLionWithException() {
        String expected = "Используйте допустимые значения пола животного - самец или самка";

        String actual = "";
        try {
            new Lion("test", feline);
        } catch (Exception e) {
            actual = e.getMessage();
        }

        assertEquals(expected, actual, "create Lion with incorrect argument");
    }

    @ParameterizedTest
    @MethodSource("provideArgsForConstructor")
    public void doesHaveManeReturnCorrectValue(String sex, boolean expected) throws Exception {
        Lion lion = new Lion(sex, feline);

        boolean actual = lion.doesHaveMane();

        assertEquals(expected, actual, "method return incorrect value");
    }

    @Test
    public void getKittensReturnCorrectValue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expected = 1;

        int actual = lion.getKittens();

        assertEquals(expected, actual, "method return incorrect value");
    }

    @Test
    public void getFoodReturnCorrectValues() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedValues = List.of("Животные", "Птицы", "Рыба");

        List<String> actualValues = lion.getFood();

        assertEquals(expectedValues, actualValues, "method return incorrect values");
    }
}
