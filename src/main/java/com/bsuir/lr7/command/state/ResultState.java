package com.bsuir.lr7.command.state;

import com.bsuir.lr7.command.Calculator;

public class ResultState implements CalculatorState {

  @Override
  public void handleDigit(Calculator calculator, String digit) {
    calculator.clearInternal();
    calculator.appendDigitInternal(digit);
    calculator.setState(new InputDigitState()); // Switch to digit input mode after entering a digit
  }

  @Override
  public void handleOperation(Calculator calculator, String operation) {
    calculator.applyOperationInternal(operation);
    calculator.setState(new InputDigitState()); // After an operation, go to input mode
  }

  @Override
  public void handleClear(Calculator calculator) {
    calculator.clearInternal();
    calculator.setState(new InputDigitState()); // Clear and go to input mode
  }

  @Override
  public void handleEqual(Calculator calculator) {
    // Do nothing since the result is already displayed.
  }
}

