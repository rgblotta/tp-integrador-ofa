/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frsf.ofa.cursojava.tp.integrador.modelo;

import java.util.List;

/**
 *
 * @author mdominguez
 */
public class Autor {
    private Integer id;
    private String nombre;
    private List<Receta> recetasCreadas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Receta> getRecetasCreadas() {
        return recetasCreadas;
    }

    public void setRecetasCreadas(List<Receta> recetasCreadas) {
        this.recetasCreadas = recetasCreadas;
    }
    
    
}
