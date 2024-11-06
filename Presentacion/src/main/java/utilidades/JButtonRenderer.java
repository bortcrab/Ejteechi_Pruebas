/*
 * JButtonRenderer.java
 */
package utilidades;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * Clase que nos brinda la posibilidad de agregar botones en las tablas.
 *
 * @author Diego Valenzuela Parra - 00000247700
 */
public class JButtonRenderer implements TableCellRenderer {

    private final JButton button;

    public JButtonRenderer(String text) {
        this.button = new JButton(text);
        this.button.setFont(new Font("Sans Serif", Font.BOLD, 16));
        this.button.setBackground(new Color(79, 89, 144));
        this.button.setForeground(new Color(255, 255, 255));
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return this.button;
    }

}
