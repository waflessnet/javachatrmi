/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javachatrmi.ventana;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author waflessnet
 */
public class PanelSuperior {
    private JPanel panel;
    public  PanelSuperior() {
        this.panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JMenuBar mb = new JMenuBar();
        
        //menu principal
        JMenu servidor = new JMenu("Servidor");
        JMenu help = new JMenu("Help");
        //sub menu
        JMenuItem quit = new JMenuItem("Salir");
        JMenuItem acerca = new JMenuItem("About");
        //agregar submenus a menu
        servidor.add(quit);
        help.add(acerca);
        //agregar los menus al menu bar:
        mb.add(servidor);
        mb.add(Box.createHorizontalGlue());
        mb.add(help);
        //agregar menu al panel
        this.panel.add(mb);


    }
    public JPanel getPanel(){
        return this.panel;
    }
}
