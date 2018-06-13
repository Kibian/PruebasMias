package src;

public class Transportista {
	private String contrasenna;
	private String DNI;
	private String nombre;
	private Vehiculo vehiculo;
	private boolean disponible;
	
	public Transportista(String contrasenna, String DNI, String nombre, boolean disponible) {
		super();
		this.contrasenna = contrasenna;
		this.DNI = DNI;
		this.nombre = nombre;
		this.disponible = disponible;
	}
	public String getContrasenna() {
		return contrasenna;
	}
	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String DNI) {
		this.DNI = DNI;
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
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
}
