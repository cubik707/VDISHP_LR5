package com.bsuir.lr7.command;

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
