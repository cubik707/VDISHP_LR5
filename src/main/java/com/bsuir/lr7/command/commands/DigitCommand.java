package com.bsuir.lr7.command.commands;

import com.bsuir.lr7.command.Calculator;

public class DigitCommand implements Command {
  private final Calculator calculator;
  private final String digit;

  public DigitCommand(Calculator calculator, String digit) {
    this.calculator = calculator;
    this.digit = digit;
  }

  @Override
  public void execute() {
    calculator.appendDigit(digit);
  }
}


