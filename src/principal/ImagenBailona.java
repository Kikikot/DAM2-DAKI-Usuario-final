package principal;

import java.awt.Graphics;

import javax.swing.JPanel;

public class ImagenBailona extends utiles.JPanelFondo implements Runnable {
	
	private int x, y, ancho, alto;
	private boolean bailando;
	private JPanel pista;
	public static final int milisegundosPorMovimiento = 1000;
	public static final int movimientos = 4;
	
	public ImagenBailona(String rutaImagen, int posX, int posY, int anchoEnPantalla, int altoEnPantalla, JPanel contenedor){
		super(rutaImagen);
		x = posX;
		y = posY;
		ancho = anchoEnPantalla;
		alto = altoEnPantalla;
		pista = contenedor;
		bailando = true;
		setBounds(x, y, ancho, alto);
		
		new Thread(this).start();
	}
	
	@Override
	public void run() {
		colocarRandom();
		bailar();
		dirigirAlSitio();
	}

	private void dirigirAlSitio() {
		moverHasta(x, y);
	}

	private void bailar() {
		for (int i=1; i<movimientos; i++){
			int a = (int)(Math.random()*(pista.getWidth()-this.getWidth()));
			int b = (int)(Math.random()*(pista.getHeight()-this.getHeight()));
			moverHasta(a,b);
		}
	}

	private void moverHasta(int a, int b) {
		int preX = super.getX();
		int preY = super.getY();
		
		int min = Math.min(Math.abs(a-preX), Math.abs(b-preY));
		if (min==0) min = Math.max(Math.abs(a-preX), Math.abs(b-preY));
		
		int espera = milisegundosPorMovimiento/min;
		int iteraciones = milisegundosPorMovimiento/espera;
		
		double difX = ((double)(a-preX))/iteraciones;
		double difY = ((double)(b-preY))/iteraciones;
		
		for (int i=0; i<iteraciones; i++){
			try {
				Thread.sleep(espera);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			setBounds((int) (preX+(difX*i)), (int) (preY+(difY*i)), ancho, alto);
		}
		
		setBounds(a, b, ancho, alto);
	}

	private void colocarRandom() {
		int a = (int)(Math.random()*(pista.getWidth()-this.getWidth()));
		int b = (int)(Math.random()*(pista.getHeight()-this.getHeight()));
		setBounds(a, b, alto, ancho);
	}
}
