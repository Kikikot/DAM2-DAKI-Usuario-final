package marco;

import java.util.ArrayList;

import objetos.Comentario;
import objetos.Notificacion;
import objetos.Patrocinador;
import objetos.Presorteo;
import ddbb.GestorDDBB;
import p00Notificaciones.GraficoNotificacion;
import p00Notificaciones.PantallaNotificaciones;
import p06MostrarTickets.TicketGroup;
import principal.PantallaPrincipal;
import utiles.PanelPantalla;
import utiles.PrevisualizacionSorteo;

public class ControladorMarco {
	
	private Marco vista;
	private ArrayList<PanelPantalla> pantallas;
	private GestorDDBB db;
	
	private PantallaNotificaciones pNotificaciones;
	
	private String usuario = null;
	
	public ControladorMarco(Marco marco){
		vista = marco;
		pantallas = new ArrayList<PanelPantalla>();
		db = new GestorDDBB();
		pNotificaciones = new PantallaNotificaciones(this);
		this.putNotificaciones(0);
		cargarInicio();
	}
	
	private void cargarInicio() {
		PanelPantalla inicio = new PantallaPrincipal(this);
		anadirPantalla(inicio);
	}

	public void anadirPantalla(PanelPantalla pantalla) {
		pantallas.add(pantalla);
		cargar();
	}

	public void salir(){
		if (pantallas.size() <= 1){
			db.desconectar();
			pNotificaciones.finalizar();
			System.exit(0);
		} else {
			//Pantalla p = pantallas.get(pantallas.size()-1);
			//p.liberar();
			pantallas.get(pantallas.size()-1).cerrar();
			pantallas.remove(pantallas.size()-1);
			cargar();
		}
	}

	private void cargar() {
		PanelPantalla carga = pantallas.get(pantallas.size()-1);
		vista.setSMS1(carga.getSMS1());
		vista.setSMS2(carga.getSMS2());
		vista.setCentro(carga);
		vista.setbSalir(carga.getbSALIR());
	}

	public boolean isConectado() {
		return usuario!=null;
	}

	public String getUsuario() {
		return usuario;
	}

	public boolean conecta(String user, String pass) {
		boolean conectado = db.conecta(user, pass);
		if (conectado){
			usuario = user;
		}
		return conectado;
	}

	public void reload() {
		cargar();
	}
	
	public void notificaciones() {
		this.anadirPantalla(pNotificaciones);
	}
	
	public void putNotificaciones(int x){
		vista.lContador.setText(x+"");
		if (x==0) vista.pContador.setVisible(false);
		else vista.pContador.setVisible(true);
	}
	
	public void actualizaNotificacion(Notificacion notificacion) {
		if (notificacion.getEstado()==Notificacion.ESTADO_NUEVA){
			notificacion.setEstado(Notificacion.ESTADO_LEYENDO);
			disminuyeContador();
		} else if (notificacion.getEstado()==Notificacion.ESTADO_LEYENDO){
			notificacion.setEstado(Notificacion.ESTADO_LEIDA);
		} else{
			notificacion.setEstado(Notificacion.ESTADO_LEYENDO);
		}
		db.actualizaNotificacion(notificacion);
	}

	private void disminuyeContador() {
		int x = Integer.parseInt(vista.lContador.getText());
		putNotificaciones(x-1);
	}
	
	public void borrarNotificacion(GraficoNotificacion graficoNotificacion) {
		if (db.borrarNotificacion(graficoNotificacion.getNotificacion()))
			pNotificaciones.borrar(graficoNotificacion);
	}

	public String[] getDatosCortosUsuario() {
		return db.getDatosCortosUsuario(usuario);
	}

	public String[] getProvincias() {
		return db.getProvincias();
	}

	public String[] getLocalidades(String provincia) {
		return db.getLocalidades(provincia);
	}

	public boolean existeUsuario(String user) {
		return db.existeUsuario(user);
	}

	public boolean existeMail(String mail) {
		return db.existeMail(mail);
	}

