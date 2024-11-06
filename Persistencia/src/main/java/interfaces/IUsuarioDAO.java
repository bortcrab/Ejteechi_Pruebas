/*
 * IUsuarioDAO.java
 */
package interfaces;

import colecciones.Usuario;

/**
 * Interfaz que define los métodos para acceder y manipular datos relacionados
 * con los usuarios en la base de datos.
 *
 * @author Eliana Monge Cámara - 00000247782
 * @author Francisco Valdez Gastelum - 00000246904
 * @author Diego Valenzuela Parra - 00000247700
 */
public interface IUsuarioDAO {

    /**
     * Método para agregar un usuario a la base de datos.
     *
     * @param usuario Usuario a agregar..
     * @return El usuario con su ID de la base de datos.
     */
    public Usuario agregarUsuario(Usuario usuario);

    /**
     * Método para obtener un usuario de la base de datos dado su correo.
     *
     * @param correo Correo del usuario a buscar.
     * @return El usuario encontrado, null si no se encontró nada.
     */
    public Usuario obtenerUsuarioCorreo(String correo);

    /**
     * Método para obtener un usuario de la base de datos dada su CURP.
     *
     * @param curp CURP del usuario a buscar.
     * @return El usuario encontrado, null si no se encontró nada.
     */
    public Usuario obtenerUsuarioCurp(String curp);

    /**
     * Método para obtener un usuario de la base de datos dado su RFC.
     *
     * @param rfc RFC del usuario a buscar.
     * @return El usuario encontrado, null si no se encontró nada.
     */
    public Usuario obtenerUsuarioRfc(String rfc);

    /**
     * Método para obtener un usuario de la base de datos dados su correo y
     * contraseña.
     *
     * @param correo Correo del usuario a buscar.
     * @param contrasenia Contraseña del usuario a buscar.
     * @return El usuario encontrado, null si no se encontró nada.
     */
    public Usuario obtenerUsuarioCorreoContra(String correo, String contrasenia);

}
