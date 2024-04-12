package org.example;

import java.util.Stack;

public class Arithmometer {
    public static int calculate(String exp) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (Character.isDigit(c)) { //digit
                int operand = 0;
                //continues digits, i will stop at next sign
                while (i < exp.length() && Character.isDigit(exp.charAt(i))) {
                    operand = operand * 10 + (exp.charAt(i++) - '0');
                }
                i--; //back i to digit
                operands.push(operand);
            } else if (c == '+' || c == '-' || c == '*' || c == '/') { //sign
                while (!operators.isEmpty() && precedence(c) <= precedence(operators.peek())) {
                    performOperation(operands, operators);
                }
                operators.push(c);
            }
        }

        while (!operators.isEmpty()) {
            performOperation(operands, operators);
        }

        return operands.pop();
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    private static void performOperation(Stack<Integer> operands, Stack<Character> operators) {
        char operator = operators.pop();
        int operand2 = operands.pop();
        int operand1 = operands.pop();
        switch (operator) {
            case '+':
                operands.push(operand1 + operand2);
                break;
            case '-':
                operands.push(operand1 - operand2);
                break;
            case '*':
                operands.push(operand1 * operand2);
                break;
            case '/':
                operands.push(operand1 / operand2);
                break;
        }
    }
}
