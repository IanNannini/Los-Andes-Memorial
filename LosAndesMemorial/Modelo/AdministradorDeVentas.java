package LosAndesMemorial.Modelo;

public class AdministradorDeVentas extends Usuario {

    public AdministradorDeVentas(int id, String nombre, String apellido, String email, String contraseña) {
        super(id, nombre, apellido, email, "Administrador de Ventas", contraseña);
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " (Rol específico: Administrador de Ventas)";
    }
}