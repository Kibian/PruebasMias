package src;

import java.sql.Date;

public class Fallo {
	int id, numeroFallos;
	String receptorDni;
	String razon, lugarEntrega, dniTransportista;
	Date proximaEntrega;
	
	public Fallo(int id, String receptorDni, String lugarEntrega, String razon,
			String dniTransportista, Date proximaEntrega, int numeroFallos) {
		super();
		this.id = id;
		this.receptorDni = receptorDni;
		this.razon = razon;
		this.lugarEntrega = lugarEntrega;
		this.dniTransportista = dniTransportista;
		this.proximaEntrega = proximaEntrega;
		this.numeroFallos = numeroFallos;
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

	public String getRazon() {
		return razon;
	}

	public void setRazon(String razon) {
		this.razon = razon;
	}

	public String getLugarEntrega() {
		return lugarEntrega;
	}

	public void setLugarEntrega(String lugarEntrega) {
		this.lugarEntrega = lugarEntrega;
	}

	public String getDniTransportista() {
		return dniTransportista;
	}

	public void setDniTransportista(String dniTransportista) {
		this.dniTransportista = dniTransportista;
	}

	public Date getProximaEntrega() {
		return proximaEntrega;
	}

	public void setProximaEntrega(Date proximaEntrega) {
		this.proximaEntrega = proximaEntrega;
	}

	public int getNumeroFallos() {
		return numeroFallos;
	}

	public void setNumeroFallos(int numeroFallos) {
		this.numeroFallos = numeroFallos;
	}
	
}
