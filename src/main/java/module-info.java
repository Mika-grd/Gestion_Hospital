module co.edu.uniquindio.poo.gestion_hospital {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.gestion_hospital to javafx.fxml;
    exports co.edu.uniquindio.poo.gestion_hospital;
    exports co.edu.uniquindio.poo.gestion_hospital.controller;
    opens co.edu.uniquindio.poo.gestion_hospital.controller to javafx.fxml;
}