package com.moldavets.integerdivision.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorImplTest {

    @Test
    void calculator_shouldReturnResultEqualsZero_whenDividendEqalsZero() {
        Calculator calc = new CalculatorImpl();
        Exception exception = assertThrows(ArithmeticException.class,
                () -> calc.divide(0, 10));
        assertEquals("Dividend is zero", exception.getMessage());
    }

    @Test
    void calculator_shouldReturnResultEqualsZero_whenDivisorEqalsZero() {
        Calculator calc = new CalculatorImpl();
        Exception exception = assertThrows(ArithmeticException.class,
                () -> calc.divide(10,0));
        assertEquals("Divisor is zero", exception.getMessage());
    }

    @Test
    void calculator_shouldReturnResultEqualsZero_whenDividendLessDivisor() {
        Calculator calc = new CalculatorImpl();
        assertEquals(0, calc.divide(3,10).getResult());
    }

    @Test
    void calculator_shouldReturnPositiveResult_whenDividendWasPositive() {
        Calculator calc = new CalculatorImpl();
        assertEquals(1, calc.divide(25,25).getResult());
    }

    @Test
    void calculator_shouldReturnNegativeResult_whenDividendWasNegative() {
        Calculator calc = new CalculatorImpl();
        assertEquals(-1, calc.divide(-25,25).getResult());
    }

    @Test
    void calculator_shouldReturnPositiveResult_whenDivisorWasNegative() {
        Calculator calc = new CalculatorImpl();
        assertEquals(-25, calc.divide(50,-2).getResult());
    }

    @Test
    void calculator_shouldReturnPositiveResult_whenDividendAndDivisorWasNegative() {
        Calculator calc = new CalculatorImpl();
        assertEquals(25, calc.divide(-50,-2).getResult());
    }


}