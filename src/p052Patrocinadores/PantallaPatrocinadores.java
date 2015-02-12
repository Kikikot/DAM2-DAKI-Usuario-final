package p052Patrocinadores;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import utiles.AKIPanel;
import utiles.JPanelFondo;
import marco.ControladorMarco;

public class PantallaPatrocinadores extends utiles.PanelPantalla implements ActionListener {

	private ControladorPatrocinadores c;
	
	protected JComboBox<objetos.Patrocinador> cPatrocinador = new JComboBox<objetos.Patrocinador>();
	protected JPanelFondo imagen = new JPanelFondo();
	protected JTextPane tTipoComercio = new JTextPane();
	protected JLabel lNombreComercio = new JLabel("Tienda");
	protected JLabel lDistancia = new JLabel("Distancia");
	protected JLabel lDireccionComercio = new JLabel("lDireccionComercio");
	protected JLabel lEmailContacto = new JLabel("lEmailContacto");
	protected JLabel lTelefonoContacto = new JLabel("lTelefonoContacto");
	protected JLabel lNombreContacto = new JLabel("lNombreContacto");
	protected JPanelFondo pMapa = new JPanelFondo("mapa.png");
	
	protected String idSorteo;

	public PantallaPatrocinadores(ControladorMarco controladorMarco, String idSorteo) {
		super(controladorMarco);
		
		this.idSorteo = idSorteo;
		
		this.bSalir = "Volver al sorteo";
		this.sms2 = "Patrocinadores";
		this.sms1 = "Sorteo "+idSorteo;
		
		c = new ControladorPatrocinadores(this);
		
		
		cPatrocinador.setFont(new Font("Verdana", Font.BOLD, 12));
		cPatrocinador.setBounds(10, 11, this.getWidth()-20, 20);
		cPatrocinador.addActionListener(this);
		add(cPatrocinador);
		
		AKIPanel panel = new AKIPanel();
		panel.setBounds(10, 42, 367, 399);
		add(panel);
		panel.setLayout(null);
		
		
		imagen.setBounds(10, 58, 145, 103);
		panel.add(imagen);
		
		
		pMapa.setBounds(10, 240, 145, 145);
		panel.add(pMapa);
		
		
		lNombreComercio.setFont(new Font("Verdana", Font.BOLD, 12));
		lNombreComercio.setBounds(165, 11, 192, 14);
		panel.add(lNombreComercio);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(175, 36, 182, 66);
		panel.add(scrollPane);
		
		
		tTipoComercio.setFont(new Font("Verdana", Font.PLAIN, 12));
		tTipoComercio.setEditable(false);
		scrollPane.setViewportView(tTipoComercio);
		
		JLabel lContacto = new JLabel("Contacto");
		lContacto.setFont(new Font("Verdana", Font.PLAIN, 12));
		lContacto.setBounds(165, 113, 192, 14);
		panel.add(lContacto);
		
		
		lNombreContacto.setFont(new Font("Verdana", Font.PLAIN, 12));
		lNombreContacto.setBounds(175, 138, 182, 14);
		panel.add(lNombreContacto);
		
		
		lTelefonoContacto.setFont(new Font("Verdana", Font.PLAIN, 12));
		lTelefonoContacto.setBounds(175, 163, 182, 14);
		panel.add(lTelefonoContacto);
		
		
		lEmailContacto.setFont(new Font("Verdana", Font.PLAIN, 12));
		lEmailContacto.setBounds(175, 188, 182, 14);
		panel.add(lEmailContacto);
		
		JLabel Direccion = new JLabel("Direcci\u00F3n");
		Direccion.setFont(new Font("Verdana", Font.PLAIN, 12));
		Direccion.setBounds(165, 240, 192, 14);
		panel.add(Direccion);
		
		
		lDireccionComercio.setFont(new Font("Verdana", Font.PLAIN, 12));
		lDireccionComercio.setBounds(175, 265, 182, 14);
		panel.add(lDireccionComercio);
		
		
		lDistancia.setFont(new Font("Verdana", Font.BOLD, 30));
		lDistancia.setHorizontalAlignment(SwingConstants.CENTER);
		lDistancia.setBounds(165, 290, 192, 95);
		panel.add(lDistancia);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(this.cPatrocinador)){
			c.patrocinadorCambiado();
		}
	}

}
