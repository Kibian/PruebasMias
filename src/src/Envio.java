package src;

public class Envio {
	private boolean aDomicilio;
	private Cliente receptor;
	private Cliente emisor;
	private Transportista transportista;
	private String provinciaDestino;
	private String provinciaOrigen;
	private double precio;
	public Envio(boolean aDomicilio, Cliente receptor, Cliente emisor, Transportista transportista,
			String provinciaDestino, String provinciaOrigen) {
		super();
		this.aDomicilio = aDomicilio;
		this.receptor = receptor;
		this.emisor = emisor;
		this.transportista = transportista;
		this.provinciaDestino = provinciaDestino;
		this.provinciaOrigen = provinciaOrigen;
	}
	public boolean isaDomicilio() {
		return aDomicilio;
	}
	public void setaDomicilio(boolean aDomicilio) {
		this.aDomicilio = aDomicilio;
	}
	public Cliente getReceptor() {
		return receptor;
	}
	public void setReceptor(Cliente receptor) {
		this.receptor = receptor;
	}
	public Cliente getEmisor() {
		return emisor;
	}
	public void setEmisor(Cliente emisor) {
		this.emisor = emisor;
	}
	public Transportista getTransportista() {
		return transportista;
	}
	public void setTransportista(Transportista transportista) {
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
	public double getPrecio() {
		if(provinciaOrigen.equals(provinciaDestino)) {
			precio = 5.0;
		}
		else {
			precio = 11.5;
		}
		return precio;
			
	}
}
