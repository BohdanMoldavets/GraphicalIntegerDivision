package com.moldavets.integerdivision.formatter;

import com.moldavets.integerdivision.model.DivisionResult;
import com.moldavets.integerdivision.model.DivisionStep;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClassicFormatterTest {

    @Test
    void classicFormatter_shouldCorrectFormat_whenInputContainsSimpleNumbers() {
        Formatter formatter = new ClassicFormatter();

        List<DivisionStep> intermediateSteps = new ArrayList<>();
        intermediateSteps.add(new DivisionStep(8,8, 0));
        DivisionResult input = new DivisionResult(4, intermediateSteps, 2, 8);
        String expected = """
                _8|2
                 8|-
                 -|4
                 0
                """;
        String actual = formatter.format(input);
        assertEquals(expected, actual);
    }

    @Test
    void classicFormatter_shouldCorrectFormatWithRemainder_whenInputContainsSimpleNumbers() {
        Formatter formatter = new ClassicFormatter();

        List<DivisionStep> intermediateSteps = new ArrayList<>();
        intermediateSteps.add(new DivisionStep(10,9, 1));
        DivisionResult input = new DivisionResult(3, intermediateSteps, 3, 10);
        String expected = """
                _10|3
                 9 |-
                 - |3
                 1
                """;
        String actual = formatter.format(input);
        assertEquals(expected, actual);

    }

    @Test
    void classicFormatter_shouldReturnCorrectFormatAndInResultZero_whenInputContainsDividendLessDivisor() {
        Formatter formatter = new ClassicFormatter();

        List<DivisionStep> intermediateSteps = new ArrayList<>();
        intermediateSteps.add(new DivisionStep(0,0, 0));
        DivisionResult input = new DivisionResult(0, intermediateSteps, 10, 3);
        String expected = """
                _3|10
                 0|--
                 -|0
                 0""";
        String actual = formatter.format(input);
        assertEquals(expected, actual);
    }

    @Test
    void classicFormatter_shouldReturnInResultZero_whenInputContainsDivisorEqualsZero() {
        Formatter formatter = new ClassicFormatter();

        List<DivisionStep> intermediateSteps = new ArrayList<>();
        intermediateSteps.add(new DivisionStep(0,0, 0));
        DivisionResult input = new DivisionResult(0, intermediateSteps, 0, 3);
        String expected = """
                _3|0
                 0|-
                 -|0
                 0""";
        String actual = formatter.format(input);
        assertEquals(expected, actual);
    }

    @Test
    void classicFormatter_shouldReturnInResultOne_whenInputContainsDivisorEqualsOne() {
        Formatter formatter = new ClassicFormatter();

        List<DivisionStep> intermediateSteps = new ArrayList<>();
        intermediateSteps.add(new DivisionStep(1,1, 0));
        DivisionResult input = new DivisionResult(10, intermediateSteps, 1, 10);
        String expected = """
                _10|1
                 1 |--
                 - |10
                 0
                """;
        String actual = formatter.format(input);
        assertEquals(expected, actual);
    }

    @Test
    void classicFormatter_shouldReturnCorrectFormat_whenInputContainsDivisorEqualsDividend() {
        Formatter formatter = new ClassicFormatter();

        List<DivisionStep> intermediateSteps = new ArrayList<>();
        intermediateSteps.add(new DivisionStep(10,10, 0));
        DivisionResult input = new DivisionResult(1, intermediateSteps, 10, 10);
        String expected = """
                _10|10
                 10|--
                 --|1
                  0
                """;
        String actual = formatter.format(input);
        assertEquals(expected, actual);
    }

    @Test
    void classicFormatter_shouldReturnNegativeNumberInResult_whenInputContainsNegaiveDivisor() {
        Formatter formatter = new ClassicFormatter();

        List<DivisionStep> intermediateSteps = new ArrayList<>();
        intermediateSteps.add(new DivisionStep(10,10, 0));
        DivisionResult input = new DivisionResult(-5, intermediateSteps, 2, 10);
        String expected = """
                _10|2
                 10|--
                 --|-5
                  0
                """;
        String actual = formatter.format(input);
        assertEquals(expected, actual);
    }

    @Test
    void classicFormatter_shouldReturnNegativeNumberInResult_whenInputContainsNegaiveDividend() {
        Formatter formatter = new ClassicFormatter();

        List<DivisionStep> intermediateSteps = new ArrayList<>();
        intermediateSteps.add(new DivisionStep(10,10, 0));
        DivisionResult input = new DivisionResult(-5, intermediateSteps, 2, 10);
        String expected = """
                _10|2
                 10|--
                 --|-5
                  0
                """;
        String actual = formatter.format(input);
        assertEquals(expected, actual);
    }

    @Test
    void classicFormatter_shouldReturnCorrectFormat_whenInputContainsMoreSteps() {
        Formatter formatter = new ClassicFormatter();

        List<DivisionStep> intermediateSteps = new ArrayList<>();
        intermediateSteps.add(new DivisionStep(10,9, 1));
        intermediateSteps.add(new DivisionStep(10,9, 1));
        intermediateSteps.add(new DivisionStep(10,9, 1));
        intermediateSteps.add(new DivisionStep(10,9, 1));
        DivisionResult input = new DivisionResult(3333, intermediateSteps, 3, 10000);
        String expected = """
                _10000|3
                 9    |----
                 -    |3333
                 _10
                   9
                   -
                   _10
                     9
                     -
                     _10
                       9
                       -
                       1
                """;
        String actual = formatter.format(input);
        assertEquals(expected, actual);
    }

    @Test
    void classicFormatter_shouldReturnCorrectFormat_whenInputContainsThousandAndOne() {
        Formatter formatter = new ClassicFormatter();

        List<DivisionStep> intermediateSteps = new ArrayList<>();
        intermediateSteps.add(new DivisionStep(1,1, 0));
        intermediateSteps.add(new DivisionStep(1,1, 0));
        DivisionResult input = new DivisionResult(1001, intermediateSteps, 1, 1001);
        String expected = """
                _1001|1
                 1   |----
                 -   |1001
                 _1
                  1
                  -
                  0
                """;
        String actual = formatter.format(input);
        assertEquals(expected, actual);
    }

    @Test
    void classicFormatter_shouldReturnCorrectFormat_whenInputContainsOneHundredTwentyThree() {
        Formatter formatter = new ClassicFormatter();

        List<DivisionStep> intermediateSteps = new ArrayList<>();
        intermediateSteps.add(new DivisionStep(123,123, 0));
        DivisionResult input = new DivisionResult(1, intermediateSteps, 123, 123);
        String expected = """
                _123|123
                 123|---
                 ---|1
                   0
                   """;
        String actual = formatter.format(input);
        assertEquals(expected, actual);
    }

    @Test
    void classicFormatter_shouldReturnCorrectFormat_whenInputContainsTwelveThousandThreeHundredFortyFive() {
        Formatter formatter = new ClassicFormatter();

        List<DivisionStep> intermediateSteps = new ArrayList<>();
        intermediateSteps.add(new DivisionStep(12,12, 0));
        intermediateSteps.add(new DivisionStep(34,24, 10));
        intermediateSteps.add(new DivisionStep(105,96, 9));
        DivisionResult input = new DivisionResult(1028, intermediateSteps, 12, 12345);
        String expected = """
                _12345|12
                 12   |----
                 --   |1028
                 _34
                  24
                  --
                  _105
                    96
                    --
                     9
                """;

        String actual = formatter.format(input);
        assertEquals(expected, actual);
    }


}