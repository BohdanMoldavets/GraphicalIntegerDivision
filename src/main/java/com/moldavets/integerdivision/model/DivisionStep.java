package com.moldavets.integerdivision.model;

public class DivisionStep {

    private final int reminder;
    private final int subtrahend;
    private final int difference;

    public DivisionStep(int reminder, int subtrahend, int difference) {
        this.reminder = reminder;
        this.subtrahend = subtrahend;
        this.difference = difference;
    }

    public int getReminder() {
        return reminder;
    }

    public int getSubtrahend() {
        return subtrahend;
    }

    public int getDifference() {
        return difference;
    }


}
