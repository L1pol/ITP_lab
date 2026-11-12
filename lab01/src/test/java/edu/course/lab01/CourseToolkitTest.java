package edu.course.lab01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseToolkitTest {

    // --- Исходные тесты ---

    @Test
    void returnsTrueForEvenNumber() {
        boolean result = CourseToolkit.isEven(8);
        assertTrue(result);
    }

    @Test
    void returnsFalseForOddNumber() {
        boolean result = CourseToolkit.isEven(7);
        assertFalse(result);
    }

    // --- Подготовительная часть ---

    @Test
    void returnsTrueForNegativeEvenNumber() {
        boolean result = CourseToolkit.isEven(-8);
        assertTrue(result);
    }

    // --- Тесты для isPrime ---

    @Test
    void isPrimeReturnsFalseForLessThanTwo() {
        assertFalse(CourseToolkit.isPrime(-7));
        assertFalse(CourseToolkit.isPrime(0));
        assertFalse(CourseToolkit.isPrime(1));
    }

    @Test
    void isPrimeReturnsTrueForTwo() {
        assertTrue(CourseToolkit.isPrime(2));
    }

    @Test
    void isPrimeReturnsFalseForComposite() {
        assertFalse(CourseToolkit.isPrime(15));
    }

    @Test
    void isPrimeReturnsFalseForSquareOfPrime() {
        assertFalse(CourseToolkit.isPrime(49));
    }

    @Test
    void isPrimeReturnsTrueForLargePrime() {
        assertTrue(CourseToolkit.isPrime(97));
    }

    // --- Тесты для isPalindrome ---

    @Test
    void isPalindromeReturnsTrueForPalindrome() {
        assertTrue(CourseToolkit.isPalindrome("шалаш"));
    }

    @Test
    void isPalindromeIsCaseSensitive() {
        assertFalse(CourseToolkit.isPalindrome("Мадам"));
    }

    @Test
    void isPalindromeTreatsSpacesAsSignificant() {
        assertFalse(CourseToolkit.isPalindrome("а роза упала на лапу азора "));
    }

    @Test
    void isPalindromeThrowsOnNull() {
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.isPalindrome(null));
    }

    // --- Тесты для average ---

    @Test
    void averageReturnsFractionalResult() {
        assertEquals(2.5, CourseToolkit.average(new int[]{1, 2, 3, 4}), 1e-9);
    }

    @Test
    void averageHandlesNegativeValues() {
        assertEquals(-2.0, CourseToolkit.average(new int[]{-1, -3}), 1e-9);
    }

    @Test
    void averageThrowsOnNullOrEmpty() {
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.average(null));
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.average(new int[0]));
    }

    @Test
    void averageDoesNotModifyArray() {
        int[] values = {5, 1, 4};
        CourseToolkit.average(values);
        assertArrayEquals(new int[]{5, 1, 4}, values);
    }
}
