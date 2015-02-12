package p051Comentarios;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

import marco.ControladorMarco;
import objetos.Comentario;

public class PanelComentarios extends JPanel implements Runnable{
	
	private ArrayList<Comentario> comentarios;
	private String idSorteo;
	private boolean trabajando = true;
	private int anchoComentarios;
	private int altoPanel;
	private ControladorMarco marco;
	
	
	public PanelComentarios(String idSorteo, int anchoComentarios, int altoPanel, ControladorMarco controladorMarco){
		super();
		this.idSorteo = idSorteo;
		this.setBackground(Color.WHITE);
		comentarios = new ArrayList<Comentario>();
		this.anchoComentarios = anchoComentarios;
		this.altoPanel = altoPanel;
		marco = controladorMarco;
		new Thread(this).start();
	}

	@Override
	public void run() {
		while (trabajando) {
			actualizarComentarios();
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private synchronized void actualizarComentarios() {
		ArrayList<String> idComentarios = new ArrayList<String>();
		
		for (int i=0; i<this.comentarios.size(); i++) idComentarios.add(this.comentarios.get(i).getId());
		
		ArrayList<Comentario> comentarios = marco.actualizarComentarios(idComentarios, idSorteo);
		
		if(comentarios!=null){
			for (int i=0; i<comentarios.size(); i++){
				anadirComentario(comentarios.get(i));
			}
		}
	}
	
	public void enviarComentario(Comentario comentario){
		if (marco.actualizarComentarios(comentario, null)==null){
			System.out.println("enviando comentario");
			anadirComentario(comentario);
			actualizarComentarios();
		} else {
			System.out.println("comentario no enviado");
		}
		
	}

	private synchronized void anadirComentario(Comentario comentario) {
		JPanel panelComentario = comentario.getPanelComentario(anchoComentarios);
		hacerHuecoComentario(panelComentario.getHeight());
		panelComentario.setLocation(0, 0);
		this.add(panelComentario);
		comentarios.add(comentario);
		ajustarTamanoPanel();
	}

	private void ajustarTamanoPanel() {
		int x = 0, l = 0;
		Component[] paneles = this.getComponents();
		for (int i=0; i<paneles.length; i++){
			if (x<paneles[i].getLocation().getY()){
				x = (int) paneles[i].getLocation().getY();
				l = (int) paneles[i].getSize().getHeight();
			}
		}
		this.setPreferredSize(new Dimension(anchoComentarios, Math.max(x+l+5, altoPanel)));
		marco.reload();
	}

	private synchronized void hacerHuecoComentario(int desplazamientoY) {
		Component[] paneles = this.getComponents();
		for(int i=0; i<paneles.length; i++){
			paneles[i].setLocation((int)paneles[i].getLocation().getX(), 
								   (int)paneles[i].getLocation().getY()+desplazamientoY);
		}
	}

	public void finalizar(){
		trabajando = false;
	}
}
