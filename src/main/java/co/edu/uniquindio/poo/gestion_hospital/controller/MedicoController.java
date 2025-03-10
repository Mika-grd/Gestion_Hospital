package co.edu.uniquindio.poo.gestion_hospital.controller;



import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MedicoController {

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
    private TableColumn<?, ?> idColumna;

    @FXML
    private TextField medicoCedulaCampo;

    @FXML
    private TextField medicoNombreCampo;

    @FXML
    private TableView<?> medicosTabla;

    @FXML
    private TableColumn<?, ?> nombreColumna;

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

    }

    @FXML
    void buscarAccion(ActionEvent event) {

    }

    @FXML
    void eliminarMedicoAccion(ActionEvent event) {

    }

    @FXML
    void recargarAccion(ActionEvent event) {

    }

    @FXML
    void initialize() {
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


