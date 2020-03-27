package control;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Random;
import entities.Cliente;
import entities.Producto;
import entities.Pedido;

public class ControlDespachos {

  private GestionCliente gestionCliente;
	 private GestionProducto gestionProducto;
	 private ArrayList<Cliente> listaClientes;
	 private ArrayList<Producto> listaProductos;
	 private ArrayList<Pedido> pedidos;


	public ControlDespachos() {
		super();
	}


	public ControlDespachos(GestionCliente gestionCliente, GestionProducto gestionProducto,
			ArrayList<Cliente> listaClientes, ArrayList<Producto> listaProductos, ArrayList<Pedido> pedidos) {
		super();
		this.gestionCliente = gestionCliente;
		this.gestionProducto = gestionProducto;
		this.listaClientes = listaClientes;
		this.listaProductos = listaProductos;
		this.pedidos = pedidos;
	}


	public GestionCliente getGestionCliente() {
		return gestionCliente;
	}


	public void setGestionCliente(GestionCliente gestionCliente) {
		this.gestionCliente = gestionCliente;
	}


	public GestionProducto getGestionProducto() {
		return gestionProducto;
	}


	public void setGestionProducto(GestionProducto gestionProducto) {
		this.gestionProducto = gestionProducto;
	}


	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}


	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}


	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}


	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}


	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}


	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

  public boolean reservarPedido(long cedula, long pid, Producto producto){
		if(autoGenerarPedido(cedula, pid) == true) {
			//PUNTO C ACA
			if(validacionPedido(cedula, pid) == false) {
				System.out.println("Nueva fecha de pedido");
			}
			else {
				System.out.println("El costo total de su pedido es ");
				System.out.println(costoPedido(cedula, pid, producto));
			}
			}



	   	return false;
	}

	public boolean existePedido(long numeroPedido){
		for(Pedido aux: this.pedidos) {
			if(aux.getNumeroPedido() == numeroPedido) {
				return true;
			}
		}
		return false;
	}


	public boolean autoGenerarPedido(long cedula, long pid) {	//Funcion que asigna un numero pedido aleatorio a un pedido que esta por reservar
		int upperbound = 9999;									//Numero de pedido de cuatro digitos
		Random aleatorio = new Random();

	   	for(Cliente aux: this.listaClientes) {
	   		for(Producto aux2 : this.listaProductos) {
	   			if(cedula == aux.getCedula() && pid == aux2.getPid()) {		//Se comprueba que existe cliente y producto
	   				long long_random = (long)aleatorio.nextInt(upperbound);
	   					if(existePedido(long_random) == false){				//Se comprueba que el nª de pedido no haya sido asignado
	   						return true;
	   					}
	   			}
	   		}
	   	}

	   	return false;
	}

	public boolean validacionPedido(long cedula, long pid) {



		return false;
	}

	public void solicitarServiciosAdicionales (long cedula, long pid) {
		System.out.println("Bienvenido al menu: Servicios Adicionales");


	}

	public double costoPedido (long cedula, long pid, Producto producto) {
		double costo = 0;
		costo = producto.getPrecio + producto.getIva;
		if(producto.getIva > 50000) {
			costo = costo + 8000;
		}

		return costo;
	}

	public void mostrarPedido (long cedula, long pid, Producto producto, Pedido pedido) {

		if(pedido.getPagado == true) {
		System.out.println("Confirmación de su pedido");
		System.out.println("Nª de pedido: " + pedido.getNropedido);
		System.out.println("Producto: " + producto.getNombre);
		System.out.println("Precio: " + producto.getPrecio);
		System.out.println("Precio (IVA): " + producto.getIva);
		System.out.println("Tienda: " + producto.getTienda);
		System.out.println("Repartidor: " + pedido.getRepartidor);
		System.out.println("Fecha de recibido: " + pedido.getFecharecibido);
		}
		else {
			System.out.println("Por favor haga el pago de su pedido para hacer la confirmacion de su pedido");
		}

	}


	public int listadoPedidos (long pid, Calendar fecha) {



		return 0;
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
