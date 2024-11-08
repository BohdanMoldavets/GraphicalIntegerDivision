package com.moldavets.integerdivision.service;

import com.moldavets.integerdivision.model.DivisionResult;
import com.moldavets.integerdivision.model.DivisionStep;
import com.moldavets.integerdivision.utils.MathUtils;

import java.util.ArrayList;
import java.util.List;

public class CalculatorImpl implements Calculator {

    public DivisionResult divide(int dividend, int divisor) {

        boolean isNegativeDividend = false;
        boolean isNegativeDivisor = false;

        if (divisor == 0) {
            throw new ArithmeticException("Divisor is zero");
        } else if (dividend == 0) {
            throw new ArithmeticException("Dividend is zero");
        }

        if (dividend < 0) {
            dividend = -dividend;
            isNegativeDividend = true;
        } else if (dividend < divisor) {
            List<DivisionStep> resultWhenDividendLessDivisor = new ArrayList<>();
            resultWhenDividendLessDivisor.add(new DivisionStep(0,0, 0));
            return new DivisionResult(0, resultWhenDividendLessDivisor,divisor,dividend);
        }


        if (divisor < 0) {
            divisor = -divisor;
            isNegativeDivisor = true;
        }


        List<DivisionStep> steps = new ArrayList<>();
        StringBuilder resultString = new StringBuilder();
        int[] digits = MathUtils.digits(dividend);
        int reminder = 0;
        int[] result = new int[digits.length];

        for (int i = 0; i <= digits.length-1; i++) {

            reminder = reminder * 10 + digits[i];
            if (reminder < divisor) {
                steps.add(new DivisionStep(reminder,0,0));
                result[i] = 0;
                continue;
            }
            int quotient = reminder / divisor;
            result[i] = quotient;
            int subtrahend = quotient * divisor;
            int difference = reminder - subtrahend;
            steps.add(new DivisionStep(reminder,subtrahend,difference));


            if (quotient > 0) {
                reminder = difference;
            }
        }

        if (isNegativeDividend != isNegativeDivisor) {
            resultString.append("-");
        }

        for(int i = 0; i <= result.length-1; i++) {
            if (i == 0 && result[i] == 0) {
                continue;
            }
            resultString.append(result[i]);
        }

        return new DivisionResult(Integer.parseInt(String.valueOf(resultString)),steps,divisor,dividend);
    }

}
