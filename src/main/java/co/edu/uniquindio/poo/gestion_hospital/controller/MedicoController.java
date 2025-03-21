package co.edu.uniquindio.poo.gestion_hospital.controller;



import java.net.URL;
import java.util.LinkedList;
import java.util.Optional;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.gestion_hospital.model.Hospital;
import co.edu.uniquindio.poo.gestion_hospital.model.Medico;
import co.edu.uniquindio.poo.gestion_hospital.model.Paciente;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class MedicoController {
    Hospital hospital = Hospital.getInstance();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button atrasBoton;

    @FXML
    private Button añadirMedicoBoton;

    @FXML
    private Button buscarBoton;

    @FXML
    private TextField busquedaCampo;

    @FXML
    private Button eliminarMedicoBoton;

    @FXML
    private TableColumn<Medico, String> idColumna;

    @FXML
    private TextField medicoCedulaCampo;

    @FXML
    private TextField medicoNombreCampo;

    @FXML
    private TableView<Medico> medicosTabla;

    @FXML
    private TableColumn<Medico, String> nombreColumna;

    @FXML
    private Button recargarBoton;

    @FXML
    void atrasAccion(ActionEvent event) {
        // Obtener la ventana actual (Pantalla de Pacientes) y cerrarla
        Stage stageActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stageActual.close();
    }

    @FXML
    void añadirMedicoAccion(ActionEvent event) {
        if (medicoNombreCampo.getText().isEmpty() ||
                medicoCedulaCampo.getText().isEmpty()) {

            // Mostrar alerta si algún campo está vacío
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Error al añadir médico");
            alerta.setHeaderText(null);
            alerta.setContentText("Todos los campos son obligatorios. ¡Por favor, complétalos!");
            alerta.showAndWait();

        } else {
            // Crear y añadir medico
            Medico medico = new Medico(
                    medicoNombreCampo.getText(),
                    medicoCedulaCampo.getText()
            );
            hospital.agregarMedico(medico);

            // Mostrar mensaje de éxito (opcional)
            Alert confirmacion = new Alert(Alert.AlertType.INFORMATION);
            confirmacion.setTitle("Médico añadido");
            confirmacion.setHeaderText(null);
            confirmacion.setContentText("El médico ha sido añadido con éxito.");
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

        // Buscar el medico en el hospital
        Medico medicoEncontrado = hospital.buscarMedico(cedula);

        if (medicoEncontrado != null) {
            // Seleccionar y resaltar el paciente en la tabla
            medicosTabla.getSelectionModel().select(medicoEncontrado);
            medicosTabla.scrollTo(medicoEncontrado);


            // Alerta de éxito
            Alert alertaExito = new Alert(Alert.AlertType.INFORMATION);
            alertaExito.setTitle("médico encontrado");
            alertaExito.setHeaderText(null);
            alertaExito.setContentText("El médico con cédula " + cedula + " ha sido encontrado y resaltado en la tabla.");
            alertaExito.showAndWait();
        } else {
            // Alerta de error si no se encuentra
            Alert alertaNoEncontrado = new Alert(Alert.AlertType.ERROR);
            alertaNoEncontrado.setTitle("médico no encontrado");
            alertaNoEncontrado.setHeaderText(null);
            alertaNoEncontrado.setContentText("No se encontró un médico con la cédula: " + cedula);
            alertaNoEncontrado.showAndWait();
        }
    }

    @FXML
    void eliminarMedicoAccion(ActionEvent event) {
        Medico medicoSeleccionado = medicosTabla.getSelectionModel().getSelectedItem();

        if (medicoSeleccionado != null) {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Confirmación");
            alerta.setHeaderText("Eliminar Médico");
            alerta.setContentText("¿Estás seguro de que deseas eliminar al paciente?");

            Optional<ButtonType> resultado = alerta.showAndWait();

            if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
                hospital.eliminarMedico(medicoSeleccionado);

            }
        } else {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Advertencia");
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor, selecciona un médico para eliminar.");
            alerta.showAndWait();
        }
    }

    @FXML
    void recargarAccion(ActionEvent event) {
        LinkedList<Medico> listaMedicos = hospital.getListaMedicos();

        // Refresca la tabla
        medicosTabla.setItems(FXCollections.observableArrayList(listaMedicos));
    }

    @FXML
    void initialize() {
        idColumna.setCellValueFactory(new PropertyValueFactory<>("id"));
        nombreColumna.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        assert atrasBoton != null : "fx:id=\"atrasBoton\" was not injected: check your FXML file 'MedicoView.fxml'.";
        assert añadirMedicoBoton != null : "fx:id=\"añadirMedicoBoton\" was not injected: check your FXML file 'MedicoView.fxml'.";
        assert buscarBoton != null : "fx:id=\"buscarBoton\" was not injected: check your FXML file 'MedicoView.fxml'.";
        assert busquedaCampo != null : "fx:id=\"busquedaCampo\" was not injected: check your FXML file 'MedicoView.fxml'.";
        assert eliminarMedicoBoton != null : "fx:id=\"eliminarMedicoBoton\" was not injected: check your FXML file 'MedicoView.fxml'.";
        assert idColumna != null : "fx:id=\"idColumna\" was not injected: check your FXML file 'MedicoView.fxml'.";
        assert medicoCedulaCampo != null : "fx:id=\"medicoCedulaCampo\" was not injected: check your FXML file 'MedicoView.fxml'.";
        assert medicoNombreCampo != null : "fx:id=\"medicoNombreCampo\" was not injected: check your FXML file 'MedicoView.fxml'.";
        assert medicosTabla != null : "fx:id=\"medicosTabla\" was not injected: check your FXML file 'MedicoView.fxml'.";
        assert nombreColumna != null : "fx:id=\"nombreColumna\" was not injected: check your FXML file 'MedicoView.fxml'.";
        assert recargarBoton != null : "fx:id=\"recargarBoton\" was not injected: check your FXML file 'MedicoView.fxml'.";

    }

}


