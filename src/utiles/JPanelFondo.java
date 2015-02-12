package utiles;

import java.awt.Graphics;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
 
public class JPanelFondo extends JPanel {
	
    private Image imagen;
    private boolean fondoTapado;
    
    public JPanelFondo() {
    	fondoTapado = false;
    }
 
    public JPanelFondo(String nombreImagen) {
        if (nombreImagen != null) {
            imagen = new ImageIcon(JPanelFondo.class.getResource("/imagenes/"+nombreImagen)).getImage();
            fondoTapado = false;
        } else {
        	fondoTapado = true;
        }
    }
 
    public JPanelFondo(Image imagenInicial) {
        if (imagenInicial != null) {
            imagen = imagenInicial;
            fondoTapado = false;
        } else {
        	fondoTapado = true;
        }
    }
 
    public JPanelFondo(URL url) {
    	imagen = new ImageIcon(url).getImage();
    	fondoTapado = false;
	}

	public void setImagen(String nombreImagen) {
        if (nombreImagen != null) {
            imagen = new ImageIcon(JPanelFondo.class.getResource("/imagenes/"+nombreImagen)).getImage();
            fondoTapado = false;
        } else {
        	fondoTapado = true;
            imagen = null;
        }
 
        repaint();
    }
 
    public void setImagen(Image nuevaImagen) {
        imagen = nuevaImagen;
        fondoTapado = false;
        repaint();
    }
    
    public void setImagen(URL url) {
    	imagen = new ImageIcon(url).getImage();
        fondoTapado = false;
        repaint();
	}
 
    public void paint(Graphics g) {
    	setOpaque(fondoTapado);
    	if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    	super.paint(g);
    }
    
    public Image getImagen(){
    	return imagen;
    }
}