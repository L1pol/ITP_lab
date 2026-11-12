package edu.course.lab01;

/**
 * Утилитарный класс с базовыми операциями.
 */
public final class CourseToolkit {

    private CourseToolkit() {
        // Утилитарный класс не должен иметь экземпляров.
    }

    /**
     * Возвращает true, если число четное.
     */
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    /**
     * Проверяет, является ли число простым.
     */
    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        // Внимание: используем <=, чтобы корректно обработать квадраты простых (например, 49)
        for (int divisor = 2; divisor * divisor <= number; divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Проверяет, является ли строка палиндромом (регистр и пробелы значимы).
     */
    public static boolean isPalindrome(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Текст не может быть null");
        }
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Вычисляет среднее арифметическое элементов массива.
     */
    public static double average(int[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Массив не может быть null или пустым");
        }
        long sum = 0; // Используем long, чтобы избежать переполнения
        for (int value : values) {
            sum += value;
        }
        return (double) sum / values.length;
    }
}
