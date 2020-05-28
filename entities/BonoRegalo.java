package entities;

import java.util.Date;

public class BonoRegalo extends ServicioAdicional {
	
	private String comercioAsociado;
	private String mensaje;
	private	 Date fechaVencimiento;

	public BonoRegalo() {
		super();
	}

	public BonoRegalo(String comercioAsociado, String mensaje, Date fechaVencimiento) {
		super();
		this.comercioAsociado = comercioAsociado;
		this.mensaje = mensaje;
		this.fechaVencimiento = fechaVencimiento;
	}
	
	public String getComercioAsociado() {
		return comercioAsociado;
	}

	public void setComercioAsociado(String comercioAsociado) {
		this.comercioAsociado = comercioAsociado;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	@Override
	public Double calcularPrecio() {
		this.precio = this.precio;
		return null;
	}

	
}
