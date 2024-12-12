package com.bsuir.lr7.command.state;

import com.bsuir.lr7.command.Calculator;

public class InputDigitState implements CalculatorState {

  @Override
  public void handleDigit(Calculator calculator, String digit) {
    calculator.appendDigitInternal(digit);
  }

  @Override
  public void handleOperation(Calculator calculator, String operation) {
    calculator.applyOperationInternal(operation);
    calculator.setState(new InputDigitState()); // After an operation, switch back to input mode
  }

  @Override
  public void handleClear(Calculator calculator) {
    calculator.clearInternal();
    calculator.setState(new InputDigitState()); // Clear and go back to input mode
  }

  @Override
  public void handleEqual(Calculator calculator) {
    calculator.calculateResultInternal();
    calculator.setState(new ResultState()); // After calculating, go to the result state
  }
}

