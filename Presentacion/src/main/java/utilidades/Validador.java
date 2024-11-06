/*
 * Validadores.java
 */
package utilidades;

import pantallas.FrmLogin;
import dtos.UsuarioDTO;
import javax.swing.JFrame;
import excepciones.PresentacionException;

/**
 * Clase con todos los métodos necesarios para validar que los datos
 * introducidos por el cliente tengan el formato correcto.
 *
 * @author Francisco Valdez Gastelum - 00000247700
 * @author Diego Valenzuela Parra - 00000247700
 */
public class Validador {

    /**
     * Método para validar cadenas vacías o con puros espacios.
     *
     * @param cadena Cadena a validar.
     * @throws PresentacionException si la cadena del parámetro está vacía.
     */
    public void validarVacio(String cadena) throws PresentacionException {
        if (cadena.isBlank()) {
            throw new PresentacionException("");
        }
    }

    /**
     * Método para validar que un correo cumple con el formato correcto.
     *
     * @param correo correo a validar.
     * @throws PresentacionException si el correo está vacío, excede la longitud
     * de caracteres o no cumple con el patrón especifico.
     */
    public void validarCorreo(String correo) throws PresentacionException {
        try {
            validarVacio(correo);
        } catch (PresentacionException pe) {
            // Si el correo está vacío.
            throw new PresentacionException("El correo no puede estar vacío. "
                    + "Ejemplo: \"ejemplo@ejemplo.com\".");
        }
        if (correo.length() > 256) {
            // Si el correo excede los 256 caracteres.
            throw new PresentacionException("El correo excede el límite. "
                    + "Ejemplo: \"ejemplo@ejemplo.com\".");
        }
        if (!correo.matches("^[\\w\\-\\.]+@([\\w-]+\\.)+[\\w-]{2,}$")) {
            // Si el correo no coincide con el patrón "ejemplo@ejemplo.com".
            throw new PresentacionException("El correo no es válido. "
                    + "Ejemplo: \"ejemplo@ejemplo.com\".");
        }
    }

    /**
     * Método para validar que un telefono cumple con el formato correcto.
     *
     * @param telefono Teléfono a validar.
     * @throws PresentacionException si el teléfono está vacío, excede la
     * longitud de caracteres o no cumple con el patrón especifico.
     */
    public void validarTelefono(String telefono) throws PresentacionException {
        try {
            validarVacio(telefono);
        } catch (PresentacionException pe) {
            // Si el teléfono está vacío.
            throw new PresentacionException("El teléfono no puede estar vacío. "
                    + "Ejemplo: \"6440123456\".");
        }
        // Elimina cualquier espacio en blanco y guiones del número de teléfono
        telefono = telefono.replaceAll("\\s|-", "");

        // Verifica si el número de teléfono tiene exactamente 10 dígitos
        if (!telefono.matches("\\d{10}")) {
            throw new PresentacionException("El teléfono sólo debe tener 10 dígitos. "
                    + "Ejemplo: \"6440123456\".");
        }
    }

    /**
     * Método para validar que una CURP cumple con el formato correcto.
     *
     * @param curp CURP a validar.
     * @throws PresentacionException si la CURP está vacía, excede la longitud
     * de caracteres o no cumple con el patrón especifico.
     */
    public void validarCURP(String curp) throws PresentacionException {
        try {
            validarVacio(curp);
        } catch (PresentacionException pe) {
            // Si la CURP está vacío.
            throw new PresentacionException("La CURP no puede estar vacía. "
                    + "Ejemplo: \"ABCD010312HSRLRPM5\".");
        }
        // Elimina cualquier espacio en blanco de la CURP y la convierte a mayúsculas.
        curp = curp.trim().toUpperCase();

        // Verifica si la CURP tiene el formato correcto.
        if (!curp.matches("[a-zA-Z0-9]{18}")) {
            throw new PresentacionException("La CURP sólo puede tener 18 caracteres. "
                    + "Ejemplo: \"ABCD010312HSRLRPM5\".");
        }
    }

