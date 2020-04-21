package control;

import entities.Producto;
import entities.Pedido;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionProducto {


	public void imprimirProductos(ArrayList<Producto> listaProductos)
	{
		for(Producto aux_prod: listaProductos )
		{
			System.out.println(aux_prod.toString());
		}
	}


	public boolean insertar_un_producto(ArrayList<Producto> listaProductos,long pid, String nombreComercial,double precio, String tienda)
	{
		int index = getIndexProducto(listaProductos,pid);
		if(index ==-1)
		{
			
			if( pid>=100000 && pid <= 9999999)
			{
				Producto nuevo_producto = new Producto();
				nuevo_producto.setPid(pid);
				nuevo_producto.setNombreComercial(nombreComercial);
				nuevo_producto.setPrecio(precio);
				nuevo_producto.setTienda(tienda);
				nuevo_producto.setIva(precio);
				listaProductos.add(nuevo_producto);
				return true;
				
			}
			else
				return false;

		}
		else
			return false;

	}

	public boolean modificar_un_producto(ArrayList<Producto> listaProductos,long pid)
	{
		int index = getIndexProducto(listaProductos,pid);
		Scanner sc = new Scanner(System.in);
		
        if(index != -1){
        	System.out.println("que desea modificar?");
        	listaProductos.get(index).toString();
        	System.out.println("\n:");
        	int opcion = sc.nextInt();
        	switch(opcion)
        	{
        	case 1:
        		System.out.println("\ndeme el nuevo nombre del producto:");
        		String nombreComercial = sc.next();
        		listaProductos.get(index).setNombreComercial(nombreComercial);
        		break;
        	case 2:
        		System.out.println("\ndeme el nuevo precio del producto:");
        		double precio = sc.nextDouble();
        		listaProductos.get(index).setPrecio(precio);
        		listaProductos.get(index).setIva(precio);
        		break;
        	case 3:
        		System.out.println("\ndeme el nombre de la nueva tienda:");
        		String tienda = sc.next();
        		listaProductos.get(index).setTienda(tienda);
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

	public boolean eliminar_un_producto(ArrayList<Producto> listaProductos,long pid_de_baja, ArrayList<Pedido> pedidos)
	{
		int index = getIndexProducto(listaProductos,pid_de_baja);
		for(Pedido pedido : pedidos)
		{
			if(pedido.getProductoSolicitado().getPid() == pid_de_baja)
			{
				return false;
			}
		}
		listaProductos.remove(index);
		return true;
	}


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




}