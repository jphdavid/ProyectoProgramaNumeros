/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dfuentes.modelo;

/**
 *
 * @author David Fuentes
 * Arista que une dos puntos
 */
public class Arista {
    public Punto ptoIni; //Punto Inicial de la arista
    public Punto ptoFin; //Punto Final de la arista
    
    public Arista(Punto ptoIni, Punto ptoFin){
        this.ptoIni= ptoIni;
        this.ptoFin= ptoFin;
    }   
}
