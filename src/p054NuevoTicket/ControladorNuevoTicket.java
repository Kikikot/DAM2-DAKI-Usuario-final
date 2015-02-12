package p054NuevoTicket;


import java.util.Calendar;

import javax.swing.JOptionPane;

import marco.ControladorMarco;

public class ControladorNuevoTicket {
	
	private PantallaNuevoTicket pantalla;
	private ControladorMarco marco;
	
	private int valorMinimo;
	
	private String error;
	
	public ControladorNuevoTicket(PantallaNuevoTicket pantallaNuevoTicket, int valorMinimoTickets) {
		pantalla = pantallaNuevoTicket;
		marco = pantalla.getMarco();
		this.valorMinimo = valorMinimoTickets;
		
		initPantalla();
	}

	private void initPantalla() {
		for (int i=1; i<13; i++){
			pantalla.cDia.addItem(i+"");
			pantalla.cMes.addItem(i+"");
		}
		for (int i=13; i<32; i++){
			pantalla.cDia.addItem(i+"");
		}
		Calendar hoy= Calendar.getInstance();
		int ano = hoy.get(Calendar.YEAR);
		pantalla.cAno.addItem(((ano-1)+"").substring(2));
		pantalla.cAno.addItem(((ano)+"").substring(2));
		
		String[] patrocinadores = marco.getNombrePatrocinadores(pantalla.idSorteo);
		for(int i=0; i<patrocinadores.length; i++){
			pantalla.cPatrocinador.addItem(patrocinadores[i]);
		}
		
		pantalla.cDia.setSelectedIndex(0);
		pantalla.cMes.setSelectedIndex(0);
		pantalla.cAno.setSelectedIndex(0);
		pantalla.cPatrocinador.setSelectedIndex(0);
	}

	public void registrarTicket() {
		if (todoOK()) registrar();
		else mostrarFallos();
	}

	private void registrar() {
		boolean ok = marco.registrarTicket(pantalla.idSorteo,
								   pantalla.tTicket.getText(),
								   pantalla.cDia.getSelectedItem()+"/"+pantalla.cMes.getSelectedItem()+"/"+pantalla.cAno.getSelectedItem(),
								   Float.parseFloat(pantalla.tImporte.getText()),
								   (String)pantalla.cPatrocinador.getSelectedItem());
		if (ok) resetPantalla();
		else JOptionPane.showMessageDialog(pantalla,
				   "Ese número de ticket, ya existe para ese patrocinador.\n"
				   + "Por favor, comprueba haber introducido bien los datos.");
	}

	private void resetPantalla() {
		pantalla.tTicket.setText("");
		pantalla.cDia.setSelectedIndex(0);
		pantalla.cMes.setSelectedIndex(0);
		pantalla.cAno.setSelectedIndex(0);
		pantalla.tImporte.setText("");
		pantalla.cPatrocinador.setSelectedIndex(0);
	}

	private void mostrarFallos() {
		JOptionPane.showMessageDialog(pantalla,
				   "Se ha producido algún error:"
				   + error);
	}

	private boolean todoOK() {
		boolean ok = true;
		error = "";
		
		if (pantalla.tTicket.getText().equals("")) ok = addError("No has introducido ningún ticket.");
		String valor = pantalla.tImporte.getText();
		if (valor.equals("")) ok = addError("No has introducido el valor del ticket.");
		else{
			try{
				float v = Float.parseFloat(valor);
				if (v<valorMinimo) ok = addError("El valor del ticket ha de ser superior a "+valorMinimo+" euros."
												+ "\n        (compruebalo en las condiciones)");
			} catch (Exception e){
				ok = addError("El valor del ticket ha de ser un número.");
			}
		}
		
		Calendar hoy = Calendar.getInstance();
		Calendar dia = Calendar.getInstance();
		dia.set(Calendar.YEAR, 2000+(Integer.parseInt((String)pantalla.cAno.getSelectedItem())));
		dia.set(Calendar.MONTH, (Integer.parseInt((String)pantalla.cMes.getSelectedItem()))-1);
		dia.set(Calendar.DAY_OF_MONTH, (Integer.parseInt((String)pantalla.cDia.getSelectedItem())));
		System.out.println(dia.getTime());
		if (hoy.getTimeInMillis()<dia.getTimeInMillis()) ok = addError("La fecha de compra no ha de ser superior a la de hoy");
		
		return ok;
	}

	private boolean addError(String mensaje) {
		error = error+"\n   "+mensaje;
		return false;
	}

}
