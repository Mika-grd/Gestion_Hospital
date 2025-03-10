package co.edu.uniquindio.poo.gestion_hospital.model;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class Hospital {
    private String nombre;
    public static String horarioAtencion;
    public static int maxPacientes;
    public static boolean isFacturacionElectronica;
    private LinkedList <Medico> ListaMedicos;
    private LinkedList<Paciente> ListaPacientes;
    private LinkedList<Cita> ListaCitas;
    private static Hospital instance;

    /* Muestra todos los pacientes con nombres palindromos en una lista de Pacientes */
    public LinkedList<Paciente> pacientesDosVocales(){
        LinkedList<Paciente> pacientes = new LinkedList<>();
        for (Paciente paciente : ListaPacientes){
            if(twoVowelsInName(paciente.getNombre())){
                pacientes.add(paciente);
            }
        }
        return pacientes;
    }

    private boolean twoVowelsInName(String nombre){
        char[] chars = nombre.toCharArray();
        int count = 0;
        for (char c : chars) {
            if (isVowel(c)){
                count++;
            }
        }
        if (count >= 2){
            return true;
        }
        return false;
    }

    private boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }

    /* Muestra todos los pacientes con nombres palindromos en una lista de Pacientes */
    public LinkedList<Paciente> pacientesPalindromos(){
        LinkedList<Paciente> pacientes = new LinkedList<>();
        for (Paciente paciente : ListaPacientes){
            if(isPalindrome(paciente.getNombre())){
                pacientes.add(paciente);
            }
        }
        return pacientes;
    }

    private boolean isPalindrome(String nombre) {
        String lower = nombre.toLowerCase();
        return lower.contentEquals(new StringBuilder(lower).reverse());
    }

    public Hospital(String nombre, LinkedList<Medico> listaMedicos, LinkedList<Paciente> listaPacientes, LinkedList<Cita> listaCitas) {
        this.nombre = nombre;
        horarioAtencion = "24 horas";
        maxPacientes = 30;
        isFacturacionElectronica = true;
        ListaMedicos = listaMedicos;
        ListaPacientes = listaPacientes;
        ListaCitas = listaCitas;
    }

    /*Cambiar configuracion desde cualquier lugar */
    public static String cambiarConfiguracion(String horarioAtencion, int maxPacientes, boolean isFacturacionElectronica) {
        if (horarioAtencion != null) {
            setHorarioAtencion(horarioAtencion);
            setMaxPacientes(maxPacientes);
            setFacturacionElectronica(isFacturacionElectronica);
            return horarioAtencion;
        }
        return "No hay horario atencion";
    }

    /*Implementacion del singleton*/
    public static Hospital getInstance() {
        if(instance == null){
            instance = new Hospital("clinica la sagrada familia", new LinkedList<Medico>(), new LinkedList<Paciente>(),new LinkedList<Cita>() );
        }
        return instance;
    }


    //CRUD generico

    public <T> String agregarObjeto(T objeto, LinkedList<T> listaObjetos) {
        if (objeto != null) {
            listaObjetos.add(objeto);
            return "Exitoso";
        }
        return "No exitoso";
    }

    public <T> String eliminarObjeto(T objeto, LinkedList<T> listaObjetos) {
        if (objeto != null) {
            listaObjetos.remove(objeto);
            return "Exitoso";
        }
        return "No exitoso";
    }

    public <T> String editarObjeto(T objeto, T objetoNuevo, LinkedList<T> listaObjetos) {
        String resultado = "Exitoso";
        if (objeto != null && objetoNuevo != null) {
            listaObjetos.remove(objeto);
            listaObjetos.add(objetoNuevo);
            return resultado;
        }
        return "No exitoso";
    }

    public <T> T buscarObjeto(Object id, LinkedList<T> listaObjetos) {
        for (T objeto : listaObjetos) {
            try {
                Method getIdMethod = objeto.getClass().getMethod("getId");
                Object objetoId = getIdMethod.invoke(objeto);

                if (objetoId != null && objetoId.equals(id)) {
                    return objeto;
                }
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return null; // Retorna null si no se encuentra el objeto con el ID dado
    }

    /* CRUD Reporte */
    public String agregarReporte(Reporte reporte, LinkedList<Reporte> listaReportes) {
        return agregarObjeto(reporte, listaReportes);
    }

    public String eliminarReporte(Reporte reporte, LinkedList<Reporte> listaReportes) {
        return eliminarObjeto(reporte, listaReportes);
    }

    public String editarReporte(Reporte reporte, Reporte reporteNuevo, LinkedList<Reporte> listaReportes) {
        if (listaReportes.contains(reporte)) {
            return editarObjeto(reporte, reporteNuevo, listaReportes);
        }
        return "No existe";
    }

    public Reporte buscarReporte(String idReporte, LinkedList<Reporte> listaReportes) {
        return buscarObjeto(idReporte, listaReportes);
    }


    /*CRUD Medico*/

    public String agregarMedico(Medico medico) {
        return agregarObjeto(medico, ListaMedicos);
    }

    public String eliminarMedico(Medico medico) {
        return eliminarObjeto(medico, ListaMedicos);
    }

    public String editarMedico(Medico medico, Medico medicoNuevo) {
        if(ListaMedicos.contains(medico)){
            return editarObjeto(medico, medicoNuevo, ListaMedicos);
        }
        return "No existe";
    }

    public Medico buscarMedico(String idMedico) {
        return buscarObjeto(idMedico, ListaMedicos);
    }


    /*CRUD paciente*/

    public String añadirPaciente(Paciente paciente) {
        return agregarObjeto(paciente, ListaPacientes);
    }

    public String eliminarPaciente(Paciente paciente) {
        return eliminarObjeto(paciente, ListaPacientes);
    }

    public String editarPaciente(Paciente paciente, Paciente pacienteNuevo) {
        if(ListaPacientes.contains(paciente)){
            return editarObjeto(paciente, pacienteNuevo, ListaPacientes);
        }
        return "No existe";
    }

    public Paciente buscarPaciente(String idPaciente) {
        return buscarObjeto(idPaciente, ListaPacientes);
    }


    /*CRUD citas*/

    public String añadirCita(Cita cita) {
        return agregarObjeto(cita, ListaCitas);
    }

    public String eliminarCita(Cita cita) {
        return eliminarObjeto(cita, ListaCitas);
    }

    public String editarCita(Cita cita, Cita citaNuevo) {
        if(ListaCitas.contains(cita)){
            return editarObjeto(cita, citaNuevo, ListaCitas);
        }
        return "No existe";
    }

    public Cita buscarCitas(String idCita) {
        return buscarObjeto(idCita, ListaCitas);
    }




    /*SETS & GETS*/
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Medico> getListaMedicos() {
        return ListaMedicos;
    }

    public void setListaMedicos(LinkedList<Medico> listaMedicos) {
        ListaMedicos = listaMedicos;
    }

    public LinkedList<Paciente> getListaPacientes() {
        return ListaPacientes;
    }

    public void setListaPacientes(LinkedList<Paciente> listaPacientes) {
        ListaPacientes = listaPacientes;
    }

    public LinkedList<Cita> getListaCitas() {
        return ListaCitas;
    }

    public void setListaCitas(LinkedList<Cita> listaCitas) {
        ListaCitas = listaCitas;
    }

    public String getHorarioAtencion() {
        return horarioAtencion;
    }

    public static void setHorarioAtencion(String horarioAtencion) {
        horarioAtencion = horarioAtencion;
    }

    public int getMaxPacientes() {
        return maxPacientes;
    }

    public static void setMaxPacientes(int maxPacientes) {
        maxPacientes = maxPacientes;
    }

    public  boolean isFacturacionElectronica() {
        return isFacturacionElectronica;
    }

    public static void setFacturacionElectronica(boolean facturacionElectronica) {
        isFacturacionElectronica = facturacionElectronica;
    }
}
