/**
 * Sample Skeleton for 'CitaView.fxml' Controller Class
 */

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

import javafx.stage.Stage;



public class CitaController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="atrasBoton"
    private Button atrasBoton; // Value injected by FXMLLoader

    @FXML // fx:id="añadirCitaBoton"
    private Button añadirCitaBoton; // Value injected by FXMLLoader

    @FXML // fx:id="citasTabla"
    private TableView<?> citasTabla; // Value injected by FXMLLoader

    @FXML // fx:id="eliminarCitaBoton"
    private Button eliminarCitaBoton; // Value injected by FXMLLoader

    @FXML // fx:id="fechaColumna"
    private TableColumn<?, ?> fechaColumna; // Value injected by FXMLLoader

    @FXML // fx:id="fechaPicker"
    private DatePicker fechaPicker; // Value injected by FXMLLoader

    @FXML // fx:id="medicoColumna"
    private TableColumn<?, ?> medicoColumna; // Value injected by FXMLLoader

    @FXML // fx:id="medicoComboBox"
    private ComboBox<?> medicoComboBox; // Value injected by FXMLLoader

    @FXML // fx:id="pacienteColumna"
    private TableColumn<?, ?> pacienteColumna; // Value injected by FXMLLoader

    @FXML // fx:id="pacienteComboBox"
    private ComboBox<?> pacienteComboBox; // Value injected by FXMLLoader

    @FXML
    void atrasAccion(ActionEvent event) {

        // Obtener la ventana actual (Pantalla de Pacientes) y cerrarla
        Stage stageActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stageActual.close();


    }

    @FXML
    void añadirCitaAccion(ActionEvent event) {

    }

    @FXML
    void eliminarCitaAccion(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert atrasBoton != null : "fx:id=\"atrasBoton\" was not injected: check your FXML file 'CitaView.fxml'.";
        assert añadirCitaBoton != null : "fx:id=\"añadirCitaBoton\" was not injected: check your FXML file 'CitaView.fxml'.";
        assert citasTabla != null : "fx:id=\"citasTabla\" was not injected: check your FXML file 'CitaView.fxml'.";
        assert eliminarCitaBoton != null : "fx:id=\"eliminarCitaBoton\" was not injected: check your FXML file 'CitaView.fxml'.";
        assert fechaColumna != null : "fx:id=\"fechaColumna\" was not injected: check your FXML file 'CitaView.fxml'.";
        assert fechaPicker != null : "fx:id=\"fechaPicker\" was not injected: check your FXML file 'CitaView.fxml'.";
        assert medicoColumna != null : "fx:id=\"medicoColumna\" was not injected: check your FXML file 'CitaView.fxml'.";
        assert medicoComboBox != null : "fx:id=\"medicoComboBox\" was not injected: check your FXML file 'CitaView.fxml'.";
        assert pacienteColumna != null : "fx:id=\"pacienteColumna\" was not injected: check your FXML file 'CitaView.fxml'.";
        assert pacienteComboBox != null : "fx:id=\"pacienteComboBox\" was not injected: check your FXML file 'CitaView.fxml'.";

    }

}

