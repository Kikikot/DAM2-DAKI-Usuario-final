package p06MostrarTickets;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import marco.ControladorMarco;
import utiles.AKIButton;
import utiles.AKIPanel;
import utiles.PanelPantalla;

public class PantallaMostrarTickets extends PanelPantalla implements MouseListener{
	
	private ControladorMarco marco;
	
	public PantallaMostrarTickets(ControladorMarco controladorMarco, ArrayList<TicketGroup> gruposDeTickets, boolean conBotonDeAcceso) {
		super(controladorMarco);
		marco = controladorMarco;
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		for (int i=0; i<gruposDeTickets.size(); i++){
			AKIPanel temp = gruposDeTickets.get(i).getComoPanel(this.getSize().width, conBotonDeAcceso, this);
			this.add(temp);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		AKIButton b = (AKIButton)e.getSource();
		System.out.println("'"+b.getText()+"'");
		String id = b.getText().substring(8, b.getText().length()-4);
		marco.anadirPantalla(p05Sorteo.PantallaSorteo.buidPantallaSorteo(marco, id));
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
