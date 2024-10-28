package LosAndesMemorial.Controlador;

import LosAndesMemorial.Modelo.Notificacion;
import LosAndesMemorial.Modelo.Usuario;
import java.util.List;
import java.util.stream.Collectors;
/**
 * Controlador encargado de gestionar las notificaciones.
 */
public class NotificacionController {
    private List<Notificacion> notificaciones;

    /**
     * Constructor del NotificacionController.
     * @param notificaciones Lista de notificaciones registradas en el sistema.
     */
    public NotificacionController(List<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
    }

    /**
     * Método para generar una nueva notificación.
     * CU005: Generar notificaciones.
     * @param mensaje Mensaje de la notificación.
     * @param destinatario Usuario que recibirá la notificación.
     */
    public void generarNotificacion(String mensaje, Usuario destinatario) {
        Notificacion nuevaNotificacion = new Notificacion(notificaciones.size() + 1, mensaje, java.time.LocalDateTime.now(), false, destinatario);
        notificaciones.add(nuevaNotificacion);
        // Aquí podríamos tener más lógica, como enviar la notificación al destinatario
    }

    /**
     * Método para obtener las notificaciones de un usuario.
     * @param usuario Usuario del cual se quiere obtener las notificaciones.
     * @return Lista de notificaciones no vistas del usuario.
     */
    public List<Notificacion> obtenerNotificacionesUsuario(Usuario usuario) {
        return notificaciones.stream()
                .filter(n -> n.getDestinatario().equals(usuario) && !n.isMostrada())
                .toList();
    }
}
