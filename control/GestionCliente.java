package control;

import control.ControlDespachos;
import entities.Cliente;
import entities.Pedido;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionCliente {
	//----------------6.Ver listado de Clientes registrados en el sistema-----------
	//Recibe una lista de clientes y los imprime por pantalla
	//por medio de la sobrescritura del método toString en la clase CLiente.
	public void verClientes(ArrayList<Cliente> clientes) {
		for(Cliente cliente : clientes) {
			System.out.println(cliente.toString());
		}//rof
	}

	//------------------------------7.Insertar Cliente------------------------------
	//Inserta un cliente y retorna true si sí se ingresó. False de lo contrario.
	public boolean insertarCliente(ArrayList<Cliente> clientes, Cliente clienteAIngresar) {
		for(Cliente cliente: clientes) {
			if(clienteAIngresar.getCedula() == cliente.getCedula()) {
				return false;
			}//fi
		}//rof

		clientes.add(clienteAIngresar);
		return true;
	}

	//-----------------------------8.Modificar Cliente-----------------------------
	//Retorna true si puede modificar un cliente. False de lo contrario.
	public boolean modificarCliente(ArrayList<Cliente> clientes, long cedula) {
		for(Cliente cliente: clientes) {
			if(cliente.getCedula() == cedula) {
				System.out.println(cliente.toString());
				Scanner sc = new Scanner(System.in);

				System.out.println("Que cliente desea modificar?[1,2,3]: ");
				int datoAModificar = sc.nextInt();

				switch (datoAModificar) {
				case 1://Modifica nombre completo
					System.out.println("Ingrese el nombre a modificar: ");
					String nombre = sc.next();
					cliente.setNombreCompleto(nombre);
					break;
				case 2://Modifica teléfono de contacto
					System.out.println("Ingrese el telefono a modificar: ");
					long telefono = sc.nextLong();
					cliente.setTelefonoContacto(telefono);
					break;
				case 3://modifica dirección
					System.out.println("Ingrese la direccion a modificar: ");
					String direccion = sc.next();
					cliente.setDireccion(direccion);
					break;
				default:
					System.out.println("dato incorrecto, vuelva a intentar.");
					break;
				}

				return true;
			}//fi
		}//rof

		System.out.println("El cliente no se encuentra registrado.");
		return false;
	}
	//---------------------------9.Eliminar Cliente------------------------------
	//Retorna true si se pudo eliminar un cliente. False de lo contrario.
	public boolean eliminarCliente(ArrayList<Cliente> clientes, ArrayList<Pedido> pedidos, long cedulaAEliminar) {
		// El siguiente for verifica que no haya un pedido asociado a un cliente
		for(Pedido pedido : pedidos){
			if(pedido.getSolicitante().getCedula() == cedulaAEliminar) {
				System.out.println("El cliente esta asociado a un pedido. No se puede eliminar.");
				return false;
			}//fi
		}//rof

		//En caso de que lo anterior no pase, procedemos a
		//buscar la cédula en la lista de clientes con el siguiente for
		for(Cliente cliente : clientes) {
			if(cliente.getCedula() == cedulaAEliminar) {
				Scanner sc = new Scanner(System.in);

				System.out.println("Seguro de querer eliminar el cliente?[S,N]: ");
				String respuesta = sc.next();

				switch (respuesta) {
				case "s":
					clientes.remove(cliente);
					System.out.println("Cliente eliminado exitosamente.");
					break;
				case "S":
					clientes.remove(cliente);
					System.out.println("Cliente eliminado exitosamente.");
					break;
				default:
					break;
				}
			}//fi
		}//rof

		System.out.println("Cliente no encontrado.");
		return false;

	}
}
