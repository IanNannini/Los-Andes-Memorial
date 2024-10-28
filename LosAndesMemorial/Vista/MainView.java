package LosAndesMemorial.Vista;

import LosAndesMemorial.Controlador.LoginController;
import LosAndesMemorial.Controlador.ServicioFunerarioController;
import LosAndesMemorial.Controlador.NotificacionController;
import LosAndesMemorial.Modelo.Usuario;
import LosAndesMemorial.Modelo.ServicioFunerario;
import LosAndesMemorial.Modelo.Estado;
import LosAndesMemorial.Modelo.Operario;
import LosAndesMemorial.Modelo.Cremador;
import LosAndesMemorial.Modelo.AsesorComercial;
import LosAndesMemorial.Vista.ServicioFunerarioView;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;


public class MainView {
    private LoginController loginController;
    private ServicioFunerarioController servicioFunerarioController;
    private NotificacionController notificacionController;
    private ServicioFunerarioView servicioFunerarioView; // Nueva instancia

    public MainView(LoginController loginController, ServicioFunerarioController servicioFunerarioController, NotificacionController notificacionController) {
        this.loginController = loginController;
        this.servicioFunerarioController = servicioFunerarioController;
        this.notificacionController = notificacionController;
        this.servicioFunerarioView = new ServicioFunerarioView(servicioFunerarioController); // Inicializamos ServicioFunerarioView
    }

