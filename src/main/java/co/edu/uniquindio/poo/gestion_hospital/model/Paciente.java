package co.edu.uniquindio.poo.gestion_hospital.model;

public class Paciente {

    private String nombre, idPaciente;
    private int edad;
    private Tratamiento tratamiento;

    // Constructor
    public Paciente(String nombre, String idPaciente, int edad) {
        this.nombre = nombre;
        this.idPaciente = idPaciente;
        this.edad = edad;
    }

    // Getters y Setters
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

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    // Método toString
    @Override
    public String toString() {
        return "Paciente [nombre=" + nombre + ", idPaciente=" + idPaciente + ", edad=" + edad + "]";
    }
}
