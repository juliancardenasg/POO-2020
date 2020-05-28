package entities;

public class Producto {

	private long pid;
	private String nombreComercial;
	private double precio;
	private double iva;
	private String tienda;

	@Override
	public String toString() {
		return "Producto \n pid=" + pid + ", \n(1)nombreComercial=" + nombreComercial + ", \n(2)precio=" + precio + ", \n(2)iva=" + iva
				+ ", \n(3)tienda=" + tienda ;
	}

	public Producto(long pid, String nombreComercial, double precio, String tienda) {
		this.pid = pid;
		this.nombreComercial = nombreComercial;
		this.precio = precio;
		this.iva = precio*0.19f;
		this.tienda = tienda;
	}
	public Producto() {	}

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
	public void setIva(double precio) {
		this.iva = precio*0.19;
	}
	public String getTienda() {
		return tienda;
	}
	public void setTienda(String tienda) {
		this.tienda = tienda;
	}
	//--------------------------------methods--------------------------------
	public double calcularPrecio() {
		double precio = 0;
		precio = this.precio + this.precio*this.iva;

		return precio;
	}
	
}
