/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dfuentes.modelo;

import java.util.ArrayList;

/**
 *
 * @author David Fuentes
 */
public class Aristas {
   private ArrayList<Arista> aristas = new ArrayList<Arista>();
   
   /**
    * Añade una arista
    * @param a arista a añadir
    */
   public void añade(Arista a){
       aristas.add(a);
   }
   
   /**
    * Retorna la arista i-ésima
    * @param i posisción de la arista en la lista
    * @return arista i-ésima o null si la posición no es válida
    */
   public Arista arista(int i){
       if(i<0 || i>=aristas.size())
           return null;
       return aristas.get(i);
   }  
}
