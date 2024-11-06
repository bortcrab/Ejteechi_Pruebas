package dtos;

public class CitaDTO {
    private String noCita;
    private String fecha;
    private String documentos;
    private String asesor;

    public CitaDTO(String noCita, String fecha, String documentos, String Asesor) {
        this.noCita = noCita;
        this.fecha = fecha;
        this.documentos = documentos;
        this.asesor = Asesor;
    }

    public String getNoCita() {
        return noCita;
    }

    public void setNoCita(String noCita) {
        this.noCita = noCita;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDocumentos() {
        return documentos;
    }

    public void setDocumentos(String documentos) {
        this.documentos = documentos;
    }

    public String getAsesor() {
        return asesor;
    }

    public void setAsesor(String asesor) {
        this.asesor = asesor;
    }
    
}
