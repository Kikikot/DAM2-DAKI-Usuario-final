package principal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import marco.ControladorMarco;
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
		
		imgUsuario = new ImagenBailona("usuariot.png", 50, 10, 100, 100, this);
		this.add(imgUsuario);
		imgBuscar = new ImagenBailona("buscart.png", 50, 115, 100, 100, this);
		this.add(imgBuscar);
		imgSorteos = new ImagenBailona("sorteost.png", 50, 220, 100, 100, this);
		this.add(imgSorteos);
		imgTickets = new ImagenBailona("ticketst.png", 50, 325, 100, 100, this);
		this.add(imgTickets);
		
		new Thread(){
			
			public void run(){
				
				try {
					Thread.sleep(ImagenBailona.milisegundosPorMovimiento*ImagenBailona.movimientos);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				lPerfil.setVisible(true);
				lBuscar.setVisible(true);
				lMisSorteos.setVisible(true);
				lMisTickets.setVisible(true);
			}
		}.start();
		
		lPerfil = new JLabel("Mi Perfil");
		lPerfil.setForeground(new Color(0xBB00BB));
		lPerfil.setFont(new Font("Gabrielle", Font.BOLD, 36));
		lPerfil.setBounds(170, 40, 150, 41);
		add(lPerfil);
		lPerfil.setOpaque(true);
		lPerfil.setVisible(false);
		
		lBuscar = new JLabel("Buscar Sorteos");
		lBuscar.setForeground(new Color(0xBB00BB));
		lBuscar.setFont(new Font("Gabrielle", Font.BOLD, 36));
		lBuscar.setBounds(170, 145, 210, 41);
		add(lBuscar);
		lBuscar.setOpaque(true);
		lBuscar.setVisible(false);
		
		lMisSorteos = new JLabel("Mis Sorteos");
		lMisSorteos.setForeground(new Color(0xBB00BB));
		lMisSorteos.setFont(new Font("Gabrielle", Font.BOLD, 36));
		lMisSorteos.setBounds(170, 250, 177, 41);
		add(lMisSorteos);
		lMisSorteos.setOpaque(true);
		lMisSorteos.setVisible(false);
		
		lMisTickets = new JLabel("Mis Tickets");
		lMisTickets.setForeground(new Color(0xBB00BB));
		lMisTickets.setFont(new Font("Gabrielle", Font.BOLD, 36));
		lMisTickets.setBounds(170, 355, 176, 41);
		add(lMisTickets);
		lMisTickets.setOpaque(true);
		lMisTickets.setVisible(false);
		
		imgUsuario.addMouseListener(this);
		imgBuscar.addMouseListener(this);
		imgSorteos.addMouseListener(this);
		imgTickets.addMouseListener(this);
		
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
		if (e.getSource().equals(imgUsuario) || e.getSource().equals(lPerfil)){
			c.miPerfil();
		} else if (e.getSource().equals(imgBuscar) || e.getSource().equals(lBuscar)){
			c.buscarSorteos();
		} else if (e.getSource().equals(imgSorteos) || e.getSource().equals(lMisSorteos)){
			c.misSorteos();
		} else if (e.getSource().equals(imgTickets) || e.getSource().equals(lMisTickets)){
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
		if (e.getSource().equals(imgUsuario) || e.getSource().equals(lPerfil)){
			c.sobreMiPerfil();
		} else if (e.getSource().equals(imgBuscar) || e.getSource().equals(lBuscar)){
			c.sobreBuscarSorteos();
		} else if (e.getSource().equals(imgSorteos) || e.getSource().equals(lMisSorteos)){
			c.sobreMisSorteos();
		} else if (e.getSource().equals(imgTickets) || e.getSource().equals(lMisTickets)){
			c.sobreMisTickets();
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		c.relax();
	};
	
}
