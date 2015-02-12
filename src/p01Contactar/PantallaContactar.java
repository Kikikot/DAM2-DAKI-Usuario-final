package p01Contactar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import utiles.AKIButton;
import utiles.AKIPanel;
import utiles.JPanelFondo;
import marco.ControladorMarco;

public class PantallaContactar extends utiles.PanelPantalla implements MouseListener, KeyListener {
	
	protected AKIButton bEnviar = new AKIButton("Enviar Mensaje", AKIButton.TipoBoton.BotonSimple);
	protected JTextField tAsunto;
	protected JLabel lCaracteres;
	protected JEditorPane tTexto;
	protected JTextField tCorreo;
	
	protected int maxLength = 500;
	
	private ControladorContactar c;
	
	public PantallaContactar(ControladorMarco marco){
		super(marco);
		
		this.bSalir = "Volver";
		this.sms1 = this.getMarco().getUsuario();
		if (this.sms1==null) this.sms1 = "Sin identificar";
		this.sms2 = "Contacta con nosotros";
		
		AKIPanel pSuperior = new AKIPanel();
		pSuperior.setBounds(10, 11, 367, 343);
		add(pSuperior);
		pSuperior.setLayout(new BorderLayout(0, 0));
		
		JPanelFondo pSur = new JPanelFondo();
		pSuperior.add(pSur, BorderLayout.SOUTH);
		bEnviar.addMouseListener(this);
		pSur.add(bEnviar);
		
		JPanelFondo pNorte = new JPanelFondo();
		pSuperior.add(pNorte, BorderLayout.NORTH);
		
		JLabel lAsunto = new JLabel("Asunto:");
		lAsunto.setFont(new Font("Verdana", Font.BOLD, 12));
		lAsunto.setBackground(Color.WHITE);
		lAsunto.setHorizontalAlignment(SwingConstants.LEFT);
		pNorte.add(lAsunto);
		
		tAsunto = new JTextField();
		tAsunto.setFont(new Font("Verdana", Font.PLAIN, 12));
		pNorte.add(tAsunto);
		tAsunto.setColumns(25);
		
		JPanelFondo pCentro = new JPanelFondo();
		pSuperior.add(pCentro, BorderLayout.CENTER);
		pCentro.setLayout(new BorderLayout(0, 0));
		
		JPanelFondo pCentroSup = new JPanelFondo();
		pCentroSup.setLayout(new BorderLayout(0, 0));
		pCentro.add(pCentroSup, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Mensaje:");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		pCentroSup.add(lblNewLabel, BorderLayout.WEST);
		
		lCaracteres = new JLabel("(0 / "+maxLength+")");
		lCaracteres.setFont(new Font("Verdana", Font.BOLD, 12));
		lCaracteres.setBackground(Color.WHITE);
		lCaracteres.setHorizontalAlignment(SwingConstants.LEFT);
		pCentroSup.add(lCaracteres, BorderLayout.EAST);
		
		JPanelFondo pC_Sur = new JPanelFondo();
		pCentro.add(pC_Sur, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_1 = new JLabel("Facilita un e-mail:");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_1.setBackground(Color.WHITE);
		pC_Sur.add(lblNewLabel_1);
		
		tCorreo = new JTextField();
		tCorreo.setFont(new Font("Verdana", Font.PLAIN, 12));
		pC_Sur.add(tCorreo);
		tCorreo.setColumns(20);
		
		AKIPanel pC_Centro = new AKIPanel();
		pC_Centro.setLayout(null);
		pCentro.add(pC_Centro, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 320, 200);
		scrollPane.setBorder(null);
		pC_Centro.add(scrollPane);
		
		tTexto = new JEditorPane();
		tTexto.setFont(new Font("Verdana", Font.PLAIN, 12));
		tTexto.addKeyListener(this);
		scrollPane.setViewportView(tTexto);
		
		JPanelFondo pC_Este = new JPanelFondo();
		pCentro.add(pC_Este, BorderLayout.EAST);
		
		JPanelFondo pC_Oeste = new JPanelFondo();
		pCentro.add(pC_Oeste, BorderLayout.WEST);
		
		AKIPanel pInferior = new AKIPanel();
		pInferior.setBounds(10, 365, 367, 76);
		add(pInferior);
		pInferior.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Otras formas de contactar con nosotros");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 11, 347, 14);
		pInferior.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("(solo si falla la aplicaci\u00F3n)");
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 31, 347, 14);
		pInferior.add(lblNewLabel_3);
		
		JLabel lblEnvianosUnCorreo = new JLabel("Envianos un correo electr\u00F3nico a:");
		lblEnvianosUnCorreo.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblEnvianosUnCorreo.setBackground(Color.WHITE);
		lblEnvianosUnCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnvianosUnCorreo.setBounds(10, 52, 192, 14);
		pInferior.add(lblEnvianosUnCorreo);
		
		JLabel lblNewLabel_4 = new JLabel("dakidam@hotmail.com");
		lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setBounds(212, 52, 145, 14);
		pInferior.add(lblNewLabel_4);
		
		c = new ControladorContactar(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(bEnviar)){
			c.enviar();
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
	public void keyTyped(KeyEvent e) {
		if (e.getSource().equals(tTexto)){
			c.escribiendo();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getSource().equals(tTexto)){
			c.escribiendo();
		}
	}
	
}
