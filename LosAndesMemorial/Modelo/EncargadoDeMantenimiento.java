package LosAndesMemorial.Modelo;

public class EncargadoDeMantenimiento extends Usuario {

    public EncargadoDeMantenimiento(int id, String nombre, String apellido, String email, String contraseña) {
        super(id, nombre, apellido, email, "Encargado de Mantenimiento", contraseña);
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " (Rol específico: Encargado de Mantenimiento)";
    }
}