/*
 * UsuarioBO.java
 */
package implementaciones;

import colecciones.Usuario;
import dtos.UsuarioDTO;
import excepciones.ObjetosNegocioException;
import interfaces.IUsuarioBO;
import interfaces.IUsuarioDAO;
import utilidades.Encriptador;

/**
 * Clase que implementa los métodos de la interfaz IUsuarioBO para aplicar
 * reglas de negocio relacionadas con los usuarios.
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class UsuarioBO implements IUsuarioBO {

    private final IUsuarioDAO usuarioDAO;
    private final Encriptador encriptador;

    /**
     * Constructor que inicializa los atributos de la clase.
     */
    public UsuarioBO() {
        this.usuarioDAO = new UsuarioDAO();
        this.encriptador = new Encriptador();
    }

    /**
     * Método para agregar un usuario.
     *
     * @param usuarioDTO Usuario que se agregará.
     * @return El usuario ya insertado con sus datos encriptados.
     * @throws ObjetosNegocioException si ya existe una cuenta creada con el
     * correo proporcionado.
     */
    @Override
    public UsuarioDTO agregarUsuario(UsuarioDTO usuarioDTO) throws ObjetosNegocioException {
        // Obtenemos el usuario de la base de datos con base al correo.
        Usuario usuarioEnt = usuarioDAO.obtenerUsuarioCorreo(encriptador.encriptar(usuarioDTO.getCorreo()));

        // Si se obtuvo algo, lanzamos una excepción.
        if (usuarioEnt != null) {
            throw new ObjetosNegocioException("Ese correo ya está registrado.");
        }

        // Si el usuario es un empleado.
        if (!usuarioDTO.getTipo().equals("cliente")) {
            // Obtenemos el usuario de la base de datos con base a la CURP
            usuarioEnt = usuarioDAO.obtenerUsuarioCurp(usuarioDTO.getCurp());
            // Si se obtuvo algo, lanzamos una excepción.
            if (usuarioEnt != null) {
                throw new ObjetosNegocioException("Ya se registró esa CURP.");
            }

            // Obtenemos el usuario de la base de datos con base al RFC.
            usuarioEnt = usuarioDAO.obtenerUsuarioRfc(usuarioDTO.getRfc());
            // Si se obtuvo algo, lanzamos una excepción.
            if (usuarioEnt != null) {
                throw new ObjetosNegocioException("Ya se registró ese RFC.");
            }
        }

        // Convertimos el usuario.
        usuarioEnt = convertirUsuario(usuarioDTO);

        // Lo mandamos a agregar.
        usuarioEnt = usuarioDAO.agregarUsuario(usuarioEnt);

        // Lo convertirmos de vuelta a DTO:
        usuarioDTO = convertirUsuario(usuarioEnt);

        // Lo retornamos.
        return usuarioDTO;
    }

    /**
     * Método para obtener un usuario.
     *
     * @param usuarioDTO Usuario a buscar.
     * @return El usuario encontrado.
     * @throws ObjetosNegocioException si no se encontró el usuario o si la
     * contraseña es incorrecta.
     */
    @Override
    public UsuarioDTO obtenerUsuarioCorreoContra(UsuarioDTO usuarioDTO) throws ObjetosNegocioException {
        // Obtenemos el correo y la contraseña y desencriptamos ambos datos.
        String correo = encriptador.encriptar(usuarioDTO.getCorreo());
        String contrasenia = encriptador.encriptar(usuarioDTO.getContra());

        // Obtenemos el usuario de la base de datos con base al correo.
        Usuario usuarioEnt = usuarioDAO.obtenerUsuarioCorreo(correo);
        // Si NO se obtuvo nada, lanzamos una excepción.
        if (usuarioEnt == null) {
            throw new ObjetosNegocioException("No se encontró ninguna cuenta con el correo proporcionado.");
        }

        // Obtenemos el usuario de la base de datos con base al correo y la contraseña.
        usuarioEnt = usuarioDAO.obtenerUsuarioCorreoContra(correo, contrasenia);
        // Si NO se obtuvo nada, lanzamos una excepción.
        if (usuarioEnt == null) {
            throw new ObjetosNegocioException("Contraseña incorrecta.");
        }

        // Convertirmos el usuario a DTO.
        usuarioDTO = convertirUsuario(usuarioEnt);

        // Lo retornamos.
        return usuarioDTO;
    }

    /**
     * Método para convertir de UsuarioDTO a una entidad Usuario.
     *
     * @param usuarioDTO UsuarioDTO a convertir.
     * @return La entidad de Usuario ya convertida.
     */
    private Usuario convertirUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuarioEnt = new Usuario(
                usuarioDTO.getNombres(),
                usuarioDTO.getApellidoPaterno(),
                usuarioDTO.getApellidoMaterno(),
                usuarioDTO.getTelefono(),
                encriptador.encriptar(usuarioDTO.getCorreo()),
                encriptador.encriptar(usuarioDTO.getContra()),
                usuarioDTO.getCurp(),
                usuarioDTO.getRfc(),
                usuarioDTO.getTipo());

        return usuarioEnt;
    }

    /**
     * Método para convertir de una entidad Usuario a UsuarioDTO.
     *
     * @param usuarioEnt Entidad de Usuario a convertir.
     * @return UsuarioDTO ya convertido.
     */
    private UsuarioDTO convertirUsuario(Usuario usuarioEnt) {
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                usuarioEnt.getId(),
                usuarioEnt.getNombres(),
                usuarioEnt.getApellidoPaterno(),
                usuarioEnt.getApellidoMaterno(),
                usuarioEnt.getTelefono(),
                usuarioEnt.getCurp(),
                usuarioEnt.getRfc(),
                usuarioEnt.getCorreo(),
                usuarioEnt.getContrasenia(),
                usuarioEnt.getTipo());

        return usuarioDTO;
    }
}
