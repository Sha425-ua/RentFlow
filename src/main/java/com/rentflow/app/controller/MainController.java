package com.rentflow.app.controller;

import com.rentflow.app.SpringStageManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MainController {

    @FXML private VBox contentArea;
    @FXML private HBox navDashboardButton;
    @FXML private HBox navCarsButton;
    @FXML private HBox navContractsButton;
    @FXML private HBox navRentalsButton;
    @FXML private HBox navReportsButton;
    @FXML private HBox navSettingsButton;

    @Autowired private SpringStageManager stageManager;

    @Autowired
    private final ApplicationContext applicationContext;

    public MainController(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    private void loadSubView(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            loader.setControllerFactory(applicationContext::getBean);

            Parent view = loader.load();
            contentArea.getChildren().setAll(view);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void setActiveNav(HBox selected) {
        navDashboardButton.getStyleClass().remove("nav-item-active");
        navCarsButton.getStyleClass().remove("nav-item-active");
        navContractsButton.getStyleClass().remove("nav-item-active");
        navRentalsButton.getStyleClass().remove("nav-item-active");
        navReportsButton.getStyleClass().remove("nav-item-active");
        navSettingsButton.getStyleClass().remove("nav-item-active");

        selected.getStyleClass().add("nav-item-active");
    }

    @FXML
    private void onNavDashboard() {
        loadSubView("/com/rentflow/app/view/fxml/dashboard-view.fxml");
        setActiveNav(navDashboardButton);
    }

    @FXML
    private void onNavCars() {
        loadSubView("/com/rentflow/app/view/fxml/cars-view.fxml");
        setActiveNav(navCarsButton);
    }

    @FXML
    private void onNavContracts() {
        loadSubView("/com/rentflow/app/view/fxml/contracts-view.fxml");
        setActiveNav(navContractsButton);
    }

    @FXML
    private void onNavRentals() {
        loadSubView("/com/rentflow/app/view/fxml/rentals-view.fxml");
        setActiveNav(navRentalsButton);
    }

    @FXML
    private void onNavReports() {
        loadSubView("/com/rentflow/app/view/fxml/reports-view.fxml");
        setActiveNav(navReportsButton);
    }

    @FXML
    private void onNavSettings() {
        loadSubView("/com/rentflow/app/view/fxml/settings-view.fxml");
        setActiveNav(navSettingsButton);
    }

    public void initialize() {
        loadSubView("/com/rentflow/app/view/fxml/dashboard-view.fxml");
        setActiveNav(navDashboardButton);
    }
}
