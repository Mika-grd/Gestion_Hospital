package co.edu.uniquindio.poo.gestion_hospital.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Optional;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.gestion_hospital.model.Hospital;
import co.edu.uniquindio.poo.gestion_hospital.model.Paciente;
import co.edu.uniquindio.poo.gestion_hospital.model.Reporte;
import javafx.beans.property.ObjectPropertyBase;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class ReporteController {
    Hospital hospital = Hospital.getInstance();


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button agregarReporteBoton;

    @FXML
    private Button atrasBoton;

    @FXML
    private Button clonarReporteBoton;

    @FXML
    private TableColumn<Reporte, String> colDescripcion;

    @FXML
    private TableColumn<Reporte, LocalDate> colFecha;

    @FXML
    private TableColumn<Reporte, String> colMedicamento;

    @FXML
    private TableColumn<Reporte, String> colPaciente;

    @FXML
    private TextField descripcionCampo;

    @FXML
    private Button eliminarReporteBoton;


    @FXML
    private DatePicker fechaReporte;

    @FXML
    private TextField medicamentoCampo;

    @FXML
    private ComboBox<Paciente> pacienteComboBox;

    @FXML
    private Button recargarBoton;

    @FXML
    private TableView<Reporte> reportesTabla;

    @FXML
    private Button editarReporteBoton;

    @FXML
    void editarReporteAccion(ActionEvent event) {
        // Obtener el reporte seleccionado de la tabla
        Reporte reporteSeleccionado = reportesTabla.getSelectionModel().getSelectedItem();

        // Obtener los nuevos valores desde los campos de entrada
        Paciente pacienteSeleccionado = pacienteComboBox.getSelectionModel().getSelectedItem();
        LocalDate fecha = fechaReporte.getValue();
        String descripcion = descripcionCampo.getText();
        String medicamento = medicamentoCampo.getText();

        // Validar que se haya seleccionado un reporte
        if (reporteSeleccionado == null) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Advertencia");
            alerta.setHeaderText("Selección requerida");
            alerta.setContentText("Por favor, selecciona un reporte de la tabla para editar.");
            alerta.showAndWait();
            return;
        }

        // Validar que los campos no estén vacíos
        if (pacienteSeleccionado == null || fecha == null || descripcion.isEmpty() || medicamento.isEmpty()) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Advertencia");
            alerta.setHeaderText("Campos incompletos");
            alerta.setContentText("Por favor, completa todos los campos antes de editar el reporte.");
            alerta.showAndWait();
            return;
        }

        // Crear el nuevo reporte con los datos actualizados
        Reporte reporteNuevo = new Reporte(fecha, descripcion, pacienteSeleccionado, medicamento);

        // Obtener la lista de reportes del paciente seleccionado
        LinkedList<Reporte> listaReportes = pacienteSeleccionado.getHistorialMedico();

        // Llamar al método para editar el reporte
        String resultado = hospital.editarReporte(reporteSeleccionado, reporteNuevo, listaReportes);

        // Verificar el resultado y mostrar el mensaje adecuado
        if (resultado.equals("No existe")) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("Reporte no encontrado");
            alerta.setContentText("El reporte seleccionado no se encuentra en la lista del paciente.");
            alerta.showAndWait();
        } else {
            // Refrescar la tabla para mostrar los cambios
            reportesTabla.refresh();

            // Mostrar mensaje de éxito
            Alert confirmacion = new Alert(Alert.AlertType.INFORMATION);
            confirmacion.setTitle("Éxito");
            confirmacion.setHeaderText("Reporte editado");
            confirmacion.setContentText("El reporte ha sido editado correctamente.");
            confirmacion.showAndWait();
        }
    }

    @FXML
    void agregarReporteAccion(ActionEvent event) {

        // Verificar que no haya campos vacíos
        if (pacienteComboBox.getSelectionModel().isEmpty() ||
                descripcionCampo.getText().isEmpty() ||
                fechaReporte.getValue() == null ||
                medicamentoCampo.getText().isEmpty()) {

            // Mostrar alerta si algún campo está vacío
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Error al añadir reporte");
            alerta.setHeaderText(null);
            alerta.setContentText("Todos los campos son obligatorios. ¡Por favor, complétalos!");
            alerta.showAndWait();

        } else {
            // Obtener los valores de los campos
            Paciente pacienteSeleccionado = pacienteComboBox.getSelectionModel().getSelectedItem();
            LocalDate fecha = fechaReporte.getValue();
            String descripcion = descripcionCampo.getText();
            String medicamento = medicamentoCampo.getText();

            // Crear el reporte
            Reporte reporte = new Reporte(fecha, descripcion, pacienteSeleccionado, medicamento);

            // Añadir el reporte (suponiendo que el hospital tiene un método para ello)
            hospital.agregarReporte(reporte, pacienteSeleccionado.getHistorialMedico()); // Asegúrate de tener este método en tu clase `Hospital`

            // Mostrar mensaje de éxito
            Alert confirmacion = new Alert(Alert.AlertType.INFORMATION);
            confirmacion.setTitle("Reporte añadido");
            confirmacion.setHeaderText(null);
            confirmacion.setContentText("El reporte ha sido añadido con éxito.");
            confirmacion.showAndWait();
        }
    }




    @FXML
    void atrasAccion(ActionEvent event) {
        // Obtener la ventana actual (Pantalla de Pacientes) y cerrarla
        Stage stageActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stageActual.close();
    }


    @FXML
    void clonarReporteAccion(ActionEvent event) {
        Paciente pacienteSeleccionado = pacienteComboBox.getSelectionModel().getSelectedItem();
        Reporte reporteSeleccionado = reportesTabla.getSelectionModel().getSelectedItem();

        // Validar que ambos elementos sean seleccionados
        if (pacienteSeleccionado == null || reporteSeleccionado == null) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Advertencia");
            alerta.setHeaderText("Selección requerida");
            alerta.setContentText("Por favor, selecciona un paciente y un reporte antes de clonar.");
            alerta.showAndWait();
            return;
        }

        // Confirmación antes de clonar
        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Confirmación");
        confirmacion.setHeaderText("Clonar Reporte");
        confirmacion.setContentText("¿Estás seguro de que deseas clonar este reporte para el paciente seleccionado?");

        Optional<ButtonType> resultado = confirmacion.showAndWait();

        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            // Clonar el reporte
            Reporte clone = reporteSeleccionado.clone();

            // Agregar el reporte clonado al historial del paciente
            hospital.agregarReporte(clone, pacienteSeleccionado.getHistorialMedico());

            // Mostrar mensaje de éxito
            Alert exito = new Alert(Alert.AlertType.INFORMATION);
            exito.setTitle("Éxito");
            exito.setHeaderText("Reporte Clonado");
            exito.setContentText("El reporte ha sido clonado exitosamente.");
            exito.showAndWait();

        }
    }

    @FXML
    void eliminarReporteAccion(ActionEvent event) {
        Paciente pacienteSeleccionado = pacienteComboBox.getSelectionModel().getSelectedItem();
        Reporte reporteSeleccionado = reportesTabla.getSelectionModel().getSelectedItem();
        if (reporteSeleccionado != null) {
            // Crear una alerta de confirmación
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Confirmación");
            alerta.setHeaderText("Eliminar reporte");
            alerta.setContentText("¿Estás seguro de que deseas eliminar este reporte?");

            Optional<ButtonType> resultado = alerta.showAndWait();

            if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
                // Eliminar el reporte del hospital
                hospital.eliminarReporte(reporteSeleccionado, pacienteSeleccionado.getHistorialMedico());

                // Refrescar la tabla para actualizar la vista
                reportesTabla.getItems().remove(reporteSeleccionado);
            }
        } else {
            // Mostrar alerta si no se seleccionó ningún reporte
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Advertencia");
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor, selecciona un reporte para eliminar.");
            alerta.showAndWait();
        }
    }

    @FXML
    void recargarAccion(ActionEvent event) {
        Paciente pacienteSeleccionado = pacienteComboBox.getSelectionModel().getSelectedItem();
        LinkedList<Reporte> historialMedico = pacienteSeleccionado.getHistorialMedico();

        // Refresca la tabla
        reportesTabla.setItems(FXCollections.observableArrayList(historialMedico));
    }

    @FXML
    void initialize() {
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
        pacienteComboBox.setOnAction(event -> {
            Paciente pacienteSeleccionado = pacienteComboBox.getSelectionModel().getSelectedItem();
            System.out.println("Paciente seleccionado: " + pacienteSeleccionado.getNombre());
        });
        colDescripcion.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDescripcion()));

        colFecha.setCellValueFactory(cellData ->
                new SimpleObjectProperty<>(cellData.getValue().getFecha()));

        colMedicamento.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getMedicamento()));

        colPaciente.setCellValueFactory(cellData -> {
            Paciente paciente = cellData.getValue().getPaciente();
            return new SimpleStringProperty(paciente != null ? paciente.getNombre() : "Desconocido");
        });
        assert agregarReporteBoton != null : "fx:id=\"agregarReporteBoton\" was not injected: check your FXML file 'ReporteView.fxml'.";
        assert atrasBoton != null : "fx:id=\"atrasBoton\" was not injected: check your FXML file 'ReporteView.fxml'.";
        assert clonarReporteBoton != null : "fx:id=\"clonarReporteBoton\" was not injected: check your FXML file 'ReporteView.fxml'.";
        assert colDescripcion != null : "fx:id=\"colDescripcion\" was not injected: check your FXML file 'ReporteView.fxml'.";
        assert colFecha != null : "fx:id=\"colFecha\" was not injected: check your FXML file 'ReporteView.fxml'.";
        assert colMedicamento != null : "fx:id=\"colMedicamento\" was not injected: check your FXML file 'ReporteView.fxml'.";
        assert colPaciente != null : "fx:id=\"colPaciente\" was not injected: check your FXML file 'ReporteView.fxml'.";
        assert descripcionCampo != null : "fx:id=\"descripcionCampo\" was not injected: check your FXML file 'ReporteView.fxml'.";
        assert eliminarReporteBoton != null : "fx:id=\"eliminarReporteBoton\" was not injected: check your FXML file 'ReporteView.fxml'.";
        assert fechaReporte != null : "fx:id=\"fechaReporte\" was not injected: check your FXML file 'ReporteView.fxml'.";
        assert medicamentoCampo != null : "fx:id=\"medicamentoCampo\" was not injected: check your FXML file 'ReporteView.fxml'.";
        assert pacienteComboBox != null : "fx:id=\"pacienteComboBox\" was not injected: check your FXML file 'ReporteView.fxml'.";
        assert recargarBoton != null : "fx:id=\"recargarBoton\" was not injected: check your FXML file 'ReporteView.fxml'.";
        assert reportesTabla != null : "fx:id=\"reportesTabla\" was not injected: check your FXML file 'ReporteView.fxml'.";
        assert editarReporteBoton != null : "fx:id=\"editarReporteBoton\" was not injected: check your FXML file 'ReporteView.fxml'.";

    }

}


