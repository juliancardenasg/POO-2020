package entities;
import java.util.Calendar;
import java.util.Scanner;


public class Pedido {
	
    private long numeroPedido;
    private Calendar fechaRecibido;
    private boolean pagado;
    private String nombreRepartidor;
    private Cliente solicitante;
    private Producto productoSolicitado;
    
    
    public Pedido() {
		super();
	}
    
    public Pedido(long numeroPedido, Calendar fechaRecibido, boolean pagado, String nombreRepartidor,
			Cliente solicitante, Producto productoSolicitado) {
		super();
		this.numeroPedido = numeroPedido;
		this.fechaRecibido = fechaRecibido;
		this.pagado = pagado;
		this.nombreRepartidor = nombreRepartidor;
		this.solicitante = solicitante;
		this.productoSolicitado = productoSolicitado;
	}
    

	public long getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(long numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public Calendar getFechaRecibido() {
		return fechaRecibido;
	}

	public void setFechaRecibido(Calendar fechaRecibido) {
		this.fechaRecibido = fechaRecibido;
	}

	public boolean getPagado() {
		return pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}

	public String getNombreRepartidor() {
		return nombreRepartidor;
	}

	public void setNombreRepartidor(String nombreRepartidor) {
		this.nombreRepartidor = nombreRepartidor;
	}

	public Cliente getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Cliente solicitante) {
		this.solicitante = solicitante;
	}

	public Producto getProductoSolicitado() {
		return productoSolicitado;
	}

	public void setProductoSolicitado(Producto productoSolicitado) {
		this.productoSolicitado = productoSolicitado;
	}
	
    

}

