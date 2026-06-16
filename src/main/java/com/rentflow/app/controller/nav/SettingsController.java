package com.rentflow.app.controller.nav;

import com.rentflow.app.SpringStageManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class SettingsController implements Initializable {

    @FXML
    private Slider fontSlider;

    @FXML
    private Label previewLabel;

    @Autowired
    private SpringStageManager stageManager;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fontSlider.setMin(10);
        fontSlider.setMax(18);
        fontSlider.setValue(14);

        previewLabel.setText("Preview Text: 14px");
        previewLabel.setText("-fx-font-size: 14px;");
        fontSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            int newSize = newValue.intValue();

            fontSlider.getScene().getRoot().setStyle("-fx-font-size: " + newSize + "px;");
            previewLabel.setText("Preview Text: " + newSize + "px");
            previewLabel.setText("-fx-font-size: " + newSize + "px;");
        });
    }
}
