package LosAndesMemorial.Controlador;

import LosAndesMemorial.Modelo.ServicioFunerario;
import LosAndesMemorial.Modelo.Usuario;
import LosAndesMemorial.Modelo.Estado;
import LosAndesMemorial.Excepciones.OperarioNoDisponibleException;
import LosAndesMemorial.Excepciones.EstadoInvalidoException;
import java.util.List;
import java.util.ArrayList;
import LosAndesMemorial.Controlador.NotificacionController;

/**
 * Controlador encargado de gestionar los servicios funerarios.
 */
public class ServicioFunerarioController {
    private List<ServicioFunerario> serviciosFunerarios;
    private List<Usuario> operarios; // Lista de operarios disponibles
    private NotificacionController notificacionController; // Controlador de notificaciones

    /**
     * Constructor de ServicioFunerarioController.
     * Verifica que el controlador de notificaciones no sea nulo.
     * @param serviciosFunerarios Lista de servicios funerarios registrados.
     * @param operarios Lista de operarios disponibles.
     * @param notificacionController Controlador de notificaciones.
     * @throws IllegalArgumentException Si notificacionController es nulo.
     */
    public ServicioFunerarioController(List<ServicioFunerario> serviciosFunerarios, List<Usuario> operarios, NotificacionController notificacionController) {
        if (serviciosFunerarios == null) {
            this.serviciosFunerarios = new ArrayList<>();
        } else {
            this.serviciosFunerarios = serviciosFunerarios;
        }

        if (operarios == null) {
            this.operarios = new ArrayList<>();
        } else {
            this.operarios = operarios;
        }

        if (notificacionController == null) {
            throw new IllegalArgumentException("El controlador de notificaciones no puede ser nulo.");
        }
        this.notificacionController = notificacionController;
    }

    /**
     * Método para solicitar un nuevo servicio funerario.
     * Genera una notificación automática para los roles relevantes.
     * @param servicio Nuevo servicio funerario a registrar.
     */
    public void solicitarServicio(ServicioFunerario servicio) {
        serviciosFunerarios.add(servicio);

        // Generar una notificación automática para roles que sean "Administrador de Ventas"
        String mensaje = "Nuevo servicio funerario creado: " + servicio.getTipoServicio();
        
    
        for (Usuario usuario : operarios) {
            if (usuario.getRolUsuario().equalsIgnoreCase("Administrador de Ventas")) {
                notificacionController.generarNotificacion(mensaje, usuario);
            }
        }
        
    }

    /**
     * Método para asignar un operario específico a un servicio funerario.
     * Genera una notificación para el operario asignado.
     * @param servicio Servicio funerario al que se le va a asignar un operario.
     * @param operario Usuario operario que se asignará al servicio.
     */
    public void asignarOperario(ServicioFunerario servicio, Usuario operario) {
        servicio.setOperarioAsignado(operario);
        String mensaje = "Has sido asignado al servicio funerario: " + servicio.getTipoServicio();
        notificacionController.generarNotificacion(mensaje, operario);
    }

    /**
     * Método para asignar un operario al servicio funerario de forma automática.
     * Selecciona el primer operario disponible en la lista.
     * @param servicio Servicio funerario al que se le va a asignar un operario.
     * @throws OperarioNoDisponibleException Si no hay operarios disponibles.
     */
    public void asignarOperario(ServicioFunerario servicio) throws OperarioNoDisponibleException {
        if (operarios == null || operarios.isEmpty()) {
            throw new OperarioNoDisponibleException("No hay operarios disponibles para asignar al servicio.");
        }
        Usuario operarioAsignado = operarios.get(0); // Asignar el primer operario disponible
        servicio.setOperarioAsignado(operarioAsignado);

        // Generar notificación para el operario asignado
        String mensaje = "Has sido asignado al servicio funerario: " + servicio.getTipoServicio();
        notificacionController.generarNotificacion(mensaje, operarioAsignado);
    }

    /**
     * Método para actualizar el estado del servicio funerario.
     * Genera una notificación automática para los roles relevantes.
     * @param servicio Servicio funerario al que se le va a actualizar el estado.
     * @param nuevoEstado Nuevo estado del servicio funerario.
     * @throws EstadoInvalidoException Si el nuevo estado es inválido.
     */
    public void actualizarEstado(ServicioFunerario servicio, Estado nuevoEstado) throws EstadoInvalidoException {
        if (nuevoEstado == null || nuevoEstado.getEstado().isEmpty()) {
            throw new EstadoInvalidoException("El estado proporcionado es inválido.");
        }
        servicio.setEstado(nuevoEstado);

        // Generar una notificación automática sobre el cambio de estado
        String mensaje = "El estado del servicio funerario ha cambiado a: " + nuevoEstado.getEstado();
        for (Usuario usuario : operarios) {
            if (!usuario.getRolUsuario().equalsIgnoreCase("Administrador de Ventas")) {
                notificacionController.generarNotificacion(mensaje, usuario);
            }
        }
    }

    /**
     * Obtiene la lista de servicios funerarios pendientes de revisión de documentación.
     * @return Lista de servicios funerarios con estado de "documentación cargada".
     */
    public List<ServicioFunerario> obtenerServiciosPendientes() {
        List<ServicioFunerario> pendientes = new ArrayList<>();
        for (ServicioFunerario servicio : serviciosFunerarios) {
            if (servicio.getEstado().getEstado().equalsIgnoreCase("documentación cargada")) {
                pendientes.add(servicio);
            }
        }
        return pendientes;
    }
}