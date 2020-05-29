/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import entities.*;
import control.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.sound.midi.Soundbank;
import javax.swing.*;

/**
 * FXML Controller class
 *
 * @author Richard Fonseca
 */
public class ProyectoPOO_interfazgraficaRealController implements Initializable {
	ControlDespachos despacho = new ControlDespachos();
	
    @FXML private TextField prod_name_agregar;
    @FXML private TextField prod_id_agregar;
    @FXML private TextField textFieldReporte;
    @FXML    private TextField prod_price_agregar;
    @FXML    private ListView<Producto> prod_list;
    @FXML    private Label prod_name_mostrar;
    @FXML    private TextField prod_id_mostrar;
    @FXML    private TextField prod_price_mostrar;
    @FXML    private Button prod_agregar;
    @FXML    private Button prod_modificar;
    @FXML    private Button prod_eliminar;
    @FXML    private ListView<Cliente> client_list;
    @FXML    private TextField client_name_agregar;
    @FXML    private TextField client_id_agregar;
    @FXML    private TextField cliente_tel_agregar;
    @FXML    private TextArea cliente_id_mostrar;
    @FXML    private TextArea client_tel_mostrar;
    @FXML    private Label client_name_mostrar;
    @FXML    private Button client_agregar;
    @FXML    private Button client_modificar;
    @FXML    private Button client_eliminar;
    @FXML    private Button pedido_modificar;
    @FXML    private Button pedido_eliminar;
    @FXML    private ChoiceBox<String> pedido_servicios_reservar;
    @FXML    private ChoiceBox<String> pedido_producto_reservar;
    @FXML    private ChoiceBox<String> pedido_servicios_mostrar;
    @FXML    private ChoiceBox<String> pedido_cliente_reservar;
    @FXML    private ChoiceBox<String> pedido_cliente_mostrar;
    @FXML    private ChoiceBox<String> pedido_producto_mostrar;
    @FXML    private Button pedido_reservar;
    @FXML    private ChoiceBox<String> reporte_tipo_buscar;
    @FXML    private ListView<Pedido> reporte_list;
    @FXML    private TextField reporte_tipo;
    @FXML    private Button reporte_buscar;
    @FXML    private DatePicker reporte_fechai;
    @FXML    private DatePicker reporte_fechaf;
    @FXML    private ChoiceBox<String> reporte_producto;

    /**
     * Initializes the controller class.
     */
    @FXML
    void botonAgregarProducto(ActionEvent event ) {
         String nombre = this.prod_name_agregar.getText();
         Long pid = Long.parseLong(this.prod_id_agregar.getText());
         double precio = Double.parseDouble(this.prod_price_agregar.getText());
         Producto productoAux = new Producto(pid, nombre, precio, "D1");
         this.prod_list.getItems().add(productoAux);
         this.llenarInfoProducto();
         AlertUtils.alertMiniInformation("Producto info", "Producto agregado correctamente");
         despacho.guardarArchivosXML_producto();
     }
    @FXML
    void botonAgregarCliente(ActionEvent event) {
    	long cedula = Long.parseLong(this.client_id_agregar.getText());
    	String nombreCompleto = client_name_agregar.getText();
    	long telefonoContacto = Long.parseLong(cliente_tel_agregar.getText());
    	Cliente clienteAux = new Cliente(cedula, nombreCompleto, telefonoContacto, "av Siempre viva");
    	despacho.insertarCliente(clienteAux);
    	this.llenarInfoCliente();
    	AlertUtils.alertMiniInformation("Cliente info", "Clente agregado correctamente");
    	despacho.guardarArchivosXMLCliente();

    }
    
    @FXML
    void modificarProductoB(ActionEvent event) {
    	long id = Long.parseLong(this.prod_id_mostrar.getText());
    	despacho.getMapaProductos().get(id).setPrecio(Double.parseDouble(prod_price_mostrar.getText()));
    	AlertUtils.alertMiniInformation("Producto info", "Producto modificado correctamente");
    	llenarInfoProducto();
    }
    
