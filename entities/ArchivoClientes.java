package entities;

import java.util.HashMap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "RegristroClientes")
public class ArchivoClientes {
	
	@XmlElement(name = "Cliente")
	private HashMap<Long, Cliente> clientes = new HashMap<Long, Cliente>();

	public HashMap<Long, Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(HashMap<Long, Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArchivoClientes(HashMap<Long, Cliente> clientes) {
		this.clientes = clientes;
	}
	public ArchivoClientes() {}

}
