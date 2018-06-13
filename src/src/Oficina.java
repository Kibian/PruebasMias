package src;

public class Oficina {
	private String provinciaLocalizacion;
	private String nombre;
	private Integer id;
	public Oficina(String provinciaLocalizacion, String nombre) {
		super();
		this.provinciaLocalizacion = provinciaLocalizacion;
		this.nombre = nombre;
	}
	public String getProvinciaLocalizacion() {
		return provinciaLocalizacion;
	}
	public void setProvinciaLocalizacion(String provinciaLocalizacion) {
		this.provinciaLocalizacion = provinciaLocalizacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
