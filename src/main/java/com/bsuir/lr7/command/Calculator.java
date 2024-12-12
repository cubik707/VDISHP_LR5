package com.bsuir.lr7.command;

import com.bsuir.lr7.command.state.CalculatorState;
import com.bsuir.lr7.command.state.InputDigitState;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
  private List<Double> operands = new ArrayList<>();
  private List<String> operations = new ArrayList<>();
  private String currentInput = "";
  private CalculatorState currentState;

  public Calculator() {
    this.currentState = new InputDigitState(); // Initial state
  }

  public void setState(CalculatorState state) {
    this.currentState = state;
  }

  public void appendDigit(String digit) {
    currentState.handleDigit(this, digit);
  }

  public void applyOperation(String operation) {
    currentState.handleOperation(this, operation);
  }

  public void clear() {
    currentState.handleClear(this);
  }

  public void calculateResult() {
    currentState.handleEqual(this);
  }

  public String getCurrentInput() {
    return currentInput;
  }

  public void appendDigitInternal(String digit) {
    currentInput += digit;
  }

  public void applyOperationInternal(String operation) {
    if (!currentInput.isEmpty()) {
      operands.add(Double.parseDouble(currentInput));
      currentInput = "";
      operations.add(operation);
    }
  }

  public void clearInternal() {
    operands.clear();
    operations.clear();
    currentInput = "";
  }

  public void calculateResultInternal() {
    if (!currentInput.isEmpty()) {
      operands.add(Double.parseDouble(currentInput));
    }

    if (operands.size() < 2) {
      return;
    }

    double result = operands.get(0);

    for (int i = 0; i < operations.size(); i++) {
      double nextOperand = operands.get(i + 1);
      switch (operations.get(i)) {
        case "+":
          result += nextOperand;
          break;
        case "-":
          result -= nextOperand;
          break;
        case "*":
          result *= nextOperand;
          break;
        case "/":
          if (nextOperand != 0) {
            result /= nextOperand;
          } else {
            currentInput = "Error";
            return;
          }
          break;
      }
    }

    currentInput = String.valueOf(result);
    operands.clear();
    operations.clear();
  }
}
