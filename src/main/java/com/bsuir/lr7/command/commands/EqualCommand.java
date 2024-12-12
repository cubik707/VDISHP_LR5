package com.bsuir.lr7.command.commands;

import com.bsuir.lr7.command.Calculator;

public class EqualCommand implements Command {
  private final Calculator calculator;

  public EqualCommand(Calculator calculator) {
    this.calculator = calculator;
  }

  @Override
  public void execute() {
    calculator.calculateResult();
  }
}
