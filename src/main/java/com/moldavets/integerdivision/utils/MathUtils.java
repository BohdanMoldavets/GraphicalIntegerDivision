package com.moldavets.integerdivision.utils;

public class MathUtils {
    public static int[] digits(int number) {
        int[] digits = new int[length(number)];
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = (number % 10);
            number /= 10;
        }
        return digits;
    }

    private static int length(int number) {
        return number < 10 ? 1 : (int) (Math.log10(number) + 1);
    }
}
