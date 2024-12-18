/*
 * UsuarioDTO.java
 */
package dtos;

import org.bson.types.ObjectId;

/**
 * Clase DTO con las características que conforman un usuario (ya sea cliente o
 * empleado).
 *
 * @author Eliana Monge Cámara - 00000247782
 * @author Francisco Valdez Gastelum - 00000246904
 * @author Diego Valenzuela Parra - 00000247700
 */
public class UsuarioDTO {

    private ObjectId id;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String telefono;
    private String curp;
    private String rfc;
    private String correo;
    private String contra;
    private String tipo;

    /**
     * Constructor por ausencia.
     */
    public UsuarioDTO() {
    }

    /**
     * Constructor que inicializa todos los atributos de un usuario.
     *
     * @param id ID del usuario.
     * @param nombres Nombres del usuario.
     * @param apellidoPaterno Apellido paterno del usuario.
     * @param apellidoMaterno Apellido materno del usuario.
     * @param telefono Teléfono del usuario.
     * @param curp CURP del usuario.
     * @param rfc RFC del usuario.
     * @param correo Correo del usuario.
     * @param contra Contraseña del usuario.
     * @param tipo Tipo de usuario (atención al cliente, rrhh, mantenimiento,
     * gerente).
     */
    public UsuarioDTO(ObjectId id, String nombres, String apellidoPaterno, String apellidoMaterno, String telefono, String curp, String rfc, String correo, String contra, String tipo) {
        this.id = id;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
        this.curp = curp;
        this.rfc = rfc;
        this.correo = correo;
        this.contra = contra;
        this.tipo = tipo;
    }
    
    /**
     * Constructor que inicializa todos los atributos de un usuario.
     *
     * @param nombres Nombres del usuario.
     * @param apellidoPaterno Apellido paterno del usuario.
     * @param apellidoMaterno Apellido materno del usuario.
     * @param telefono Teléfono del usuario.
     * @param curp CURP del usuario.
     * @param rfc RFC del usuario.
     * @param correo Correo del usuario.
     * @param contra Contraseña del usuario.
     * @param tipo Tipo de usuario (atención al cliente, rrhh, mantenimiento,
     * gerente).
     */
    public UsuarioDTO(String nombres, String apellidoPaterno, String apellidoMaterno, String telefono, String curp, String rfc, String correo, String contra, String tipo) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
        this.curp = curp;
        this.rfc = rfc;
        this.correo = correo;
        this.contra = contra;
        this.tipo = tipo;
    }

    /**
     * Constructor que inicializa los atributos del usuario en caso de ser
     * cliente.
     *
     * @param correo Correo del cliente.
     * @param contra Contraseña del cliente.
     * @param tipo Tipo de usuario (en este caso cliente).
     */
    public UsuarioDTO(String correo, String contra, String tipo) {
        this.correo = correo;
        this.contra = contra;
        this.tipo = tipo;
    }
    
    /**
     * Constructor que inicializa los atributos del usuario en caso de ser
     * cliente.
     *
     * @param correo Correo del cliente.
     * @param contra Contraseña del cliente.
     * @param tipo Tipo de usuario (en este caso cliente).
     */
    public UsuarioDTO(String nombres, String apellidoPaterno, String apellidoMaterno, String correo, String contra, String tipo) {    
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.contra = contra;
        this.tipo = tipo;
    }

    /**
     * Método que devuelve el ID de un usuario.
     *
     * @return ID de un usuario.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Método que asigna el ID a un usuario.
     *
     * @param id ID a asignar a un usuario.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }
    
    /**
     * Método que devuelve los nombres de un usuario.
     *
     * @return Nombres de un usuario.
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Método que asigna los nombres a un usuario.
     *
     * @param nombres Nombres a asignar a un usuario.
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Método que devuelve el apellido paterno de un usuario.
     *
     * @return Apellido paterno de un usuario.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Método que asigna el apellido paterno a un usuario.
     *
     * @param apellidoPaterno Apellido paterno a asignar a un usuario.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Método que devuelve el apellido materno de un usuario.
     *
     * @return Apellido materno de un usuario.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Método que asigna el apellido materno a un usuario.
     *
     * @param apellidoMaterno Apellido materno a asignar a un usuario.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Método que devuelve el teléfono de un usuario.
     *
     * @return Teléfono de un usuario.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Método que asigna el teléfono a un usuario.
     *
     * @param telefono Teléfono a asignar a un usuario.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Mñetodo que devuelve la CURP de un usuario.
     *
     * @return CURP de un usuario.
     */
    public String getCurp() {
        return curp;
    }

    /**
     * Método que asigna la CURP a un usuario.
     *
     * @param curp CURP a asignar a un usuario.
     */
    public void setCurp(String curp) {
        this.curp = curp;
    }

    /**
     * @return RFC de un usuario.
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Método que asigna el RFC a un usuario.
     *
     * @param rfc RFC a asignar a un usuario.
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * @return El correo de un usuario.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Método que asigna el correo a un usuario.
     *
     * @param correo Correo a asignar a un usuario.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Método que devuelve la contraseña de un usuario.
     *
     * @return La contraseña de un usuario.
     */
    public String getContra() {
        return contra;
    }

    /**
     * Método que asigna la contraseña a un usuario.
     *
     * @param contra Contraseña a asignar a un usuario.
     */
    public void setContra(String contra) {
        this.contra = contra;
    }

    /**
     * Método que devuelve de qué tipo es un usuario.
     *
     * @return Tipo que un usuario es.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Método que asigna el tipo a un usuario.
     *
     * @param tipo Tipo a asignar a un usuario.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
