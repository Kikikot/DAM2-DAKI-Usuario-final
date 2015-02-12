package principal;

import java.awt.Color;

import javax.swing.JOptionPane;

import marco.ControladorMarco;

public class ControladorPrincipal {
	
	private PantallaPrincipal pantalla;
	private ControladorMarco marco;
	
	
	public ControladorPrincipal(PantallaPrincipal pantallaPrincipal) {
		pantalla = pantallaPrincipal;
		marco = pantalla.getMarco();
		relax();
	}


	public void miPerfil() {
		marco.anadirPantalla(new p01Perfil.PantallaPerfil(marco));
	}


	public void buscarSorteos() {
		if (marco.getUsuario()==null){
			JOptionPane.showMessageDialog(pantalla,
					   "Aún no estás conectado.\n"
					   + "Conéctate (o Registrate) en el apartado 'Perfil'.");
		} else {
			marco.anadirPantalla(new p02BuscarSorteos.PantallaBuscarSorteos(marco));
		}
	}


	public void misSorteos() {
		if (marco.getUsuario()==null){
			JOptionPane.showMessageDialog(pantalla,
					   "Aún no estás conectado.\n"
					   + "Conéctate (o Registrate) en el apartado 'Perfil'.");
		} else {
			marco.anadirPantalla(new p03MisSorteos.PantallaMisSorteos(marco));
		}
	}


	public void misTickets() {
		if (marco.getUsuario()==null){
			JOptionPane.showMessageDialog(pantalla,
					   "Aún no estás conectado.\n"
					   + "Conéctate (o Registrate) en el apartado 'Perfil'.");
		} else {
			marco.anadirPantalla(new p04MisTickets.PantallaMisTickets(marco));
		}
	}


	public void sobreMiPerfil() {
		relax();
		pantalla.lPerfil.setBackground(Color.LIGHT_GRAY);
	}

	public void sobreBuscarSorteos() {
		relax();
		pantalla.lBuscar.setBackground(Color.LIGHT_GRAY);
	}


	public void sobreMisSorteos() {
		relax();
		pantalla.lMisSorteos.setBackground(Color.LIGHT_GRAY);
	}


	public void sobreMisTickets() {
		relax();
		pantalla.lMisTickets.setBackground(Color.LIGHT_GRAY);
	}


	public void relax() {
		pantalla.lPerfil.setBackground(Color.WHITE);
		pantalla.lBuscar.setBackground(Color.WHITE);
		pantalla.lMisSorteos.setBackground(Color.WHITE);
		pantalla.lMisTickets.setBackground(Color.WHITE);
	}
	
/*	private void resetOrden() {
		pantalla.removeAll();
		
		pantalla.add(pantalla.pBuscar);
		pantalla.add(pantalla.pPerfil);
		pantalla.add(pantalla.pSorteos);
		pantalla.add(pantalla.pTickets);
		
		pantalla.add(pantalla.imgBuscar);
		pantalla.add(pantalla.imgBuscar);
		pantalla.add(pantalla.imgBuscar);
		pantalla.add(pantalla.imgBuscar);
		
		pantalla.add(pantalla.lBuscar);
		pantalla.add(pantalla.lMisSorteos);
		pantalla.add(pantalla.lMisTickets);
		pantalla.add(pantalla.lPerfil);
	}
*/
}
