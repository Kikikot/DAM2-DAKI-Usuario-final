package p01Registrar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import marco.ControladorMarco;
import utiles.AKIButton;
import utiles.AKIPanel;
import utiles.JPanelFondo;
import utiles.PanelPantalla;

public class PantallaRegistrar extends PanelPantalla implements MouseListener, ActionListener{
	
	private ControladorRegistrar c;
	
	protected JTextField tAlias = new JTextField();
	protected JPasswordField tPass = new JPasswordField();
	protected JTextField tMail = new JTextField();
	protected JTextField tConfirmacionMail = new JTextField();
	protected JComboBox cProvincia = new JComboBox();
	protected JComboBox cPoblacion = new JComboBox();
	protected JTextField tNombre = new JTextField();
	protected JTextField tApellido = new JTextField();
	protected JTextField tDireccion = new JTextField();
	protected JTextField tCP = new JTextField();
	
	protected JCheckBox check = new JCheckBox("Acepto las");
	private JLabel lblCondiciones = new JLabel("Condiciones");
	protected AKIButton bEnviarDatos = new AKIButton("Registrar", AKIButton.TipoBoton.BotonSimple);;
	
	public PantallaRegistrar(ControladorMarco marco){
		super(marco);
		c = new ControladorRegistrar(this);
		sms2 = "Nuevo usuario";
		sms1 = "Registrar";
		bSalir = "Volver";
		
		AKIPanel panel = new AKIPanel();
		panel.setBounds(0, 0, this.getWidth()+3, this.getHeight()+3);
		panel.setLayout(null);
		this.add(panel);
		
		JPanelFondo pIzquierdo = new JPanelFondo();
		pIzquierdo.setBounds(10, 11, 120, 342);
		pIzquierdo.setLayout(null);
		panel.add(pIzquierdo);
		
		JPanelFondo pDerecho = new JPanelFondo();
		pDerecho.setBounds(140, 11, 237, pIzquierdo.getHeight());
		pDerecho.setLayout(null);
		panel.add(pDerecho);
		
		String[] titulos = {"Alias", "Contraseña", "e-mail", "Confirma mail", "Provincia", "Población", "Nombre", "Apellidos", "Dirección", "C.P."};
		Component[] contenido = new Component[titulos.length];
			contenido[0] = tAlias;
			contenido[1] = tPass;
			contenido[2] = tMail;
			contenido[3] = tConfirmacionMail;
			contenido[4] = cProvincia;
			contenido[5] = cPoblacion;
			contenido[6] = tNombre;
			contenido[7] = tApellido;
			contenido[8] = tDireccion;
			contenido[9] = tCP;
			
		int altura = pIzquierdo.getHeight()/(titulos.length+3);
		
		for (int i=0; i<titulos.length; i++){
			int y = altura*i;
			if (i>3) y = y + altura;
			if (i>5) y = y + altura*2;
			JPanelFondo pTempI = new JPanelFondo();
			pTempI.setBounds(0, y, pIzquierdo.getWidth(), altura);
			pIzquierdo.add(pTempI);
			pTempI.setLayout(new BorderLayout(0, 0));
			
			JLabel lTempI = new JLabel(titulos[i]);
			pTempI.add(lTempI, BorderLayout.EAST);
			lTempI.setForeground(Color.GRAY);
			lTempI.setFont(new Font("Verdana", Font.BOLD, 14));
			
			contenido[i].setBounds(0, y, pDerecho.getWidth(), altura-1);
			pDerecho.add(contenido[i]);
			contenido[i].setForeground(Color.BLACK);
			contenido[i].setFont(new Font("Verdana", Font.BOLD, 14));
		}
		
		JPanelFondo pInferior = new JPanelFondo();
		pInferior.setBounds(10, 364, 367, 77);
		panel.add(pInferior);
		pInferior.setLayout(new BorderLayout(0, 0));
		
		JPanelFondo pEnviarDatos = new JPanelFondo();
		pInferior.add(pEnviarDatos, BorderLayout.SOUTH);
		
		
		pEnviarDatos.add(bEnviarDatos);
		
		JPanelFondo pCondiciones = new JPanelFondo();
		pInferior.add(pCondiciones, BorderLayout.NORTH);
		pCondiciones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		check.setBackground(Color.WHITE);
		check.setFont(new Font("Verdana", Font.BOLD, 14));
		check.setBorder(null);
		pCondiciones.add(check);
		
		
		pCondiciones.add(lblCondiciones);
		pCondiciones.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCondiciones.setForeground(Color.BLUE);
		
		
		bEnviarDatos.addMouseListener(this);
		lblCondiciones.addMouseListener(this);
		cProvincia.addActionListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(lblCondiciones)){
			c.verCondiciones();
		} else if (e.getSource().equals(bEnviarDatos) && this.getMarco().getUsuario().equals(null)){
			c.enviarDatos();
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(cProvincia)){
			c.provinciaCambiada();
		}
	}
	
}
