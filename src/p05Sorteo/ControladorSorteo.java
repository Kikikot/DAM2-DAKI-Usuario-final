package p05Sorteo;

import marco.ControladorMarco;

public class ControladorSorteo {

	private ControladorMarco marco;
	private PantallaSorteo pantalla;
	
	private boolean seguido = false;
	private int valorMinimoTicket;

	public ControladorSorteo(PantallaSorteo pantallaSorteo) {
		pantalla = pantallaSorteo;
		marco = pantallaSorteo.getMarco();
		
		initPantalla();
		
	}

	private void initPantalla() {
		// 0 = titulo,    1 = tickets_de_usuario,    2 = fecha_sorteo,    3 = total_comantario,
		// 4 = descripcion,    5 = condiciones,    6 = seguido,    7 = valor_minimo_del_ticket
		String[] datos = marco.getRestoDatosDelSorteo(pantalla.idSorteo);
		pantalla.lTitulo.setText(datos[0]);
		pantalla.lTickets.setText(datos[1]+pantalla.lTickets.getText());
		pantalla.lTiempo.setText(datos[2]);
		pantalla.lComentarios.setText(datos[3]+" comentarios");
		pantalla.tDescripcion.setText(datos[4]);
		pantalla.tCondiciones.setText(datos[5]);
		if (datos[6].equals("1")){
			pantalla.bSeguir.setPulsado(true);
			seguido = true;
		}
		this.valorMinimoTicket = Integer.parseInt(datos[7]);
	}

	public void comentarios() {
		marco.anadirPantalla(new p051Comentarios.PantallaComentarios(marco, pantalla.idSorteo));
	}

	public void patrocinadores() {
		marco.anadirPantalla(new p052Patrocinadores.PantallaPatrocinadores(marco, pantalla.idSorteo));
	}

	public void seguir() {
		if (seguido) dejarDeSeguir();
		else empezarASeguir();
	}

	private void empezarASeguir() {
		if (marco.empezarASeguirSorteo(pantalla.idSorteo)) seguido = true;
		else pantalla.bSeguir.setPulsado(false);
	}

	private void dejarDeSeguir() {
		if (marco.dejarDeSeguirSorteo(pantalla.idSorteo)) seguido = false;
		else pantalla.bSeguir.setPulsado(true);
	}

	public void tickets() {
		marco.anadirPantalla(new p053TicketsDeSorteo.PantallaTicketsDeSorteo(marco, pantalla.idSorteo));
	}

	public void addTickets() {
		marco.anadirPantalla(new p054NuevoTicket.PantallaNuevoTicket(marco, pantalla.idSorteo, valorMinimoTicket));
	}

	public void facebook() {
		System.out.println("Compartir en Facebook");
	}

	public void twitter() {
		System.out.println("Compartir en Twitter");
	}

	public void pinterest() {
		System.out.println("Compartir en Pinterest");
	}

}
