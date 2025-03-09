package co.edu.uniquindio.poo.gestion_hospital.model;

public class HistorialMedico {

    private String enfermedad, descripcion;
    private Paciente paciente;
    private Medicamento medicamento;


    //Constructor
    public HistorialMedico(String enfermedad, String descripcion,Paciente paciente, Medicamento medicamento) {
        this.enfermedad = enfermedad;
        this.descripcion = descripcion;
        this.paciente = paciente;
        this.medicamento = medicamento;
    }

    //Getters y Setters
    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
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

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    //Método toString
    @Override
    public String toString() {
        return "HistorialMedico [enfermedad=" + enfermedad + ", descripcion=" + descripcion + "]";
    }
}
