package ve.gob.cnti.model;

public class Alcaldia {
    
    private int idAlcaldia;
    private String nombreAlcaldia;
    private String directorAlcaldia;
    private String direccionAlcaldia;
    private String telefonoAlcaldia;
    private String webAlcaldia;
    private String correoAlcaldia;
    private String fecha;
    private int estado;


    public Alcaldia() {
    }

    public Alcaldia(int idAlcaldia, String nombreAlcaldia, String directorAlcaldia, String direccionAlcaldia
            , String telefonoAlcaldia, String webAlcaldia, String correoAlcaldia, String fecha, int estado) {
        this.idAlcaldia = idAlcaldia;
        this.nombreAlcaldia = nombreAlcaldia;
        this.directorAlcaldia = directorAlcaldia;
        this.direccionAlcaldia = direccionAlcaldia;
        this.telefonoAlcaldia = telefonoAlcaldia;
        this.webAlcaldia = webAlcaldia;
        this.correoAlcaldia = correoAlcaldia;
        this.fecha = fecha;
        this.estado = estado;
    }



    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getCorreoAlcaldia() {
        return correoAlcaldia;
    }

    public void setCorreoAlcaldia(String correoAlcaldia) {
        this.correoAlcaldia = correoAlcaldia;
    }

    public String getWebAlcaldia() {
        return webAlcaldia;
    }

    public void setWebAlcaldia(String web) {
        this.webAlcaldia = web;
    }

    public String getTelefonoAlcaldia() {
        return telefonoAlcaldia;
    }

    public void setTelefonoAlcaldia(String telefonoAlcaldia) {
        this.telefonoAlcaldia = telefonoAlcaldia;
    }

    public String getDireccionALcaldia() {
        return direccionAlcaldia;
    }

    public void setDireccionAlcaldia(String direccionAlcaldia) {
        this.direccionAlcaldia = direccionAlcaldia;
    }

    public String getDirectorALcaldia() {
        return directorAlcaldia;
    }

    public void setDirectorAlcaldia(String director) {
        this.directorAlcaldia = director;
    }

    public int getIdAlcaldia() {
        return idAlcaldia;
    }

    public String getNombreAlcaldia() {
        return nombreAlcaldia;
    }


    public void setIdAlcaldia(int idPoder) {
        this.idAlcaldia = idPoder;
    }

    public void setNombreAlcaldia(String nombrePoder) {
        this.nombreAlcaldia = nombrePoder;
    }

}
