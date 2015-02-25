package principal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import marco.ControladorMarco;
import utiles.AKIPanel;
import utiles.PanelPantalla;

public class PantallaPrincipal extends PanelPantalla implements MouseListener{
	
	private ControladorPrincipal c;
	
	private ImagenBailona imgUsuario;
	private ImagenBailona imgBuscar;
	private ImagenBailona imgSorteos;
	private ImagenBailona imgTickets;
	protected JLabel lPerfil;
	protected JLabel lBuscar;
	protected JLabel lMisSorteos;
	protected JLabel lMisTickets;
	protected AKIPanel pUsuario;
	protected AKIPanel pBuscar;
	protected AKIPanel pSorteos;
	protected AKIPanel pTickets;
	private PantallaPrincipal me;
	
	public PantallaPrincipal(ControladorMarco controladorMarco) {
		super(controladorMarco);
		
		bSalir = "Salir";
		if(this.getMarco().isConectado()){
			sms1 = this.getMarco().getUsuario();
			sms2 = "Principal";
		}else{
			sms1 = "Regalos";
			sms2 = "por la cara";
		}
		
		imgUsuario = new ImagenBailona("usuariot.png", 45, 30, 90, 90, this);
		this.add(imgUsuario);
		pUsuario = new AKIPanel();
		pUsuario.setBounds(10, 25, this.getWidth()-15, 100);
		pUsuario.setVisible(false);
		pUsuario.setLayout(null);
		this.add(pUsuario);
		
		imgBuscar = new ImagenBailona("buscart.png", 45, 135, 90, 90, this);
		this.add(imgBuscar);
		pBuscar = new AKIPanel();
		pBuscar.setBounds(10, 130, this.getWidth()-15, 100);
		pBuscar.setVisible(false);
		pBuscar.setLayout(null);
		this.add(pBuscar);
		
		imgSorteos = new ImagenBailona("sorteost.png", 45, 240, 90, 90, this);
		this.add(imgSorteos);
		pSorteos = new AKIPanel();
		pSorteos.setBounds(10, 235, this.getWidth()-15, 100);
		pSorteos.setVisible(false);
		pSorteos.setLayout(null);
		this.add(pSorteos);
		
		imgTickets = new ImagenBailona("ticketst.png", 45, 345, 80, 80, this);
		this.add(imgTickets);
		pTickets = new AKIPanel();
		pTickets.setBounds(10, 340, this.getWidth()-15, 100);
		pTickets.setVisible(false);
		pTickets.setLayout(null);
		this.add(pTickets);
		
		me = this;
		new Thread(){
			
			public void run(){
				
				try {
					Thread.sleep(ImagenBailona.milisegundosPorMovimiento*ImagenBailona.movimientos);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				me.remove(imgUsuario);
				me.remove(imgBuscar);
				me.remove(imgSorteos);
				me.remove(imgTickets);
				imgUsuario.setBounds(35, 5, 90, 90);
				imgBuscar.setBounds(35, 5, 90, 90);
				imgSorteos.setBounds(35, 5, 90, 90);
				imgTickets.setBounds(35, 5, 90, 90);
				pUsuario.add(imgUsuario);
				pBuscar.add(imgBuscar);
				pSorteos.add(imgSorteos);
				pTickets.add(imgTickets);
				pUsuario.setVisible(true);
				pBuscar.setVisible(true);
				pSorteos.setVisible(true);
				pTickets.setVisible(true);
				me.getMarco().reload();
			}
		}.start();
		
		lPerfil = new JLabel("Mi Perfil");
		lPerfil.setForeground(new Color(0xBB00BB));
		lPerfil.setFont(new Font("Gabrielle", Font.BOLD, 36));
		lPerfil.setBounds(140, 30, 150, 41);
		pUsuario.add(lPerfil);
		lPerfil.setOpaque(false);
		
		lBuscar = new JLabel("Buscar Sorteos");
		lBuscar.setForeground(new Color(0xBB00BB));
		lBuscar.setFont(new Font("Gabrielle", Font.BOLD, 36));
		lBuscar.setBounds(140, 30, 210, 41);
		pBuscar.add(lBuscar);
		lBuscar.setOpaque(false);
		
		lMisSorteos = new JLabel("Mis Sorteos");
		lMisSorteos.setForeground(new Color(0xBB00BB));
		lMisSorteos.setFont(new Font("Gabrielle", Font.BOLD, 36));
		lMisSorteos.setBounds(140, 30, 177, 41);
		pSorteos.add(lMisSorteos);
		lMisSorteos.setOpaque(false);
		
		lMisTickets = new JLabel("Mis Tickets");
		lMisTickets.setForeground(new Color(0xBB00BB));
		lMisTickets.setFont(new Font("Gabrielle", Font.BOLD, 36));
		lMisTickets.setBounds(140, 30, 176, 41);
		pTickets.add(lMisTickets);
		lMisTickets.setOpaque(false);
		
		imgUsuario.addMouseListener(this);
		imgBuscar.addMouseListener(this);
		imgSorteos.addMouseListener(this);
		imgTickets.addMouseListener(this);
		
		pUsuario.addMouseListener(this);
		pBuscar.addMouseListener(this);
		pSorteos.addMouseListener(this);
		pTickets.addMouseListener(this);
		
		lPerfil.addMouseListener(this);
		lBuscar.addMouseListener(this);
		lMisSorteos.addMouseListener(this);
		lMisTickets.addMouseListener(this);
		
		c = new ControladorPrincipal(this);
		
	}
	
	protected void empaquetar(){
		this.setPreferredSize(new Dimension(PanelPantalla.anchoGrande, PanelPantalla.altoMax));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(imgUsuario) || e.getSource().equals(pUsuario) || e.getSource().equals(lPerfil)){
			c.miPerfil();
		} else if (e.getSource().equals(imgBuscar) || e.getSource().equals(pBuscar) || e.getSource().equals(lBuscar)){
			c.buscarSorteos();
		} else if (e.getSource().equals(imgSorteos) || e.getSource().equals(pSorteos) || e.getSource().equals(lMisSorteos)){
			c.misSorteos();
		} else if (e.getSource().equals(imgTickets) || e.getSource().equals(pTickets) || e.getSource().equals(lMisTickets)){
			c.misTickets();
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
		if (e.getSource().equals(imgUsuario) || e.getSource().equals(pUsuario) || e.getSource().equals(lPerfil)){
			c.sobreMiPerfil();
		} else if (e.getSource().equals(imgBuscar) || e.getSource().equals(pBuscar) || e.getSource().equals(lBuscar)){
			c.sobreBuscarSorteos();
		} else if (e.getSource().equals(imgSorteos) || e.getSource().equals(pSorteos) || e.getSource().equals(lMisSorteos)){
			c.sobreMisSorteos();
		} else if (e.getSource().equals(imgTickets) || e.getSource().equals(pTickets) || e.getSource().equals(lMisTickets)){
			c.sobreMisTickets();
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		c.relax();
	};
	
}
