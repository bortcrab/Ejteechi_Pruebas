package registrarEmpleado;

import dtos.UsuarioDTO;
import excepciones.RegistrarEmpleadoException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author franc
 */
public class FacadeRegistrarEmpleado implements IRegistrarEmpleado {

    private final CtrlRegistrarEmpleado ctrlRegistrarEmpleado;

    /**
     * Constructor que inicializa el atributo de la clase.
     */
    public FacadeRegistrarEmpleado() {
        ctrlRegistrarEmpleado = new CtrlRegistrarEmpleado();
    }

    /**
     * Método para crear la cuenta de un usuario del tipo "cliente".
     *
     * @param usuario Usuario a quien se le creará la cuenta.
     * @return El usuario con sus datos encriptados.
     * @throws RegistrarEmpleadoException si ya hay una cuenta con el correo
     * proporcionado.
     */
    
    public UsuarioDTO crearCuenta(UsuarioDTO usuario) throws RegistrarEmpleadoException {
        return ctrlRegistrarEmpleado.registrarEmpleado(usuario);
    }
}
