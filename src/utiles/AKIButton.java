package utiles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.border.AbstractBorder;

public class AKIButton extends JLabel implements MouseListener{
	
	public static enum TipoBoton {BotonSimple, BotonDoblePosicion};
	
	private boolean pulsado;
	private TipoBoton tipoBoton;
	
	public AKIButton(String etiqueta, TipoBoton tipo){
		super("  "+etiqueta+"  ");
		setFont(new Font("Verdana", Font.PLAIN, 12));
		
		pulsado = false;
		tipoBoton = tipo;
		
		setOpaque(true);
		AbstractBorder borde = new BordeRedondeado(new Color(0xBB00BB),2,5, new Color(0xffffff));
		setBorder(borde);
		setNoPulsado();
		addMouseListener(this);
	}
	
	public void setPulsado(boolean ok){
		if (ok) setPulsado();
		else setNoPulsado();
	}

	private void setNoPulsado() {
		this.setBackground(new Color(0xBB00BB));
		this.setForeground(Color.WHITE);
		pulsado = false;
	}
	
	private void setPulsado() {
		this.setBackground(Color.WHITE);
		this.setForeground(new Color(0xBB00BB));
		pulsado = true;
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		if (!pulsado) setPulsado();
		else setNoPulsado();
	}

	public void mouseReleased(MouseEvent e) {
		if (tipoBoton == TipoBoton.BotonSimple){
			if (pulsado) setNoPulsado();
			else setPulsado();
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
	
	public void setText(String texto){
		super.setText("  "+texto+"  ");
	}
}