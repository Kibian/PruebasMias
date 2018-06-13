package src;

public class Envio {
	private boolean busquedaADomicilio;
	private boolean envioADomicilio;
	private String receptor;
	private String emisor;
	private String transportista;
	private String vehiculo;
	private String provinciaDestino;
	private String provinciaOrigen;
	private String lugarEnvio;
	private double precio;
	private Integer id;
	private String estado;	//CREADO-ESPERA-VYT, ESPERA-ENVIO, EN-CAMINO, FALLO-UNO, FALLO-DOS, FALLO-TRES, ENTREGADO-DOMICILIO, ENTREGADO-OFICINA
	
	public Envio(boolean busquedaADomicilio, boolean envioADomicilio, String receptor, String emisor, String transportista, String vehiculo,
			String provinciaDestino, String provinciaOrigen, String lugarEnvio, String estado) {
		super();
		this.busquedaADomicilio = busquedaADomicilio;
		this.envioADomicilio = envioADomicilio;
		this.receptor = receptor;
		this.emisor = emisor;
		this.transportista = transportista;
		this.vehiculo = vehiculo;
		this.provinciaDestino = provinciaDestino;
		this.provinciaOrigen = provinciaOrigen;
		this.setLugarEnvio(lugarEnvio);
		this.setEstado(estado);
	}
	public Envio(boolean bad, boolean ead, String receptordni, String emisordni, String transportistadni,
			String vehiculomatricula, String provinciadestino, String provinciaorigen, String lugarenvio,
			String estado, Double precio) {
		this.busquedaADomicilio = bad;
		this.envioADomicilio = ead;
		this.receptor = receptordni;
		this.emisor = emisordni;
		this.transportista = transportistadni;
		this.vehiculo = vehiculomatricula;
		this.provinciaDestino = provinciadestino;
		this.provinciaOrigen = provinciaorigen;
		this.lugarEnvio = lugarenvio;
		this.estado = estado;
		this.precio = precio;
	}
	public boolean isbusquedaADomicilio() {
		return busquedaADomicilio;
	}
	public void setbusquedaADomicilio(boolean busquedaADomicilio) {
		this.busquedaADomicilio = busquedaADomicilio;
	}
	public boolean isenvioADomicilio() {
		return envioADomicilio;
	}
	public void setenvioADomicilio(boolean envioADomicilio) {
		this.envioADomicilio = envioADomicilio;
	}
	public String getReceptor() {
		return receptor;
	}
	public void setReceptor(String receptor) {
		this.receptor = receptor;
	}
	public String getEmisor() {
		return emisor;
	}
	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}
	public String getTransportista() {
		return transportista;
	}
	public void setTransportista(String transportista) {
		this.transportista = transportista;
	}
	public String getProvinciaDestino() {
		return provinciaDestino;
	}
	public void setProvinciaDestino(String provinciaDestino) {
		this.provinciaDestino = provinciaDestino;
	}
	public String getProvinciaOrigen() {
		return provinciaOrigen;
	}
	public void setProvinciaOrigen(String provinciaOrigen) {
		this.provinciaOrigen = provinciaOrigen;
	}	
	public double calculaPrecio() {
		if(provinciaOrigen.equals(provinciaDestino)) {
			precio = 5.0;
		}
		else {
			precio = 11.5;
		}
		if(busquedaADomicilio) {
			precio+=2.0;
		}
		if(envioADomicilio) {
			precio+=3.0;
		}
		return precio;
	}
	public boolean isBusquedaADomicilio() {
		return busquedaADomicilio;
	}
	public void setBusquedaADomicilio(boolean busquedaADomicilio) {
		this.busquedaADomicilio = busquedaADomicilio;
	}
	public boolean isEnvioADomicilio() {
		return envioADomicilio;
	}
	public void setEnvioADomicilio(boolean envioADomicilio) {
		this.envioADomicilio = envioADomicilio;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLugarEnvio() {
		return lugarEnvio;
	}
	public void setLugarEnvio(String lugarEnvio) {
		this.lugarEnvio = lugarEnvio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}
}
