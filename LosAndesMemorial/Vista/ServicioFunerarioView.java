package LosAndesMemorial.Vista;

import LosAndesMemorial.Controlador.ServicioFunerarioController;
import LosAndesMemorial.Modelo.ServicioFunerario;
import LosAndesMemorial.Modelo.Usuario;
import LosAndesMemorial.Modelo.Estado;
import LosAndesMemorial.Excepciones.OperarioNoDisponibleException;
import LosAndesMemorial.Excepciones.EstadoInvalidoException;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;


public class ServicioFunerarioView {
    private ServicioFunerarioController servicioController;

    public ServicioFunerarioView(ServicioFunerarioController servicioController) {
        this.servicioController = servicioController;
    }

    /**
     * Muestra las opciones para solicitar un servicio funerario.
     */
    public void solicitarServicioFunerario() {
    Scanner scanner = new Scanner(System.in);

    // Lista de tipos de servicio permitidos
    List<String> tiposPermitidos = Arrays.asList("Entierro", "Cremación");

    String tipoServicio;
    do {
        System.out.print("Ingrese el tipo de servicio funerario (Entierro, Cremación): ");
        tipoServicio = scanner.nextLine();

        if (!tiposPermitidos.contains(tipoServicio)) {
            System.out.println("Error: Tipo de servicio no válido. Por favor, ingrese 'Entierro' o 'Cremación'.");
        }
    } while (!tiposPermitidos.contains(tipoServicio));

    System.out.print("Ingrese la descripción del servicio: ");
    String descripcion = scanner.nextLine();


    try {
        // Definir usuarios asignados como asesor y encargado de mantenimiento
        Usuario asesorAsignado = new Usuario(1, "Asesor", "Comercial", "asesor@losandes.com", "Asesor Comercial", "1234");
        Usuario encargadoMantenimiento = new Usuario(2, "Encargado", "Mantenimiento", "encargado@losandes.com", "Encargado de Mantenimiento", "1234");

        // Crear un nuevo servicio funerario con roles asignados y documentación
        ServicioFunerario servicio = new ServicioFunerario(0, tipoServicio, descripcion, new Estado(1, "documentación cargada"), asesorAsignado, encargadoMantenimiento, "Documentación");
        System.out.println("El servicio funerario ha sido generado exitosamente.");
        // Preguntar si desea enviar la documentación para revisión
        System.out.print("¿Desea enviar la documentación para revisión? (Si/No): ");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("Si")) {
            enviarDocumentacion(servicio);
            System.out.println("Notificaciones enviadas.");
        }
        else
        {
            throw new Exception("Debe enviarse documentación");
        }

    } 
    catch (Exception e) {
        System.out.println("Ocurrió un error al solicitar el servicio funerario: " + e.getMessage());
    }
}

    /**
     * Envía la documentación para que la revise el Administrador de Ventas.
     * @param servicio Servicio funerario cuya documentación se enviará.
     */
    private void enviarDocumentacion(ServicioFunerario servicio) {
            
            servicioController.solicitarServicio(servicio);
            System.out.println("Documentación enviada para revisión.");

        
    }

    /**
     * Muestra las opciones para asignar operarios a un servicio funerario.
     * Incluye el manejo de la excepción en caso de que no haya operarios disponibles.
     */
    public void asignarOperario(ServicioFunerario servicio) {
        try {
            servicioController.asignarOperario(servicio);
            System.out.println("Operario asignado correctamente y notificación enviada.");
        } catch (OperarioNoDisponibleException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Muestra las opciones para asignar un operario específico a un servicio funerario.
     */
    public void asignarOperario(ServicioFunerario servicio, Usuario operario) {
        servicioController.asignarOperario(servicio, operario);
        System.out.println("Operario asignado correctamente y notificación enviada.");
    }

    /**
     * Muestra las opciones para actualizar el estado de un servicio funerario.
     * Captura `EstadoInvalidoException` si el estado proporcionado es inválido.
     */
    public void actualizarEstadoServicio(ServicioFunerario servicio, Estado nuevoEstado) {
        try {
            servicioController.actualizarEstado(servicio, nuevoEstado);
            System.out.println("Estado del servicio actualizado correctamente y notificaciones enviadas.");
        } catch (EstadoInvalidoException e) {
            System.out.println("Error al actualizar el estado: " + e.getMessage());
        }
    }
}