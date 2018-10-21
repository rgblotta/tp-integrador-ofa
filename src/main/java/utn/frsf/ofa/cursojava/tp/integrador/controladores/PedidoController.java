/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frsf.ofa.cursojava.tp.integrador.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.DualListModel;
import utn.frsf.ofa.cursojava.tp.integrador.modelo.Pedido;
import utn.frsf.ofa.cursojava.tp.integrador.modelo.Receta;
import utn.frsf.ofa.cursojava.tp.integrador.servicio.PedidoService;
import utn.frsf.ofa.cursojava.tp.integrador.servicio.RecetaService;

/**
 *
 * @author User
 */
@SessionScoped
@Named("pedidoController")
public class PedidoController implements Serializable{
    
    @Inject 
    private PedidoService servicioPedidos;
     
    private Pedido pedidoSeleccionado;
    private List<Pedido> listaPedidos;
    private List<Receta> recetasSeleccionadas;
    private Receta unaReceta;
 
    private DualListModel<Receta> recetasDisponibles ;
            
    
    @PostConstruct
    public void init(){
        //this.pedidoSeleccionado = null;
        //this.listaPedidos = servicioPedidos.listar();
        //------------------
        
        this.pedidoSeleccionado = new Pedido();
        this.listaPedidos = servicioPedidos.listar();
        
        this.recetasDisponibles = new DualListModel<Receta>();
        this.recetasDisponibles.setSource(recetasSeleccionadas);
        
        this.recetasSeleccionadas = new ArrayList<Receta>();
    }
    
    public Pedido getPedidoSeleccionado() {
        return pedidoSeleccionado;
    }

    public void setPedidoSeleccionado(Pedido pedidoSeleccionado) {
        this.pedidoSeleccionado = pedidoSeleccionado;
        this.pedidoSeleccionado.setRecetasPedidas(servicioPedidos.recetasPorIdPedido(pedidoSeleccionado.getIdPedido()));
        this.recetasDisponibles.setTarget(pedidoSeleccionado.getRecetasPedidas());
    }
    
    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }
    
    
    public String guardar(){
        // guardar el nuevo Pedido 
        
        //setea las Recetas Seleccionadas
        this.pedidoSeleccionado.setRecetasPedidas(recetasSeleccionadas);
        
        Pedido tmp = this.servicioPedidos.guardar(pedidoSeleccionado);      
        this.listaPedidos.add(tmp);
        
        //roxxxx    this.pedidoSeleccionado.getRecetasPedidas();
        //this.pedidoSeleccionado.setIngredientes(this.ingredientesDisponibles.getTarget());
        
        this.pedidoSeleccionado = null;
        return null;
    }
    
    private void agregarReceta (Receta recetaSel){
        this.recetasSeleccionadas.add(recetaSel);
    }
    
    public Receta getUnaReceta() {
        return this.unaReceta;
    }

    public void setUnaReceta(Receta _unaReceta) {
        this.unaReceta = _unaReceta;
        this.agregarReceta(_unaReceta);
    }
    
    public String nuevo(){      
    //    this.pedidoSeleccionado = new Pedido();
    //    this.pedidoSeleccionado.setRecetasPedidas(new ArrayList<>());
        return null;
    }    
}
