package co.edu.uniquindio.poo.gestion_hospital.controller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.gestion_hospital.model.Hospital;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class ConfiguracionController {
    private Hospital hospital = Hospital.getInstance();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button aplicarBoton;

    @FXML
    private Button atrasBoton;

    @FXML
    private ComboBox<String> facturacionElectronicaCombo;

    @FXML
    private ComboBox<String> horariosCombo;

    @FXML
    private ComboBox<String> numeroPacientesCombo;

    @FXML
    void aplicarCambiosAction(ActionEvent event) {
        String horario = horariosCombo.getValue();
        String maxPacientesStr = numeroPacientesCombo.getValue();
        String facturacion = facturacionElectronicaCombo.getValue();

        if (horario == null || maxPacientesStr == null || facturacion == null) {
            mostrarAlerta("Error", "Debe seleccionar todas las opciones antes de aplicar cambios.");
            return;
        }

        int maxPacientes = Integer.parseInt(maxPacientesStr);
        boolean isFacturacionElectronica = facturacion.equals("Sí");

        // Aplicar cambios usando el método de Hospital
        String resultado = Hospital.cambiarConfiguracion(horario, maxPacientes, isFacturacionElectronica);

        if (!resultado.equals("No hay horario atencion")) {
            mostrarAlerta("Éxito", "Configuración aplicada correctamente.");
        } else {
            mostrarAlerta("Error", "No se pudo aplicar la configuración.");
        }
    }

    @FXML
    void atrasAccion(ActionEvent event) {
        Stage stageActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stageActual.close();
    }

    @FXML
    void showFacturacionBoolean(ActionEvent event) {
        String seleccion = facturacionElectronicaCombo.getValue();
        if (seleccion != null) {
            mostrarAlerta("Facturación Electrónica", "Opción seleccionada: " + seleccion);
        }
    }

    @FXML
    void showHorarios(ActionEvent event) {
        String seleccion = horariosCombo.getValue();
        if (seleccion != null) {
            mostrarAlerta("Horario de Atención", "Opción seleccionada: " + seleccion);
        }
    }

    @FXML
    void showNumeroPacientesAction(ActionEvent event) {
        String seleccion = numeroPacientesCombo.getValue();
        if (seleccion != null) {
            mostrarAlerta("Número de Pacientes", "Opción seleccionada: " + seleccion);
        }
    }

    @FXML
    void initialize() {
        assert aplicarBoton != null : "fx:id=\"aplicarBoton\" was not injected: check your FXML file 'HospitalConfiguracion.fxml'.";
        assert atrasBoton != null : "fx:id=\"atrasBoton\" was not injected: check your FXML file 'HospitalConfiguracion.fxml'.";
        assert facturacionElectronicaCombo != null : "fx:id=\"facturacionElectronicaCombo\" was not injected: check your FXML file 'HospitalConfiguracion.fxml'.";
        assert horariosCombo != null : "fx:id=\"horariosCombo\" was not injected: check your FXML file 'HospitalConfiguracion.fxml'.";
        assert numeroPacientesCombo != null : "fx:id=\"numeroPacientesCombo\" was not injected: check your FXML file 'HospitalConfiguracion.fxml'.";

        // Inicializar ComboBox con valores
        facturacionElectronicaCombo.getItems().addAll("Sí", "No");
        horariosCombo.getItems().addAll("Mañana", "Tarde", "Noche", "24 horas");
        numeroPacientesCombo.getItems().addAll("1", "2", "3", "5", "10");

        // Establecer valores por defecto
        facturacionElectronicaCombo.setValue("No");
        horariosCombo.setValue("Mañana");
        numeroPacientesCombo.setValue("10");
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
