package control;

import java.util.ArrayList;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import entities.Cliente;
import entities.Producto;
import entities.Pedido;
import java.text.ParseException;
import java.util.Random;

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

    public boolean reservarPedido(long cedula, long pid, Producto producto) {

        return false;
    }

    public boolean existePedido(long numeroPedido) {
        for (Pedido aux : this.pedidos) {
            if (aux.getNumeroPedido() == numeroPedido) {
                return true;
            }
        }
        return false;
    }

    public boolean autoGenerarPedido(long cedula, long pid) {	//Funcion que asigna un numero pedido aleatorio a un pedido que esta por reservar
        int upperbound = 9999;									//Numero de pedido de cuatro digitos
        Random aleatorio = new Random();

        for (Cliente aux : this.listaClientes) {
            for (Producto aux2 : this.listaProductos) {
                if (cedula == aux.getCedula() && pid == aux2.getPid()) {		//Se comprueba que existe cliente y producto
                    long long_random = (long) aleatorio.nextInt(upperbound);
                    if (existePedido(long_random) == false) {				//Se comprueba que el nª de pedido no haya sido asignado
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean validacionPedido(Pedido pedido) {

        for (Pedido aux : this.pedidos) {
            if (pedido.getSolicitante().getCedula() == aux.getSolicitante().getCedula()) {
                if (pedido.getFechaRecibido() == aux.getFechaRecibido()) {
                    System.out.println("Usted debe programar una nueva fecha para su pedido");
                    return false;
                }
            } else {
                return true;
            }
        }

        return false;
    }

    public boolean validacionDePedido2(Pedido pedido) {

        Date fecha = null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);

        for (Pedido aux : this.pedidos) {
            //if(pedido.getFechaRecibido() < fecha.getDate())
        }

        return false;
    }

    public void solicitarServiciosAdicionales(long cedula, long pid) {
        System.out.println("Bienvenido al menu: Servicios Adicionales");

    }

    public double costoPedido(long cedula, long pid, Producto producto) {
        double costo = 0;
        costo = producto.getPrecio() + producto.getIva();
        if (producto.getIva() > 50000) {
            costo = costo + 8000;
        }

        return costo;
    }

    public void mostrarPedido(long cedula, long pid, Producto producto, Pedido pedido) {

        if (pedido.getPagado() == true) {
            System.out.println("Confirmación de su pedido");
            System.out.println("Nª de pedido: " + pedido.getNumeroPedido());
            System.out.println("Producto: " + producto.getNombreComercial());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("Precio (IVA): " + producto.getIva());
            System.out.println("Tienda: " + producto.getTienda());
            System.out.println("Repartidor: " + pedido.getNombreRepartidor());
            System.out.println("Fecha de recibido: " + pedido.getFechaRecibido());
        } else {
            System.out.println("Por favor haga el pago de su pedido para hacer la confirmacion de su pedido");
        }

    }

    //PARTE DE RICHARD
//11    
    public void ModificarDatosDeUnPedido(long numPedido) throws ParseException {
        Scanner sc = new Scanner(System.in);

        if (existePedido(numPedido)) {
            int opc;
            do {
                System.out.println("¿QUE DESEA CAMBIAR? \n 1.FECHA DEL PEDIDO \n 2.NOMBRE DEL REPARTIDOR \n3.SERVICIOS ADICIONALES \n4.NADA,SALIR");
                opc = sc.nextInt();
                switch (opc) {
                    case 1:
                        cambiarFecha(numPedido);
                        break;
                    case 2:
                        cambiarNombre(numPedido);
                        break;
                    case 3:
                        cambiarServicios(numPedido);
                        break;
                    case 4:
                        System.out.println("SE SALIO DE MODIFICAR");
                        break;
                    default:
                        System.out.println("OPCION NO VALIDA");
                        break;
                }

            } while (opc != 4);
        } else {
            System.out.println("No se encontro el pedido");
        }
        calcularNuevoPrecio(numPedido);
    }

    public void calcularNuevoPrecio(long numPedido) {
        for (Pedido ped : this.pedidos) {
         
            if (ped.getNumeroPedido() == numPedido) {
                Scanner sc = new Scanner(System.in);
                String op;
                System.out.println("SE VA A MODIFICAR EL PRECIO DEL PEDIDO SEGURO DESEA CONTINUAR?(si/no)");
                op = sc.next();
                if ("si".equals(op)) {

                    costoPedido(ped.getSolicitante().getCedula(),ped.getProductoSolicitado().getPid(), ped.getProductoSolicitado());
                    System.out.println("SE MODIFICO EL PRECIO");
                } else {
                    System.out.println("NO SE MODIFICO EL PRECIO");
                }
            }
        }
    }

    public void cambiarFecha(long numPedido) throws ParseException {

        String fecha;
        Calendar cal = Calendar.getInstance();
        Scanner sc = new Scanner(System.in);
        System.out.println("INGRESE LA FECHA NUEVA \n EN FORMA: dd-MM-yyyy");
        fecha = sc.next();// el String
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha_date = sdf.parse(fecha);
        cal.setTime(fecha_date);// fecha en calendar nueva
        long temp = 0;
        Calendar temporal = null ;
        for (Pedido ped : pedidos) {
            if (ped.getNumeroPedido() == numPedido)//si es el pedido
            {
                temp = ped.getSolicitante().getCedula();//identifico al cliente
                temporal = ped.getFechaRecibido();
            }
            
            if (ped.getSolicitante().getCedula() == temp && ped.getNumeroPedido() != numPedido && ped.getFechaRecibido() == temporal)//es el cliente con otro pedido, que tiene la fecha ingresada de cambio
            {
                System.out.println("YA TIENE OTRO PEDIDO A ESTA FECHA, NO SE LE ASIGANARA");
            }
            //else
            {
                System.out.println("SE ASIGNO LA FECHA");
                ped.setFechaRecibido(cal);
            }

        }
    }

    public void cambiarNombre(long numPedido)//listo
    {
        String nom;
        Scanner sc = new Scanner(System.in);
        System.out.println("INGRESE EL NOMBRE DEL NUEVO REPARTIDOR");
        nom = sc.next();
        for (Pedido ped : pedidos) {
            if (ped.getNumeroPedido() == numPedido) {
                ped.setNombreRepartidor(nom);
            }
        }
    }

    public void cambiarServicios(long numPedido) {
        String servicio;
        Scanner sc = new Scanner(System.in);
        System.out.println("INGRESE EL SERVICIO");
        servicio = sc.next();
        //lo dejo por opcional
    }

    //12//
    public boolean eliminarReservaDeUnPedido(long numPedido) {
        String confi;
        Scanner sc = new Scanner(System.in);
        if (existePedido(numPedido)) {
            System.out.println("SE ENCONTRO EL PEDIDO.¿ESTA SEGURO DE QUE QUIERE ELIMINARLO ?(si/no)");
            confi = sc.next();
            if ("si".equals(confi)) {
                for (Pedido ped : pedidos) {
                    System.out.println("SE ELIMINO");
                    return this.pedidos.remove(ped);
                }

            } else {
                System.out.println("NO SE ELIMINO");
                return false;
            }
        } else {
            System.out.println("NO EXISTE ESTE PEDIDO");
        }

        return false;
    }

    //13//
    public void VerListadoDePedidosExistentes() {
        for (Pedido ped : pedidos) {
            System.out.println("\nCODIGO:" + ped.getNumeroPedido() + "\nFECHA:" + ped.getFechaRecibido() + "\nNOMBRE REPARTIDOR" + ped.getNombreRepartidor() + "\nPRECIO" + costoPedido(ped.getSolicitante().getCedula(),ped.getProductoSolicitado().getPid(), ped.getProductoSolicitado()));
               
        }
    }
}
    /*
	public int listadoPedidos (long pid, Calendar fecha) {
    int cont = 0;
		Producto auxiliar = null;
		for(Cliente aux : this.listaClientes) {
			if(aux.getPedido().getFechaRecibido() == fecha) {
				auxiliar = aux.getPedido().getProductoSolicitado();
				if(auxiliar.getPid() == pid) {
					System.out.println("LISTADO DE PEDIDOS PARA ESTE CLIENTE EN ESTA FECHA");
					cont++;
				}

			}
		}
		return cont;
	}
     */
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
