package co.edu.uniquindio.poo.gestion_hospital.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class ConfiguracionController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button aplicarBoton;

    @FXML
    private Button atrasBoton;

    @FXML
    private ComboBox<?> facturacionElectronicaCombo;

    @FXML
    private ComboBox<?> horariosCombo;

    @FXML
    private ComboBox<?> numeroPacientesCombo;

    @FXML
    void aplicarCambiosAction(ActionEvent event) {

    }

    @FXML
    void atrasAccion(ActionEvent event) {

    }

    @FXML
    void showFacturacionBoolean(ActionEvent event) {

    }

    @FXML
    void showHorarios(ActionEvent event) {

    }

    @FXML
    void showNumeroPacientesAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert aplicarBoton != null : "fx:id=\"aplicarBoton\" was not injected: check your FXML file 'HospitalConfiguracion.fxml'.";
        assert atrasBoton != null : "fx:id=\"atrasBoton\" was not injected: check your FXML file 'HospitalConfiguracion.fxml'.";
        assert facturacionElectronicaCombo != null : "fx:id=\"facturacionElectronicaCombo\" was not injected: check your FXML file 'HospitalConfiguracion.fxml'.";
        assert horariosCombo != null : "fx:id=\"horariosCombo\" was not injected: check your FXML file 'HospitalConfiguracion.fxml'.";
        assert numeroPacientesCombo != null : "fx:id=\"numeroPacientesCombo\" was not injected: check your FXML file 'HospitalConfiguracion.fxml'.";

    }

}
