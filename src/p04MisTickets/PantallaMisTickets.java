package p04MisTickets;

import java.util.ArrayList;

import marco.ControladorMarco;
import p06MostrarTickets.TicketGroup;

public class PantallaMisTickets extends p06MostrarTickets.PantallaMostrarTickets{

	public PantallaMisTickets(ControladorMarco controladorMarco) {
		super(controladorMarco, controladorMarco.getTicketsUsuario(), true);
		sms1 = controladorMarco.getUsuario();
		sms2 = "Mis tickets";
		bSalir = "Volver";
	}

}
