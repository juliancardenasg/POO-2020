package test;

import entities.*;
import control.*;
import boundary.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestDespacho {
	
	ControlDespacho admin;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		/*private HashMap<Long, Cliente> mapaClientes = new HashMap<Long, Cliente>();
	    private HashMap<Long, Producto> mapaProductos = new HashMap<Long, Producto>();
	    private ArrayList<Pedido> pedidos = new ArrayList <>();
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
	    
	  		Cliente ricardo = new Cliente(1321456, "Ricardo Torres", 545154, "calle c");
			Cliente julian = new Cliente(1213, "Julian C", 4455, "calle ce");
			Cliente richard = new Cliente(54456, "Richard T", 54564, "calle cee");
			Cliente edgar = new Cliente(4324, "Edgar B", 4543543, "calle m");
			Cliente julianD= new Cliente(5435435, "Julian D", 5435435, "calle mee");
			
			mapaClientes.put(1321456,ricardo);
			mapaClientes.put(1213,julian);
			mapaClientes.put(54456,richard);
			mapaClientes.put(4324,edgar);
			mapaClientes.put(435435,julianD);*/
	    
		
		//Sabemos que la manera correcta de hacer los test, es declarar los objetos de prueba en este espacio.
		//Habia problemas y no detactaba las colecciones
		//Por esta razon decidimos implementar cada objeto dentro de cada test
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	
	@Test
	 void testExistePedido () {
		Pedido pedido1;
		pedido1.setNumeroPedido = 83847;
		pedidos.add(pedido1);
		assertTrue(existePedido(83847) == true, "Prueba funciona correctamente");
		fail("Prueba fallida");

	}

	 

	 

	 @Test
	 void testAutoGenerarPedido () {
	 assertTrue(autoGenerarPedido(1000718536, 9876), "Prueba funciona correctamente");
	 assertFalse(autoGenerarPedido(1000718536, 1000), "Prueba funciona correctamente");
	 fail("Prueba fallida");

	}

	 

	 

	 @Test
	 void testValidacionPedido () {
	 Pedido pedido1;
	 pedido1.setNumeroPedido = 83847;
	 pedido1.setFechaRecibido = 05/05/2020;
	 assertTrue(validacionDePedido(pedido1), "Prueba funciona correctamente");
	 pedido1.setNumeroPedido = 02020;
	 pedido1.setFechaRecibido = 12/12/2020;
	 assertFalse(validacionDePedido(pedido1), "Prueba funciona correctamente");
	 fail("Prueba fallida");

	}

	 

	 

	 @Test
	 void testValidacionPedido2 () {
	 Pedido pedido1;
     pedido1.setNumeroPedido = 83847;
	 pedido1.setFechaRecibido = 05/05/2020;
	 assertTrue(validacionDePedido2(pedido1), "Prueba funciona correctamente");
	 fail("Prueba fallida");

	 }
	 
	 @Test
	 public void costoPedido()throws Exception {
     double res=0;
		Cliente richard = new Cliente(54456, "Richard T", 54564, "calle cee");
		Producto manzana = new Fruver(1000001, "manzana roja",1000, "D1", true, 20 , "santa Barbara");
		Pedido p1=new Pedido(10,Calendar.getInstance(), true, "Pepe",richard,manzana);
		res=admin.costoPedido(54456,1000001,manzana);//long cedula, long pid, Producto producto
		 assertEquals(1000, res, 1e-8);
	        System.out.println("LOGRADO CostoPedido");
	        assertEquals(5.5d, res, 1e-8);
	        System.out.println("NO LOGRADO CostoPedido");
	}

	@Test
	public void verListadodePedidosParaProductoyFecha() throws Exception {
		int res=admin.verListadodePedidosParaProductoyFecha(230,Calendar.getInstance()); //long pid, Calendar fecha
		 assertEquals(1, res);
		System.out.println("LOGRADO");
		 assertEquals(3, res);
		 System.out.println("NO LOGRADO");
	}

	@Test
	public void productosFruver() throws Exception {
		 assertEquals(3, admin.productosFruver().size());
		 System.out.println("LOGRADO");
		 assertEquals(1, admin.productosFruver().size());
		 System.out.println("NO LOGRADO");
	}

	@Test
	public void pedidosAseo() throws Exception {
		 assertEquals(3, admin.pedidosAseo().size());
		 System.out.println("LOGRADO");
		 assertEquals(1, admin.productosFruver().size());
		 System.out.println("NO LOGRADO");
	}

	@Test
	public void precioPedidosDeAseoPorTipo()throws Exception{
		Producto shampoo = new Aseo(0000004, "shampoo ", 15000, "D1","head & shoulders", true, TipoProducto.HOGAR);
  		Producto cremaDeDientes = new Aseo(0000005, "crema colgate", 5000, "etsito","colgate", true, TipoProducto.INDUSTRIAL);
  		Producto tapabocas = new Aseo(0000006, "cubrebocas", 1000000, "D1", "E3", true, TipoProducto.HOSPITALARIO) ;
		double res;
		assertEquals(5.5d, res, 1e-8);
		 System.out.println("LOGRADO");
		 assertEquals(5.5d, res, 1e-8);
		 System.out.println("NO LOGRADO");
	}
	
	//--//
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
	
	@Test
    public void precioPedidosDeAseoPorTipo()throws Exception{
        Producto shampoo = new Aseo(0000004, "shampoo ", 15000, "D1","head & shoulders", true, TipoProducto.HOGAR);
          Producto cremaDeDientes = new Aseo(0000005, "crema colgate", 5000, "etsito","colgate", true, TipoProducto.INDUSTRIAL);
          Producto tapabocas = new Aseo(0000006, "cubrebocas", 1000000, "D1", "E3", true, TipoProducto.HOSPITALARIO) ;
          Cliente richard = new Cliente(54456, "Richard T", 54564, "calle cee");
          Pedido p1=new Pedido(10,Calendar.getInstance(),TRUE,"Pepe",richard,shampoo);
        double res;
        assertEquals(15000, res, 1e-8);
         System.out.println("LOGRADO");
         assertEquals(5.5d, res, 1e-8);
         System.out.println("NO LOGRADO");
    }

}
