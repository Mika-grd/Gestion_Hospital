package co.edu.uniquindio.poo.gestion_hospital.model;

import java.time.LocalDate;

public class Cita {

    private LocalDate fechaCita;
    private Medico medico;
    private Paciente paciente;

    public Cita(LocalDate fechaCita, Medico medico, Paciente paciente) {
        this.fechaCita = fechaCita;
        this.medico = medico;
        this.paciente = paciente;
    }

    public LocalDate getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(LocalDate fechaCita) {
        this.fechaCita = fechaCita;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
