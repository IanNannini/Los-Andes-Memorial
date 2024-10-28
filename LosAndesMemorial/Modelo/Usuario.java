package LosAndesMemorial.Modelo;


public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String rolUsuario;
    private String contraseña;

    /**
     * Constructor para inicializar un objeto Usuario.
     * @param id Identificador único del usuario.
     * @param nombre Nombre del usuario.
     * @param apellido Apellido del usuario.
     * @param email Correo electrónico del usuario.
     * @param rolUsuario Rol que desempeña el usuario (Asesor, Operario, Administrativo, etc.).
     * @param contraseña Contraseña del usuario para login.
     */
    public Usuario(int id, String nombre, String apellido, String email, String rolUsuario, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.rolUsuario = rolUsuario;
        this.contraseña = contraseña;
    }

    // Métodos Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRolUsuario() { return rolUsuario; }
    public void setRolUsuario(String rolUsuario) { this.rolUsuario = rolUsuario; }

    public String getContraseña() { return contraseña; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }

    /**
     * Método para validar las credenciales de un usuario.
     * @param email Correo electrónico ingresado para el login.
     * @param contraseña Contraseña ingresada para el login.
     * @return Verdadero si las credenciales son correctas, falso si no lo son.
     */
    public boolean validarCredenciales(String email, String contraseña) {
        return this.email.equals(email) && this.contraseña.equals(contraseña);
    }

    /**
     * Método para mostrar información básica del usuario.
     * Este método puede ser sobrescrito en las subclases para mostrar detalles específicos de cada rol.
     * @return Información del usuario.
     */
    public String mostrarInfo() {
        return "ID: " + id + ", Nombre: " + nombre + " " + apellido + ", Rol: " + rolUsuario;
    }
}