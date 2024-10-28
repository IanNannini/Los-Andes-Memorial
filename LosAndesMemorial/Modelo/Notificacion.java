package LosAndesMemorial.Modelo;


import java.time.LocalDateTime;

/**
 * Clase que representa una notificación en el sistema.
 */
public class Notificacion {
    private int id;
    private String mensaje;
    private LocalDateTime fecha;
    private boolean mostrada;
    private Usuario destinatario;

    /**
     * Constructor para inicializar un objeto Notificacion.
     * @param id Identificador único de la notificación.
     * @param mensaje Mensaje de la notificación.
     * @param fecha Fecha en la que se generó la notificación.
     * @param mostrada Indica si la notificación ya fue mostrada al usuario.
     * @param destinatario Usuario destinatario de la notificación.
     */
    public Notificacion(int id, String mensaje, LocalDateTime fecha, boolean mostrada, Usuario destinatario) {
        this.id = id;
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.mostrada = mostrada;
        this.destinatario = destinatario;
    }

    // Métodos Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }

    public boolean isMostrada() { return mostrada; }
    public void setMostrada(boolean mostrada) { this.mostrada = mostrada; }

    public Usuario getDestinatario() { return destinatario; }
    public void setDestinatario(Usuario destinatario) { this.destinatario = destinatario; }
}
