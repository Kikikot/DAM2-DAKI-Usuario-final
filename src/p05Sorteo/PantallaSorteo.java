package p05Sorteo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.AbstractBorder;

import objetos.Presorteo;
import utiles.AKIButton;
import utiles.AKIPanel;
import utiles.BordeRedondeado;
import utiles.JPanelFondo;
import utiles.PrevisualizacionSorteo;
import marco.ControladorMarco;

public class PantallaSorteo extends utiles.PanelPantalla implements MouseListener {
	
	protected String idSorteo;
	protected String totalTickets;
	
	protected JTextPane tDescripcion = new JTextPane();
	protected JTextPane tCondiciones = new JTextPane();
	protected JLabel lTitulo;
	protected JLabel lKm;
	protected JLabel lTickets;
	protected JLabel lValor;
	protected JLabel lTiempo;
	protected JLabel lComentarios;
	
	private JPanelFondo bF;
	private JPanelFondo bT;
	private JPanelFondo bP;
	
	private AKIButton bPatrocinadores = new AKIButton("Patrocinadores", AKIButton.TipoBoton.BotonSimple);
	protected AKIButton bSeguir = new AKIButton("Seguir sorteo", AKIButton.TipoBoton.BotonDoblePosicion);
	private AKIButton bTickets = new AKIButton("Mis tickets registrados", AKIButton.TipoBoton.BotonSimple);
	private AKIButton bAddTicket = new AKIButton("Registrar ticket", AKIButton.TipoBoton.BotonSimple);

	private ControladorSorteo c;
	
	public static PantallaSorteo buidPantallaSorteo(ControladorMarco controladorMarco, String id){
		Presorteo s = controladorMarco.getDatosCortosSorteo(id);
		Image img = null;
		try {
			img = new ImageIcon(new URL(s.getUrlImagen())).getImage();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return new PantallaSorteo(controladorMarco, id, img, s.getDistancia(), s.getValor(), s.getTotalTickets());
	}
	
	public PantallaSorteo(ControladorMarco controladorMarco, String id, Image img, String distancia, String valor, String tickets) {
		super(controladorMarco);
		
		idSorteo = id;
		
		sms1 = this.getMarco().getUsuario();
		sms2 = "Sorteo: "+idSorteo;
		bSalir = "Volver";
		
		lTitulo = new JLabel("Cargando Título");
		lKm = new JLabel(distancia+" Km");
		lTickets = new JLabel(" de "+tickets+" tickets");
		lValor = new JLabel(valor+" €");
		lTiempo = new JLabel("Cronometrando Tiempo");
		lComentarios = new JLabel("Contando Comentarios");
		
		setLayout(null);
		
		AbstractBorder borde = new BordeRedondeado(new Color(0xBB00BB),1,5, new Color(0xffffff));
		
		JPanelFondo pSorteo = new JPanelFondo(img);
		pSorteo.setBounds(10, 11, 367, 218);
		pSorteo.setLayout(null);
		pSorteo.setBorder(borde);
		add(pSorteo);
		
		
		lTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		lTitulo.setBounds(10, 11, 203, 14);
		adecuar(lTitulo);
		pSorteo.add(lTitulo);
		
		
		lValor.setHorizontalAlignment(SwingConstants.RIGHT);
		lValor.setBounds(223, 11, 134, 14);
		adecuar(lValor);
		pSorteo.add(lValor);
		
		
		lTickets.setHorizontalAlignment(SwingConstants.LEFT);
		lTickets.setBounds(10, 36, 203, 14);
		adecuar(lTickets);
		pSorteo.add(lTickets);
		
		
		lKm.setHorizontalAlignment(SwingConstants.RIGHT);
		lKm.setBounds(223, 36, 134, 14);
		adecuar(lKm);
		pSorteo.add(lKm);
		
		
		lTiempo.setHorizontalAlignment(SwingConstants.LEFT);
		lTiempo.setBounds(10, 193, 203, 14);
		adecuar(lTiempo);
		pSorteo.add(lTiempo);
		
		
		lComentarios.setHorizontalAlignment(SwingConstants.RIGHT);
		lComentarios.setBounds(223, 193, 134, 14);
		lComentarios.setBackground(Color.WHITE);
		lComentarios.setForeground(Color.BLUE);
		lComentarios.setFont(new Font("Verdana", Font.BOLD, 12));
		pSorteo.add(lComentarios);
		
		JPanelFondo pSocial = new JPanelFondo();
		pSocial.setBounds(10, 65, 30, 108);
		pSorteo.add(pSocial);
		pSocial.setLayout(null);
		
		bF = new JPanelFondo("f.PNG");
		bF.setBounds(0, 0, 30, 30);
		pSocial.add(bF);
		
		bT = new JPanelFondo("t.PNG");
		bT.setBounds(0, 39, 30, 30);
		pSocial.add(bT);
		
		bP = new JPanelFondo("p.PNG");
		bP.setBounds(0, 78, 30, 30);
		pSocial.add(bP);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(10, 240, 181, 121);
		scrollPane.setBorder(borde);
		add(scrollPane);
		
		
		tDescripcion.setEditable(false);
		tDescripcion.setFont(new Font("Verdana", Font.PLAIN, 12));
		scrollPane.setViewportView(tDescripcion);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBackground(Color.WHITE);
		scrollPane_1.setBounds(196, 240, 181, 121);
		scrollPane_1.setBorder(borde);
		add(scrollPane_1);
		
		
		tCondiciones.setEditable(false);
		tCondiciones.setFont(new Font("Verdana", Font.PLAIN, 12));
		scrollPane_1.setViewportView(tCondiciones);
		
		JPanelFondo pPatrocinadores = new JPanelFondo();
		pPatrocinadores.setBounds(20, 366, 162, 39);
		add(pPatrocinadores);
		pPatrocinadores.add(bPatrocinadores);
		
		JPanelFondo pTickets = new JPanelFondo();
		pTickets.setBounds(182, 366, 205, 39);
		add(pTickets);
		pTickets.add(bTickets);
		
		JPanelFondo pSeguir = new JPanelFondo();
		pSeguir.setBounds(10, 409, 181, 43);
		add(pSeguir);
		pSeguir.add(bSeguir);
		
		JPanelFondo pAddTicket = new JPanelFondo();
		pAddTicket.setBounds(196, 409, 181, 43);
		add(pAddTicket);
		pAddTicket.add(bAddTicket);
		
		c = new ControladorSorteo(this);
		
		lComentarios.addMouseListener(this);
		bPatrocinadores.addMouseListener(this);
		bSeguir.addMouseListener(this);
		bTickets.addMouseListener(this);
		bAddTicket.addMouseListener(this);
		
	}

	private void adecuar(JLabel l) {
		l.setBackground(Color.WHITE);
		l.setForeground(new Color(0xBB00BB));
		l.setFont(new Font("Verdana", Font.BOLD, 12));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(lComentarios)){
			c.comentarios();
		} else if (e.getSource().equals(bPatrocinadores)){
			c.patrocinadores();
		} else if (e.getSource().equals(bSeguir)){
			c.seguir();
		} else if (e.getSource().equals(bTickets)){
			c.tickets();
		} else if (e.getSource().equals(bAddTicket)){
			c.addTickets();
		} else if (e.getSource().equals(bF)){
			c.facebook();
		} else if (e.getSource().equals(bT)){
			c.twitter();
		} else if (e.getSource().equals(bP)){
			c.pinterest();
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
