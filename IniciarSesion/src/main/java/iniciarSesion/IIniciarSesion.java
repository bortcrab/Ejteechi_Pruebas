package iniciarSesion;

import dtos.UsuarioDTO;

/**
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public interface IIniciarSesion {
    public UsuarioDTO iniciarSesion(UsuarioDTO usuarioDTO) throws IniciarSesionException;
}