    /**
     * Método para validar que un RFC cumple con el formato correcto.
     *
     * @param rfc RFC a validar.
     * @throws PresentacionException si el RFC está vacío, excede la longitud de
     * caracteres o no cumple con el patrón especifico.
     */
    public void validarRFC(String rfc) throws PresentacionException {
        try {
            validarVacio(rfc);
        } catch (PresentacionException pe) {
            // Si el RFC está vacío.
            throw new PresentacionException("El RFC no puede estar vacío. "
                    + "Ejemplo: \"ABCD010312MC2\".");
        }
        // Elimina cualquier espacio en blanco del RFC y lo convierte a mayúsculas.
        rfc = rfc.trim().toUpperCase();

        // Verifica si el RFC tiene el formato correcto
        if (!rfc.matches("[a-zA-Z0-9]{13}")) {
            throw new PresentacionException("El RFC sólo puede tener 13 caracteres. "
                    + "Ejemplo: \"ABCD010312MC2\".");
        }
    }

    /**
     * Método para validar que una contraseña cumple con el formato correcto.
     *
     * @param contrasenia Contraseña a validar.
     * @throws PresentacionException si la contraseña está vacía, excede la
     * longitud de caracteres o no cumple con el patrón especifico.
     */
    public void validarContrasenia(String contrasenia) throws PresentacionException {
        try {
            validarVacio(contrasenia);
        } catch (PresentacionException pe) {
            // Si la contraseña está vacía.
            throw new PresentacionException("La contraseña no puede estar vacía. "
                    + "Ejemplo: \"jk2aUHhaj9\".");
        }
        if (contrasenia.length() < 8) {
            // Si la contraseña tiene menos de 8 caracteres.
            throw new PresentacionException("La contraseña debe tener al menos 8 caracteres. "
                    + "Ejemplo: \"jk2aUHhaj9\".");
        }
        if (!contrasenia.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+")) {
            // Si la contraseña no cumple con el formato definido.
            throw new PresentacionException("La contraseña debe contener:"
                    + "\n• Al menos una minúscula."
                    + "\n• Al menos una mayúscula."
                    + "\n• Al menos un número. "
                    + "Ejemplo: \"jk2aUHhaj9\".");
        }
    }

    /**
     * Método para validar que un la contraseña para confirmar es la misma que
     * la otra.
     *
     * @param contraseniaOriginal Contraseña a la cual la otra tiene que ser
     * igual.
     * @param contraseniaCopia Contraseña a validar.
     * @throws PresentacionException si la contraseña está vacía o es diferente
     * a la otra contraseña.
     */
    public void validarConfirmarContrasenia(String contraseniaOriginal, String contraseniaCopia) throws PresentacionException {
        try {
            validarVacio(contraseniaCopia);
        } catch (PresentacionException pe) {
            // Si la contraseña está vacía.
            throw new PresentacionException("La segunda contraseña no puede estar vacía. "
                    + "Ejemplo: \"jk2aUHhaj9\".");
        }
        if (!contraseniaCopia.equals(contraseniaOriginal)) {
            // Si la contraseña es diferente a la original.
            throw new PresentacionException("Las contraseñas son diferentes.");
        }
    }

    /**
     * Método para validar que el contenido de un ticket es correcto.
     *
     * @param contenido Contenido del ticket.
     * @throws PresentacionException si el contenido del ticket está vacío o
     * excede el límite de caracteteres.PresentacionException
     */
    public void validarTicket(String contenido) throws PresentacionException {
        try {
            validarVacio(contenido);
        } catch (PresentacionException pe) {
            // Si el contenido del ticket está vacío.
            throw new PresentacionException("El ticket no puede estar vacío.");
        }
        if (contenido.length() > 500) {
            // Si el contenido del ticket excede los 500 caracteres.
            throw new PresentacionException("El ticket no puede exceder los 500 caracteres.");
        }
    }

