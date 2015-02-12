package p053TicketsDeSorteo;

import marco.ControladorMarco;

public class PantallaTicketsDeSorteo extends p06MostrarTickets.PantallaMostrarTickets{

	public PantallaTicketsDeSorteo(ControladorMarco controladorMarco, String id) {
		super(controladorMarco, controladorMarco.getTicketsDeSorteo(id), false);
		sms1 = controladorMarco.getUsuario();
		sms2 = "Tickets en "+id;
		bSalir = "Volver";
	}
	
}
