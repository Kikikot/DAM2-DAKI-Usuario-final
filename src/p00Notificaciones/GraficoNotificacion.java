package p00Notificaciones;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import marco.ControladorMarco;
import objetos.Notificacion;
import utiles.BordeRedondeado;
import utiles.JPanelFondo;

public class GraficoNotificacion extends JPanelFondo implements MouseListener{
	
	private Color lila = new Color(0xBB00BB);
	private Color blanco = Color.WHITE;
	
	int anchoN;
	int altoN;
	
	private Notificacion notificacion;
	
	private JPanelFondo pNotificacion = new JPanelFondo();
	private JPanel pAsunto = new JPanel();
	private JPanelFondo pFlecha = new JPanelFondo();
	private JPanelFondo pBasura = new JPanelFondo();
	private JLabel lAsunto = new JLabel();
	private JPanel pMensaje = new JPanel();
	private JTextPane tMensaje = new JTextPane();
	
	private ControladorMarco marco;
	
	public GraficoNotificacion(Notificacion notificacion, ControladorMarco controladorMarco, int ancho){
		super();
		this.notificacion = notificacion;
		anchoN = ancho;
		altoN = 30;
		marco = controladorMarco;
		initImagen();
	}

	private void initImagen() {
		add(pNotificacion);
		pNotificacion.setLayout(null);
		pNotificacion.setPreferredSize(new Dimension(anchoN, altoN));
		
		pAsunto.setBounds(0, 0, anchoN, 30);
		pNotificacion.add(pAsunto);
		pAsunto.setLayout(null);
		
		
		pFlecha.setBounds(15, 5, altoN-10, altoN-10);
		pAsunto.add(pFlecha);
		pFlecha.addMouseListener(this);
		
		
		pBasura.setBounds(anchoN-altoN-10+3, 3, altoN-6, altoN-6);
		pBasura.addMouseListener(this);
		pAsunto.add(pBasura);
		
		
		lAsunto.setText(notificacion.getAsunto());
		lAsunto.setFont(new Font("Gabrielle", Font.PLAIN, 23));
		lAsunto.setHorizontalAlignment(SwingConstants.CENTER);
		lAsunto.setBounds(altoN+10, 0, anchoN-altoN*2-20, altoN);
		pAsunto.add(lAsunto);
		
		
		pMensaje.setBackground(blanco);
		pMensaje.setBorder(new BordeRedondeado(lila,1,5, blanco));
		pMensaje.setBounds(10, 20, anchoN-20, 105);
		pNotificacion.add(pMensaje);
		pMensaje.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));
		
		tMensaje.setFont(new Font("Verdana", Font.PLAIN, 12));
		tMensaje.setText(notificacion.getMensaje());
		pMensaje.add(tMensaje);
		
		int altoFila = (int)tMensaje.getPreferredSize().getHeight()-4;
		int largoFila = pMensaje.getWidth()-10;
		if ((int)tMensaje.getPreferredSize().getWidth()<largoFila){
			tMensaje.setPreferredSize(new Dimension(largoFila, (int)tMensaje.getPreferredSize().getHeight()));
		}
		while ((int)tMensaje.getPreferredSize().getWidth()>largoFila){
			Dimension dim = tMensaje.getPreferredSize();
			int largo = Math.max(largoFila, (int)(dim.getWidth()-largoFila));
			tMensaje.setPreferredSize(new Dimension(largo, ((int)dim.getHeight())+altoFila));
		}
		
		cambioEstado();
	}
	
	private void cambioEstado() {
		Color colorBordeYLetras = lila;
		Color colorFondo = blanco;
		if (notificacion.getEstado()==Notificacion.ESTADO_NUEVA){
			colorBordeYLetras = blanco;
			colorFondo = lila;
		}
		pAsunto.setBackground(colorFondo);
		pAsunto.setBorder(new BordeRedondeado(lila,2,5, blanco));
		lAsunto.setForeground(colorBordeYLetras);
		tMensaje.setText(tMensaje.getText());
		
		//  -  - 
		
		if (notificacion.getEstado()==Notificacion.ESTADO_LEYENDO){
			pMensaje.setSize(new Dimension(anchoN-20, (int) (tMensaje.getPreferredSize().getHeight()+30)));
			int alto_x_M = (int) (pMensaje.getPreferredSize().getHeight() + pMensaje.getLocation().getY());
			pNotificacion.setPreferredSize(new Dimension(anchoN, alto_x_M));
			pFlecha.setImagen("trianguloLeyendot.png");
			pBasura.setImagen("basuraColor.png");
		} else {
			pMensaje.setSize(new Dimension(altoN, 0));
			pNotificacion.setPreferredSize(new Dimension(anchoN, altoN+10));
			if (notificacion.getEstado()==Notificacion.ESTADO_NUEVA) {
				pFlecha.setImagen("trianguloNuevat.png");
				pBasura.setImagen("basura.png");
			} else {
				pFlecha.setImagen("trianguloLeidat.png");
				pBasura.setImagen("basuraColor.png");
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(pFlecha)){
			marco.actualizaNotificacion(notificacion);
			cambioEstado();
		} else if (e.getSource().equals(pBasura)){
			marco.borrarNotificacion(this);
			marco.reload();
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

	public int getEstado() {
		return this.notificacion.getEstado();
	}

	public Notificacion getNotificacion() {
		return notificacion;
	}
	
}
