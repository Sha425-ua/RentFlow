package com.rentflow.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import atlantafx.base.theme.PrimerLight;

import java.net.URL;
import java.util.Objects;

@Component
public class SpringStageManager {

    private final ApplicationContext applicationContext;

    public SpringStageManager(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void showMainStage(Stage stage) throws Exception {
        URL fxml = getClass().getResource("/com/rentflow/app/view/fxml/main-view-2.fxml");

        FXMLLoader loader = new FXMLLoader(fxml);

        loader.setControllerFactory(applicationContext::getBean);

        Scene scene = new Scene(loader.load(), 900, 600);
        Application.setUserAgentStylesheet(new PrimerLight().getUserAgentStylesheet());
//        scene.getStylesheets().add(
//                Objects.requireNonNull(
//                        getClass().getResource("/com/rentflow/app/view/css/primer-light.css")
//                ).toExternalForm()
//        );
        scene.getStylesheets().add(
                getClass().getResource("/com/rentflow/app/view/css/custom-style.css").toExternalForm()
        );
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setTitle("RentFlow");


        stage.show();
    }
}
