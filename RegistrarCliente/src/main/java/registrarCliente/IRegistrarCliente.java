/*
 * IRegistrarCliente.java
 */
package registrarCliente;

import excepciones.RegistrarClienteException;
import dtos.UsuarioDTO;

/**
 * Interfaz que define los métodos que el subsistema puede realizar.
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public interface IRegistrarCliente {

    /**
     * Método para crear la cuenta de un cliente.
     *
     * @param usuario Cliente a quien se le creará la cuenta.
     * @return El cliente con sus datos encriptados.
     * @throws RegistrarClienteException si ya hay una cuenta con el correo
     * proporcionado.
     */
    public UsuarioDTO crearCuenta(UsuarioDTO usuario) throws RegistrarClienteException;

}
