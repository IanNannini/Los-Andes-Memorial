package LosAndesMemorial.Vista;

import LosAndesMemorial.Controlador.LoginController;
import LosAndesMemorial.Modelo.Usuario;
import java.util.Scanner;

public class LoginView {
    private LoginController loginController;

    public LoginView(LoginController loginController) {
        this.loginController = loginController;
    }

    /**
     * Muestra la pantalla de login y captura los datos de acceso.
     * @return El usuario que inició sesión si las credenciales son correctas, o null si no lo son.
     */
    public Usuario mostrarLogin() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su email: ");
        String email = scanner.nextLine();

        System.out.print("Ingrese su contraseña: ");
        String contraseña = scanner.nextLine();

        return loginController.login(email, contraseña);
    }
}