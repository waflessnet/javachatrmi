/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javachatrmi.ventana;
import java.awt.BorderLayout;


import javax.swing.*;



/**
 *
 * @author waflessnet
 */
public class Ventana {
    
    /* panel superior */
    private final JPanel jpSuperior;
    /* panel superior */
    private final JPanel jpInferior;
    /* panel superior */
    private JPanel jpDerecha;
    /* panel superior */
    private final JPanel jpIzquerda;
    
    public static JEditorPane editor;
    
    public Ventana(){
        PanelSuperior panelSuperior = new PanelSuperior();
        this.jpSuperior = panelSuperior.getPanel();
        PanelInferior panelInferior = new PanelInferior();
        this.jpInferior  = panelInferior.getPanel();
        PanelIzquerda panelIzquerda = new PanelIzquerda();
        this.jpIzquerda = panelIzquerda.getPanel();
        
        this.ConstruyeTodo();
        
        
        
      
    }
    private void ConstruyeTodo(){
        JFrame ventana = new JFrame("*** Chat con JAVA RMI *** ");
        //panel del centro ;
        Ventana.editor = new JEditorPane();
        Ventana.editor.setContentType("text/html");
        Ventana.editor.setText("<b><font face='arial'> *** DEEP WEB CHACALITO *** </font> </b>");
        //Ventana.editor.setEnabled(false);
        // agregamos los paneles 
        ventana.setLayout(new BorderLayout());
        ventana.add(Ventana.editor, BorderLayout.CENTER);
        ventana.add(this.jpSuperior, BorderLayout.NORTH);
        ventana.add(this.jpInferior, BorderLayout.SOUTH);
        ventana.add(this.jpIzquerda,BorderLayout.EAST);
        //eventos 
        
        ventana.setSize(500, 500);
        //ventana.pack();
        ventana.setVisible(true);
        ventana.setResizable(true);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
    }
    
    
}
