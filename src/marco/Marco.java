package marco;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import utiles.AKIButton;
import utiles.JPanelFondo;
import utiles.PanelPantalla;

public class Marco extends JFrame implements MouseListener{

	private JPanel contentPane;
	private JLabel sms1;
	private JLabel sms2;
	private JPanelFondo pNotificaciones;
	protected JPanelFondo pContador;
	protected JLabel lContador;
	private JScrollPane scroll;
	private AKIButton bSalir;
	private ControladorMarco controler;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Marco vista = new Marco();
		ControladorMarco controlador = new ControladorMarco(vista);
		vista.setControlador(controlador);
	}

	private void setControlador(ControladorMarco controlador) {
		controler = controlador;
	}

	/**
	 * Create the frame.
	 */
	public Marco() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(406, 628);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		JPanel zSuperior = new JPanel();
		zSuperior.setBackground(new Color(0xBB00BB));
		contentPane.add(zSuperior, BorderLayout.NORTH);
		zSuperior.setLayout(null);
		zSuperior.setBounds(0, 0, 400, 100);
		
		
		JPanelFondo pSupIzq = new JPanelFondo("logo.png");
		pSupIzq.setBounds(0, 0, 100, 100);
		pSupIzq.addMouseListener(this);
		zSuperior.add(pSupIzq, BorderLayout.WEST);
		
		JPanelFondo pSupCen = new JPanelFondo();
		pSupCen.setBounds(100, 0, 200, 100);
		zSuperior.add(pSupCen, BorderLayout.CENTER);
		pSupCen.setLayout(new BorderLayout(0, 0));
		
		JPanelFondo pSupCentrisimo = new JPanelFondo();
		pSupCentrisimo.setLayout(new BorderLayout(0, 0));
		
		JPanelFondo pSupCenUp = new JPanelFondo();
		pSupCenUp.setSize(0, 15);
		JPanelFondo pSupCenDown = new JPanelFondo();
		pSupCenDown.setSize(0, 15);
		pSupCen.add(pSupCenUp, BorderLayout.NORTH);
		pSupCen.add(pSupCentrisimo, BorderLayout.CENTER);
		pSupCen.add(pSupCenUp, BorderLayout.SOUTH);
		
		sms1 = new JLabel("SMS 1");
		pSupCentrisimo.add(sms1, BorderLayout.NORTH);
		sms1.setForeground(Color.WHITE);
		sms1.setFont(new Font("Gabrielle", Font.BOLD, 36));
		sms1.setHorizontalAlignment(SwingConstants.CENTER);
		
		sms2 = new JLabel("SMS 2");
		pSupCentrisimo.add(sms2, BorderLayout.SOUTH);
		sms2.setForeground(Color.WHITE);
		sms2.setFont(new Font("Gabrielle", Font.BOLD, 25));
		sms2.setHorizontalAlignment(SwingConstants.CENTER);
		
		pNotificaciones = new JPanelFondo("mensajet.png");
		pNotificaciones.addMouseListener(this);
		pNotificaciones.setBounds(305, 5, 90, 90);
		pNotificaciones.addMouseListener(this);
		zSuperior.add(pNotificaciones);
		pNotificaciones.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
		
		pContador = new JPanelFondo("circulot.png");
		pContador.setBackground(Color.RED);
		pNotificaciones.add(pContador);
		
		lContador = new JLabel();
		pContador.add(lContador);
		
		scroll = new JScrollPane();
		scroll.setBorder(null);
		scroll.setBounds(5, 105, 390, 455);
		contentPane.add(scroll);
		
		JPanel zInferior = new JPanel();
		zInferior.setBounds(0, 550, 400, 50);
		zInferior.setLayout(new BorderLayout(0, 0));
		zInferior.setBackground(Color.WHITE);
		contentPane.add(zInferior, BorderLayout.SOUTH);
		
		JPanel pInfCentro = new JPanel();
		zInferior.add(pInfCentro, BorderLayout.SOUTH);
		pInfCentro.setBackground(Color.WHITE);
		
		bSalir = new AKIButton("Morcillitas de Burgos", AKIButton.TipoBoton.BotonSimple);
		pInfCentro.add(bSalir, BorderLayout.SOUTH);
		bSalir.addMouseListener(this);
		
		setVisible(true);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(bSalir)) controler.salir();
		else if(e.getSource().equals(pNotificaciones)) controler.notificaciones();
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void setSMS1(String mensaje) {
		sms1.setText(mensaje);
	}
	
	public void setSMS2(String mensaje) {
		sms2.setText(mensaje);
	}
	
	public void setbSalir(String mensaje) {
		bSalir.setText(mensaje);
		this.setSize(this.getWidth()+1, this.getHeight());
		this.setSize(this.getWidth()-1, this.getHeight());
	}

	public void setCentro(PanelPantalla pantalla) {
		scroll.setViewportView(pantalla);
	}
}
