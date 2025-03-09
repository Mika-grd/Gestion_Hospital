package co.edu.uniquindio.poo.gestion_hospital.model;




import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;

public class Hospital {
    private String nombre;
    private LinkedList <Medico> ListaMedicos;
    private LinkedList<Paciente> ListaPacientes;
    private LinkedList<Cita> ListaCitas;
    private static Hospital instance;

    private Hospital(String nombre, LinkedList <Medico> ListaMedicos, LinkedList<Paciente> ListaPacientes, LinkedList<Cita> ListaCitas){
        this.nombre = nombre;
        this.ListaMedicos = ListaMedicos;
        this.ListaPacientes = ListaPacientes;
        this.ListaCitas = ListaCitas;
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
}
