package entities;

import java.util.HashMap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "RegistroProductos")
public class ArchivoProductos {
	@XmlElement(name = "Producto")
	private HashMap<Long, Producto> productos = new HashMap<Long, Producto>();

	public HashMap<Long, Producto> getProductos() {
		return this.productos;
	}
	public void setProductos(HashMap<Long, Producto> productos) {
		this.productos = productos;
	}
	public ArchivoProductos(HashMap<Long, Producto> productos) {
		this.productos = productos;
	}
	public ArchivoProductos() {}
	

}
