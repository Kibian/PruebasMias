package src;


public class RegistroMovimiento {
	String dniTransportista;
	String vehiculo;
	int idEnvio;
	String ubicacionActual;
	public RegistroMovimiento(String dniTransportista, String vehiculo, int idEnvio, String ubicacionActual) {
		super();
		this.dniTransportista = dniTransportista;
		this.vehiculo = vehiculo;
		this.idEnvio = idEnvio;
		this.ubicacionActual = ubicacionActual;
	}
	public String getDniTransportista() {
		return dniTransportista;
	}
	public void setDniTransportista(String dniTransportista) {
		this.dniTransportista = dniTransportista;
	}
	public String getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}
	public int getIdEnvio() {
		return idEnvio;
	}
	public void setIdEnvio(int idEnvio) {
		this.idEnvio = idEnvio;
	}
	public String getUbicacionActual() {
		return ubicacionActual;
	}
	public void setUbicacionActual(String estadoActual) {
		this.ubicacionActual = estadoActual;
	}
}
