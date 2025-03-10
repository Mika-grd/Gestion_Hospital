package co.edu.uniquindio.poo.gestion_hospital.model;

import java.util.LinkedList;

public class Medico {

    private String nombre,idMedico;
    private LinkedList<Cita> citasPropias = new LinkedList<>();

    // Constructor
    public Medico(String nombre, String idMedico) {
        this.nombre = nombre;

        this.idMedico = idMedico;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(String idMedico) {
        this.idMedico = idMedico;
    }

    public LinkedList<Cita> getCitasPropias() {
        return citasPropias;
    }

    public void setCitasPropias(LinkedList<Cita> citasPropias) {
        this.citasPropias = citasPropias;
    }

    // Método toString
    @Override
    public String toString() {
        return "Medico [nombre=" + nombre +  " idMedico=" + idMedico + "]";
    }
}
