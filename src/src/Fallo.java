package src;

public class Fallo {
	int id;
	String receptorDni;
	String estado;
	
	public Fallo(int id, String receptorDni, String estado) {
		super();
		this.id = id;
		this.receptorDni = receptorDni;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReceptorDni() {
		return receptorDni;
	}

	public void setReceptorDni(String receptorDni) {
		this.receptorDni = receptorDni;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
