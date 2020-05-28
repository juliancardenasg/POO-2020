package test;

import entities.*;
import control.*;
import boundary.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

class TestDespacho {
	
	ControlDespachos admin = new ControlDespachos();
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {

	    
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testInsertar_un_producto() {
		//tres productos de fruver
		Producto manzana = new Fruver(1000001, "manzana roja",1000, "D1", true, 20 , "santa Barbara");
		
		
		assertEquals(true, admin.insertar_un_producto(manzana));
		
	}
	//----------------------------testing productos----------------------------
	
	@Test
	void testImprimirProductos() {
		//tres productos de fruver
		Producto manzana = new Fruver(1000001, "manzana roja",1000, "D1", true, 20 , "santa Barbara");
		Producto naranja = new Fruver(0000002, "toronja", 500, "exito", true, 30, "Santa Barbara");
		Producto brevas = new Fruver(0000003, "brevas con arequipe", 2000, "jumbo", true, 10, "Santa Barbara");
		//tres productos de Aseo:
		Producto shampoo = new Aseo(0000004, "shampoo ", 15000, "D1","head & shoulders", true, TipoProducto.HOGAR);
		Producto cremaDeDientes = new Aseo(0000005, "crema colgate", 5000, "etsito","colgate", true, TipoProducto.INDUSTRIAL);
		Producto tapabocas = new Aseo(0000006, "cubrebocas", 1000000, "D1", "E3", true, TipoProducto.HOSPITALARIO) ;
		//tres productos genericos
		Producto xbox = new Producto(0000007, "xbox 1", 1500000, "alkosto");
		Producto bolsa = new Producto(0000011, "bolsa plastica", 100, "jumbo");
		Producto carro = new Producto(0000012, "ferrari juguete", 1000, "pepe ganga");
		
		admin.insertar_un_producto(manzana);
		admin.insertar_un_producto(naranja);
		admin.insertar_un_producto(brevas);
			
		admin.insertar_un_producto(shampoo);
		admin.insertar_un_producto(cremaDeDientes);
		admin.insertar_un_producto(tapabocas);
		
		admin.insertar_un_producto(xbox);
		admin.insertar_un_producto(bolsa);
		admin.insertar_un_producto(carro);
		
	    admin.imprimirProductos();
		
	}


	@Test
	void testEliminar_un_producto(){
		System.out.println("------testEliminar_un_producto-------------");
		Producto manzana = new Fruver(1000001, "manzana roja",1000, "D1", true, 20 , "santa Barbara");
		Producto naranja = new Fruver(0000002, "toronja", 500, "exito", true, 30, "Santa Barbara");
		admin.insertar_un_producto(manzana);
		admin.insertar_un_producto(naranja);
		
		boolean result = admin.eliminar_un_producto(1000001);
		
		System.out.println("resultado" + result);
		
		
	}
	
	//--------------------------Testing Clientes------------------------------
	@Test
	void testVerClientes() {
		System.out.println("------testVerClientes-------------");
		Cliente ricardo = new Cliente(1321456, "Ricardo Torres", 545154, "calle c");
		Cliente julian = new Cliente(1213, "Julian C", 4455, "calle ce");
		Cliente richard = new Cliente(54456, "Richard T", 54564, "calle cee");
		Cliente edgar = new Cliente(4324, "Edgar B", 4543543, "calle m");
		Cliente julianD= new Cliente(5435435, "Julian D", 5435435, "calle mee");
		
		admin.insertarCliente(ricardo);
		admin.insertarCliente(julian);
		admin.insertarCliente(richard);
		admin.insertarCliente(edgar);
		admin.insertarCliente(julianD);
		
		admin.verClientes();
	}
	
	@Test
	void testInsertarCliente() {
		System.out.println("------testInsertarCliente-------------");
		Cliente ricardo = new Cliente(1321456, "Ricardo Torres", 545154, "calle c");

		boolean result = admin.insertarCliente(ricardo);
		assertEquals(true, result);
	}
	
	@Test
	void testModificarCliente() {
		System.out.println("------testModificarCliente-------------");
		Cliente ricardo = new Cliente(1321456, "Ricardo Torres", 545154, "calle c");
		Cliente julian = new Cliente(1213, "Julian C", 4455, "calle ce");
		Cliente richard = new Cliente(54456, "Richard T", 54564, "calle cee");
		Cliente edgar = new Cliente(4324, "Edgar B", 4543543, "calle m");
		Cliente julianD= new Cliente(5435435, "Julian D", 5435435, "calle mee");
		
		admin.insertarCliente(ricardo);
		admin.insertarCliente(julian);
		admin.insertarCliente(richard);
		admin.insertarCliente(edgar);
		admin.insertarCliente(julianD);
		
		boolean result= admin.modificarCliente(5435435);
		assertEquals(true, result);
		
		boolean result2 = admin.modificarCliente(54354);
		assertEquals(false, result2);
	}
	@Test
	void testEliminarCliente(){
		System.out.println("------testEliminarCliente-------------");
		Cliente ricardo = new Cliente(1321456, "Ricardo Torres", 545154, "calle c");
		Cliente julian = new Cliente(1213, "Julian C", 4455, "calle ce");
		Cliente richard = new Cliente(54456, "Richard T", 54564, "calle cee");
		Cliente edgar = new Cliente(4324, "Edgar B", 4543543, "calle m");
		Cliente julianD= new Cliente(5435435, "Julian D", 5435435, "calle mee");
		
		admin.insertarCliente(ricardo);
		admin.insertarCliente(julian);
		admin.insertarCliente(richard);
		admin.insertarCliente(edgar);
		admin.insertarCliente(julianD);
		
		boolean eliminadoRicardo= admin.eliminarCliente(1321456);
		assertEquals(true, eliminadoRicardo);
	}
	//---------------------------------testXMLPedidos--------------------------
	@Test 
	void testGuardarArchivoXMLPedidos(){
		
		long numeroPedido1 = 13213;
		Calendar fechaRecibido1 = new GregorianCalendar(); 
		boolean pagado1 = true;
		String nombreRepartidor1 = "Pepe";
		Cliente solicitante1 = new Cliente(5435435, "Julian D", 5435435, "calle mee");
		Producto productoSolicitado1 = new Aseo(1000006, "cubrebocas", 1000000, "D1", "E3", true, TipoProducto.HOSPITALARIO);
		
        long numeroPedido2 = 18943;
		Calendar fechaRecibido2 = new GregorianCalendar(); 
		boolean pagado2 = true;
		String nombreRepartidor2 = "Magui";
		Cliente solicitante2 = new Cliente(1321456, "Ricardo Torres", 545154, "calle c");
		Producto productoSolicitado2 = new Aseo(0000004, "shampoo ", 15000, "D1","head & shoulders", true, TipoProducto.HOGAR);
		
        long numeroPedido3 = 23613;
		Calendar fechaRecibido3 = new GregorianCalendar(); 
		boolean pagado3 = true;
		String nombreRepartidor3 = "Julian";
		Cliente solicitante3 = new Cliente(4324, "Edgar B", 4543543, "calle m");
		Producto productoSolicitado3 = new Fruver(0000003, "brevas con arequipe", 2000, "jumbo", true, 10, "Santa Barbara");
		
        long numeroPedido4 = 41013;
		Calendar fechaRecibido4 = new GregorianCalendar(); 
		boolean pagado4 = true;
		String nombreRepartidor4 = "Diomedes";
		Cliente solicitante4 = new Cliente(54456, "Richard T", 54564, "calle cee");
		Producto productoSolicitado4 = new Producto(0000007, "xbox 1", 1500000, "alkosto");
		
		Pedido pedido1 = new Pedido(numeroPedido1, fechaRecibido1, pagado1, nombreRepartidor1, solicitante1, productoSolicitado1);
		Pedido pedido2 = new Pedido(numeroPedido2, fechaRecibido2, pagado2, nombreRepartidor2, solicitante2, productoSolicitado2);
		Pedido pedido3 = new Pedido(numeroPedido3, fechaRecibido3, pagado3, nombreRepartidor3, solicitante3, productoSolicitado3);
		Pedido pedido4 = new Pedido(numeroPedido4, fechaRecibido4, pagado4, nombreRepartidor4, solicitante4, productoSolicitado4);
		
		
		admin.getPedidos().add(pedido1);
		admin.getPedidos().add(pedido2);
		admin.getPedidos().add(pedido3);
		admin.getPedidos().add(pedido4);
		
		admin.VerListadoDePedidosExistentes();
		admin.guardarArchivosXMLPedidos();
	}
	@Test 
	void testCargarArchivoXMLPedidos() {
		admin.cargarArchivosXMLPedidos();
		//admin.VerListadoDePedidosExistentes();
	}
	
	//---------------------------------testClientesXML--------------------------
	@Test	
	void testGuardarXMLClientes() {
		System.out.println("------testGuardarXML-Cliente-------------");
		Cliente ricardo = new Cliente(1321456, "Ricardo Torres", 545154, "calle c");
		Cliente julian = new Cliente(1213, "Julian C", 4455, "calle ce");
		Cliente richard = new Cliente(54456, "Richard T", 54564, "calle cee");
		Cliente edgar = new Cliente(4324, "Edgar B", 4543543, "calle m");
		Cliente julianD= new Cliente(5435435, "Julian D", 5435435, "calle mee");
		
		admin.insertarCliente(ricardo);
		admin.insertarCliente(julian);
		admin.insertarCliente(richard);
		admin.insertarCliente(edgar);
		admin.insertarCliente(julianD);

		admin.guardarArchivosXMLCliente();
	}
	
	@Test	
	void testCargarXMLClientes() {
		admin.cargarArchivoXMLCliente();
	}
	
	//---------------------------------testProductosXML--------------------------
	@Test
	void testGuardarArchivosXML_producto() {
		//--------------------------------------------------------------------
		Producto manzana = new Fruver(1000001, "manzana roja",1000, "D1", true, 20 , "santa Barbara");
		Producto naranja = new Fruver(1000002, "toronja", 500, "exito", true, 30, "Santa Barbara");
		Producto brevas = new Fruver(1000003, "brevas con arequipe", 2000, "jumbo", true, 10, "Santa Barbara");
		//tres productos de Aseo:
		Producto shampoo = new Aseo(1000004, "shampoo ", 15000, "D1","head & shoulders", true, TipoProducto.HOGAR);
		Producto cremaDeDientes = new Aseo(1000005, "crema colgate", 5000, "etsito","colgate", true, TipoProducto.INDUSTRIAL);
		Producto tapabocas = new Aseo(1000006, "cubrebocas", 1000000, "D1", "E3", true, TipoProducto.HOSPITALARIO) ;
		//tres productos genericos
		Producto xbox = new Producto(1000007, "xbox 1", 1500000, "alkosto");
		Producto bolsa = new Producto(1000011, "bolsa plastica", 100, "jumbo");
		Producto carro = new Producto(1000012, "ferrari juguete", 1000, "pepe ganga");
		admin.insertar_un_producto(manzana);
		admin.insertar_un_producto(naranja);
		admin.insertar_un_producto(brevas);
			
		admin.insertar_un_producto(shampoo);
		admin.insertar_un_producto(cremaDeDientes);
		admin.insertar_un_producto(tapabocas);
		
		admin.insertar_un_producto(xbox);
		admin.insertar_un_producto(bolsa);
		admin.insertar_un_producto(carro);
		
		admin.imprimirProductos();
		admin.guardarArchivosXML_producto();
	}
	
	@Test
	void testCargarArchivosXML_producto() {
		admin.cargarArchivosXML_producto();
		admin.imprimirProductos();
	}
	
	
	

}
