package entities;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "RegristroPedidos")
public class ArchivoPedido {
	@XmlElement(name = "Pedido")
	
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

	public ArchivoPedido(ArrayList<Pedido> pedidos) {
		super();
		this.pedidos = pedidos;
	}
	public ArchivoPedido() {}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	

}
