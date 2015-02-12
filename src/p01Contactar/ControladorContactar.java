package p01Contactar;

import javax.swing.JOptionPane;

import marco.ControladorMarco;

public class ControladorContactar {
	
	private PantallaContactar pantalla;
	private ControladorMarco marco;
	private String fallos;
	
	public ControladorContactar(PantallaContactar p){
		pantalla = p;
		marco = pantalla.getMarco();
	}
	
	public void enviar(){
		String asunto = pantalla.tAsunto.getText();
		String mensaje = pantalla.tTexto.getText();
		String correo = pantalla.tCorreo.getText();
		if (todoOK(asunto, mensaje, correo)){
			marco.enviarMensaje(asunto, mensaje, correo);
		} else {
			JOptionPane.showMessageDialog(pantalla,
					   "Todos los campos son obligatorios."
					   + fallos);
		}
	}

	private boolean todoOK(String asunto, String mensaje, String correo) {
		fallos = "";
		boolean ok = true;
		if (asunto.equals("")){
			fallos = fallos + "\n    Falta el asunto.";
			ok = false;
		}
		if (mensaje.equals("")){
			fallos = fallos + "\n    Falta el mensaje.";
			ok = false;
		}
		if (correo.equals("")){
			fallos = fallos + "\n    Falta el e-mail de contacto.";
			ok = false;
		}
		return ok;
	}

	public void escribiendo() {
		String mensaje = pantalla.tTexto.getText();
		if (mensaje.length()>pantalla.maxLength) pantalla.tTexto.setText(mensaje.substring(0, pantalla.maxLength));
		pantalla.lCaracteres.setText("("+pantalla.tTexto.getText().length()+" / "+pantalla.maxLength+")");
	}
	
}
