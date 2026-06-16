package com.rentflow.app.controller.nav;

import com.rentflow.app.SpringStageManager;
import com.rentflow.app.controller.CarDto;
import com.rentflow.app.controller.CarStatus;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class DashboardController implements Initializable {

    @FXML
    private ListView<CarDto> fleetList;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Список автомобілів
        fleetList.getItems().addAll(
                new CarDto("Toyota Camry", "АА 1234 BB", CarStatus.RENTED),
                new CarDto("BMW X5", "АХ 5678 KH", CarStatus.AVAILABLE),
                new CarDto("Renault Logan", "BH 9012 XX", CarStatus.SERVICE),
                new CarDto("Volkswagen Polo", "KA 3456 MH", CarStatus.RENTED),
                new CarDto("BMW M5 E60", "AA 7777 AA", CarStatus.RENTED)
        );

        fleetList.setCellFactory(list -> new ListCell<>() {
            @Override
            protected void updateItem(CarDto car, boolean empty) {
                super.updateItem(car, empty);
                if (empty || car == null) {
                    setGraphic(null);
                    return;
                }

                HBox row = new HBox(10);
                row.getStyleClass().add("fleet-item");
                row.setAlignment(Pos.CENTER_LEFT);

                Label icon = new Label("🚗");
                icon.getStyleClass().add("fleet-icon-box");

                VBox info = new VBox(2);
                Label model = new Label(car.model());
                model.getStyleClass().add("fleet-car-model");
                Label plate = new Label(car.plate());
                plate.getStyleClass().add("fleet-car-plate");
                info.getChildren().addAll(model, plate);
                HBox.setHgrow(info, Priority.ALWAYS);

                Label dot = new Label("●");
                Label statusLabel = new Label(car.status().getLabel());
                statusLabel.getStyleClass().add("avail-text");

                switch (car.status()) {
                    case AVAILABLE -> dot.getStyleClass().add("dot-green");
                    case RENTED    -> dot.getStyleClass().add("dot-amber");
                    case SERVICE   -> dot.getStyleClass().add("dot-red");
                }

                HBox status = new HBox(4, dot, statusLabel);
                status.setAlignment(Pos.CENTER_RIGHT);

                row.getChildren().addAll(icon, info, status);
                setGraphic(row);
            }
        });
    }
}