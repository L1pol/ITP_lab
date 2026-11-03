package edu.course.lab01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CourseToolkitTest {

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

    @Test
    void returnsTrueForNegativeEvenNumber() {
        boolean result = CourseToolkit.isEven(-8);

        assertTrue(result);
    }

    @Test
    void returnsFalseForNumbersLessThanTwo() {
        assertFalse(CourseToolkit.isPrime(-5));
        assertFalse(CourseToolkit.isPrime(0));
        assertFalse(CourseToolkit.isPrime(1));
    }

    @Test
    void returnsTrueForTwo() {
        assertTrue(CourseToolkit.isPrime(2));
    }

    @Test
    void returnsFalseForCompositeNumber() {
        assertFalse(CourseToolkit.isPrime(21));
    }

    @Test
    void returnsFalseForSquareOfPrimeNumber() {
        assertFalse(CourseToolkit.isPrime(49));
    }

    @Test
    void returnsTrueForPrimeNumber() {
        assertTrue(CourseToolkit.isPrime(97));
    }

    @Test
    void returnsTrueForPalindrome() {
        assertTrue(CourseToolkit.isPalindrome("level"));
    }

    @Test
    void returnsFalseForNonPalindrome() {
        assertFalse(CourseToolkit.isPalindrome("hello"));
    }

    @Test
    void palindromeComparisonIsCaseSensitive() {
        assertFalse(CourseToolkit.isPalindrome("Level"));
    }

    @Test
    void palindromeComparisonTreatsSpacesAsCharacters() {
        assertFalse(CourseToolkit.isPalindrome("a b"));
    }

    @Test
    void throwsExceptionForNullPalindromeText() {
        assertThrows(
                IllegalArgumentException.class,
                () -> CourseToolkit.isPalindrome(null)
        );
    }

    @Test
    void calculatesAverage() {
        assertEquals(3.0, CourseToolkit.average(new int[]{2, 3, 4}), 0.000001);
    }

    @Test
    void calculatesFractionalAverage() {
        assertEquals(2.5, CourseToolkit.average(new int[]{2, 3}), 0.000001);
    }

    @Test
    void calculatesAverageForNegativeValues() {
        assertEquals(-3.0, CourseToolkit.average(new int[]{-2, -4}), 0.000001);
    }

    @Test
    void doesNotModifyInputArray() {
        int[] values = {1, 2, 3};
        int[] originalValues = values.clone();

        CourseToolkit.average(values);

        assertArrayEquals(originalValues, values);
    }

    @Test
    void throwsExceptionForNullArray() {
        assertThrows(
                IllegalArgumentException.class,
                () -> CourseToolkit.average(null)
        );
    }

    @Test
    void throwsExceptionForEmptyArray() {
        assertThrows(
                IllegalArgumentException.class,
                () -> CourseToolkit.average(new int[]{})
        );
    }
}
