package p03MisSorteos;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import utiles.AKIButton;
import utiles.PrevisualizacionSorteo;
import marco.ControladorMarco;

public class PantallaMisSorteos extends p020MuestraSorteos.PantallaMostrarSorteos implements MouseListener {

	private ControladorMisSorteos c;
	protected AKIButton bParticipando = new AKIButton("Participando", AKIButton.TipoBoton.BotonDoblePosicion);
	protected AKIButton bSiguiendo = new AKIButton("Siguiendo", AKIButton.TipoBoton.BotonDoblePosicion);

	public PantallaMisSorteos(ControladorMarco controladorMarco) {
		super(controladorMarco);
		
		this.sms1 = this.getMarco().getUsuario();
		this.sms2 = "Mis Sorteos";
		this.bSalir = "Volver al menú principal";
		
		bParticipando.setFont(new Font("Verdana", Font.BOLD, 15));
		pFiltros.add(bParticipando);
		bParticipando.addMouseListener(this);
		
		bSiguiendo.setFont(new Font("Verdana", Font.BOLD, 15));
		pFiltros.add(bSiguiendo);
		bSiguiendo.addMouseListener(this);
		
		c = new ControladorMisSorteos(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(bParticipando)){
			c.listarParticipando();
		} else if (e.getSource().equals(bSiguiendo)){
			c.listarSiguiendo();
		}
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
