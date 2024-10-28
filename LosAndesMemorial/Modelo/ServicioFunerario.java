package LosAndesMemorial.Modelo;

public class ServicioFunerario {
    private int id;
    private String tipoServicio;
    public String descripcion;
    private Estado estado;
    private Usuario asesor;
    private Usuario operarioAsignado;
    private Usuario encargadoMantenimiento; // Nuevo campo para encargado de mantenimiento
    public String documentacion;

    /**
     * Constructor para inicializar un objeto ServicioFunerario.
     * @param id Identificador único del servicio funerario.
     * @param tipoServicio Tipo de servicio funerario (cremación, entierro, etc.).
     * @param descripcion Descripción del servicio funerario.
     * @param estado Estado actual del servicio funerario.
     * @param asesor Asesor encargado del servicio funerario.
     * @param operarioAsignado Operario asignado para ejecutar el servicio.
     * @param encargadoMantenimiento Usuario encargado de mantenimiento para el servicio.
     * @param documentacion Documentación asociada al servicio.
     */
    public ServicioFunerario(int id, String tipoServicio, String descripcion, Estado estado, Usuario asesor, Usuario operarioAsignado, String documentacion) {
    // Implementación del constructor
        this.id = id;
        this.tipoServicio = tipoServicio;
        this.descripcion = descripcion;
        this.estado = estado;
        this.asesor = asesor;
        this.operarioAsignado = operarioAsignado;
        this.encargadoMantenimiento = encargadoMantenimiento; // Inicializamos el nuevo campo
        this.documentacion = documentacion;
    }

    // Métodos Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTipoServicio() { return tipoServicio; }
    public void setTipoServicio(String tipoServicio) { this.tipoServicio = tipoServicio; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }

    public Usuario getAsesor() { return asesor; }
    public void setAsesor(Usuario asesor) { this.asesor = asesor; }

    public Usuario getOperarioAsignado() { return operarioAsignado; }
    public void setOperarioAsignado(Usuario operarioAsignado) { this.operarioAsignado = operarioAsignado; }

    public Usuario getEncargadoMantenimiento() { return encargadoMantenimiento; } // Nuevo getter para encargado de mantenimiento
    public void setEncargadoMantenimiento(Usuario encargadoMantenimiento) { this.encargadoMantenimiento = encargadoMantenimiento; } // Nuevo setter para encargado de mantenimiento

    public String getDocumentacion() { return documentacion; }
    public void setDocumentacion(String documentacion) { this.documentacion = documentacion; }
}