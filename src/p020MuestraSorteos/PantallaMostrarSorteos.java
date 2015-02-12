package p020MuestraSorteos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import utiles.JPanelFondo;
import utiles.AKIButton;
import utiles.PanelPantalla;
import utiles.PrevisualizacionSorteo;
import marco.ControladorMarco;

public class PantallaMostrarSorteos extends utiles.PanelPantalla implements MouseListener{
	
	protected JPanelFondo pFiltros = new JPanelFondo();
	protected JScrollPane scroll = new JScrollPane();
	protected JPanel pSorteos = new JPanel();
	
	private final int columnas = 2;
	private final int margen = 5;
	private int altoSorteo = 120;
	private int totalSorteos = 0;
	
	public PantallaMostrarSorteos(ControladorMarco controladorMarco) {
		super(controladorMarco);
		
		pFiltros.setBounds(0, 0, this.getWidth(), 43);
		add(pFiltros);
		
		scroll.setBorder(null);
		scroll.setBounds(0, pFiltros.getHeight(), PanelPantalla.anchoGrande, this.getHeight()-pFiltros.getHeight());
		add(scroll);
		scroll.getVerticalScrollBar().setUnitIncrement(10); // Acelerar scroll
		
		pSorteos.setLayout(null);
		pSorteos.setBackground(Color.WHITE);
		scroll.setViewportView(pSorteos);
		
	}
	
	public void anadirListaSorteos(PrevisualizacionSorteo[] sorteos){
		
		int filaActual = totalSorteos/columnas;
		
		int columnaActual = (totalSorteos%columnas);
		
		int filaFinal = (sorteos.length + totalSorteos)/columnas;
		
		int columnaFinal = (sorteos.length + totalSorteos)%columnas;
		
		int altoPanel = margen*(filaFinal+1)+altoSorteo*filaFinal;
		int anchoPanel = PanelPantalla.anchoPequeno;
		if (altoPanel+this.pFiltros.getHeight()<PanelPantalla.altoMax){
			altoPanel=PanelPantalla.altoMax-this.pFiltros.getHeight();
			anchoPanel = PanelPantalla.anchoGrande;
		}
		
		int ancho = (anchoPanel-(margen*(columnas+1)))/columnas;
		
		cargaDesdeHasta(filaActual, columnaActual, filaFinal, (int) columnaFinal, ancho, sorteos);
		
		pSorteos.setPreferredSize(new Dimension(anchoPanel, altoPanel));
		
		totalSorteos = totalSorteos + sorteos.length;
	}
	
	private void cargaDesdeHasta(int filaActual, int columnaActual, int filaFinal, int columnaFinal, int ancho, PrevisualizacionSorteo[] sorteos) {
		if (filaActual!=filaFinal){
			cargaFilaDesdeHasta(filaActual, columnaActual, columnas, ancho, sorteos);
			for (int f=filaActual+1; f<filaFinal-1; f++){
				cargaFilaDesdeHasta(f, 0, columnas, ancho, sorteos);
			}
			cargaFilaDesdeHasta(filaFinal, 0, columnaFinal, ancho, sorteos);
		} else {
			cargaFilaDesdeHasta(filaActual, columnaActual, columnaFinal, ancho, sorteos);
		}
	}

	private void cargaFilaDesdeHasta(int fila, int columnaOrigen, int columnaDestino, int anchoPrevisualizacion, PrevisualizacionSorteo[] sorteos) {
		for (int c=columnaOrigen; c<columnaDestino; c++){
			PrevisualizacionSorteo temp = sorteos[columnas*fila+c-totalSorteos];
			pSorteos.add(temp);
			temp.setBounds(margen*(c+1)+anchoPrevisualizacion*c, margen*(fila+1)+altoSorteo*fila, anchoPrevisualizacion, altoSorteo);
			pSorteos.add(new Membrana(temp, margen*(c+1)+anchoPrevisualizacion*c, margen*(fila+1)+altoSorteo*fila, anchoPrevisualizacion, altoSorteo, this.getMarco()));
		}
	}

	public void mostrarListaSorteos(PrevisualizacionSorteo[] sorteos){
		limpiarPanelSorteos();
		anadirListaSorteos(sorteos);
	}

	public void limpiarPanelSorteos() {
		totalSorteos = 0;
		pSorteos.removeAll();
	}
	
	public void setAltoPrevisualizacionSorteo(int alto){
		altoSorteo = alto;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() instanceof PrevisualizacionSorteo){
			PrevisualizacionSorteo s = (PrevisualizacionSorteo) e.getSource();
			System.out.println("Cargar Sorteo "+s.getIdSorteo());
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
