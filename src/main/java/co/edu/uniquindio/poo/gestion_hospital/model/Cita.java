package co.edu.uniquindio.poo.gestion_hospital.model;

import java.time.LocalDate;

public class Cita {

    private LocalDate fechaCita;
    private String lugar;
    private Paciente paciente;

    //Constructor
    public Cita(LocalDate fechaCita, String lugar) {
        this.fechaCita = fechaCita;
        this.lugar = lugar;
    }

    //Getters y Setters

    public LocalDate getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(LocalDate fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    //Método toString
    @Override
    public String toString() {
        return "Cita [fechaCita=" + fechaCita + ", lugar=" + lugar + "]";
    }
}
