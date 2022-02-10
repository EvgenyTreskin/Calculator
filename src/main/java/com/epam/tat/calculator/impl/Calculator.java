package com.epam.tat.calculator.impl;

import com.epam.tat.calculator.ICalculator;

public class Calculator implements ICalculator {

    private int precision;

    public Calculator(int precision) {
        this.precision = precision;
    }

    @Override
    public double add(double a, double b) {
        throw new UnsupportedOperationException("You need to implement this method");
    }

    @Override
    public double subtract(double a, double b) {
        throw new UnsupportedOperationException("You need to implement this method");
    }

    @Override
    public double multiply(double a, double b) {
        throw new UnsupportedOperationException("You need to implement this method");
    }

    @Override
    public double divide(double a, double b) {
        throw new UnsupportedOperationException("You need to implement this method");
    }
}
