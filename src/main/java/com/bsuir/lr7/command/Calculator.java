package com.bsuir.lr7.command;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
  private List<Double> operands = new ArrayList<>();
  private List<String> operations = new ArrayList<>();
  private String currentInput = "";

  public void appendDigit(String digit) {
    currentInput += digit;
  }

  public void applyOperation(String operation) {
    if (!currentInput.isEmpty()) {
      operands.add(Double.parseDouble(currentInput));
      currentInput = "";
      operations.add(operation);
    }
  }

  public void clear() {
    operands.clear();
    operations.clear();
    currentInput = "";
  }

  public void calculateResult() {
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


  public String getCurrentInput() {
    return currentInput;
  }
}
