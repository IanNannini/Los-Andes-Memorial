package LosAndesMemorial.Modelo;

public class AsesorComercial extends Usuario {

    public AsesorComercial(int id, String nombre, String apellido, String email, String contraseña) {
        super(id, nombre, apellido, email, "Asesor Comercial", contraseña);
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " (Rol específico: Asesor Comercial)";
    }
}