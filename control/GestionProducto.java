package control;

import entities.Producto;
import entities.Pedido;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Scanner;
public class GestionProductos {


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

/*
Buenas tardes,

Ya cree los tres diferentes espacios de trabajo (tres branches/ramas), distribuidos asi para Producto:
Nombre del responsable: Ricardo Sebastian T

Tener en cuenta lo siguiente:
- Si usted va a hacer cambios tanto en la entidad (Producto) como en el control
(GestionProducto) solo hacer commits en esta rama: "producto", y cuando tenga
la version final (ultimo commit), avisar a Julian para que el haga el respectivo
merge a la rama final (master). Haga cuantos commits desee, pero no olvide
comentar cada uno de ellos. En resumen, haga los cambios en su repo local, hasta
que tenga la versión final de esta rama, no avisar.
- Comunicación por el grupo de Whatsapp para cualquier cosa.
- Si tiene alguna duda acerca de Git o GitHub, no dude con contactarme, yo le
ayudo a configurar su repositorio local al remoto y viceversa.
- Tenga en cuenta el buen manejo de los commits.
- Como mencione anteriormente, solo gestione y edite sus dos correspondientes
archivos, despues todos nos encargamos de fusionar y hacer los respectivos
cambios.
- Fecha de entrega de esta rama (producto): Viernes 27 de Marzo
- No borrar estos comentarios


Julian,


*/
