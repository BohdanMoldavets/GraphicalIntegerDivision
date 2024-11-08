package com.moldavets.integerdivision.formatter;

import com.moldavets.integerdivision.model.DivisionResult;
import com.moldavets.integerdivision.model.DivisionStep;

public class ClassicFormatter implements Formatter {

    @Override
    public String format(DivisionResult result) {
        StringBuilder stringResult = new StringBuilder();
        String dividendString = String.valueOf(result.getDividend());
        String divisorString = String.valueOf(result.getDivisor());
        StringBuilder resultString = new StringBuilder();
        int dividendLength = dividendString.length();

        resultString.append(result.getResult());

        stringResult.append("_").append(dividendString).append("|").append(divisorString).append("\n");

        stringResult.append(" ");

        for(int i = 0; i < result.getIntermediateSteps().size(); i++) {
            if(result.getIntermediateSteps().get(i).getSubtrahend() <= 0) {
                result.getIntermediateSteps().remove(i);
                i--;
            }
        }

        if (result.getIntermediateSteps().isEmpty()) {
            stringResult.append("0").append(repeatChar(' ', dividendLength-1));
            stringResult.append("|").append(repeatChar('-', String.valueOf(result.getDivisor()).length())).append("\n ");
            stringResult.append("-").append(repeatChar(' ', dividendLength-1)).append("|").append("0\n ");
            stringResult.append("0");
            return stringResult.toString();
        }

        stringResult.append(result.getIntermediateSteps().get(0).getSubtrahend());
        stringResult.append(repeatChar(' ', dividendLength - String.valueOf(result.getIntermediateSteps().get(0).getSubtrahend()).length()));

        if(String.valueOf(result.getResult()).length() >= String.valueOf(result.getDivisor()).length()) {
            stringResult.append("|").append(repeatChar('-', resultString.length())).append("\n");
        } else {
            stringResult.append("|").append(repeatChar('-', String.valueOf(result.getDivisor()).length())).append("\n");
        }

        stringResult.append(" ").append(repeatChar('-', String.valueOf(result.getIntermediateSteps().get(0).getSubtrahend()).length()));
        stringResult.append(repeatChar(' ', dividendLength - String.valueOf(result.getIntermediateSteps().get(0).getSubtrahend()).length()));
        stringResult.append("|").append(resultString).append("\n");


        int offset = 1;

        for (int i = 1; i < result.getIntermediateSteps().size(); i++) {
            DivisionStep step = result.getIntermediateSteps().get(i);
            String stepReminder = String.valueOf(step.getReminder());
            String stepSubtraction = String.valueOf(step.getSubtrahend());

            stringResult.append(repeatChar(' ', offset));
            stringResult.append("_").append(stepReminder).append("\n");
            if(String.valueOf(step.getReminder()).length() > String.valueOf(step.getSubtrahend()).length()) {
                offset++;
            }

            stringResult.append(repeatChar(' ', offset+1)); //- stepSubtraction.length()-1
            stringResult.append(stepSubtraction).append("\n");

            if (i < result.getIntermediateSteps().size()) {
                stringResult.append(repeatChar(' ', offset+1)); // -stepSubtraction.length()-1
                stringResult.append(repeatChar('-', stepSubtraction.length())).append("\n");

            }
            offset++;
        }


        DivisionStep lastStep = result.getIntermediateSteps().get(result.getIntermediateSteps().size()-1);
        String lastStepSubtraction = String.valueOf(lastStep.getSubtrahend());
        String lastStepDiference = String.valueOf(lastStep.getDifference());

        if(lastStepSubtraction.length() > lastStepDiference.length()) {
            offset += lastStepSubtraction.length()-lastStepDiference.length();
        }

        stringResult.append(repeatChar(' ', offset));
        stringResult.append(lastStepDiference).append("\n");

        return stringResult.toString();
    }

    private String repeatChar(char c, int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(c);
        }
        return builder.toString();
    }


}
