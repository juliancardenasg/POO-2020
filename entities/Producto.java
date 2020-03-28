public class Producto {

	private long pid;
	private String nombreComercial;
	private double precio;
	private double iva;
	private String tienda;

	@Override
	public String toString() {
		return "Producto \n(imposible de modificar)pid=" + pid + ", \n(1)nombreComercial=" + nombreComercial + ", \n(2)precio=" + precio + ", \n(2)iva=" + iva
				+ ", \n(3)tienda=" + tienda ;
	}

	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public String getNombreComercial() {
		return nombreComercial;
	}
	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public String getTienda() {
		return tienda;
	}
	public void setTienda(String tienda) {
		this.tienda = tienda;
	}






}


/*
Buenas tardes,

Ya cree los tres diferentes espacios de trabajo (tres branches/ramas), distribuidos asi para Producto:
Nombre del responsable: Ricardo Sebastian T

Tener en cuenta lo siguiente:
- Si usted va a hacer cambios tanto en la entidad (Producto) como en el control
(GestionProducto) solo hacer commits en esta rama: "producto", y cuando tenga
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
- Fecha de entrega de esta rama (producto): Viernes 27 de Marzo
- No borrar estos comentarios


Julian,


*/
