package co.edu.uniquindio.poo.gestion_hospital.controller;

import java.io.IOException;


import java.net.URL;
import java.util.LinkedList;
import java.util.Optional;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.gestion_hospital.model.Hospital;
import co.edu.uniquindio.poo.gestion_hospital.model.Paciente;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class PacienteController {
    Hospital hospital = Hospital.getInstance();

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
    private TableColumn<Paciente, String> edadColumna;

    @FXML
    private Button eliminarPacienteBoton;

    @FXML

    private Button gestionarReportesBoton;

    @FXML

    private TableColumn<Paciente, String> idColumna;

    @FXML
    private TableView<Paciente> medicosTabla;

    @FXML
    private TableColumn<Paciente, String> nombreColumna;

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
        // Obtener la ventana actual (Pantalla de Pacientes) y cerrarla
        Stage stageActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stageActual.close();
    }

    @FXML
    void añadirPacienteAccion(ActionEvent event) {
        if (pacienteNombreCampo.getText().isEmpty() ||
                pacienteCedulaCampo.getText().isEmpty() ||
                pacienteEdadCampo.getText().isEmpty()) {

            // Mostrar alerta si algún campo está vacío
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Error al añadir paciente");
            alerta.setHeaderText(null);
            alerta.setContentText("Todos los campos son obligatorios. ¡Por favor, complétalos!");
            alerta.showAndWait();

        } else {
            // Crear y añadir paciente
            Paciente paciente = new Paciente(
                    pacienteNombreCampo.getText(),
                    pacienteCedulaCampo.getText(),
                    pacienteEdadCampo.getText(),
                    new LinkedList<>()
            );
            hospital.añadirPaciente(paciente);

            // Mostrar mensaje de éxito (opcional)
            Alert confirmacion = new Alert(Alert.AlertType.INFORMATION);
            confirmacion.setTitle("Paciente añadido");
            confirmacion.setHeaderText(null);
            confirmacion.setContentText("El paciente ha sido añadido con éxito.");
            confirmacion.showAndWait();
        }
    }


    @FXML
    void buscarAccion(ActionEvent event) {
        String cedula = busquedaCampo.getText().trim(); // Obtener el texto del campo

        if (cedula.isEmpty()) {
            // Alerta si el campo está vacío
            Alert alertaVacia = new Alert(Alert.AlertType.WARNING);
            alertaVacia.setTitle("Campo vacío");
            alertaVacia.setHeaderText(null);
            alertaVacia.setContentText("Por favor, ingrese una cédula para buscar.");
            alertaVacia.showAndWait();
            return;
        }

        // Buscar el paciente en el hospital
        Paciente pacienteEncontrado = hospital.buscarPaciente(cedula);

        if (pacienteEncontrado != null) {
            // Seleccionar y resaltar el paciente en la tabla
            medicosTabla.getSelectionModel().select(pacienteEncontrado);
            medicosTabla.scrollTo(pacienteEncontrado);


            // Alerta de éxito
            Alert alertaExito = new Alert(Alert.AlertType.INFORMATION);
            alertaExito.setTitle("Paciente encontrado");
            alertaExito.setHeaderText(null);
            alertaExito.setContentText("El paciente con cédula " + cedula + " ha sido encontrado y resaltado en la tabla.");
            alertaExito.showAndWait();
        } else {
            // Alerta de error si no se encuentra
            Alert alertaNoEncontrado = new Alert(Alert.AlertType.ERROR);
            alertaNoEncontrado.setTitle("Paciente no encontrado");
            alertaNoEncontrado.setHeaderText(null);
            alertaNoEncontrado.setContentText("No se encontró un paciente con la cédula: " + cedula);
            alertaNoEncontrado.showAndWait();
        }
    }

    @FXML
    void eliminarPacienteAccion(ActionEvent event) {
        Paciente pacienteSeleccionado = medicosTabla.getSelectionModel().getSelectedItem();

        if (pacienteSeleccionado != null) {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Confirmación");
            alerta.setHeaderText("Eliminar paciente");
            alerta.setContentText("¿Estás seguro de que deseas eliminar al paciente?");

            Optional<ButtonType> resultado = alerta.showAndWait();

            if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
                hospital.eliminarPaciente(pacienteSeleccionado);

            }
        } else {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Advertencia");
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor, selecciona un paciente para eliminar.");
            alerta.showAndWait();
        }
    }

    @FXML

    void gestionarReportesAccion(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/gestion_hospital/ReporteView.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Gestionar Reportes");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML

  
    void recargarAccion(ActionEvent event) {
        LinkedList<Paciente> listaPacientes = hospital.getListaPacientes();

        // Refresca la tabla
        medicosTabla.setItems(FXCollections.observableArrayList(listaPacientes));
    }

    @FXML
    void initialize() {
        idColumna.setCellValueFactory(new PropertyValueFactory<>("id"));
        nombreColumna.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        edadColumna.setCellValueFactory(new PropertyValueFactory<>("edad"));
        assert atrasBoton != null : "fx:id=\"atrasBoton\" was not injected: check your FXML file 'PacienteView.fxml'.";
        assert añadirPacienteBoton != null : "fx:id=\"añadirPacienteBoton\" was not injected: check your FXML file 'PacienteView.fxml'.";
        assert buscarBoton != null : "fx:id=\"buscarBoton\" was not injected: check your FXML file 'PacienteView.fxml'.";
        assert busquedaCampo != null : "fx:id=\"busquedaCampo\" was not injected: check your FXML file 'PacienteView.fxml'.";
        assert edadColumna != null : "fx:id=\"edadColumna\" was not injected: check your FXML file 'PacienteView.fxml'.";
        assert eliminarPacienteBoton != null : "fx:id=\"eliminarPacienteBoton\" was not injected: check your FXML file 'PacienteView.fxml'.";

        assert gestionarReportesBoton != null : "fx:id=\"gestionarReportesBoton\" was not injected: check your FXML file 'PacienteView.fxml'.";

        assert idColumna != null : "fx:id=\"idColumna\" was not injected: check your FXML file 'PacienteView.fxml'.";
        assert medicosTabla != null : "fx:id=\"medicosTabla\" was not injected: check your FXML file 'PacienteView.fxml'.";
        assert nombreColumna != null : "fx:id=\"nombreColumna\" was not injected: check your FXML file 'PacienteView.fxml'.";
        assert pacienteCedulaCampo != null : "fx:id=\"pacienteCedulaCampo\" was not injected: check your FXML file 'PacienteView.fxml'.";
        assert pacienteEdadCampo != null : "fx:id=\"pacienteEdadCampo\" was not injected: check your FXML file 'PacienteView.fxml'.";
        assert pacienteNombreCampo != null : "fx:id=\"pacienteNombreCampo\" was not injected: check your FXML file 'PacienteView.fxml'.";
        assert recargarBoton != null : "fx:id=\"recargarBoton\" was not injected: check your FXML file 'PacienteView.fxml'.";

    }

}



