/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frsf.ofa.cursojava.tp.integrador.servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import utn.frsf.ofa.cursojava.tp.integrador.modelo.Pedido;
import utn.frsf.ofa.cursojava.tp.integrador.modelo.Receta;

/**
 *
 * @author User
 */
@Stateless
public class PedidoService {
    @PersistenceContext(unitName = "RECETAS_PU")
    private EntityManager em;

    public Pedido guardar(Pedido a){
        if(a.getIdPedido() !=null && a.getIdPedido() >0 ) {
           return em.merge(a);
        }
        em.persist(a);
        em.flush();
        em.refresh(a);
        return a;
        }
    
    public List<Pedido> listar(){
        return em.createQuery("SELECT a FROM Pedido a").getResultList();   
    }
    
    public List<Receta> recetasPorIdPedido(Integer id){
        return em.createQuery("SELECT r FROM Pedido p JOIN p.recetasPedidas r WHERE p.idPedido = :P_ID_PEDIDO")
                .setParameter("P_ID_PEDIDO", id)
                .getResultList();
    }
    //    public List<Ingrediente> ingredientesPorIdReceta(Integer id){
    //     return em.createQuery("SELECT i FROM Receta r JOIN r.ingredientes i WHERE r.id = :P_ID_RECETA")
    //            .setParameter("P_ID_RECETA", id)
    //            .getResultList();
}
