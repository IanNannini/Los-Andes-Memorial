package LosAndesMemorial;

import LosAndesMemorial.Controlador.*;
import LosAndesMemorial.Vista.*;
import LosAndesMemorial.Modelo.*;
import java.util.ArrayList;

public class MainApp {
    public static void main(String[] args) {
        // Crear una lista de usuarios específicos por rol
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Operario(1, "Walter", "White", "walter@losandes.com", "1234"));
        usuarios.add(new EncargadoDeMantenimiento(2, "Gus", "Fring", "gus@losandes.com", "1234"));
        usuarios.add(new AsesorComercial(3, "Saul", "Goodman", "saul@losandes.com", "1234"));
        usuarios.add(new AdministradorDeVentas(4, "Skyler", "White", "skyler@losandes.com", "1234"));
        usuarios.add(new Cremador(5, "Jesse", "Pinkman", "jesse@losandes.com", "1234"));

        // Crear una lista de servicios funerarios
        ArrayList<ServicioFunerario> servicios = new ArrayList<>();

        // Crear una lista de notificaciones
        ArrayList<Notificacion> notificaciones = new ArrayList<>();

        // Instanciar controladores
        LoginController loginController = new LoginController(usuarios);
        NotificacionController notificacionController = new NotificacionController(notificaciones);
        ServicioFunerarioController servicioController = new ServicioFunerarioController(servicios, usuarios, notificacionController);

        // Instanciar la vista principal
        MainView mainView = new MainView(loginController, servicioController, notificacionController);

        // Iniciar el menú principal
        mainView.mostrarMenuPrincipal();
    }
}