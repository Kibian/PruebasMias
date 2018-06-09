package src;

public class Transportista {
	private String contrasenna;
	private String usuario;
	private String nombre;
	private Vehiculo vehiculo;
	
	public Transportista(String contrasenna, String usuario, String nombre) {
		super();
		this.contrasenna = contrasenna;
		this.usuario = usuario;
		this.nombre = nombre;
	}
	public String getContrasenna() {
		return contrasenna;
	}
	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
}
