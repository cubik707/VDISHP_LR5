package com.bsuir.lr7.command;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalculatorApp extends Application {
  @Override
  public void start(Stage primaryStage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("calculator.fxml"));
    primaryStage.setScene(new Scene(loader.load()));
    primaryStage.setTitle("Customizable Calculator");
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
