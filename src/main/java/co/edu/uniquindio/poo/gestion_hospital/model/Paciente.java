package co.edu.uniquindio.poo.gestion_hospital.model;

import java.util.LinkedList;

public class Paciente {

    private String nombre, idPaciente;
    private int edad;
    private LinkedList<Reporte> historialMedico;

    public Paciente(String nombre, String idPaciente, int edad, LinkedList<Reporte> historialMedico) {
        this.nombre = nombre;
        this.idPaciente = idPaciente;
        this.edad = edad;
        this.historialMedico = historialMedico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public LinkedList<Reporte> getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(LinkedList<Reporte> historialMedico) {
        this.historialMedico = historialMedico;
    }
}
