package src;

public class Vehiculo {
	private String matricula;
	private String marca;
	private String tipo;
	private Integer edificioId;
	
	public Vehiculo(String matricula, String marca, String tipo) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.tipo = tipo;
	}
	public Vehiculo(String matricula, String marca, String tipo, int edificioId) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.tipo = tipo;
		this.edificioId = edificioId;
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
	public int getEdificioId() {
		return edificioId;
	}
	public void setEdificioId(int edificioId) {
		this.edificioId = edificioId;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
}
