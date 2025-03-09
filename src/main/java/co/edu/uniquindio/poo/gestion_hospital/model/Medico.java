package co.edu.uniquindio.poo.gestion_hospital.model;

public class Medico {

    private String nombre,especialidad,idMedico;
    private HistorialMedico historialMedico;

    // Constructor
    public Medico(String nombre, String especialidad, String idMedico) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.idMedico = idMedico;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(String idMedico) {
        this.idMedico = idMedico;
    }

    public HistorialMedico getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(HistorialMedico historialMedico) {
        this.historialMedico = historialMedico;
    }

    // Método toString
    @Override
    public String toString() {
        return "Medico [nombre=" + nombre + ", especialidad=" + especialidad + ", idMedico=" + idMedico + "]";
    }
}
