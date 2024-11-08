package com.moldavets.integerdivision.model;

import java.util.List;

public class DivisionResult {

    private final int result;
    private final List<DivisionStep> intermediateSteps;
    private final int divisor;
    private final int dividend;

    public DivisionResult(int result, List<DivisionStep> intermediateSteps, int divisor, int dividend) {
        this.result = result;
        this.intermediateSteps = intermediateSteps;
        this.divisor = divisor;
        this.dividend = dividend;
    }

    public int getResult() {
        return result;
    }

    public List<DivisionStep> getIntermediateSteps() {
        return intermediateSteps;
    }

    public int getDivisor() {
        return divisor;
    }

    public int getDividend() {
        return dividend;
    }


    @Override
    public String toString() {
        return "DivisionResult{" +
                "result=" + result +
                ", intermediateSteps=" + intermediateSteps +
                ", divisor=" + divisor +
                ", dividend=" + dividend +
                '}';
    }
}
