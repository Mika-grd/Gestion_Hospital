package co.edu.uniquindio.poo.gestion_hospital.model;

public class Tratamiento {

    private String descripcion;
    private Medicamento medicamento;

    // Constructor
    public Tratamiento(String descripcion, Medicamento medicamento) {
        this.descripcion = descripcion;
        this.medicamento = medicamento;
    }

    // Getters y Setters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    // Método toString
    @Override
    public String toString() {
        return "Tratamiento [descripcion=" + descripcion + ", medicamento=" + medicamento + "]";
    }
}
