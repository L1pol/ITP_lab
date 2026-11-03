package edu.course.lab01;

/**
 * Небольшие методы для первой лабораторной работы.
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
     * Числа меньше 2 простыми не являются.
     */
    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        // Проверяем делители до квадратного корня включительно.
        // Деление вместо divisor * divisor защищает от переполнения int.
        for (int divisor = 2; divisor <= number / divisor; divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Проверяет, читается ли строка одинаково в обоих направлениях.
     * Регистр и пробелы учитываются.
     *
     * @throws IllegalArgumentException если text равен null
     */
    public static boolean isPalindrome(String text) {
        if (text == null) {
            throw new IllegalArgumentException("text must not be null");
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
     * Исходный массив не изменяется.
     *
     * @throws IllegalArgumentException если values равен null или пуст
     */
    public static double average(int[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("values must not be null or empty");
        }

        double sum = 0.0;
        for (int value : values) {
            sum += value;
        }

        return sum / values.length;
    }
}
