package entities;

public class Fruver extends Producto{
	//---------------------Attributes------------------------
	private boolean esOrganico;
	private double impuestoLocal;
	private String ascienda;
	//---------------------Constructors------------------------
	public Fruver(long pid , String nombreComercial, double precio, String tienda, boolean esOrganico,
			double impuestoLocal, String ascienda) {
		super(pid, nombreComercial, precio, tienda);
		this.esOrganico = esOrganico;
		this.impuestoLocal = impuestoLocal;
		this.ascienda = ascienda;
	}
	public Fruver() {}
	//---------------------Accessors------------------------
	public boolean isEsOrganico() {
		return esOrganico;
	}
	public void setEsOrganico(boolean esOrganico) {
		this.esOrganico = esOrganico;
	}
	public double getPuestoLocal() {
		return impuestoLocal;
	}
	public void setPuestoLocal(double puestoLocal) {
		this.impuestoLocal = puestoLocal;
	}
	public String getAscienda() {
		return ascienda;
	}
	public void setAscienda(String ascienda) {
		this.ascienda = ascienda;
	}
	//---------------------Methods------------------------
	@Override
	public double calcularPrecio() {
		double precioFruver = 0;
		precioFruver = super.calcularPrecio() + this.impuestoLocal;
		if(this.esOrganico == true) {
			precioFruver += + .2*(this.impuestoLocal);
		}
		return precioFruver;
	}
	
	
	

	
	
	
	
	
}
