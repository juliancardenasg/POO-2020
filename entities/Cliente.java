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

/*
Buenas tardes,

Ya cree los tres diferentes espacios de trabajo (tres branches/ramas), distribuidos asi para Cliente:
Nombre del responsable: Edgar Baquero

Tener en cuenta lo siguiente:
- Si usted va a hacer cambios tanto en la entidad (Cliente) como en el control
(GestionCliente) solo hacer commits en esta rama: "cliente", y cuando tenga
la version final (ultimo commit), avisar a Julian para que el haga el respectivo
merge a la rama final (master). Haga cuantos commits desee, pero no olvide
comentar cada uno de ellos. En resumen, haga los cambios en su repo local, hasta
que tenga la versión final de esta rama, no avisar.
- Comunicación por el grupo de Whatsapp para cualquier cosa.
- Si tiene alguna duda acerca de Git o GitHub, no dude con contactarme, yo le
ayudo a configurar su repositorio local al remoto y viceversa.
- Tenga en cuenta el buen manejo de los commits.
- Como mencione anteriormente, solo gestione y edite sus dos correspondientes
archivos, despues todos nos encargamos de fusionar y hacer los respectivos
cambios.
- Fecha de entrega de esta rama (cliente): Viernes 27 de Marzo
- No borrar estos comentarios


Julian,


*/
