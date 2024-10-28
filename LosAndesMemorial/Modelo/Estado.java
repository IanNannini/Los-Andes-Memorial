package LosAndesMemorial.Modelo;

public class Estado {
    private int id;
    private String estado;

    /**
     * Constructor para inicializar un objeto Estado.
     * @param id Identificador único del estado.
     * @param estado Descripción del estado (documentación cargada, finalizado, etc.).
     */
    public Estado(int id, String estado) {
        this.id = id;
        this.estado = estado;
    }

    // Métodos Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
