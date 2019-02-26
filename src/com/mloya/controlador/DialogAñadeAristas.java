/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mloya.controlador;

import static com.sun.glass.ui.Cursor.setVisible;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author MARIA LOYA
 * Dialogo que permite introducir las aristas a añadir
 */

public class DialogAñadeAristas extends JDialog{
    
    //Botones
    private JButton bAceptar = new JButton("Aceptar");
    private JButton bOtroPto = new JButton("Otro Punto");
    
    //Campos de texto y etiquetas: su número no es fijo, ya que se
    //pueden crear con el boton bOtroPto
    private LinkedList<JTextField> camposTexto = new LinkedList<JTextField>();
    private LinkedList<JLabel> etiquetas = new LinkedList<JLabel>();
    
    //Almacena los puntos introducidos en el dialogo y retornados
    //a la ventana principal
    private int[] puntos = null;
    
    /**
     * Constructor
     */
    public DialogAñadeAristas(JFrame owner){
        super(owner, "Introduce aristas",true);
        
        setLayout(new GridLayout(0,2));
        
        //Crea los campos de texto y las etiquetas de los 2 primeros
        //puntos
        camposTexto.add(new JTextField());
        etiquetas.add(new JLabel("Punto 0"));
        camposTexto.add(new JTextField());
        etiquetas.add(new JLabel("Punto 1"));
        
        //Distribuye componentes
        add(bAceptar);
        add(bOtroPto);
        add(etiquetas.get(0));
        add(camposTexto.get(0));
        add(etiquetas.get(1));
        add(camposTexto.get(1));
        
        //Añade Manejadores
        bAceptar.addActionListener(new ManejadorBotonAceptar());
        bOtroPto.addActionListener(new ManejadorBotonOtroPunto());
        
        //Fin de la configuración del dialogo
        pack();
        setResizable(false);   
    }
    /**
     * Muestra el dialogo
     * @return puntos introducidos o null si el usuario cancela el
     * dialogo
     */
    public int[] muestra(){
        //pone los puntos a null. Se cambia su valor en el manejador
        //del boton aceptar.
        puntos=null;
        
        //hace visible el diálogo
        setVisible(true);
        
        //elimina posibles campos de texto creados por el usuario para
        //que la siguiente vez que aparezca el dialogo solo tenga dos
        while(camposTexto.size() > 2){
            remove(camposTexto.removeLast());
            remove(etiquetas.removeLast());
        }
        pack(); //ajusta el dialogo a los nuevos componentes
        
        //cuando se cierra los puntos introducidos están en "puntos"
        return puntos;
    }
    /**
     * Manejador del boton aceptar
     */
    private class ManejadorBotonAceptar implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            puntos= new int[camposTexto.size()];
            int i=0;
            try {
                for(i=0; i<camposTexto.size(); i++)
                puntos[i]=Integer.parseInt(camposTexto.get(i).getText());
            } catch (NumberFormatException except) {
                //tratamiento de errores (no exigido en el examen)
                puntos=null;
                JOptionPane.showMessageDialog(null, "Error en punto" +i,"Error en los datos",JOptionPane.ERROR_MESSAGE);
                return; //No hace visible el dialogo
            }
            setVisible(false);
        }
                
    }
    /**
     * Manejador del boton otro punto
     */
    private class ManejadorBotonOtroPunto implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){
            //añade otra etiqueta y otro campo de texto
            JLabel l= new JLabel ("Punto "+camposTexto.size());
            etiquetas.add(l);
            JTextField tf = new JTextField();
            camposTexto.add(tf);
            add(tf);
            
            //ajusta el tamaño del dialogo para que se vean los
            //nuevos componentes
            pack();   
        }           
    }    
}
