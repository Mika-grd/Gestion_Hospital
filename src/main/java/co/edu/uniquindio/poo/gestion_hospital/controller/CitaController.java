package co.edu.uniquindio.poo.gestion_hospital.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.gestion_hospital.model.Cita;
import co.edu.uniquindio.poo.gestion_hospital.model.Hospital;
import co.edu.uniquindio.poo.gestion_hospital.model.Medico;
import co.edu.uniquindio.poo.gestion_hospital.model.Paciente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.StringConverter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CitaController {

    private Hospital hospital = Hospital.getInstance();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button atrasBoton;

    @FXML
    private Button añadirCitaBoton;

    @FXML
    private TableView<Cita> citasTabla;

    @FXML
    private Button eliminarCitaBoton;

    @FXML
    private TableColumn<Cita, LocalDate> fechaColumna;

    @FXML
    private DatePicker fechaPicker;

    @FXML
    private TableColumn<Cita, String> medicoColumna;

    @FXML
    private ComboBox<Medico> medicoComboBox;

    @FXML
    private TableColumn<Cita, String> pacienteColumna;

    @FXML
    private ComboBox<Paciente> pacienteComboBox;

    private ObservableList<Cita> listaCitas;

    @FXML
    void atrasAccion(ActionEvent event) {
        Stage stageActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stageActual.close();
    }

    @FXML
    void añadirCitaAccion(ActionEvent event) {
        if (medicoComboBox.getValue() == null || pacienteComboBox.getValue() == null || fechaPicker.getValue() == null) {
            mostrarAlerta("Error", "Debe seleccionar un médico, un paciente y una fecha.");
            return;
        }

        Cita nuevaCita = new Cita(fechaPicker.getValue(),medicoComboBox.getValue() ,pacienteComboBox.getValue());
        hospital.añadirCita(nuevaCita);
        listaCitas.add(nuevaCita);

        mostrarAlerta("Éxito", "Cita añadida correctamente.");
    }

    @FXML
    void eliminarCitaAccion(ActionEvent event) {
        Cita citaSeleccionada = citasTabla.getSelectionModel().getSelectedItem();

        if (citaSeleccionada == null) {
            mostrarAlerta("Error", "Debe seleccionar una cita para eliminar.");
            return;
        }

        hospital.eliminarCita(citaSeleccionada);
        listaCitas.remove(citaSeleccionada);

        mostrarAlerta("Éxito", "Cita eliminada correctamente.");
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    @FXML
    void initialize() {

        // Obtener la lista de medicos del hospital
        LinkedList<Medico> listaMedicos = hospital.getListaMedicos();

        // Pasar la lista al ComboBox
        medicoComboBox.setItems(FXCollections.observableArrayList(listaMedicos));

        // Definir cómo se mostrará cada Medico en el ComboBox
        medicoComboBox.setConverter(new StringConverter<Medico>() {
            @Override
            public String toString(Medico medico) {
                return (medico != null) ? medico.getNombre() : "";
            }

            @Override
            public Medico fromString(String string) {
                return null; // No se necesita conversión inversa
            }
        });

        // Obtener la lista de pacientes del hospital
        LinkedList<Paciente> listaPacientes = hospital.getListaPacientes();

        // Pasar la lista al ComboBox
        pacienteComboBox.setItems(FXCollections.observableArrayList(listaPacientes));

        // Definir cómo se mostrará cada paciente en el ComboBox
        pacienteComboBox.setConverter(new StringConverter<Paciente>() {
            @Override
            public String toString(Paciente paciente) {
                return (paciente != null) ? paciente.getNombre() : "";
            }

            @Override
            public Paciente fromString(String string) {
                return null; // No se necesita conversión inversa
            }
        });
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

        // Configurar columnas de la tabla
        fechaColumna.setCellValueFactory(new PropertyValueFactory<>("fechaCita"));
        medicoColumna.setCellValueFactory(new PropertyValueFactory<>("nombreMedico"));
        pacienteColumna.setCellValueFactory(new PropertyValueFactory<>("nombrePaciente"));

        // Inicializar listas
        listaCitas = FXCollections.observableArrayList(hospital.getListaCitas());
        citasTabla.setItems(listaCitas);

        // Llenar ComboBox con los datos de Hospital
        medicoComboBox.setItems(FXCollections.observableArrayList(hospital.getListaMedicos()));
        pacienteComboBox.setItems(FXCollections.observableArrayList(hospital.getListaPacientes()));
    }
}


