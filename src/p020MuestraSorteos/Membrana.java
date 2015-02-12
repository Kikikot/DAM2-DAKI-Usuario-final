package p020MuestraSorteos;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import p05Sorteo.PantallaSorteo;
import marco.ControladorMarco;
import utiles.JPanelFondo;
import utiles.PrevisualizacionSorteo;

public class Membrana extends JPanelFondo implements MouseListener{
	
	private ControladorMarco marco;
	private PrevisualizacionSorteo pre;
	
	public Membrana(PrevisualizacionSorteo pre, int x, int y, int ancho, int alto, ControladorMarco controladorMarco) {
		super();
		this.pre = pre;
		marco = controladorMarco;
		super.setBounds(x, y, ancho, alto);
		super.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		marco.anadirPantalla(new PantallaSorteo(marco, pre.getIdSorteo(), pre.getImagen(), pre.getDistancia(), pre.getValor(), pre.getTickets()));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
