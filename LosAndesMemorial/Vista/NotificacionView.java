package LosAndesMemorial.Vista;

import LosAndesMemorial.Controlador.NotificacionController;
import LosAndesMemorial.Modelo.Usuario;
import LosAndesMemorial.Modelo.Notificacion;
import java.util.List;

public class NotificacionView {
    private NotificacionController notificacionController;

    public NotificacionView(NotificacionController notificacionController) {
        this.notificacionController = notificacionController;
    }

    /**
     * Muestra las notificaciones pendientes para un usuario.
     * @param usuario El usuario que recibe las notificaciones.
     */
    public void mostrarNotificaciones(Usuario usuario) {
        List<Notificacion> notificaciones = notificacionController.obtenerNotificacionesUsuario(usuario);

        if (notificaciones.isEmpty()) {
            System.out.println("No tienes notificaciones pendientes.");
        } else {
            System.out.println("Notificaciones pendientes:");
            for (Notificacion notificacion : notificaciones) {
                System.out.println("- " + notificacion.getMensaje() + " (Fecha: " + notificacion.getFecha() + ")");
            }
        }
    }
}