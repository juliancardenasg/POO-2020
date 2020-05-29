package entities;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;


public class Pedido {

    private long numeroPedido;
    private Calendar fechaRecibido;
    private boolean pagado;
    private String nombreRepartidor;
    private Cliente solicitante;
    private Producto productoSolicitado;
    private ArrayList<ServicioAdicional> serviciosAdicionales =new ArrayList<>();


    @Override
    public String toString() {
    	return this.nombreRepartidor +this.solicitante.toString()+this.productoSolicitado.toString();
    }
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
	
	 public String todosLosServiciosAdicionalesDeEnvioPrime(TipoTransporte tipo) {
	        String a = " ";
	        for (ServicioAdicional sera : this.serviciosAdicionales) {
	            if (sera instanceof EnvioPrime) {
	                if (((EnvioPrime) sera).getTipo().equals(tipo)) {
	                    if(a==" ") {
	                        a = ("\n" + sera.getCodigoServicio() + "\n" + sera.getPrecio() + "\n" + sera.getNombreServicio()
	                        + "\n" + ((EnvioPrime) sera).getDistancia() + "\n" + ((EnvioPrime) sera).getTipo() + "\n"
	                        + ((EnvioPrime) sera).getNumeroCajas());
	                    }
	                    else
	                    {
	                        a = (a+"\n" + sera.getCodigoServicio() + "\n" + sera.getPrecio() + "\n" + sera.getNombreServicio()
	                        + "\n" + ((EnvioPrime) sera).getDistancia() + "\n" + ((EnvioPrime) sera).getTipo() + "\n"
	                        + ((EnvioPrime) sera).getNumeroCajas());
	                    }
	                    
	                }
	            }

	 

	        }
	        return a;
	    }



}
