module com.bsuir.lr7.command {
  requires javafx.controls;
  requires javafx.fxml;


  opens com.bsuir.lr7.command to javafx.fxml;
  exports com.bsuir.lr7.command;
  exports com.bsuir.lr7.command.commands;
  opens com.bsuir.lr7.command.commands to javafx.fxml;
}