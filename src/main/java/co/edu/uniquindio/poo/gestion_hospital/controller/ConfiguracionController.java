package co.edu.uniquindio.poo.gestion_hospital.controller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.gestion_hospital.model.Hospital;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class ConfiguracionController {
    Hospital hospital = Hospital.getInstance();

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
        // Obtener la ventana actual (Pantalla de Pacientes) y cerrarla
        Stage stageActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stageActual.close();
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
