package boundary;

import control.*;
import entities.*;
import java.util.Calendar;
import java.util.Scanner;

public class PantallaDespacho {
	ControlDespachos despacho = new ControlDespachos();
	Producto arroz = new Producto(4324231, "Arroz", 1800, "Tienda Geminis");
	Producto lenteja = new Producto(3215432, "Lenteja", 1900, "D1");
	Cliente ricardo = new Cliente(8908023, "Ricardo Arjona", 4342343, "sfdsfsd");
	//testeando punto 10
	despacho.reservarPedido(ricardo.getCedula(), 1113, arroz);
	despacho.reservarPedido(ricardo.getCedula(), 1114, lenteja);
	//testeando punto 11
	despacho.ModificarDatosDeUnPedido(1113);//va en minúscula
	//testeando punto 12
	despacho.eliminarReservaDeUnPedido (1113);
	//testeando punto 13
	despacho.VerListadoDePedidosExistentes();//minúscula
	//testeando punto 14
	despecho.listadoPedidos (1114, new GregorianCalendar(2020,3,30));
	
	
}

/*
Buenas tardes a todos,

Por favor nadie toque este espacio en su rama, este espacio solo es
modificable en la rama master, es decir, la rama final de todo el proyecto.

Julian,

*/
