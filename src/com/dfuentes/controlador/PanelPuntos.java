/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dfuentes.controlador;

import com.dfuentes.modelo.Arista;
import com.dfuentes.modelo.Aristas;
import com.dfuentes.modelo.Punto;
import com.dfuentes.modelo.Puntos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author David Fuentes
 * Panel que muestra los puntos y las aristas que los unen
 */
public class PanelPuntos extends JPanel {
    
    //referencias a las listas de puntos y aristas
    private Puntos puntos;
    private Aristas aristas;
    
    /**
     * Crea el panel
     * @param puntos lista de puntos a dibujar
     * @param aristas lista de aristas a dibujar
     */
    public PanelPuntos(Puntos puntos, Aristas aristas){
        this.puntos = puntos;
        this.aristas = aristas;
        
        setPreferredSize(new Dimension(400,400));
        setBackground(Color.LIGHT_GRAY);
    }
    /**
     * sobreescribe el metodo paintComponent para dibujar los puntos
     * y las aristas
     */
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        //dibuja los pumtos
        int i =0;
        Punto p;
        while ((p= puntos.punto(i)) !=null) {
        g.drawString(String.valueOf(i), p.x, p.y);
        i ++;         
        }
        
        //dibuja las aristas
        i=0;
        Arista a;
        while ((a=aristas.arista(i)) !=null) {
        g.drawLine(a.ptoIni.x, a.ptoIni.y, a.ptoFin.x ,a.ptoFin.y);
        i ++;
            
        }
    }
}
