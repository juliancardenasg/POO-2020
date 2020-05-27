package control;


import control.ControlDespachos;
import entities.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.xml.bind.JAXB;

public class GestionCliente {
	//----------------6.Ver listado de Clientes registrados en el sistema-----------
	//Recibe una lista de clientes y los imprime por pantalla
	//por medio de la sobrescritura del método toString en la clase CLiente.
	public void verClientes(HashMap<Long, Cliente> mapaClientes) {
		if(!mapaClientes.isEmpty()) {
			for(long cedulaCliente: mapaClientes.keySet()) {
				System.out.println(mapaClientes.get(cedulaCliente).toString());
			}//rof	
		}//fi
	}

	//------------------------------7.Insertar Cliente------------------------------
	//Inserta un cliente y retorna true si sí se ingresó. False de lo contrario.
	public boolean insertarCliente(HashMap<Long, Cliente> mapaClientes, Cliente clienteAIngresar) {
		long cedula = clienteAIngresar.getCedula();
		if(mapaClientes.get(cedula) == null) {
			mapaClientes.put(cedula,clienteAIngresar);
			return true;	
		}//fi
		return false;
	}

	//-----------------------------8.Modificar Cliente-----------------------------
	//Retorna true si puede modificar un cliente. False de lo contrario.
	public boolean modificarCliente(HashMap<Long,Cliente> mapaClientes, long cedula) {
		if(!mapaClientes.isEmpty()) {
			if(mapaClientes.get(cedula) != null) {
				Cliente clienteAModificar =mapaClientes.get(cedula); 
				System.out.println(clienteAModificar.toString());
				Scanner sc = new Scanner(System.in);

				System.out.println("Que dato desea modificar?\n1-nombre\n2-telefono\n3-direccion: ");
				int datoAModificar = sc.nextInt();
				switch (datoAModificar) {
				case 1://Modifica nombre completo
					System.out.println("Ingrese el nombre a modificar: ");
					String nombre = sc.next();
					clienteAModificar.setNombreCompleto(nombre);
					break;
				case 2://Modifica teléfono de contacto
					System.out.println("Ingrese el telefono a modificar: ");
					long telefono = sc.nextLong();
					clienteAModificar.setTelefonoContacto(telefono);
					break;
				case 3://modifica dirección
					System.out.println("Ingrese la direccion a modificar: ");
					String direccion = sc.next();
					clienteAModificar.setDireccion(direccion);
					break;
				default:
					System.out.println("dato incorrecto, vuelva a intentar.");
					break;
				}//hctiws

					return true;
			}//fi

			System.out.println("El cliente no se encuentra registrado.");
			return false;
		}//fi
		return false;
	}
	//---------------------------9.Eliminar Cliente------------------------------
	//Retorna true si se pudo eliminar un cliente. False de lo contrario.
	public boolean eliminarCliente(HashMap<Long,Cliente> mapaClientes, ArrayList<Pedido> pedidos, long cedulaAEliminar) {
		// El siguiente for verifica que no haya un pedido asociado a un cliente
		
		//buscamos si existe un cliente en la lista de clientes con la cédula dada:
		Cliente clienteBuscado = mapaClientes.get(cedulaAEliminar);
		
		for(Pedido pedido : pedidos){
			if(pedido.getSolicitante() == clienteBuscado) {
				System.out.println("El cliente esta asociado a un pedido. No se puede eliminar.");
				return false;
			}//fi
		}//rof

		if(clienteBuscado != null) {
			Scanner sc = new Scanner(System.in);

			System.out.println("Seguro de querer eliminar el cliente?[S,N]: ");
			String respuesta = sc.next();

			switch (respuesta) {
			case "s":
				mapaClientes.remove(clienteBuscado);
				System.out.println("Cliente eliminado exitosamente.");
				break;				
			case "S":
				mapaClientes.remove(clienteBuscado);
				System.out.println("Cliente eliminado exitosamente.");
				break;
			default:
				break;
			}
			return true;
		}		
		System.out.println("Cliente no encontrado, o no eliminado.\n");
		return false;

	}
	

	
}

