package utiles;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;

public class AKIPanel extends JPanel {

	/**
	 * Create the panel.
	 * @param marco 
	 */
	public AKIPanel() {
		AbstractBorder borde = new BordeRedondeado(new Color(0xBB00BB),1,5, new Color(0xffffff));
		this.setBackground(Color.WHITE);
		setBorder(borde);
	}
}
