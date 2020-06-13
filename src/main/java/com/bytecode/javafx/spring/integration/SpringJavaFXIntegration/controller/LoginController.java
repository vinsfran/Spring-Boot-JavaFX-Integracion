package com.bytecode.javafx.spring.integration.SpringJavaFXIntegration.controller;

import com.bytecode.javafx.spring.integration.SpringJavaFXIntegration.config.StageManager;
import com.bytecode.javafx.spring.integration.SpringJavaFXIntegration.model.LoginResponse;
import com.bytecode.javafx.spring.integration.SpringJavaFXIntegration.service.SimeacBackendService;
import com.bytecode.javafx.spring.integration.SpringJavaFXIntegration.view.FxmlView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class LoginController implements Initializable {

    private static final Log LOG = LogFactory.getLog(LoginController.class);

    @Autowired
    @Qualifier("simeacBackendServiceImpl")
    private SimeacBackendService simeacBackendService;

    @Lazy
    @Autowired
    private StageManager stageManager;

    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    private Label lblLogin;



    @FXML
    public void login(ActionEvent event) throws IOException {
        String usuario = username.getText();
        String pass = password.getText();

        if (usuario.isEmpty() || pass.isEmpty()) {
            setLblError(Color.TOMATO, "Credenciales no pueden estar vacias");
        } else {
            try {
                LoginResponse login = simeacBackendService.login(usuario, pass);
                if (login.getLoginModel() != null) {
                    Global.loginModel = login.getLoginModel();
                    setLblError(Color.GREEN, "Login Correcto..Redirecting..");
                    stageManager.switchScene(FxmlView.PERSONAS);
                } else {
                    setLblError(Color.TOMATO, login.getMessage().getMessages().get(0).getDescription());
                }
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }


    private void setLblError(Color color, String text) {
        lblLogin.setTextFill(color);
        lblLogin.setText(text);
        System.out.println(text);
    }

}
