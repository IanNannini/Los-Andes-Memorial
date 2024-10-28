package LosAndesMemorial.Modelo;


public class Operario extends Usuario {

    public Operario(int id, String nombre, String apellido, String email, String contraseña) {
        super(id, nombre, apellido, email, "Operario", contraseña);
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " (Rol específico: Operario)";
    }
}