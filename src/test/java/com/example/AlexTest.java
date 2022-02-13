package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AlexTest {

    @Mock
    private Feline feline;

    @Test
    public void getFriendsReturnCorrectValues() throws Exception {
        Alex alex = new Alex(feline);
        List<String> expectedValues = List.of("Марти", "Глория", "Мелман");

        List<String> actualValues = alex.getFriends();

        assertEquals(expectedValues, actualValues, "method return incorrect values");
    }

    @Test
    public void getPlaceOfLivingReturnCorrectValue() throws Exception {
        Alex alex = new Alex(feline);
        String expected = "Нью-Йоркский зоопарк";

        String actual = alex.getPlaceOfLiving();

        assertEquals(expected, actual, "method return incorrect value");
    }

    @Test
    public void getKittensReturnZero() throws Exception {
        Alex alex = new Alex(feline);
        int expected = 0;

        int actual = alex.getKittens();

        assertEquals(expected, actual, "method return incorrect value");
    }
}
