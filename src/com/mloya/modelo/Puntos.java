/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mloya.modelo;

import java.util.ArrayList;

/**
 *
 * @author MARIA LOYA
 * Lista con todos los puntos existentes
 */
public class Puntos {
    private ArrayList<Punto> puntos = new ArrayList<Punto>();

    
    /* Crea una lista de Puntos*/
    public Puntos() {
    }
    
    /**
     * Retorna el punto que ocupa la posición i-ésima en la lista
     * @param i posición del punto en la lista
     * @return el i-ésimo punto o null en caso de que
     * el valor de i no corresponda a ningún punto
     */
    public Punto punto(int i){
        if(i<0 || i>=puntos.size())
            return null;
        return puntos.get(i);
    }  
}
