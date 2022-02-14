package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AlexTest {

    @Mock
    private Feline feline;

    @Test
    public void getFriendsReturnCorrectValues() throws Exception {
        Alex alex = new Alex(feline);
        List<String> expectedValues = List.of("Марти", "Глория", "Мелман");

        List<String> actualValues = alex.getFriends();

        assertEquals("method return incorrect values", expectedValues, actualValues);
    }

    @Test
    public void getPlaceOfLivingReturnCorrectValue() throws Exception {
        Alex alex = new Alex(feline);
        String expected = "Нью-Йоркский зоопарк";

        String actual = alex.getPlaceOfLiving();

        assertEquals("method return incorrect value", expected, actual);
    }

    @Test
    public void getKittensReturnZero() throws Exception {
        Alex alex = new Alex(feline);
        int expected = 0;

        int actual = alex.getKittens();

        assertEquals("method return incorrect value", expected, actual);
    }
}
