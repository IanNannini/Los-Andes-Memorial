package LosAndesMemorial.Modelo;

public class Cremador extends Usuario {

    public Cremador(int id, String nombre, String apellido, String email, String contraseña) {
        super(id, nombre, apellido, email, "Cremador", contraseña);
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " (Rol específico: Cremador)";
    }
}