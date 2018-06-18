package src;


public class RegistroMovimiento {
	String dniTransportista;
	String vehiculo;
	int idEnvio;
	String estadoActual;
	public RegistroMovimiento(String dniTransportista, String vehiculo, int idEnvio, String estadoActual) {
		super();
		this.dniTransportista = dniTransportista;
		this.vehiculo = vehiculo;
		this.idEnvio = idEnvio;
		this.estadoActual = estadoActual;
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
	public String getEstadoActual() {
		return estadoActual;
	}
	public void setEstadoActual(String estadoActual) {
		this.estadoActual = estadoActual;
	}
}
