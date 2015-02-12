package p01Perfil;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import utiles.AKIButton;
import utiles.AKIPanel;
import utiles.JPanelFondo;

import marco.ControladorMarco;

public class PantallaPerfil extends utiles.PanelPantalla implements MouseListener{
	
	private ControladorPerfil c;
	private AKIPanel panel;
	private JLabel lUsuario = new JLabel("Usuario");
	protected JTextField tUsuario = new JTextField();
	private JLabel lContrasena = new JLabel("Contraseña");
	protected JPasswordField tContrasena = new JPasswordField();
	private AKIButton bConectar = new AKIButton("Conectar", AKIButton.TipoBoton.BotonSimple);
	private AKIButton bRegistrar = new AKIButton("Registrar", AKIButton.TipoBoton.BotonSimple);
	private AKIButton bEditar = new AKIButton("Editar", AKIButton.TipoBoton.BotonSimple);
	private JLabel linkContactar = new JLabel("Contactar con el administrador");
	
	public PantallaPerfil(ControladorMarco controladorMarco) {
		super(controladorMarco);
		
		bSalir = "Volver a la portada";
		
		panel = new AKIPanel();
		panel.setBounds(0, 0, this.getWidth()+3, this.getHeight()+3);
		panel.setLayout(null);
		this.add(panel);
		
		c = new ControladorPerfil(this);
		
		bConectar.addMouseListener(this);
		bRegistrar.addMouseListener(this);
		bEditar.addMouseListener(this);
		linkContactar.addMouseListener(this);
		
		if (this.getMarco().isConectado()){
			cargarConectado();
		}else{
			cargarDesconectado();
		}
	}

	private void cargarDesconectado() {
		sms1 = "Conectar";
		sms2 = "o Registrar";
		
		lUsuario.setForeground(Color.GRAY);
		lUsuario.setFont(new Font("Verdana", Font.BOLD, 19));
		lUsuario.setBounds(30, 50, 97, 25); 
		panel.add(lUsuario);
		
		tUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		tUsuario.setFont(new Font("Verdana", Font.BOLD, 16));
		tUsuario.setBounds(30, 80, panel.getWidth()-60, 25);
		panel.add(tUsuario);
		
		lContrasena.setForeground(Color.GRAY);
		lContrasena.setFont(new Font("Verdana", Font.BOLD, 19));
		lContrasena.setBounds(30, 130, 123, 25); 
		panel.add(lContrasena);
		
		tContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		tContrasena.setFont(new Font("Verdana", Font.BOLD, 16));
		tContrasena.setBounds(30, 160, panel.getWidth()-60, 25);
		panel.add(tContrasena);
		
		JPanelFondo botonera = new JPanelFondo();
		botonera.setBounds(0, panel.getHeight()/2 + 10, panel.getWidth(), panel.getHeight()/2 - 20);
		panel.add(botonera);
		botonera.setLayout(new BorderLayout(0, 0));
		
		JPanelFondo pConectar = new JPanelFondo();
		botonera.add(pConectar, BorderLayout.NORTH);
		pConectar.add(bConectar, BorderLayout.CENTER);
		
		JPanelFondo pRegistrar = new JPanelFondo();
		botonera.add(pRegistrar, BorderLayout.CENTER);
		pRegistrar.add(bRegistrar, BorderLayout.CENTER);
		
		JPanelFondo pContactar = new JPanelFondo();
		botonera.add(pContactar, BorderLayout.SOUTH);
		linkContactar.setFont(new Font("Verdana", Font.PLAIN, 11));
		linkContactar.setForeground(Color.BLUE);
		pContactar.add(linkContactar, BorderLayout.CENTER);
		
	}

	public void cargarConectado() {
		sms1 = this.getMarco().getUsuario();
		sms2 = "Mi Perfil";
		
		panel.removeAll();
		
		JPanel pIzquierdo = new JPanel();
		pIzquierdo.setBounds(10, 11, 120, 302);
		pIzquierdo.setBackground(Color.WHITE);
		pIzquierdo.setLayout(null);
		panel.add(pIzquierdo);
		
		JPanel pDerecho = new JPanel();
		pDerecho.setBounds(140, 11, 237, pIzquierdo.getHeight());
		pDerecho.setBackground(Color.WHITE);
		pDerecho.setLayout(null);
		panel.add(pDerecho);
		
		String[] titulos = {"Alias", "e-mail", "Población", "Contacto", "Dirección"};
		String[] contenido = c.getDatosCortosUsuario();
		
		for (int i=0; i<titulos.length; i++){
			JPanel pTempI = new JPanel();
			pTempI.setBackground(Color.WHITE);
			pTempI.setBounds(0, (pIzquierdo.getHeight()/5)*i, pIzquierdo.getWidth(), pIzquierdo.getHeight()/5);
			pIzquierdo.add(pTempI);
			pTempI.setLayout(new BorderLayout(0, 0));
			
			JLabel lTempI = new JLabel(titulos[i]);
			pTempI.add(lTempI, BorderLayout.EAST);
			lTempI.setForeground(Color.GRAY);
			lTempI.setFont(new Font("Verdana", Font.BOLD, 19));
			
			JPanel pTempD = new JPanel();
			pTempD.setBackground(Color.WHITE);
			pTempD.setBounds(0, (pDerecho.getHeight()/5)*i, pDerecho.getWidth(), pDerecho.getHeight()/5);
			pDerecho.add(pTempD);
			pTempD.setLayout(new BorderLayout(0, 0));
			
			JLabel lTempD = new JLabel(contenido[i]);
			pTempD.add(lTempD, BorderLayout.WEST);
			lTempD.setForeground(Color.BLACK);
			lTempD.setFont(new Font("Verdana", Font.BOLD, 16));
		}
		
		JPanel pInferior = new JPanel();
		pInferior.setBackground(Color.WHITE);
		pInferior.setBounds(10, 324, 367, 117);
		panel.add(pInferior);
		pInferior.setLayout(new BorderLayout(0, 0));
		
		JPanel pEditar = new JPanel();
		pEditar.setBackground(Color.WHITE);
		pInferior.add(pEditar, BorderLayout.NORTH);
		
		pEditar.add(bEditar);
		
		JPanel pContactar = new JPanel();
		pContactar.setBackground(Color.WHITE);
		pInferior.add(pContactar, BorderLayout.SOUTH);
		
		linkContactar.setFont(new Font("Verdana", Font.PLAIN, 11));
		linkContactar.setForeground(Color.BLUE);
		pContactar.add(linkContactar, BorderLayout.CENTER);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(bConectar)){
			c.conectar();
		} else if (e.getSource().equals(bRegistrar)){
			c.registrar();
		} else if (e.getSource().equals(bEditar)){
			c.editar();
		} else if (e.getSource().equals(linkContactar)){
			c.contactar();
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
