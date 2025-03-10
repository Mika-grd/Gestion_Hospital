package co.edu.uniquindio.poo.gestion_hospital.controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

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
    void configuracionHospitalAccion(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/gestion_hospital/HospitalConfiguracion.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Configuración del Hospital");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void gestionarCitasAccion(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/gestion_hospital/CitaView.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Gestión de Citas");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void gestionarMedicosAccion(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/gestion_hospital/MedicoView.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Gestión de Médicos");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void gestionarPacientesAccion(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/gestion_hospital/PacienteView.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Gestión de Pacientes");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        assert configuracionHospitalBoton != null : "fx:id=\"configuracionHospitalBoton\" was not injected: check your FXML file 'PrincipalView.fxml'.";
        assert gestionarCitasBoton != null : "fx:id=\"gestionarCitasBoton\" was not injected: check your FXML file 'PrincipalView.fxml'.";
        assert gestionarMedicosBoton != null : "fx:id=\"gestionarMedicosBoton\" was not injected: check your FXML file 'PrincipalView.fxml'.";
        assert gestionarPacientesBoton != null : "fx:id=\"gestionarPacientesBoton\" was not injected: check your FXML file 'PrincipalView.fxml'.";

    }

}

