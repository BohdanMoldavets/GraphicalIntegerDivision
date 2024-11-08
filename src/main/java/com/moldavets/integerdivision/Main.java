package com.moldavets.integerdivision;

import com.moldavets.integerdivision.service.CalculatorImpl;
import com.moldavets.integerdivision.formatter.ClassicFormatter;
import com.moldavets.integerdivision.model.DivisionResult;
import com.moldavets.integerdivision.formatter.Formatter;

public class Main {
    public static void main(String[] args) {
        CalculatorImpl calculator = new CalculatorImpl();
        DivisionResult result = calculator.divide(12345,12);
        Formatter formatter = new ClassicFormatter();
        String output = formatter.format(result);
        System.out.println(output);
    }
}