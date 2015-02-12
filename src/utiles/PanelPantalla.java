package utiles;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

import marco.ControladorMarco;
import marco.Marco;

public class PanelPantalla extends JPanel{
	
	protected String sms1;
	protected String sms2;
	protected String bSalir;
	
	protected static final int anchoGrande = 387;
	protected static final int anchoPequeno = 372;
	protected static final int altoMax = 452;
	private int alto = 452;
	private ControladorMarco marco;
	
	public PanelPantalla(ControladorMarco controladorMarco){
		this.marco = controladorMarco;
		super.setBackground(Color.WHITE);
		
		// Mantener ancho grande, a no ser que sepas que va a ser demasiado largo, y el layout sea "null".
		super.setBounds(0, 0, anchoGrande, alto);
		setLayout(null);
		empaquetar();
	}

	protected void empaquetar() {
		if (this.getLayout()==null){
			Component[] componentes = this.getComponents();
			int yMax = alto;
			for (int i=0; i<componentes.length; i++){
				Component provisional = componentes[i];
				int yProvisional = provisional.getY()+provisional.getHeight();
				if (yProvisional > yMax) yMax = yProvisional;
			}
			alto = yMax;
			
			if (alto>altoMax) super.setPreferredSize(new Dimension(anchoPequeno, alto));
			else super.setPreferredSize(new Dimension(anchoGrande, alto));
		}
	}
	
	public ControladorMarco getMarco(){
		return marco;
	}
	
	public String getSMS1(){
		return sms1;
	}
	public String getSMS2(){
		return sms2;
	}
	public String getbSALIR(){
		return bSalir;
	}

	public void cerrar() {
	}
}
