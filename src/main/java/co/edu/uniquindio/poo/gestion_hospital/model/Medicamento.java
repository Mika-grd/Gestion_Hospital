package co.edu.uniquindio.poo.gestion_hospital.model;

import java.util.Date;

public class Medicamento {
    String nombre,idMedicamento;
    Date fechaCaducidad;

    // Constructor
    public Medicamento(String nombre, String idMedicamento, Date fechaCaducidad) {
        this.nombre = nombre;
        this.idMedicamento = idMedicamento;
        this.fechaCaducidad = fechaCaducidad;
    }

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(String idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    // Método toString
    @Override
    public String toString() {
        return "Medicamento [nombre=" + nombre + ", idMedicamento=" + idMedicamento + ", fechaCaducidad=" + fechaCaducidad + "]";
    }

}
