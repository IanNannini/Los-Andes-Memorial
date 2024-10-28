package LosAndesMemorial.Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que simula una base de datos para el prototipo del sistema.
 */
public class BaseDatos {
    private List<Usuario> usuarios;
    private List<ServicioFunerario> servicios;
    private List<Notificacion> notificaciones;

    /**
     * Constructor que inicializa las listas de usuarios, servicios y notificaciones.
     */
    public BaseDatos() {
        usuarios = new ArrayList<>();
        servicios = new ArrayList<>();
        notificaciones = new ArrayList<>();
    }

    // Métodos para acceder y modificar las listas de datos

    /**
     * Obtiene la lista de usuarios.
     * @return Lista de usuarios.
     */
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * Agrega un usuario a la lista de usuarios.
     * @param usuario Objeto Usuario que se agregará.
     */
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    /**
     * Obtiene la lista de servicios funerarios.
     * @return Lista de servicios funerarios.
     */
    public List<ServicioFunerario> getServicios() {
        return servicios;
    }

    /**
     * Agrega un servicio funerario a la lista de servicios.
     * @param servicio Objeto ServicioFunerario que se agregará.
     */
    public void agregarServicio(ServicioFunerario servicio) {
        servicios.add(servicio);
    }

    /**
     * Obtiene la lista de notificaciones.
     * @return Lista de notificaciones.
     */
    public List<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    /**
     * Agrega una notificación a la lista de notificaciones.
     * @param notificacion Objeto Notificacion que se agregará.
     */
    public void agregarNotificacion(Notificacion notificacion) {
        notificaciones.add(notificacion);
    }
}
