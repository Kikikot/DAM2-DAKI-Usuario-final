package p051Comentarios;

import javax.swing.JOptionPane;

import objetos.Comentario;
import marco.ControladorMarco;

public class ControladorComentarios {

	private PantallaComentarios pantalla;
	private ControladorMarco marco;
	
	public ControladorComentarios(PantallaComentarios pantallaComentarios) {
		pantalla = pantallaComentarios;
		marco = pantalla.getMarco();
	}

	public void comentar() {
		if (pantalla.tComentario.getText().length()!=0){
			Comentario comentario = new Comentario(marco.getUsuario(), pantalla.idSorteo, pantalla.tComentario.getText());
			pantalla.pComentarios.enviarComentario(comentario);
			pantalla.tComentario.setText("");
		} else {
			JOptionPane.showMessageDialog(pantalla,
					   "Has de introducir algún mensaje.");
		}
	}

	public void escribiendo() {
		String mensaje = pantalla.tComentario.getText();
		if (mensaje.length()>pantalla.maxLength) pantalla.tComentario.setText(mensaje.substring(0, pantalla.maxLength));
		pantalla.lCaracteres.setText("("+pantalla.tComentario.getText().length()+" / "+pantalla.maxLength+")");
	}

}
