package com.bytecode.javafx.spring.integration.SpringJavaFXIntegration;

import com.bytecode.javafx.spring.integration.SpringJavaFXIntegration.config.StageManager;
import com.bytecode.javafx.spring.integration.SpringJavaFXIntegration.view.FxmlView;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;



@SpringBootApplication
public class SpringJavaFxIntegrationApplication extends Application {
    protected ConfigurableApplicationContext springContext;
    protected StageManager stageManager;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() {
        springContext = new SpringApplicationBuilder(SpringJavaFxIntegrationApplication.class).run();
    }

    @Override
    public void start(Stage stage) throws Exception {
        stageManager = springContext.getBean(StageManager.class, stage);
        displayInitialScene();
    }


    @Override
    public void stop() throws Exception {
        springContext.close();
    }

    /**
     * Useful to override this method by sub-classes wishing to change the first
     * Scene to be displayed on startup. Example: Functional tests on main
     * window.
     */
    protected void displayInitialScene() {
        stageManager.switchScene(FxmlView.LOGIN);
    }

    private ConfigurableApplicationContext springBootApplicationContext() {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringJavaFxIntegrationApplication.class);
        String[] args = getParameters().getRaw().stream().toArray(String[]::new);
        return builder.run(args);
    }
}
