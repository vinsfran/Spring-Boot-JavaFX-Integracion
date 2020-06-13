package com.bytecode.javafx.spring.integration.SpringJavaFXIntegration.controller;

import com.bytecode.javafx.spring.integration.SpringJavaFXIntegration.model.Persona;
import com.bytecode.javafx.spring.integration.SpringJavaFXIntegration.repo.PersonaRep;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class PersonaController implements Initializable {

    private static final Log LOG = LogFactory.getLog(PersonaController.class);

    @Autowired
    private PersonaRep personaRep;

    @FXML
    private Label lblTitulo;

    @FXML
    private Button btnAgregar;

    @FXML
    private TextField txtCi;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtEdad;

    @FXML
    private TableView<Persona> tblPersonas;

    @FXML
    private TableColumn colCi;

    @FXML
    private TableColumn colNombre;

    @FXML
    private TableColumn colApellido;

    @FXML
    private TableColumn colEdad;

    private ObservableList<Persona> personas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LOG.info(Global.loginModel);
        personas = FXCollections.observableArrayList(personaRep.findAll());
        this.colCi.setCellValueFactory(new PropertyValueFactory("ci"));
        this.colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colApellido.setCellValueFactory(new PropertyValueFactory("apellido"));
        this.colEdad.setCellValueFactory(new PropertyValueFactory("edad"));

        this.tblPersonas.setItems(personas);
    }

    @FXML
    public void agregarPersona(ActionEvent event) {

        try {
            String ci = this.txtCi.getText();
            String nombre = this.txtNombre.getText();
            String apellido = this.txtApellido.getText();
            int edad = Integer.parseInt(this.txtEdad.getText());

            Persona p = personaRep.findByCi(ci);
            if (p == null) {
                p = new Persona();
                p.setCi(ci);
                p.setNombre(nombre);
                p.setApellido(apellido);
                p.setEdad(edad);
                personaRep.save(p);
                this.personas.add(p);
                this.tblPersonas.setItems(personas);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("La persona existe");
                alert.showAndWait();
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato de Edad incorrecta");
            alert.showAndWait();
        }


    }

    public void closeWindows() {
    }
}
