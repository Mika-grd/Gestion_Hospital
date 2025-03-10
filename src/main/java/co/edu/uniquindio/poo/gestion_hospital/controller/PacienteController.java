package co.edu.uniquindio.poo.gestion_hospital.controller;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PacienteController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button atrasBoton;

    @FXML
    private Button añadirPacienteBoton;

    @FXML
    private Button buscarBoton;

    @FXML
    private TextField busquedaCampo;

    @FXML
    private TableColumn<?, ?> edadColumna;

    @FXML
    private TableColumn<?, ?> idColumna;

    @FXML
    private TableView<?> medicosTabla;

    @FXML
    private TableColumn<?, ?> nombreColumna;

    @FXML
    private TextField pacienteCedulaCampo;

    @FXML
    private TextField pacienteEdadCampo;

    @FXML
    private TextField pacienteNombreCampo;

    @FXML
    private Button recargarBoton;

    @FXML
    void atrasAccion(ActionEvent event) {

    }

    @FXML
    void añadirPacienteAccion(ActionEvent event) {

    }

    @FXML
    void buscarAccion(ActionEvent event) {

    }

    @FXML
    void recargarAccion(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert atrasBoton != null : "fx:id=\"atrasBoton\" was not injected: check your FXML file 'PacienteView.fxml'.";
        assert añadirPacienteBoton != null : "fx:id=\"añadirPacienteBoton\" was not injected: check your FXML file 'PacienteView.fxml'.";
        assert buscarBoton != null : "fx:id=\"buscarBoton\" was not injected: check your FXML file 'PacienteView.fxml'.";
        assert busquedaCampo != null : "fx:id=\"busquedaCampo\" was not injected: check your FXML file 'PacienteView.fxml'.";
        assert edadColumna != null : "fx:id=\"edadColumna\" was not injected: check your FXML file 'PacienteView.fxml'.";
        assert idColumna != null : "fx:id=\"idColumna\" was not injected: check your FXML file 'PacienteView.fxml'.";
        assert medicosTabla != null : "fx:id=\"medicosTabla\" was not injected: check your FXML file 'PacienteView.fxml'.";
        assert nombreColumna != null : "fx:id=\"nombreColumna\" was not injected: check your FXML file 'PacienteView.fxml'.";
        assert pacienteCedulaCampo != null : "fx:id=\"pacienteCedulaCampo\" was not injected: check your FXML file 'PacienteView.fxml'.";
        assert pacienteEdadCampo != null : "fx:id=\"pacienteEdadCampo\" was not injected: check your FXML file 'PacienteView.fxml'.";
        assert pacienteNombreCampo != null : "fx:id=\"pacienteNombreCampo\" was not injected: check your FXML file 'PacienteView.fxml'.";
        assert recargarBoton != null : "fx:id=\"recargarBoton\" was not injected: check your FXML file 'PacienteView.fxml'.";

    }

}

