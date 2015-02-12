package p01Perfil;

import javax.swing.JOptionPane;

import marco.ControladorMarco;

public class ControladorPerfil {
	
	private PantallaPerfil pantalla;
	private ControladorMarco marco;
	
	public ControladorPerfil(PantallaPerfil pantallaPerfil){
		pantalla = pantallaPerfil;
		marco = pantalla.getMarco();
	}

	public void conectar() {
		String usuario = pantalla.tUsuario.getText();
		String clave = new String(pantalla.tContrasena.getPassword());
		if (clave.equals("") || clave.equals(null) || usuario.equals("") || usuario.equals(null)){
			JOptionPane.showMessageDialog(pantalla,
					   "No has introducido los datos requeridos.\n"
					   + "(Has de introducir ''Usuario'' y ''Contraseña'')");
		} else {
			boolean conectado = marco.conecta(usuario, clave);
			if (conectado){
				pantalla.cargarConectado();
				marco.reload();
			} else {
				JOptionPane.showMessageDialog(pantalla,
						   "No te has identificado correctamente.\n"
						   + "Comprueba tu ''Usuario'' y ''Contraseña''");
			}
		}
	}

	public void registrar() {
		// TODO Auto-generated method stub
		marco.anadirPantalla(new p01Registrar.PantallaRegistrar(marco));
	}

	public void contactar() {
		// TODO Auto-generated method stub
		marco.anadirPantalla(new p01Contactar.PantallaContactar(marco));
	}

	public void editar() {
		// TODO Auto-generated method stub
		registrar();
	}

	public String[] getDatosCortosUsuario() {
		return marco.getDatosCortosUsuario();
	}
	
}
