package com.bsuir.lr7.command;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class CalculatorController {
  @FXML
  private TextField inputDisplay;

  private Calculator calculator = new Calculator();

  // Метод для обработки кликов по цифрам
  @FXML
  public void onDigitClick() {
    Button clickedButton = (Button) inputDisplay.getScene().getFocusOwner();
    String digit = clickedButton.getText();
    Command command = new DigitCommand(calculator, digit);
    command.execute();
    updateDisplay();
  }

  // Метод для обработки кликов по операциям
  @FXML
  public void onOperationClick() {
    Button clickedButton = (Button) inputDisplay.getScene().getFocusOwner();
    String operation = clickedButton.getText();
    Command command = new OperationCommand(calculator, operation);
    command.execute();
    updateDisplay();
  }

  // Метод для очистки
  @FXML
  public void onClearClick() {
    Command command = new ClearCommand(calculator);
    command.execute();
    updateDisplay();
  }

  // Метод для вычисления результата
  @FXML
  public void onEqualClick() {
    Command command = new EqualCommand(calculator);
    command.execute();
    updateDisplay();
  }

  private void updateDisplay() {
    inputDisplay.setText(calculator.getCurrentInput());
  }
}
