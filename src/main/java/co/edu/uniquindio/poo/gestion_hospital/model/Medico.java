package co.edu.uniquindio.poo.gestion_hospital.model;

public class Medico {

    private String nombre,idMedico;
    private Reporte historialMedico;

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

    public Reporte getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(Reporte historialMedico) {
        this.historialMedico = historialMedico;
    }

    // Método toString
    @Override
    public String toString() {
        return "Medico [nombre=" + nombre +  " idMedico=" + idMedico + "]";
    }
}
