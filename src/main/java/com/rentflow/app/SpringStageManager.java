package com.rentflow.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import atlantafx.base.theme.PrimerLight;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

@Component
public class SpringStageManager {

    @Autowired
    private final ApplicationContext applicationContext;

    private Stage stage;

    public SpringStageManager(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void showMainStage(Stage stage) throws Exception {
        this.stage = stage;

        URL fxml = getClass().getResource("/com/rentflow/app/view/fxml/main-view.fxml");
        FXMLLoader loader = new FXMLLoader(fxml);
        loader.setControllerFactory(applicationContext::getBean);

        Scene scene = new Scene(loader.load());
        Application.setUserAgentStylesheet(new PrimerLight().getUserAgentStylesheet());

        scene.getStylesheets().add(new PrimerLight().getUserAgentStylesheet());

        scene.getStylesheets().add(
                Objects.requireNonNull(getClass().getResource("/com/rentflow/app/view/css/custom-style.css")).toExternalForm()
        );

        stage.setScene(scene);
        stage.sizeToScene();
        stage.setTitle("RentFlow");

        stage.setMinWidth(800);
        stage.setMinHeight(400);
        stage.show();
    }

    public void showScene(String fxmlPath) {
        try {
            URL fxml = getClass().getResource(fxmlPath);
            FXMLLoader loader = new FXMLLoader(fxml);
            loader.setControllerFactory(applicationContext::getBean);

            Scene scene = new Scene(loader.load());
            scene.getStylesheets().add(new PrimerLight().getUserAgentStylesheet());
            scene.getStylesheets().add(
                    getClass().getResource("/com/rentflow/app/view/css/custom-style.css").toExternalForm()
            );

            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
