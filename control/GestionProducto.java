package control;

import entities.Producto;
import entities.Pedido;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class GestionProducto {

	public void imprimirProductos(HashMap<Long, Producto> mapaProductos)
	{
		if(!mapaProductos.isEmpty()) {
			for(long claveProducto: mapaProductos.keySet() ){
				System.out.println(mapaProductos.get(claveProducto).toString());
			}
		}
	}


	public boolean insertar_un_producto(HashMap<Long, Producto> mapaProductos, Producto producto)
	{
		
		//int index = getIndexProducto(listaProductos,pid);
		long pid = producto.getPid();
		
		if(mapaProductos.get(pid) == null)
		{
			String pidStr = Long.toString(pid);
			if( pidStr.length() == 7)
			{
				mapaProductos.put(pid,producto);
				return true;

			}
			else
				return false;

		}
		return false;
			
	}

	public boolean modificar_un_producto(HashMap<Long, Producto> mapaProductos,long pid)
	{
		//int index = getIndexProducto(listaProductos,pid);
		Scanner sc = new Scanner(System.in);

        if(mapaProductos.get(pid) != null){
        	Producto productoTemp =mapaProductos.get(pid) ;  
        	
        	System.out.println("que desea modificar?");
        	
        	productoTemp.toString();
        	
        	System.out.println("\n:");
        	int opcion = sc.nextInt();
        	switch(opcion)
        	{
        	case 1:
        		System.out.println("\ndeme el nuevo nombre del producto:");
        		String nombreComercial = sc.next();
        		productoTemp.setNombreComercial(nombreComercial);
        		break;
        	case 2:
        		System.out.println("\ndeme el nuevo precio del producto:");
        		double precio = sc.nextDouble();
        		productoTemp.setPrecio(precio);
        		productoTemp.setIva(precio);
        		break;
        	case 3:
        		System.out.println("\ndeme el nombre de la nueva tienda:");
        		String tienda = sc.next();
        		productoTemp.setTienda(tienda);
        		break;
        	default:
        		System.out.println("\nopcion invalida");
        		break;

        	}

        	return true;
        }
        else
        	return false;

	}

	public boolean eliminar_un_producto(HashMap<Long,Producto> mapaProductos,long pid_de_baja, ArrayList<Pedido> pedidos)
	{
		if(mapaProductos.get(pid_de_baja) != null) {
			for(Pedido pedido: pedidos) {
				if(pedido.getProductoSolicitado() == mapaProductos.get(pid_de_baja)) {
					return false;
				}
				mapaProductos.remove(pid_de_baja);
				return true;	
			}
		}
		return false;
	}

/*
    private int getIndexProducto (ArrayList<Producto> listaProductos,long idProducto)
    {
        for (int i = 0; i < listaProductos.size() ; i++)
        {
            if(listaProductos.get(i).getPid() == idProducto )
            {
                 return i;
            }
        }
        return -1;
    }
*/



}
