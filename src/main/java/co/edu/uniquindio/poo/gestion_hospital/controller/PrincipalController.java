package co.edu.uniquindio.poo.gestion_hospital.controller;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PrincipalController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button configuracionHospitalBoton;

    @FXML
    private Button gestionarCitasBoton;

    @FXML
    private Button gestionarMedicosBoton;

    @FXML
    private Button gestionarPacientesBoton;

    @FXML
    void configuracionHospitalAccion(ActionEvent event) {

    }

    @FXML
    void gestionarCitasAccion(ActionEvent event) {

    }

    @FXML
    void gestionarMedicosAccion(ActionEvent event) {

    }

    @FXML
    void gestionarPacientesAccion(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert configuracionHospitalBoton != null : "fx:id=\"configuracionHospitalBoton\" was not injected: check your FXML file 'PrincipalView.fxml'.";
        assert gestionarCitasBoton != null : "fx:id=\"gestionarCitasBoton\" was not injected: check your FXML file 'PrincipalView.fxml'.";
        assert gestionarMedicosBoton != null : "fx:id=\"gestionarMedicosBoton\" was not injected: check your FXML file 'PrincipalView.fxml'.";
        assert gestionarPacientesBoton != null : "fx:id=\"gestionarPacientesBoton\" was not injected: check your FXML file 'PrincipalView.fxml'.";

    }

}

