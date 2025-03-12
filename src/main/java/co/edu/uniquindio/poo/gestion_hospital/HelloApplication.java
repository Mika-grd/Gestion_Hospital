package co.edu.uniquindio.poo.gestion_hospital;

import co.edu.uniquindio.poo.gestion_hospital.model.Hospital;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PrincipalView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600); // Ajusta el tamaño según necesites
        stage.setTitle("Vista Principal");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Hospital hospital = Hospital.getInstance();
        hospital.cargarDatos();
        launch();
    }
}