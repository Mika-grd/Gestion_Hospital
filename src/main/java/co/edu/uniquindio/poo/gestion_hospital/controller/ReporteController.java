
package co.edu.uniquindio.poo.gestion_hospital.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.Node;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import javafx.stage.Stage;

public class ReporteController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button agregarReporteBoton;

    @FXML
    private Button atrasBoton;

    @FXML
    private Button buscarBoton;

    @FXML
    private TextField busquedaCampo;

    @FXML
    private Button clonarReporteBoton;

    @FXML
    private TableColumn<?, ?> colDescripcion;

    @FXML
    private TableColumn<?, ?> colEnfermedad;

    @FXML
    private TableColumn<?, ?> colFecha;

    @FXML
    private TableColumn<?, ?> colMedicamento;

    @FXML
    private TableColumn<?, ?> colPaciente;

    @FXML
    private TableColumn<?, ?> colTitulo;

    @FXML
    private TextField descripcionCampo;

    @FXML
    private Button eliminarReporteBoton;

    @FXML
    private TextField enfermedadCampo;

    @FXML
    private DatePicker fechaReporte;

    @FXML
    private TextField medicamentoCampo;

    @FXML
    private ComboBox<?> pacienteComboBox;

    @FXML
    private Button recargarBoton;

    @FXML
    private TableView<?> reportesTabla;

    @FXML
    private TextField tituloCampo;


public class ReporteController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="agregarReporteBoton"
    private Button agregarReporteBoton; // Value injected by FXMLLoader

    @FXML // fx:id="buscarBoton"
    private Button buscarBoton; // Value injected by FXMLLoader

    @FXML // fx:id="busquedaCampo"
    private TextField busquedaCampo; // Value injected by FXMLLoader

    @FXML // fx:id="clonarReporteBoton"
    private Button clonarReporteBoton; // Value injected by FXMLLoader

    @FXML // fx:id="colDescripcion"
    private TableColumn<?, ?> colDescripcion; // Value injected by FXMLLoader

    @FXML // fx:id="colEnfermedad"
    private TableColumn<?, ?> colEnfermedad; // Value injected by FXMLLoader

    @FXML // fx:id="colFecha"
    private TableColumn<?, ?> colFecha; // Value injected by FXMLLoader

    @FXML // fx:id="colMedicamento"
    private TableColumn<?, ?> colMedicamento; // Value injected by FXMLLoader

    @FXML // fx:id="colPaciente"
    private TableColumn<?, ?> colPaciente; // Value injected by FXMLLoader

    @FXML // fx:id="colTitulo"
    private TableColumn<?, ?> colTitulo; // Value injected by FXMLLoader

    @FXML // fx:id="descripcionCampo"
    private TextField descripcionCampo; // Value injected by FXMLLoader

    @FXML // fx:id="eliminarReporteBoton"
    private Button eliminarReporteBoton; // Value injected by FXMLLoader

    @FXML // fx:id="enfermedadCampo"
    private TextField enfermedadCampo; // Value injected by FXMLLoader

    @FXML // fx:id="fechaReporte"
    private DatePicker fechaReporte; // Value injected by FXMLLoader

    @FXML // fx:id="medicamentoCampo"
    private TextField medicamentoCampo; // Value injected by FXMLLoader

    @FXML // fx:id="pacienteComboBox"
    private ComboBox<?> pacienteComboBox; // Value injected by FXMLLoader

    @FXML // fx:id="recargarBoton"
    private Button recargarBoton; // Value injected by FXMLLoader

    @FXML // fx:id="reportesTabla"
    private TableView<?> reportesTabla; // Value injected by FXMLLoader

    @FXML // fx:id="tituloCampo"
    private TextField tituloCampo; // Value injected by FXMLLoader


    @FXML
    void agregarReporteAccion(ActionEvent event) {

    }

    @FXML

    void atrasAccion(ActionEvent event) {
        // Obtener la ventana actual (Pantalla de Pacientes) y cerrarla
        Stage stageActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stageActual.close();
    }

    @FXML

    void buscarAccion(ActionEvent event) {

    }

    @FXML
    void clonarReporteAccion(ActionEvent event) {

    }

    @FXML
    void eliminarReporteAccion(ActionEvent event) {

    }

    @FXML
    void recargarAccion(ActionEvent event) {

    }


    @FXML
    void initialize() {
        assert agregarReporteBoton != null : "fx:id=\"agregarReporteBoton\" was not injected: check your FXML file 'ReporteView.fxml'.";
        assert atrasBoton != null : "fx:id=\"atrasBoton\" was not injected: check your FXML file 'ReporteView.fxml'.";

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert agregarReporteBoton != null : "fx:id=\"agregarReporteBoton\" was not injected: check your FXML file 'ReporteView.fxml'.";

        assert buscarBoton != null : "fx:id=\"buscarBoton\" was not injected: check your FXML file 'ReporteView.fxml'.";
        assert busquedaCampo != null : "fx:id=\"busquedaCampo\" was not injected: check your FXML file 'ReporteView.fxml'.";
        assert clonarReporteBoton != null : "fx:id=\"clonarReporteBoton\" was not injected: check your FXML file 'ReporteView.fxml'.";
        assert colDescripcion != null : "fx:id=\"colDescripcion\" was not injected: check your FXML file 'ReporteView.fxml'.";
        assert colEnfermedad != null : "fx:id=\"colEnfermedad\" was not injected: check your FXML file 'ReporteView.fxml'.";
        assert colFecha != null : "fx:id=\"colFecha\" was not injected: check your FXML file 'ReporteView.fxml'.";
        assert colMedicamento != null : "fx:id=\"colMedicamento\" was not injected: check your FXML file 'ReporteView.fxml'.";
        assert colPaciente != null : "fx:id=\"colPaciente\" was not injected: check your FXML file 'ReporteView.fxml'.";
        assert colTitulo != null : "fx:id=\"colTitulo\" was not injected: check your FXML file 'ReporteView.fxml'.";
        assert descripcionCampo != null : "fx:id=\"descripcionCampo\" was not injected: check your FXML file 'ReporteView.fxml'.";
        assert eliminarReporteBoton != null : "fx:id=\"eliminarReporteBoton\" was not injected: check your FXML file 'ReporteView.fxml'.";
        assert enfermedadCampo != null : "fx:id=\"enfermedadCampo\" was not injected: check your FXML file 'ReporteView.fxml'.";
        assert fechaReporte != null : "fx:id=\"fechaReporte\" was not injected: check your FXML file 'ReporteView.fxml'.";
        assert medicamentoCampo != null : "fx:id=\"medicamentoCampo\" was not injected: check your FXML file 'ReporteView.fxml'.";
        assert pacienteComboBox != null : "fx:id=\"pacienteComboBox\" was not injected: check your FXML file 'ReporteView.fxml'.";
        assert recargarBoton != null : "fx:id=\"recargarBoton\" was not injected: check your FXML file 'ReporteView.fxml'.";
        assert reportesTabla != null : "fx:id=\"reportesTabla\" was not injected: check your FXML file 'ReporteView.fxml'.";
        assert tituloCampo != null : "fx:id=\"tituloCampo\" was not injected: check your FXML file 'ReporteView.fxml'.";

    }

}

