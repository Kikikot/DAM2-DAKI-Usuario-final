package p054NuevoTicket;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import utiles.AKIButton;
import utiles.AKIPanel;
import utiles.JPanelFondo;
import marco.ControladorMarco;

public class PantallaNuevoTicket extends utiles.PanelPantalla implements MouseListener {
	
	protected String idSorteo;
	private ControladorNuevoTicket c;
	
	protected JComboBox<String> cPatrocinador = new JComboBox<String>();
	protected JTextField tTicket;
	protected JTextField tImporte;
	protected JLabel tId;
	protected JComboBox<String> cDia;
	protected JComboBox<String> cMes;
	protected JComboBox<String> cAno;
	protected AKIButton bRegistrar = new AKIButton("Registrar ticket", AKIButton.TipoBoton.BotonSimple);
	
	public PantallaNuevoTicket(ControladorMarco controladorMarco, String idSorteo, int valorMinimoTickets) {
		super(controladorMarco);
		this.idSorteo = idSorteo;
		
		sms1 = this.getMarco().getUsuario();
		sms2 = "Registrar ticket";
		bSalir = "Cancelar registro";
		
		AKIPanel panel = new AKIPanel();
		panel.setBounds(10, 11, 367, 350);
		add(panel);
		panel.setLayout(null);
		
		JLabel lId = new JLabel("Id Sorteo:");
		lId.setFont(new Font("Verdana", Font.BOLD, 14));
		lId.setForeground(Color.GRAY);
		lId.setHorizontalAlignment(SwingConstants.RIGHT);
		lId.setBounds(10, 11, 103, 14);
		panel.add(lId);
		
		JLabel lTicket = new JLabel("N\u00BA Ticket:");
		lTicket.setFont(new Font("Verdana", Font.BOLD, 12));
		lTicket.setForeground(Color.GRAY);
		lTicket.setHorizontalAlignment(SwingConstants.RIGHT);
		lTicket.setBounds(10, 63, 103, 14);
		panel.add(lTicket);
		
		JLabel lFecha = new JLabel("Fecha compra:");
		lFecha.setFont(new Font("Verdana", Font.BOLD, 12));
		lFecha.setForeground(Color.GRAY);
		lFecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lFecha.setBounds(10, 124, 103, 14);
		panel.add(lFecha);
		
		JLabel lImporte = new JLabel("Importe:");
		lImporte.setFont(new Font("Verdana", Font.BOLD, 12));
		lImporte.setForeground(Color.GRAY);
		lImporte.setHorizontalAlignment(SwingConstants.RIGHT);
		lImporte.setBounds(10, 179, 103, 14);
		panel.add(lImporte);
		
		JLabel lPatrocinador = new JLabel("Patrocinador:");
		lPatrocinador.setFont(new Font("Verdana", Font.BOLD, 12));
		lPatrocinador.setForeground(Color.GRAY);
		lPatrocinador.setHorizontalAlignment(SwingConstants.RIGHT);
		lPatrocinador.setBounds(10, 236, 103, 14);
		panel.add(lPatrocinador);
		
		JPanelFondo panel_1 = new JPanelFondo();
		panel_1.setBounds(10, 286, 347, 38);
		panel.add(panel_1);
		
		bRegistrar.addMouseListener(this);
		panel_1.add(bRegistrar);
		
		tId = new JLabel(this.idSorteo);
		tId.setFont(new Font("Verdana", Font.PLAIN, 14));
		tId.setBounds(123, 11, 234, 14);
		panel.add(tId);
		
		tTicket = new JTextField();
		tTicket.setFont(new Font("Verdana", Font.PLAIN, 12));
		tTicket.setBounds(123, 60, 234, 20);
		panel.add(tTicket);
		tTicket.setColumns(10);
		
		JLabel lblD = new JLabel("d");
		lblD.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblD.setBounds(123, 124, 14, 14);
		panel.add(lblD);
		
		cDia = new JComboBox<String>();
		cDia.setFont(new Font("Verdana", Font.PLAIN, 12));
		cDia.setBounds(139, 121, 54, 20);
		panel.add(cDia);
		
		cMes = new JComboBox<String>();
		cMes.setFont(new Font("Verdana", Font.PLAIN, 12));
		cMes.setBounds(221, 121, 54, 20);
		panel.add(cMes);
		
		JLabel lblM = new JLabel("m");
		lblM.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblM.setBounds(205, 124, 14, 14);
		panel.add(lblM);
		
		cAno = new JComboBox<String>();
		cAno.setFont(new Font("Verdana", Font.PLAIN, 12));
		cAno.setBounds(303, 121, 54, 20);
		panel.add(cAno);
		
		JLabel lblA = new JLabel("a");
		lblA.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblA.setBounds(287, 124, 14, 14);
		panel.add(lblA);
		
		tImporte = new JTextField();
		tImporte.setFont(new Font("Verdana", Font.PLAIN, 12));
		tImporte.setBounds(123, 176, 105, 20);
		panel.add(tImporte);
		tImporte.setColumns(10);
		
		JLabel lEuros = new JLabel("\u20AC");
		lEuros.setFont(new Font("Verdana", Font.PLAIN, 12));
		lEuros.setBounds(238, 179, 30, 14);
		panel.add(lEuros);
		
		cPatrocinador.setBounds(123, 233, 234, 20);
		cPatrocinador.setFont(new Font("Verdana", Font.PLAIN, 12));
		panel.add(cPatrocinador);
		
		c = new ControladorNuevoTicket(this, valorMinimoTickets);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(bRegistrar)){
			c.registrarTicket();
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
