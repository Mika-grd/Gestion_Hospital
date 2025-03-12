package co.edu.uniquindio.poo.gestion_hospital.model;

import java.util.LinkedList;

public class Medico {

    private String nombre,id;
    private LinkedList<Cita> citasPropias = new LinkedList<>();

    // Constructor
    public Medico(String nombre, String idMedico) {
        this.nombre = nombre;

        this.id = idMedico;
    }

    //Metodo para retornar el numero de cita
    public int numeroCitas(){
        return citasPropias.size();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getId() {
        return id;
    }

    public void setIdMedico(String idMedico) {
        this.id = idMedico;
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
        return "Medico [nombre=" + nombre +  " idMedico=" + id + "]";
    }
}
