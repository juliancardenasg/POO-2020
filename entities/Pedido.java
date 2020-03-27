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

	public boolean isPagado() {
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

/*
Buenas tardes,

Ya cree los tres diferentes espacios de trabajo (tres branches/ramas), distribuidos asi para Pedido:
Nombre del responsable: Julian Cárdenas y Richard Fonseca

Tener en cuenta lo siguiente:
- Si usted va a hacer cambios tanto en la entidad (Pedido) como en el control
(GestionPedido) solo hacer commits en esta rama: "pedido", y cuando tenga
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
- Fecha de entrega de esta rama (pedido): Viernes 27 de Marzo
- No borrar estos comentarios


Julian,


*/
