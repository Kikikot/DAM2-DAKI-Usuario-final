package principal;

import java.awt.Color;

import javax.swing.JOptionPane;

import marco.ControladorMarco;

public class ControladorPrincipal {
	
	private PantallaPrincipal pantalla;
	private ControladorMarco marco;
	
	Color sobre = new Color(0xFFBCFF);
	
	public ControladorPrincipal(PantallaPrincipal pantallaPrincipal) {
		pantalla = pantallaPrincipal;
		marco = pantalla.getMarco();
		relax();
	}


	public void miPerfil() {
		marco.anadirPantalla(new p01Perfil.PantallaPerfil(marco));
		relax();
	}


	public void buscarSorteos() {
		if (marco.getUsuario()==null){
			JOptionPane.showMessageDialog(pantalla,
					   "Aún no estás conectado.\n"
					   + "Conéctate (o Registrate) en el apartado 'Perfil'.");
		} else {
			marco.anadirPantalla(new p02BuscarSorteos.PantallaBuscarSorteos(marco));
			relax();
		}
	}


	public void misSorteos() {
		if (marco.getUsuario()==null){
			JOptionPane.showMessageDialog(pantalla,
					   "Aún no estás conectado.\n"
					   + "Conéctate (o Registrate) en el apartado 'Perfil'.");
		} else {
			marco.anadirPantalla(new p03MisSorteos.PantallaMisSorteos(marco));
			relax();
		}
	}


	public void misTickets() {
		if (marco.getUsuario()==null){
			JOptionPane.showMessageDialog(pantalla,
					   "Aún no estás conectado.\n"
					   + "Conéctate (o Registrate) en el apartado 'Perfil'.");
		} else {
			marco.anadirPantalla(new p04MisTickets.PantallaMisTickets(marco));
			relax();
		}
	}


	public void sobreMiPerfil() {
		relax();
		pantalla.pUsuario.setBackground(sobre);
	}

	public void sobreBuscarSorteos() {
		relax();
		pantalla.pBuscar.setBackground(sobre);
	}


	public void sobreMisSorteos() {
		relax();
		pantalla.pSorteos.setBackground(sobre);
	}


	public void sobreMisTickets() {
		relax();
		pantalla.pTickets.setBackground(sobre);
	}


	public void relax() {
		pantalla.pUsuario.setBackground(Color.WHITE);
		pantalla.pBuscar.setBackground(Color.WHITE);
		pantalla.pSorteos.setBackground(Color.WHITE);
		pantalla.pTickets.setBackground(Color.WHITE);
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
