package entities;

public class EnvioPrime extends ServicioAdicional{
	
	private Double distancia;
	private TipoTransporte tipo;
	private int numeroCajas;	

	public EnvioPrime() {
		super();
	}
	
	public EnvioPrime(Double distancia, TipoTransporte tipo, int numeroCajas) {
		super();
		this.distancia = distancia;
		this.tipo = tipo;
		this.numeroCajas = numeroCajas;
	}

	public Double getDistancia() {
		return distancia;
	}

	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}

	public TipoTransporte getTipo() {
		return tipo;
	}

	public void setTipo(TipoTransporte tipo) {
		this.tipo = tipo;
	}

	public int getNumeroCajas() {
		return numeroCajas;
	}

	public void setNumeroCajas(int numeroCajas) {
		this.numeroCajas = numeroCajas;
	}

	@Override
	public Double calcularPrecio() {
		if(this.tipo == TipoTransporte.BICICLETA) {
			this.precio = this.precio;
			return this.precio;
		}
		if(this.tipo == TipoTransporte.MOTO) {
			this.precio = this.precio + this.distancia;
			this.precio = this.precio + (this.numeroCajas*1200);
			this.precio = this.precio + (this.precio*0.10);
			return this.precio;
		}
		if(this.tipo == TipoTransporte.MINIVAN) {
			this.precio = this.precio + this.distancia;
			this.precio = this.precio + (this.numeroCajas*1200);
			this.precio = this.precio + (this.precio*0.25);
			return this.precio;
		}
		
		return null;
	}
	
	

}
