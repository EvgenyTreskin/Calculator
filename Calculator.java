package com.epam.tat.calculator.impl;

import com.epam.tat.calculator.ICalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Calculator implements ICalculator {

    public static void main(String[] args) {
        System.out.println("Enter simple action with two numbers");
        Scanner consoleEnter = new Scanner(System.in);
        String enteredString = consoleEnter.nextLine();
        String[] splitedString = enteredString.split(" ");
        double a = Double.parseDouble(splitedString[0]);
        double b = Double.parseDouble(splitedString[2]);
        String s = splitedString[1];
        char c = s.charAt(0);
        System.out.println("Action is " + c);
        double result;
        Calculator calc = new Calculator(2);
        switch (c) {
            case '+':
                result = calc.add(a,b);
                System.out.println(result);
                break;
            case '-':
                result = calc.subtract(a,b);
                System.out.println(result);
                break;
            case '*':
                result = calc.multiply(a,b);
                System.out.println(result);
                break;
            case '/':
                result = calc.divide(a,b);
                System.out.println(result);
                break;
            default:
                System.out.println("Operation is not recognized. Repete enter!");
        }
    }

    private int precision;
    // При выводе чисел с плавающей точкой мы можем указать количество знаков после запятой,
    // для этого используем спецификатор на %.2f, где .2 указывает, что после запятой два знака???

    public Calculator(int precision) {
        this.precision = precision;
    }

    @Override
    public double add(double a, double b) {
        if((a >= Double.MAX_VALUE && b > 0) || (a > 0 && b >= Double.MAX_VALUE)) {
            return Double.POSITIVE_INFINITY;
        } else if ((a <= -Double.MAX_VALUE && b < 0) || (a < 0 && b <= -Double.MAX_VALUE)) {
            return Double.NEGATIVE_INFINITY;
        } else {
            BigDecimal value = new BigDecimal(a + b);
            value = value.setScale(precision, RoundingMode.HALF_UP);
            return value.doubleValue();
        }
    }

    @Override
    public double subtract(double a, double b) {
        if((a >= Double.MAX_VALUE && b < 0) || (a < 0 && b >= Double.MAX_VALUE)) {
            return Double.POSITIVE_INFINITY;
        } else if ((a <= -Double.MAX_VALUE && b > 0) || (a > 0 && b <= -Double.MAX_VALUE)) {
            return Double.NEGATIVE_INFINITY;
        } else {
            BigDecimal value = new BigDecimal(a - b);
            value = value.setScale(precision, RoundingMode.HALF_UP);
            return value.doubleValue();
        }
    }

    @Override
    public double multiply(double a, double b) {
        if((a >= Double.MAX_VALUE && b >= Double.MAX_VALUE)|| (a <= -Double.MAX_VALUE && b <= -Double.MAX_VALUE)) {
            return Double.POSITIVE_INFINITY;
        } else if ((a <= -Double.MAX_VALUE && b >= Double.MAX_VALUE) || (a >= Double.MAX_VALUE && b <= -Double.MAX_VALUE)) {
            return Double.NEGATIVE_INFINITY;
        } else {
            BigDecimal value = new BigDecimal(a * b);
            value = value.setScale(precision, RoundingMode.HALF_UP);
            return value.doubleValue();
        }
    }

    @Override
    public double divide(double a, double b) {
        if((a > 0 && b == 0.0) || (a >= Double.MAX_VALUE && b > 0 && b < 1) || (a <= -Double.MAX_VALUE && b < 0 && b > -1)) {
            return Double.POSITIVE_INFINITY;
        } else if ((a < 0 && b == 0.0) ||(a <= -Double.MAX_VALUE && b > 0 && b < 1) || ((a >= Double.MAX_VALUE && b < 0 && b > -1))) {
            return Double.NEGATIVE_INFINITY;
        } else {
            BigDecimal value = new BigDecimal(a / b);
            value = value.setScale(precision, RoundingMode.HALF_UP);
            return value.doubleValue();
        }
    }
}
