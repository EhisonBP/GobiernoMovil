package ve.gob.cnti.model;

public class Tramite {
    
    private int idTramite;
    private String nombreTramite;
    private String telefono;
    private String horarios;
    private String direccion;
    private String descripcion;
    private String costo;
    private String requisitos;
    private String fecha;




    public Tramite() {
    }
    
    public Tramite(int idTramite, String nombreTramite, String telefono, String horarios, String direccion,
             String descripcion, String costo, String requisitos, String fecha){
        this.idTramite = idTramite;
        this.nombreTramite = nombreTramite;
        this.telefono = telefono;
        this.horarios = horarios;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.costo = costo;
        this.requisitos = requisitos;
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }



    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(int idTramite) {
        this.idTramite = idTramite;
    }

    public String getNombreTramite() {
        return nombreTramite;
    }

    public void setNombreTramite(String nombreTramite) {
        this.nombreTramite = nombreTramite;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}