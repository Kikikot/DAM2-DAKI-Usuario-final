package p00Notificaciones;

import marco.ControladorMarco;

public class ControladorNotificaciones implements Runnable{

	private PantallaNotificaciones pantalla;
	private ControladorMarco marco;
	private boolean trabajando = true;

	public ControladorNotificaciones(PantallaNotificaciones pantallaNotificaciones) {
		pantalla = pantallaNotificaciones;
		marco = pantalla.getMarco();
		new Thread(this).start();
	}

	@Override
	public void run() {
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		pantalla.setSms1(marco.getUsuario());
		while (trabajando){
			actualizar();
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void actualizar() {
		pantalla.loadNotificaciones(marco.buscaNuevasNotificaciones(pantalla.getIdNotificaciones()));
	}

	public void finalizar(){
		trabajando = false;
	}

	public void muestraTotalNuevasNotificaciones(int nuevas) {
		marco.putNotificaciones(nuevas);
	}

}
