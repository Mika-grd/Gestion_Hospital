package co.edu.uniquindio.poo.gestion_hospital.model;

import java.time.LocalDate;

public class Reporte implements IHistorialMedico, Cloneable {

    private Hospital hospital = Hospital.getInstance();
    private LocalDate fecha;
    private String descripcion;
    private Paciente paciente;
    private String medicamento;



    @Override
    public Reporte clone() {
        try {
            return (Reporte) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error al clonar el objeto Reporte", e);
        }
    }
    

    public Reporte(LocalDate fecha, String descripcion, Paciente paciente, String medicamento) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.paciente = paciente;
        this.medicamento = medicamento;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }
}
