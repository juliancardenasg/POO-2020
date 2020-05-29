package control;

import java.util.ArrayList;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import javax.xml.bind.JAXB;

import entities.*;
import javafx.event.ActionEvent;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Random;
import java.util.HashMap;

public class ControlDespachos {

    private GestionCliente gestionCliente = new GestionCliente();
    private GestionProducto gestionProducto = new GestionProducto();
    private HashMap<Long, Cliente> mapaClientes = new HashMap<Long, Cliente>();
    private HashMap<Long, Producto> mapaProductos = new HashMap<Long, Producto>();
    private ArrayList<Pedido> pedidos = new ArrayList <>();

    public ControlDespachos() {
        super();
    }

    public ControlDespachos(GestionCliente gestionCliente, GestionProducto gestionProducto,
    		HashMap<Long, Cliente> mapaClientes, HashMap<Long, Producto> mapaProductos, ArrayList<Pedido> pedidos) {
        super();
        this.gestionCliente = gestionCliente;
        this.gestionProducto = gestionProducto;
        this.mapaClientes = mapaClientes;
        this.mapaProductos = mapaProductos;
        this.pedidos = pedidos;
    }
    
    public ControlDespachos(GestionCliente gestionCliente, GestionProducto gestionProducto){
    	super();
    	this.gestionCliente = gestionCliente;
    	this.gestionProducto = gestionProducto;
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

    public HashMap<Long, Cliente> getMapaClientes() {
        return mapaClientes;
    }

    public void setMapaClientes(HashMap<Long, Cliente> mapaClientes) {
        this.mapaClientes = mapaClientes;
    }

    public HashMap<Long, Producto> getMapaProductos() {
        return mapaProductos;
    }

    public void setmapaProductos(HashMap<Long, Producto> mapaProductos) {
        this.mapaProductos = mapaProductos;
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

        /*for (Cliente aux : this.mapaClientes) {
            for (Producto aux2 : this.mapaProductos) {
                if (cedula == aux.getCedula() && pid == aux2.getPid()) {		//Se comprueba que existe cliente y producto
                    long long_random = (long) aleatorio.nextInt(upperbound);
                    if (existePedido(long_random) == false) {				//Se comprueba que el nª de pedido no haya sido asignado
                        return true;
                    }
                }
            }
        }*/

        if (this.mapaClientes.get(cedula)!=null && this.mapaProductos.get(pid)!= null) {		//Se comprueba que existe cliente y producto
            long long_random = (long) aleatorio.nextInt(upperbound);
            if (existePedido(long_random) == false) {				//Se comprueba que el nª de pedido no haya sido asignado
                return true;
            }
        }

        return false;
    }

    public boolean validacionPedido(Pedido pedido) {

    	Long temp = pedido.getSolicitante().getCedula();
        Calendar temporal = pedido.getFechaRecibido();
        for (Pedido aux : this.pedidos) {
        	/*
            if (pedido.getSolicitante().getCedula() == aux.getSolicitante().getCedula()) {
                if (pedido.getFechaRecibido() == aux.getFechaRecibido()) {
                */
        		if(pedido.getSolicitante().getCedula() == temp && pedido.getNumeroPedido() != aux.getNumeroPedido() && pedido.getFechaRecibido() == temporal) {
                    System.out.println("Usted debe programar una nueva fecha para su pedido");
                    return false;
                }
        		else {
                return true;
            }
        }

        return false;
    }

    public boolean validacionDePedido2(Pedido pedido) {

    	Date fecha=new Date();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat forma= new SimpleDateFormat("dd-MM-yyyy");
        cal.setTime(fecha);
        if((pedido.getFechaRecibido().get(Calendar.DAY_OF_MONTH) - cal.get(Calendar.DAY_OF_MONTH)) > 2) {
        	return true;

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
            System.out.println("\nCODIGO:" + ped.getNumeroPedido() + 
            		"\nFECHA:" + ped.getFechaRecibido() + "\nNOMBRE REPARTIDOR"
            		+ ped.getNombreRepartidor() + "\nPRECIO" );//+ ped.getSolicitante().toString()+ped.getProductoSolicitado().toString());
            		//costoPedido(ped.getSolicitante().getCedula(),
            		//		ped.getProductoSolicitado().getPid(), ped.getProductoSolicitado()));

        }
    }

    public int verListadodePedidosParaProductoyFecha (long pid, Calendar fecha) {
    	int cont = 0;
    	for(Pedido aux : this.pedidos) {
    		if(aux.getProductoSolicitado().getPid() == pid && aux.getFechaRecibido() == fecha) {		//Si encuentra un producto con el mismo codigo
    			System.out.println(aux.getSolicitante().getNombreCompleto());
    			System.out.println(aux.getSolicitante().getDireccion());
    			System.out.println();
    			cont++;
    		}
    	}
    	return cont;
    }


    public void imprimirProductos(){
        this.gestionProducto.imprimirProductos(this.mapaProductos);
    }
    public boolean insertar_un_producto(Producto producto){
        return this.gestionProducto.insertar_un_producto(this.mapaProductos, producto);
    }

    public boolean modificar_un_producto(long pid){
        return this.gestionProducto.modificar_un_producto(this.mapaProductos,pid);
    }
    public boolean eliminar_un_producto(long pid_de_baja){
        return this.gestionProducto.eliminar_un_producto(this.mapaProductos, pid_de_baja, pedidos);
    }


    public void verClientes() {
        this.gestionCliente.verClientes(this.mapaClientes);
    }

    public boolean insertarCliente( Cliente clienteAIngresar) {
        return this.gestionCliente.insertarCliente(this.mapaClientes, clienteAIngresar);
    }

    public boolean modificarCliente(long cedula) {
        return this.gestionCliente.modificarCliente(this.mapaClientes, cedula);
    }
    public boolean eliminarCliente(long cedulaAEliminar) {
        return this.gestionCliente.eliminarCliente(this.mapaClientes, this.pedidos, cedulaAEliminar);
    }
	//--------------------------------guardarXML-Clientes-----------------------------
    public void guardarArchivosXMLCliente(){
        ArchivoClientes archivoSalida = new ArchivoClientes(this.mapaClientes);
        try(BufferedWriter output =  Files.newBufferedWriter(Paths.get("res/data/pruebaClientes.xml"))){
        	System.out.println("entro-------------");
            JAXB.marshal(archivoSalida, output);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
	//--------------------------------cargarXML-Clientes-----------------------------
    public void cargarArchivoXMLCliente() {//ActionEvent event) {
    	try(BufferedReader input =  Files.newBufferedReader(Paths.get("res/data/lecturaClientes.xml"))){
            ArchivoClientes archivoEntrada = JAXB.unmarshal(input, ArchivoClientes.class);
            //Verificar si el archivo fue leido satisfactoriamente
            for(Cliente cliente: archivoEntrada.getClientes().values()){
                this.insertarCliente(cliente);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    
	//--------------------------------cargar XML's-Productos-----------------------------
    public void cargarArchivosXML_producto(){
    	try(BufferedReader input =  Files.newBufferedReader(Paths.get("res/data/pruebaEntradaProductos.xml"))){
            ArchivoProductos archivoEntrada = JAXB.unmarshal(input, ArchivoProductos.class);
            //Verificar si el archivo fue leido satisfactoriamente
            for(Producto producto: archivoEntrada.getProductos().values()){
                this.insertar_un_producto(producto);
            	//System.out.println(producto.toString());
            }
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
  //--------------------------------guardar XML's Productos--------------------------------
    public void guardarArchivosXML_producto(){
        ArchivoProductos archivoSalida = new ArchivoProductos(this.mapaProductos);
        try(BufferedWriter output =  Files.newBufferedWriter(Paths.get("res/data/pruebaSalidaProductos.xml"))){
        	System.out.println("entro-------------");
            JAXB.marshal(archivoSalida, output);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
  //--------------------------------cargar XML's-Productos-----------------------------
    public void cargarArchivosXMLPedidos(){
    	try(BufferedReader input =  Files.newBufferedReader(Paths.get("res/data/pruebaEntradaPedidos.xml"))){
            ArchivoPedido archivoEntrada = JAXB.unmarshal(input, ArchivoPedido.class);
            //Verificar si el archivo fue leido satisfactoriamente
            for(Pedido pedido: archivoEntrada.getPedidos()){
                System.out.println(pedido.getSolicitante().toString());
            }
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	//--------------------------------guardarXML-Pedidos-----------------------------
    public void guardarArchivosXMLPedidos(){
        ArchivoPedido archivoSalida = new ArchivoPedido(this.pedidos);
        try(BufferedWriter output =  Files.newBufferedWriter(Paths.get("res/data/pruebaSalidaPedidos.xml"))){
        	System.out.println("entro-------------");
            JAXB.marshal(archivoSalida, output);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    
    
}

