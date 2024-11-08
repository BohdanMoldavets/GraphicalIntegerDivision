package com.moldavets.integerdivision.service;

import com.moldavets.integerdivision.model.DivisionResult;

public interface Calculator {
    DivisionResult divide(int dividend, int divisor);
}
