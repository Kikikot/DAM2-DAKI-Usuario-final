package p02BuscarSorteos;

import javax.swing.JOptionPane;

import utiles.PrevisualizacionSorteo;
import marco.ControladorMarco;

public class ControladorBuscarSorteos {
	
	PantallaBuscarSorteos pantalla;
	ControladorMarco marco;
	
	public ControladorBuscarSorteos(PantallaBuscarSorteos pantallaBuscarSorteos) {
		pantalla = pantallaBuscarSorteos;
		marco = pantalla.getMarco();
		
		listarPorKm();
	}

	public void listarPorKm() {
		relajar();
		pantalla.bKm.setPulsado(true);
		PrevisualizacionSorteo[] sorteos = marco.getSorteosPorKm();
		pantalla.mostrarListaSorteos(sorteos);
		marco.reload();
	}

	public void listarPorValor() {
		relajar();
		pantalla.bEuros.setPulsado(true);
		PrevisualizacionSorteo[] sorteos = marco.getSorteosPorValor();
		pantalla.mostrarListaSorteos(sorteos);
		marco.reload();
	}

	public void listarPorRecientes() {
		relajar();
		pantalla.bNuevos.setPulsado(true);
		PrevisualizacionSorteo[] sorteos = marco.getSorteosPorRecientes();
		pantalla.mostrarListaSorteos(sorteos);
		marco.reload();
	}

	public void listarPorComercio() {
		String[] tipos = marco.getTiposComercio();
		String tipo = (String) JOptionPane.showInputDialog(pantalla.bBuscador, 
		        "Elige un tipo de comercio",
		        "Tipos de comercio",
		        JOptionPane.QUESTION_MESSAGE, 
		        null, 
		        tipos, 
		        tipos[0]);
		if (tipo!=null){
			relajar();
			pantalla.bBuscador.setPulsado(true);
			PrevisualizacionSorteo[] sorteos = marco.getSorteosPorComercio(tipo);
			pantalla.mostrarListaSorteos(sorteos);
			marco.reload();
		} else {
			pantalla.bBuscador.setPulsado(false);
		}
	}
	
	private void relajar() {
		pantalla.bKm.setPulsado(false);
		pantalla.bEuros.setPulsado(false);
		pantalla.bNuevos.setPulsado(false);
		pantalla.bBuscador.setPulsado(false);
	}

}
