package p03MisSorteos;

import marco.ControladorMarco;
import utiles.PrevisualizacionSorteo;

public class ControladorMisSorteos {
	
	PantallaMisSorteos pantalla;
	ControladorMarco marco;
	
	public ControladorMisSorteos(PantallaMisSorteos pantallaMisSorteos) {
		pantalla = pantallaMisSorteos;
		marco = pantalla.getMarco();
		
		listarParticipando();
	}

	public void listarParticipando() {
		relajar();
		pantalla.bParticipando.setPulsado(true);
		PrevisualizacionSorteo[] sorteos = marco.getSorteosParticipando();
		pantalla.mostrarListaSorteos(sorteos);
		marco.reload();
	}

	public void listarSiguiendo() {
		relajar();
		pantalla.bSiguiendo.setPulsado(true);
		PrevisualizacionSorteo[] sorteos = marco.getSorteosSiguiendo();
		pantalla.mostrarListaSorteos(sorteos);
		marco.reload();
	}
	
	private void relajar() {
		pantalla.bParticipando.setPulsado(false);
		pantalla.bSiguiendo.setPulsado(false);
	}
	
}
