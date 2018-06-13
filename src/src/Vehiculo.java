package src;

public class Vehiculo {
	private String matricula;
	private String marca;
	private String tipo;
	private Transportista transportista;
	
	public Vehiculo(String matricula, String marca, String tipo) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.tipo = tipo;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Transportista getTransportista() {
		return transportista;
	}
	public void setTransportista(Transportista transportista) {
		this.transportista = transportista;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
}
