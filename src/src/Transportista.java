package src;

public class Transportista {
	private String contrasenna;
	private String DNI;
	private String nombre;
	private Vehiculo vehiculo;
	private String provincia;
	private String lugarRecogida;
	private String lugarEntrega;
	public Transportista(String contrasenna, String DNI, String nombre, String provincia) {
		super();
		this.contrasenna = contrasenna;
		this.DNI = DNI;
		this.nombre = nombre;
		this.provincia = provincia;
	}
	public Transportista(String contrasenna, String DNI, String nombre, String provincia, String lugarRecogida, String lugarEntrega) {
		super();
		this.contrasenna = contrasenna;
		this.DNI = DNI;
		this.nombre = nombre;
		this.provincia = provincia;
		this.lugarEntrega = lugarEntrega;
		this.lugarRecogida = lugarRecogida;
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
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getLugarRecogida() {
		return lugarRecogida;
	}
	public void setLugarRecogida(String lugarRecogida) {
		this.lugarRecogida = lugarRecogida;
	}
	public String getLugarEntrega() {
		return lugarEntrega;
	}
	public void setLugarEntrega(String lugarEntrega) {
		this.lugarEntrega = lugarEntrega;
	}
}
