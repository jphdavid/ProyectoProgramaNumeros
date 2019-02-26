/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mloya.controlador;

import com.mloya.modelo.Arista;
import com.mloya.modelo.Aristas;
import com.mloya.modelo.Puntos;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author MARIA LOYA
 */
public class VentanaPuntos extends JFrame{
    private Puntos puntos = new Puntos();
    private Aristas aristas = new Aristas();
    
    //componentes
    private JButton bAñadeAristas = new JButton("AñadeAristas");
    private PanelPuntos panelPuntos = new PanelPuntos(puntos,aristas);
    
    //Dialogo para añadir aristas
    private DialogAñadeAristas dialogoAñadeAristas = new DialogAñadeAristas(this);
    
    public VentanaPuntos() {
        super ("Une Puntos");
       
        //Distribuye componentes
        //Panel en el Centro
        add(panelPuntos, BorderLayout.CENTER);
        //Boton en el sur dentro de un flow
        JPanel pB = new JPanel(new FlowLayout());
        pB.add(bAñadeAristas);
        add(pB, BorderLayout.SOUTH);
        
        //añade manejadores
        bAñadeAristas.addActionListener(new manejadorBotonAñade());
        
        //finaliza configuración de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);   
    }
    
        /**
        * Manejador del boton que permite añadir aristas
        *
        */
        private class manejadorBotonAñade implements ActionListener{   
        
        @Override
        public void actionPerformed(ActionEvent e) {                                                
        //Muestra el Dialogo
        int[] ptos = dialogoAñadeAristas.muestra();
        
        //Si se retorna null es porque el usuario
        //Dialogo o ha ocurrido algun otro problema
        if(ptos !=null){
         for(int i=0; i<ptos.length; i++)
             //añade cada arista
             aristas.añade(new Arista (puntos.punto(ptos[i]),puntos.punto(ptos[i+1])));
             
         //repinta el Panel
         panelPuntos.repaint();
        }
       } 
    }  
       /**
        * Metodo main. Crea la ventana principal de la aplicación 
        */
        public static void main(String[] args) {
        new VentanaPuntos();
    }
}
