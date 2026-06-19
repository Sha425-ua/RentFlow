package com.rentflow.app.controller.nav;

import com.rentflow.app.SpringStageManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class CarsController implements Initializable {
    @Autowired
    private SpringStageManager stageManager;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
