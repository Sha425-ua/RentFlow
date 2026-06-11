package com.rentflow.app;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class JavaFxApplication extends Application {

    private ConfigurableApplicationContext springContext;

    @Override
    public void init() {
        springContext = new SpringApplicationBuilder(RentFlowApplication.class)
                .run(getParameters().getRaw().toArray(new String[0]));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        SpringStageManager stageManager = springContext.getBean(SpringStageManager.class);
        stageManager.showMainStage(primaryStage);
    }

    @Override
    public void stop() throws Exception {
        springContext.close();
        Platform.exit();
    }
}
