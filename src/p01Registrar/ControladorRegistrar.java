package p01Registrar;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import marco.ControladorMarco;

public class ControladorRegistrar implements MouseListener {
	
	private PantallaRegistrar pantalla;
	private ControladorMarco marco;
	private String fallos = "";
	
	public ControladorRegistrar(PantallaRegistrar pantallaRegistrar){
		pantalla = pantallaRegistrar;
		marco = pantalla.getMarco();
		
		String[] provincias = marco.getProvincias();
		for(int i=0; i<provincias.length; i++){
			pantalla.cProvincia.addItem(provincias[i]);
		}
		
		if (marco.getUsuario()==null) loadPoblaciones(provincias[0]);
		else loadConectado();
		
		
	}

	private void loadConectado() {
		
		String[] datos = marco.getDatosLargoUsuario();
		pantalla.tAlias.setText(marco.getUsuario());
		pantalla.tAlias.setEditable(false);
		pantalla.setEnabled(false);
		pantalla.tPass.setText(datos[0]);
		pantalla.tMail.setText(datos[1]);
		pantalla.tConfirmacionMail.setText(datos[1]);
		pantalla.tNombre.setText(datos[6]);
		pantalla.tApellido.setText(datos[7]);
		pantalla.tDireccion.setText(datos[2]);
		pantalla.tCP.setText(datos[3]);
		
		pantalla.cProvincia.setSelectedItem(marco.getProvinciaDePoblacion(Integer.parseInt(datos[4])));
		loadPoblaciones((String) pantalla.cProvincia.getSelectedItem());
		pantalla.cPoblacion.setSelectedItem(datos[5]);
		
		pantalla.check.setSelected(true);
		
		pantalla.bEnviarDatos = null;
		pantalla.bEnviarDatos = new utiles.AKIButton("Actualizar", utiles.AKIButton.TipoBoton.BotonSimple);
		pantalla.bEnviarDatos.addMouseListener(this);
	}

	private void loadPoblaciones(String provincia) {
		String[] poblaciones = marco.getLocalidades(provincia);
		for (int i=0; i<poblaciones.length; i++){
			pantalla.cPoblacion.addItem(poblaciones[i]);
		}
	}

	public void provinciaCambiada() {
		String provincia = (String)pantalla.cProvincia.getSelectedItem();
		String[] poblaciones = marco.getLocalidades(provincia);
		pantalla.cPoblacion.removeAllItems();
		for (int i=0; i<poblaciones.length; i++){
			pantalla.cPoblacion.addItem(poblaciones[i]);
		}
	}

	public void enviarDatos() {
		if(datosOK()){
			registrarUsuario();
		} else {
			JOptionPane.showMessageDialog(pantalla,
					   "Se han producido los siguientes fallos:"
					   +fallos);
			fallos = "";
		}
		
	}

	private void registrarUsuario() {
		marco.registrarUsuario(pantalla.tAlias.getText(), new String(pantalla.tPass.getPassword()),
				pantalla.tMail.getText(), (String)pantalla.cPoblacion.getSelectedItem(), pantalla.tNombre.getText(),
				pantalla.tApellido.getText(), pantalla.tDireccion.getText(), pantalla.tCP.getText());
		JOptionPane.showMessageDialog(pantalla,
				   "Usuario registrado con exito.\nVuelve a la pantalla anterior y conectate.");
	}

	private boolean datosOK() {
		boolean ok = true;
		if (pantalla.tAlias.getText().equals("")){
			ok = false;
			addFallo("Introduce un 'Alias'.");
		} else if (marco.getUsuario().equals(null) && marco.existeUsuario(pantalla.tAlias.getText())){
			ok = false;
			addFallo("El 'Alias' ya existe.");
		}
		if ((new String(pantalla.tPass.getPassword())).equals("")){
			ok = false;
			addFallo("Introduce una 'Contraseña'.");
		}
		if (pantalla.tMail.getText().equals("")){
			ok = false;
			addFallo("Introduce un 'e-mail'.");
		} else if (!pantalla.tConfirmacionMail.getText().equals(pantalla.tMail.getText())){
			ok = false;
			addFallo("El 'e-mail' no coincide con su confirmación.");
		} else if (marco.getUsuario().equals(null) && marco.existeMail(pantalla.tMail.getText())){
			ok = false;
			addFallo("El 'e-mail' ya está registrado");
		}
		if (pantalla.tNombre.getText().equals("")){
			ok = false;
			addFallo("Introduce un 'Nombre'.");
		}
		if (pantalla.tApellido.getText().equals("")){
			ok = false;
			addFallo("Al menos un 'Apellido'.");
		}
		if (pantalla.tDireccion.getText().equals("")){
			ok = false;
			addFallo("Introduce una 'Direccion'.");
		}
		if (pantalla.tCP.getText().length()!=5 && !esCP(pantalla.tCP.getText())){
			ok = false;
			addFallo("Introduce un 'Código Postal' ('C.P.').");
		}
		if (!pantalla.check.isSelected()){
			ok = false;
			addFallo("No has aceptado las condiciones.");
		}
		return ok;
	}

	private void addFallo(String fallo) {
		fallos = fallos + "\n" + fallo;
		
	}

	private boolean esCP(String numero) {
		try{
			Integer.parseInt(numero);
			return true;
		} catch(Exception e){
			return false;
		}
		
	}

	public void verCondiciones() {
		JOptionPane.showMessageDialog(pantalla,
				   "Condiciones:\n"
				   + "Bla bla bla bla bla bla bla bla bla\n"
				   + "bla bla bla bla bla bla bla bla bla\n"
				   + "Bla bla bla bla bla bla bla bla bla\n"
				   + "bla bla bla bla bla bla bla bla bla\n"
				   + "Bla bla bla bla bla bla bla bla bla\n"
				   + "bla bla bla bla bla bla bla bla bla\n"
				   + "Bla bla bla bla bla bla bla bla bla\n"
				   + "bla bla bla bla bla bla bla bla bla\n"
				   + "Bla bla bla bla bla bla bla bla bla\n"
				   + "bla bla bla bla bla bla bla bla bla\n"
				   + "Bla bla bla bla bla bla bla bla bla\n"
				   + "bla bla bla bla bla bla bla bla bla\n");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(pantalla.bEnviarDatos)) {
			if (datosOK()){
				marco.actualizarUsuario(new String(pantalla.tPass.getPassword()),
						pantalla.tMail.getText(), (String)pantalla.cPoblacion.getSelectedItem(), pantalla.tNombre.getText(),
						pantalla.tApellido.getText(), pantalla.tDireccion.getText(), pantalla.tCP.getText());
				JOptionPane.showMessageDialog(pantalla,
						   "Datos modificados correctamente.");
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
