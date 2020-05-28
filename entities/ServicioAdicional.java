package entities;

public abstract class ServicioAdicional {
	
	protected long codigoServicio;
	protected String nombreServicio;
	protected double precio;
	
	public ServicioAdicional() {
		super();
	}

	public ServicioAdicional(long codigoServicio, String nombreServicio, double precio) {
		super();
		this.codigoServicio = codigoServicio;
		this.nombreServicio = nombreServicio;
		this.precio = precio;
	}

	public long getCodigoServicio() {
		return codigoServicio;
	}

	public void setCodigoServicio(long codigoServicio) {
		this.codigoServicio = codigoServicio;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public abstract Double calcularPrecio ();
	
	

}