    public void mostrarMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Bienvenido al Sistema de Notificaciones de Los Andes Memorial");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    iniciarSesion();
                    break;
                case 2:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (true);
    }

    private void iniciarSesion() {
        LoginView loginView = new LoginView(loginController);
        Usuario usuario = loginView.mostrarLogin();

        if (usuario != null) {
            System.out.println("Bienvenido, " + usuario.getNombre() + " (" + usuario.getRolUsuario() + ")");
            mostrarMenuUsuario(usuario);
        } else {
            System.out.println("Credenciales inválidas. Intente de nuevo.");
        }
    }

    private void mostrarMenuUsuario(Usuario usuario) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\nOpciones para " + usuario.getRolUsuario());

            if (usuario instanceof Operario) {
                System.out.println("1. Ver notificaciones");
                System.out.println("2. Salir");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        mostrarNotificaciones(usuario);
                        break;
                    case 2:
                        System.out.println("Saliendo...");
                        return;
                    default:
                        System.out.println("Opción inválida.");
                }
            } else if (usuario instanceof Cremador) {
                System.out.println("1. Ver notificaciones");
                System.out.println("2. Asignar servicio de cremación");
                System.out.println("3. Salir");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        mostrarNotificaciones(usuario);
                        break;
                    case 2:
                        asignarServicioCremacion();
                        break;
                    case 3:
                        System.out.println("Saliendo...");
                        return;
                    default:
                        System.out.println("Opción inválida.");
                }
            } else if (usuario.getRolUsuario().equalsIgnoreCase("Encargado de Mantenimiento")) {
                System.out.println("1. Asignar operario");
                System.out.println("2. Asignar cremador");
                System.out.println("3. Actualizar estado de servicio");
                System.out.println("4. Revisar notificaciones");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        asignarOperario();
                        break;
                    case 2:
                        asignarCremador();
                        break;
                    case 3:
                        actualizarEstadoServicio();
                        break;
                    case 4:
                        mostrarNotificaciones(usuario);
                        break;
                    case 5:
                        System.out.println("Saliendo...");
                        return;
                    default:
                        System.out.println("Opción inválida.");
                }
            } else if (usuario.getRolUsuario().equalsIgnoreCase("Asesor Comercial")) {
                do {
                    System.out.println("\nOpciones para Asesor Comercial");
                    System.out.println("1. Solicitar servicio funerario");
                    System.out.println("2. Salir");
                    System.out.print("Seleccione una opción: ");
                    opcion = scanner.nextInt();
                    scanner.nextLine(); 

                    switch (opcion) {
                        case 1:
                            servicioFunerarioView.solicitarServicioFunerario(); // Llamamos al método en ServicioFunerarioView
                            break;
                        case 2:
                            System.out.println("Saliendo...");
                            return;
                        default:
                            System.out.println("Opción inválida.");
                    }
                } while (true);
            } else if (usuario.getRolUsuario().equalsIgnoreCase("Administrador de Ventas")) {
                do {
                    System.out.println("Opciones para Administrador de Ventas");
                    System.out.println("1. Revisar documentación");
                    System.out.println("2. Ver notificaciones");
                    System.out.println("3. Salir");
                    System.out.print("Seleccione una opción: ");
                    opcion = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcion) {
                        case 1:
                            revisarDocumentacion();
                            break;
                        case 2:
                            mostrarNotificaciones(usuario);
                            break;
                        case 3:
                            System.out.println("Saliendo...");
                            return;
                        default:
                            System.out.println("Opción inválida.");
                    }
                } while (true);
            }
        } while (true);
    }

    private void revisarDocumentacion() {
        Scanner scanner = new Scanner(System.in);
        List<ServicioFunerario> serviciosPendientes = servicioFunerarioController.obtenerServiciosPendientes();
        if (serviciosPendientes.isEmpty()) {
            System.out.println("No hay servicios pendientes de revisión.");
            return;
        }

        for (ServicioFunerario servicio : serviciosPendientes) {
            System.out.println("Revisando documentación para el servicio: " + servicio.getTipoServicio());
            System.out.println("Descripción: " + servicio.getDescripcion());
            System.out.print("¿La documentación es correcta? (Si/No): ");
            String respuesta = scanner.nextLine();

            if (respuesta.equalsIgnoreCase("Si")) {
                try {
                    servicioFunerarioController.actualizarEstado(servicio, new Estado(2, "Documentación revisada"));
                    System.out.println("Documentación revisada y aprobada. Notificación enviada al encargado.");

                    Usuario asesor = servicio.getAsesor();
                    notificacionController.generarNotificacion("La documentación para el servicio " + servicio.getTipoServicio() + " ha sido aprobada.", asesor);

                    Usuario encargadoMantenimiento = servicio.getOperarioAsignado();
                    notificacionController.generarNotificacion("Requiere asignación de operario para el servicio: " + servicio.getTipoServicio(), encargadoMantenimiento);

                } catch (LosAndesMemorial.Excepciones.EstadoInvalidoException eie) {
                    System.out.println("Error al actualizar el estado: " + eie.getMessage());
                }
            } else {
                System.out.println("La documentación no es correcta. No se han enviado notificaciones.");
                System.out.println("¿Desea corregir la documentación? (Si/No): ");
                respuesta = scanner.nextLine();
                if (respuesta.equalsIgnoreCase("Si")){
                System.out.println("Ingrese la nueva documentación: ");
                respuesta = scanner.nextLine();
                servicio.descripcion = respuesta;
                System.out.println("Documentación actualizada.");
                }
            }
        }
    }

    private void mostrarNotificaciones(Usuario usuario) {
        NotificacionView notificacionView = new NotificacionView(notificacionController);
        notificacionView.mostrarNotificaciones(usuario);
    }

    private void asignarOperario() {
        System.out.println("Asignar operario... (pendiente implementación)");
    }

    private void asignarCremador() {
        System.out.println("Asignar cremador... (pendiente implementación)");
    }

    private void asignarServicioCremacion() {
        System.out.println("Asignar servicio de cremación... (pendiente implementación)");
    }

    private void actualizarEstadoServicio() {
        System.out.println("Actualizar estado del servicio... (pendiente implementación)");
    }

    private void notificarEncargadoDeMantenimiento(ServicioFunerario servicio) {
        Usuario encargadoMantenimiento = servicio.getOperarioAsignado();
        if (encargadoMantenimiento != null) {
            String mensaje = "Nuevo servicio funerario disponible: " + servicio.getTipoServicio() + 
                             ". Por favor, prepare el equipo y personal necesario.";
            notificacionController.generarNotificacion(mensaje, encargadoMantenimiento);
            System.out.println("Notificación enviada al Encargado de Mantenimiento.");
        } else {
            System.out.println("No se pudo encontrar un encargado de mantenimiento asignado para este servicio.");
        }
    }
}