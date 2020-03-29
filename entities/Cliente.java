package entities;

public class Cliente {
	//----------------Attributes------------------------
	private long cedula;
	private String nombreCompleto;
	private long telefonoContacto;
	private String direccion;
	//----------------Constructors------------------------
	public Cliente(long cedula, String nombreCompleto, long telefonoContacto, String direccion) {
		this.cedula = cedula;
		this.nombreCompleto = nombreCompleto;
		this.telefonoContacto = telefonoContacto;
		this.direccion = direccion;
	}
	public Cliente(){}
	
	//----------------Accessors------------------------
	public long getCedula() {
		return cedula;
	}
	
	public void setCedula(long cedula) {
		this.cedula = cedula;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public long getTelefonoContacto() {
		return telefonoContacto;
	}
	public void setTelefonoContacto(long telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	//----------------Methods------------------------
	@Override
	public String toString() {
		return "Cedula: " + this.cedula +"; \n" +
			   "1.Nombre completo: " + this.nombreCompleto+"; \n" +
			   "2.Telefono de contacto: " + this.telefonoContacto + "; \n" +
			   "3.Dirección: " + this.direccion + "; \n";
	}
}