    @FXML
    void eliminarProductoB(ActionEvent event) {
    	long id = Long.parseLong(this.prod_id_mostrar.getText());
    	despacho.eliminar_un_producto(id);
    	llenarInfoProducto();
    	AlertUtils.alertMiniInformation("Producto info", "Producto eliminado correctamente");
    	
    }	
    
    @FXML
    void botonModificarCliente(ActionEvent event) {
    	long id = Long.parseLong(this.cliente_id_mostrar.getText());

    	despacho.getMapaClientes().get(id).setTelefonoContacto(Long.parseLong(client_tel_mostrar.getText()));
    	AlertUtils.alertMiniInformation("Cliente  info", "Cliente modificado correctamente");
    	llenarInfoCliente();
    }
    @FXML
    void botonEliminarCliente(ActionEvent event) {
    	long id = Long.parseLong(this.cliente_id_mostrar.getText());
    	despacho.getMapaClientes().remove(id, despacho.getMapaClientes().get(id));	
    	llenarInfoCliente();
    	AlertUtils.alertMiniInformation("CLiente info", "Cliente eliminado correctamente");
    }
    
    
    @FXML
    void botonReservarPedido(ActionEvent event) {
    	if(this.pedido_servicios_reservar.getSelectionModel().isSelected(0) ) {
    		AlertUtils.alertMiniInformation("Pedido info", "Reserva hecha con Bono regalo");
    	}
    	else if(this.pedido_servicios_reservar.getSelectionModel().isSelected(1) ) {
    		AlertUtils.alertMiniInformation("Pedido info", "Reserva hecha con envío prime");
    	}
    	else if(this.pedido_servicios_reservar.getSelectionModel().isSelected(2) ) {
    		AlertUtils.alertMiniInformation("Pedido info", "Reserva hecha sin nada");
    	}
    }
    @FXML
    void botonBuscarReporte(ActionEvent event) {
    	AlertUtils.alertMiniInformation("Pedido info", "Busqueda realizada");
    	for(Pedido pedido: despacho.getPedidos()) {
    		reporte_list.getItems().add(pedido);
    	}
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // reporte_tipo_buscar.getItems().add("listado de Pedidos existentes");
        reporte_tipo_buscar.getItems().addAll("Pedidos_existentes",
                "Pedidos para un Producto y una fecha específica",
                "todos los Productos de tipo Fruver",
                "todos los Pedidos asociadas a Producto de Aseo con un determinado tipo",
                "todos los Pedidos en un rango de fechas dado por el usuario",
                "Servicios Adicionales de EnvioPrime asociados a un TipoTransporte particular en el sistema");
        pedido_servicios_reservar.getItems().addAll("Bono regalo", "Envio Prime", "ninguno");
        pedido_servicios_mostrar.getItems().addAll("Bono regalo", "Envio Prime", "ninguno");
        //se agrega el de los archivos
        

        despacho.cargarArchivosXML_producto();
        despacho.cargarArchivosXMLPedidos();
        despacho.cargarArchivoXMLCliente();
        this.llenarInfoProducto();
        this.llenarInfoCliente();
        //----------llenando CheckBoxes con los datos cargados, Producto----------
        
        
        for(Producto producto: despacho.getMapaProductos().values()) {
        	this.pedido_producto_mostrar.getItems().add(producto.getNombreComercial());
        	this.pedido_producto_reservar.getItems().add(producto.getNombreComercial());
        	this.reporte_producto.getItems().add(producto.getNombreComercial());
        }
        for(Cliente cli : despacho.getMapaClientes().values()) {
        	this.pedido_cliente_reservar.getItems().add(cli.getNombreCompleto());
        	this.pedido_cliente_mostrar.getItems().add(cli.getNombreCompleto());
        }
        
        //----------llenando el ListView con los datos cargados, Cliente----------
        
        

        
    }
    
    private void llenarInfoProducto() {
    	this.prod_list.getItems().clear();
    	for(Producto prod : despacho.getMapaProductos().values()) {
    		this.prod_list.getItems().add(prod);
    	}
    }

    private void llenarInfoCliente() {
    	this.client_list.getItems().clear();
    	for(Cliente cli: despacho.getMapaClientes().values()) {
    		this.client_list.getItems().add(cli);
      	}
    }

}
