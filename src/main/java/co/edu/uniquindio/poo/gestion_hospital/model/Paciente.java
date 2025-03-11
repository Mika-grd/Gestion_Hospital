package co.edu.uniquindio.poo.gestion_hospital.model;

import java.util.LinkedList;

public class Paciente {

    private final Hospital hospital = Hospital.getInstance();
    private String nombre, id;
    private String edad;
    private LinkedList<Reporte> historialMedico;
    private LinkedList<Cita> citasPropias = new LinkedList<>();

    /*CRUD Reporte*/

    public String agregarReporte(Reporte reporte) {
        return hospital.agregarReporte(reporte, historialMedico);
    }

    public String eliminarReporte(Reporte reporte) {
        return hospital.eliminarReporte(reporte, historialMedico);
    }

    public Paciente(String nombre, String idPaciente, String edad, LinkedList<Reporte> historialMedico) {
        this.nombre = nombre;
        this.id = idPaciente;
        this.edad = edad;
        this.historialMedico = historialMedico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setIdPaciente(String idPaciente) {
        this.id = idPaciente;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public LinkedList<Reporte> getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(LinkedList<Reporte> historialMedico) {
        this.historialMedico = historialMedico;
    }

    public LinkedList<Cita> getCitasPropias() {
        return citasPropias;
    }

    public void setCitasPropias(LinkedList<Cita> citasPropias) {
        this.citasPropias = citasPropias;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                ", edad='" + edad + '\'' +
                '}';
    }
}
