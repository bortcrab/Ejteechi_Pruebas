/*
 * CtrlRegistrarCliente.java
 */
package registrarCliente;

import excepciones.RegistrarClienteException;
import dtos.UsuarioDTO;
import interfaces.IUsuarioBO;
import excepciones.ObjetosNegocioException;
import implementaciones.UsuarioBO;

/**
 * Clase control para crear la cuenta de un cliente.
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class CtrlRegistrarCliente {

    private final IUsuarioBO usuarioBO;

    /**
     * Constructor que inicializa el atributo de la clase.
     */
    public CtrlRegistrarCliente() {
        usuarioBO = new UsuarioBO();
    }

    /**
     * Método para crear la cuenta de un cliente.
     *
     * @param usuario Cliente a quien se le creará la cuenta.
     * @return El cliente con sus datos encriptados.
     * @throws RegistrarClienteException si ya hay una cuenta con el correo
     * proporcionado.
     */
    public UsuarioDTO crearCuenta(UsuarioDTO usuario) throws RegistrarClienteException {
        try {
            // Mandamos a crear la cuenta y devolvemos el usuario con sus datos encriptados.
            return usuarioBO.agregarUsuario(usuario);
        } catch (ObjetosNegocioException one) {
            // Si ya existe una cuenta con el correo proporcionado.
            throw new RegistrarClienteException(one.getMessage());
        }
    }

}
