package com.bsuir.lr7.command;

public class ClearCommand implements Command {
  private final Calculator calculator;

  public ClearCommand(Calculator calculator) {
    this.calculator = calculator;
  }

  @Override
  public void execute() {
    calculator.clear();
  }
}
