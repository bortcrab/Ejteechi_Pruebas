/*
 * FacadeRegistrarCliente.java
 */
package registrarCliente;

import excepciones.RegistrarClienteException;
import dtos.UsuarioDTO;

/**
 * Clase fachada que implementa los métodos de la interfaz IRegistrarCliente
 * para facilitar el uso del subsistema al usuario.
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class FacadeRegistrarCliente implements IRegistrarCliente {

    private final CtrlRegistrarCliente ctrlCrearCuenta;

    /**
     * Constructor que inicializa el atributo de la clase.
     */
    public FacadeRegistrarCliente() {
        ctrlCrearCuenta = new CtrlRegistrarCliente();
    }

    /**
     * Método para crear la cuenta de un cliente.
     *
     * @param usuario Cliente a quien se le creará la cuenta.
     * @return El cliente con sus datos encriptados.
     * @throws RegistrarClienteException si ya hay una cuenta con el correo
     * proporcionado.
     */
    @Override
    public UsuarioDTO crearCuenta(UsuarioDTO usuario) throws RegistrarClienteException {
        return ctrlCrearCuenta.crearCuenta(usuario);
    }

}