	public void registrarUsuario(String alias, String pass, String mail, String poblacion,
			String nombre, String apellidos, String direccion, String cp) {
		db.registrarUsuario(alias, pass, mail, poblacion, nombre, apellidos, direccion, cp);
	}

	public void enviarMensaje(String asunto, String mensaje, String correo) {
		if (usuario==null){
			db.enviarMensajeAnonimo(asunto, mensaje, correo);
		} else {
			db.enviarMensaje(usuario, asunto, mensaje, correo);
		}
	}

	public String[] getDatosLargoUsuario() {
		return db.getDatosLargoUsuario(usuario);
	}

	public String getProvinciaDePoblacion(int idPoblacion) {
		return db.getProvinciaDePoblacion(idPoblacion);
	}

	public void actualizarUsuario(String pass, String mail, String poblacion,
			String nombre, String apellidos, String direccion, String cp) {
		db.actualizarUsuario(usuario, pass, mail, poblacion, nombre, apellidos, direccion, cp);
	}

	public PrevisualizacionSorteo[] getSorteosPorKm() {
		return db.getSorteosPorKm(usuario);
	}

	public PrevisualizacionSorteo[] getSorteosPorValor() {
		return db.getSorteosPorValor(usuario);
	}

	public PrevisualizacionSorteo[] getSorteosPorRecientes() {
		return db.getSorteosPorRecientes(usuario);
	}

	public PrevisualizacionSorteo[] getSorteosPorComercio(String tipo) {
		return db.getSorteosPorComercio(usuario, tipo);
	}

	public PrevisualizacionSorteo[] getSorteosParticipando() {
		return db.getSorteosParticipando(usuario);
	}

	public PrevisualizacionSorteo[] getSorteosSiguiendo() {
		return db.getSorteosSiguiendo(usuario);
	}

	public String[] getRestoDatosDelSorteo(String idSorteo) {
		return db.getRestoDatosDelSorteo(idSorteo, usuario);
	}

	public synchronized ArrayList<Comentario> actualizarComentarios(Object bulto, String idSorteo) {
		ArrayList<Comentario> lista = null;
		if (bulto instanceof Comentario){
			boolean ok = db.insertarComentario((Comentario) bulto);
			if (!ok) lista = new ArrayList<Comentario>();
		} else if (bulto instanceof ArrayList){
			ArrayList<String> ids = (ArrayList<String>) bulto;
			lista = db.buscarNuevosComentarios(ids, idSorteo);
		}
		return lista;
	}

	public ArrayList<Patrocinador> getPatrocinadores(String idSorteo) {
		return db.getPatrocinadores(idSorteo, usuario);
	}

	public boolean empezarASeguirSorteo(String idSorteo) {
		return db.empezarASeguirSorteo(idSorteo, usuario);
	}

	public boolean dejarDeSeguirSorteo(String idSorteo) {
		return db.dejarDeSeguirSorteo(idSorteo, usuario);
	}

	public String[] getNombrePatrocinadores(String idSorteo) {
		return db.getNombrePatrocinadores(idSorteo);
	}

	public boolean registrarTicket(String idSorteo, String ticket, String fecha,
								   float importe, String patrocinador) {
		return db.registrarTicket(idSorteo, ticket, fecha, importe, patrocinador, usuario);
	}

	public Presorteo getDatosCortosSorteo(String id) {
		return db.getDatosCortosSorteo(id, usuario);
	}

	public ArrayList<TicketGroup> getTicketsDeSorteo(String id) {
		ArrayList<TicketGroup> grupos = new ArrayList<TicketGroup>();
		grupos.add(db.getTicketsDeSorteo(id, usuario));
		return grupos;
	}

	public ArrayList<TicketGroup> getTicketsUsuario() {
		return db.getTicketsUsuario(usuario);
	}

	public ArrayList<Notificacion> buscaNuevasNotificaciones(ArrayList<String> idsNotificaciones) {
		if (usuario==null) return new ArrayList<Notificacion>();
		else return db.buscaNuevasNotificaciones(idsNotificaciones, usuario);
	}

	public String[] getTiposComercio() {
		return db.getTiposComercio();
	}
}
