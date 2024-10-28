package LosAndesMemorial.Controlador;

import LosAndesMemorial.Modelo.Usuario;
import java.util.List;
import java.util.ArrayList;

/**
 * Controlador encargado de gestionar el proceso de login.
 */
public class LoginController {
    private List<Usuario> usuarios;

    /**
     * Constructor del LoginController
     * @param usuarios Lista de usuarios registrados en el sistema.
     */
    public LoginController(List<Usuario> usuarios) {
        this.usuarios = usuarios != null ? usuarios : new ArrayList<>();
    }

    /**
     * Método para validar el login del usuario.
     * @param email Correo electrónico del usuario.
     * @param contraseña Contraseña del usuario.
     * @return El objeto Usuario si las credenciales son correctas, null si no lo son.
     */
    public Usuario login(String email, String contraseña) {
        for (Usuario usuario : usuarios) {
            if (usuario.validarCredenciales(email, contraseña)) {
                return usuario; // Login exitoso
            }
        }
        return null; // Credenciales inválidas
    }
}
