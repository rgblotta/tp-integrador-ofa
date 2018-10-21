/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frsf.ofa.cursojava.tp.integrador.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author R.Blotta
 */
@Entity
public class Pedido implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;
    private String direccionEnvio;
   
    @Temporal(TemporalType.DATE)
    private Date fechaPedido;
        
    // mapeo de relacion
    @ManyToMany
    @JoinTable(name="PEDIDO_RECETA",
            joinColumns=@JoinColumn(name="ID_PEDIDO"),
            inverseJoinColumns=@JoinColumn(name="ID_RECETA"))
    private List<Receta> recetasPedidas;

    
    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

     public Date getFechaPedido() {
        return fechaPedido;
    }
      
    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }
    
    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }
    
    public List<Receta> getRecetasPedidas() {
        return recetasPedidas;
    }

    public void setRecetasPedidas(List<Receta> recetasPedidas) {
        this.recetasPedidas = recetasPedidas;
    }

}
