package ru.croc.task19;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {

    @FXML
    private Label textLabel;

    @FXML
    public void initialize() {
        textLabel.setText("Hello, World!");
    }
}
