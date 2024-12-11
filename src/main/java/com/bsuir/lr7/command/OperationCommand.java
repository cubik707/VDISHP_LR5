package com.bsuir.lr7.command;

public class OperationCommand implements Command {
  private final Calculator calculator;
  private final String operation;

  public OperationCommand(Calculator calculator, String operation) {
    this.calculator = calculator;
    this.operation = operation;
  }

  @Override
  public void execute() {
    calculator.applyOperation(operation);
  }
}

