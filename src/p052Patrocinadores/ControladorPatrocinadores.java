package p052Patrocinadores;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import objetos.Patrocinador;
import marco.ControladorMarco;

public class ControladorPatrocinadores {
	
	private PantallaPatrocinadores pantalla;
	private ControladorMarco marco;
	
	public ControladorPatrocinadores(PantallaPatrocinadores pantallaProveedores) {
		pantalla = pantallaProveedores;
		marco = pantalla.getMarco();
		initPatrocinadores();
	}

	private void initPatrocinadores() {
		ArrayList<objetos.Patrocinador> patrocinadores = marco.getPatrocinadores(pantalla.idSorteo);
		for (int i=0; i<patrocinadores.size(); i++){
			pantalla.cPatrocinador.addItem(patrocinadores.get(i));
		}
		mostrarPatrocinador(patrocinadores.get(0));
	}

	public void patrocinadorCambiado() {
		mostrarPatrocinador((Patrocinador)pantalla.cPatrocinador.getSelectedItem());
	}
	
	private void mostrarPatrocinador(Patrocinador p) {
		pantalla.lNombreComercio.setText(p.getNombre());
		pantalla.tTipoComercio.setText(parsearTipoComercio(p.getTipoComercio()));
		try {
			pantalla.imagen.setImagen(new URL(p.getImagen()));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pantalla.lNombreContacto.setText(p.getNombreContacto());
		pantalla.lTelefonoContacto.setText(p.getTelfContacto());
		pantalla.lEmailContacto.setText(p.getEmailContacto());
		pantalla.lDireccionComercio.setText(p.getDireccionContacto());
		pantalla.lDistancia.setText(p.getDistancia()+" Km");
	}

	private String parsearTipoComercio(String[] tipos) {
		String respuesta = "";
		for (int i=0; i<tipos.length; i++){
			respuesta = respuesta + "#" + tipos[i] + " ";
		}
		return respuesta;
	}

}
