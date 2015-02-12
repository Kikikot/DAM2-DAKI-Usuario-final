package p02BuscarSorteos;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import utiles.AKIButton;
import utiles.PrevisualizacionSorteo;
import marco.ControladorMarco;

public class PantallaBuscarSorteos extends p020MuestraSorteos.PantallaMostrarSorteos implements MouseListener {

	private ControladorBuscarSorteos c;
	protected AKIButton bKm = new AKIButton("Km", AKIButton.TipoBoton.BotonDoblePosicion);
	protected AKIButton bEuros = new AKIButton("€", AKIButton.TipoBoton.BotonDoblePosicion);
	protected AKIButton bNuevos = new AKIButton("NEW", AKIButton.TipoBoton.BotonDoblePosicion);
	protected AKIButton bBuscador = new AKIButton("Buscador", AKIButton.TipoBoton.BotonDoblePosicion);

	public PantallaBuscarSorteos(ControladorMarco controladorMarco) {
		super(controladorMarco);
		
		this.sms1 = this.getMarco().getUsuario();
		this.sms2 = "Buscar Sorteos";
		this.bSalir = "Volver al menú principal";
		
		bKm.setFont(new Font("Verdana", Font.BOLD, 15));
		pFiltros.add(bKm);
		bKm.addMouseListener(this);
		
		bEuros.setFont(new Font("Verdana", Font.BOLD, 15));
		pFiltros.add(bEuros);
		bEuros.addMouseListener(this);
		
		bNuevos.setFont(new Font("Verdana", Font.BOLD, 15));
		pFiltros.add(bNuevos);
		bNuevos.addMouseListener(this);
		
		bBuscador.setFont(new Font("Verdana", Font.BOLD, 15));
		pFiltros.add(bBuscador);
		bBuscador.addMouseListener(this);
		
		c = new ControladorBuscarSorteos(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(bKm)){
			c.listarPorKm();
		} else if (e.getSource().equals(bEuros)){
			c.listarPorValor();
		} else if (e.getSource().equals(bNuevos)){
			c.listarPorRecientes();
		} else if (e.getSource().equals(bBuscador)){
			c.listarPorComercio();
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
