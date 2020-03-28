package boundary;
import entities.Pedido;
import entities.Cliente;
import entities.Producto;
import control.ControlDespachos;
import control.GestionCliente;
import control.GestionProducto;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class PantallaDespacho {

	public static void main(String[] args) {


		System.out.println("(1) Ver listado de Productos disponibles");
		System.out.println("(2) Insertar Productos");
		System.out.println("(3) Modificar Productos");
		System.out.println("(4) Eliminar Productos");
		System.out.println("(5) Ver listado de Clientes registrados en el sistema");
		System.out.println("(6) Insertar Cliente");
		System.out.println("(7) Modificar datos de Cliente");
		System.out.println("(8) Eliminar un Cliente");
		System.out.println("(9) Realizar el Pedido de un Producto");
		System.out.println("(A) Modificar un Pedido de un Producto");
		System.out.println("(B) Eliminar un Pedido de un Producto");
		System.out.println("(C) Ver listado de Pedidos existentes");
		System.out.println("(D) Ver listado de Pedidos existentes para un Producto y posterior a una fecha específica");
		System.out.println("(E) Salir");

        Scanner sc = new Scanner(System.in);
        char opcion_principal = sc.next().charAt(0);

        switch(opcion_principal) {
        case 1:
          // code block
          break;
        case 2:
          // code block
          break;
        case 3:
            // code block
            break;
        case 4:
            // code block
            break;
        case 5:
            // code block
            break;
        case 6:
            // code block
            break;
        case 7:
            // code block
            break;
        case 8:
            // code block
            break;
        case 9:
            System.out.println("Bienvenido a el menu para realizar su pedido");
            break;
        case 'A':
            // code block
            break;
        case 'B':
            // code block
            break;
        case 'C':
            // code block
            break;
        case 'D':
            // code block
            break;
        case 'E':
            // code block
            break;


        default:
          // code block
      }

	}
	}
