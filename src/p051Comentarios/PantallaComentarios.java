package p051Comentarios;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import utiles.AKIButton;
import utiles.AKIPanel;
import utiles.JPanelFondo;
import marco.ControladorMarco;

public class PantallaComentarios extends utiles.PanelPantalla implements MouseListener, KeyListener{

	private ControladorComentarios c;
	protected String idSorteo; 
	protected AKIButton bComentar = new AKIButton("Comentar", AKIButton.TipoBoton.BotonSimple);
	protected JTextPane tComentario = new JTextPane();
	protected JLabel lCaracteres;
	protected PanelComentarios pComentarios;
	protected int maxLength = 500;

	public PantallaComentarios(ControladorMarco controladorMarco, String idSorteo) {
		super(controladorMarco);
		
		sms1 = this.getMarco().getUsuario();
		sms2 = "Comentarios";
		bSalir = "Volver";
		
		this.idSorteo = idSorteo;
		
		AKIPanel panel = new AKIPanel();
		panel.setBounds(0, 325, 387, 127);
		add(panel);
		panel.setLayout(null);
		
		JPanelFondo pComentar = new JPanelFondo();
		pComentar.setBounds(280, 92, 106, 37);
		panel.add(pComentar);
		pComentar.add(bComentar);
		bComentar.addMouseListener(this);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(null);
		scrollPane_1.setBounds(5, 5, 377, 90);
		panel.add(scrollPane_1);
		
		
		tComentario.setFont(new Font("Verdana", Font.PLAIN, 15));
		tComentario.addKeyListener(this);
		scrollPane_1.setViewportView(tComentario);
		
		lCaracteres = new JLabel("(0 / "+maxLength+")");
		lCaracteres.setFont(new Font("Verdana", Font.PLAIN, 9));
		lCaracteres.setBounds(15, 105, 182, 14);
		panel.add(lCaracteres);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(10, 35, 377, 288);
		add(scrollPane);
		
		pComentarios = new PanelComentarios(idSorteo, (int)scrollPane.getSize().getWidth()-35, (int)scrollPane.getSize().getHeight(), this.getMarco());
		pComentarios.setBackground(Color.WHITE);
		scrollPane.setViewportView(pComentarios);
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		pComentarios.setLayout(null);
		
		JLabel lblIdSorteo = new JLabel("ID Sorteo:");
		lblIdSorteo.setBackground(Color.WHITE);
		lblIdSorteo.setFont(new Font("Verdana", Font.BOLD, 15));
		lblIdSorteo.setBounds(10, 6, 87, 24);
		add(lblIdSorteo);
		
		JLabel label = new JLabel(this.idSorteo);
		label.setBackground(Color.WHITE);
		label.setFont(new Font("Verdana", Font.PLAIN, 15));
		label.setBounds(115, 6, this.getWidth()-115, 24);
		add(label);
		
		c = new ControladorComentarios(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(bComentar)){
			c.comentar();
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
		if (e.getSource().equals(tComentario)){
			c.escribiendo();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getSource().equals(tComentario)){
			c.escribiendo();
		}
	}
	
	public void cerrar(){
		pComentarios.finalizar();
	}

}