    /**
     * Método para validar que el contenido de una respuesta es correcto.
     *
     * @param contenido Contenido de la respuesta.
     * @throws PresentacionException si el contenido de la respuesta está vacío
     * o excede el límite de caracteteres.PresentacionException
     */
    public void validarRespuesta(String contenido) throws PresentacionException {
        try {
            validarVacio(contenido);
        } catch (PresentacionException pe) {
            // Si el contenido de la respuesta está vacío.
            throw new PresentacionException("El mensaje no puede estar vacío.");
        }
        if (contenido.length() > 500) {
            // Si el contenido de la respuesta excede los 500 caracteres.
            throw new PresentacionException("El mensaje no puede exceder los 500 caracteres.");
        }
    }

    /**
     * Método para validar nombres.
     *
     * @param nombres Nombres a validar.
     * @throws PresentacionException si los nombres están vacíos, exceden el
     * límite de caracteres o contienen caracteres diferentes a letras y
     * espacios.
     */
    public void validarNombres(String nombres) throws PresentacionException {
        try {
            validarVacio(nombres);
        } catch (PresentacionException pe) {
            // Si los nombres están vacíos.
            throw new PresentacionException("El nombre no puede estar vacío.");
        }
        if (nombres.length() > 100) {
            // Si los nombres exceden los 100 caracteres.
            throw new PresentacionException("El nombre no puede exceder los 100 caracteres.");
        }

        // Patrón para checar que los nombres sólo tengan letras (contando las acentuadas) y espacios.
        if (!nombres.matches("^[a-zA-ZÀ-ÿ ]+$")) {
            throw new PresentacionException("El nombre sólo puede tener letras.");
        }
    }

    /**
     * Método para validar el apellido paterno.
     *
     * @param apellido Apellido paterno a validar.
     * @throws PresentacionException si el apellido paterno está vacío, excede
     * el límite de caracteres o contiene caracteres diferentes a letras y
     * espacios.
     */
    public void validarApellidoP(String apellido) throws PresentacionException {
        try {
            validarVacio(apellido);
        } catch (PresentacionException pe) {
            // Si el apellido está vacío.
            throw new PresentacionException("El apellido paterno no puede estar vacío.");
        }
        if (apellido.length() > 100) {
            // Si el apellido excede los 100 caracteres.
            throw new PresentacionException("El apellido paterno no puede exceder los 100 caracteres.");
        }

        // Patrón para checar que el apellido sólo tenga letras (contando las acentuadas) y espacios.
        if (!apellido.matches("^[a-zA-ZÀ-ÿ ]+$")) {
            throw new PresentacionException("El apellido paterno sólo puede tener letras.");
        }
    }

    /**
     * Método para validar el apellido materno.
     *
     * @param apellido Apellido materno a validar.
     * @throws PresentacionException si el apellido materno está vacío, excede
     * el límite de caracteres o contiene caracteres diferentes a letras y
     * espacios.
     */
    public void validarApellidoM(String apellido) throws PresentacionException {
        try {
            validarVacio(apellido);
        } catch (PresentacionException pe) {
            // Si el apellido está vacío.
            throw new PresentacionException("El apellido materno no puede estar vacío.");
        }
        if (apellido.length() > 100) {
            // Si el apellido excede los 100 caracteres.
            throw new PresentacionException("El apellido materno no puede exceder los 100 caracteres.");
        }
        // Patrón para checar que el apellido sólo tenga letras (contando las acentuadas) y espacios.
        if (!apellido.matches("^[a-zA-ZÀ-ÿ ]+$")) {
            throw new PresentacionException("El apellido materno sólo puede tener letras.");
        }
    }

    /**
     * Método para validar si hay una sesión activa para continuar.
     *
     * @param usuario Usuario que debe tener una sesión iniciada.
     * @param pantalla Pantalla donde se hace la validación.
     * @throws PresentacionException si la sesión no está activa
     */
    public static void validarSesion(UsuarioDTO usuario, JFrame pantalla) throws PresentacionException {
        if (usuario == null) { // Validamos que el usuario no sea null.
            FrmLogin frmLogin = new FrmLogin(); // Lo mandamos de vuelta a login.
            frmLogin.setVisible(true);
            pantalla.dispose(); // Se destruye la pantalla donde se hace la validación.
            throw new PresentacionException("Necesitas una sesión activa para acceder a esta funcionalidad.");
        }
    }

}
