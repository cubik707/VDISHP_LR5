package com.bsuir.lr7.command.state;

import com.bsuir.lr7.command.Calculator;

public interface CalculatorState {
  void handleDigit(Calculator calculator, String digit);
  void handleOperation(Calculator calculator, String operation);
  void handleClear(Calculator calculator);
  void handleEqual(Calculator calculator);
}