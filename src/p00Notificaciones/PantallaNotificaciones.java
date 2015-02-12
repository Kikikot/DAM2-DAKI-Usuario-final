package p00Notificaciones;

import java.awt.Component;
import java.awt.FlowLayout;
import java.util.ArrayList;

import objetos.Notificacion;
import marco.ControladorMarco;
import utiles.PanelPantalla;

public class PantallaNotificaciones extends PanelPantalla {

	private ControladorNotificaciones c;

	public PantallaNotificaciones(ControladorMarco controladorMarco) {
		super(controladorMarco);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));
		
		sms2 = "Notificaciones";
		bSalir = "Volver";
		
		c = new ControladorNotificaciones(this);
	}
	
	public void loadNotificaciones(ArrayList<Notificacion> notificaciones){
		int nuevas = 0;
		
		Component[] antiguos = this.getComponents();
		this.removeAll();
		
		for (int i=notificaciones.size()-1; i>=0; i--){
			GraficoNotificacion temp = new GraficoNotificacion(notificaciones.get(i),
												this.getMarco(), (int) this.getSize().getWidth()-20);
			this.add(temp);
			if (notificaciones.get(i).getEstado() == Notificacion.ESTADO_NUEVA) nuevas++;
		}
		
		for (int i=0; i<antiguos.length; i++){
			this.add(antiguos[i]);
			if (((GraficoNotificacion)antiguos[i]).getEstado() == Notificacion.ESTADO_NUEVA) nuevas++;
		}
		c.muestraTotalNuevasNotificaciones(nuevas);
	}
	
	public void finalizar(){
		c.finalizar();
	}

	public ArrayList<String> getIdNotificaciones() {
		Component[] antiguos = this.getComponents();
		ArrayList<String> respuesta = new ArrayList<String>();
		for (int i=0; i<antiguos.length; i++){
			respuesta.add(((GraficoNotificacion)antiguos[i]).getNotificacion().getId());
		}
		return respuesta;
	}

	public void setSms1(String sms) {
		this.sms1 = sms;
	}

	public void borrar(GraficoNotificacion graficoNotificacion) {
		this.remove(graficoNotificacion);
	}

}
