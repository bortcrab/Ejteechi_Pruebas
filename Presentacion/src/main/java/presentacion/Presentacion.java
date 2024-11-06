/*
 * Presentacion.java
 */
package presentacion;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import pantallas.FrmLogin;

/**
 * Clase principal del programa.
 */
public class Presentacion {
    public static void main(String[] args) {
        // Esto es para cambiar el look and feel (el cómo se ve) del programa.
        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            
        }
        
        // Mandamos al login.
        FrmLogin frmLogin = new FrmLogin();
        frmLogin.setVisible(true);
    }

}