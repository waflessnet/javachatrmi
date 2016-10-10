/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javachatrmi.ventana;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javachatrmi.rmi.Servidor;
import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javachatrmi.ventana.ActionListenerJavaChatRMI;
import javax.swing.text.BadLocationException;

/**
 *
 * @author waflessnet
 */
public class PanelSuperior {
    private final JPanel panel;
    public  PanelSuperior() {
        this.panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JMenuBar mb = new JMenuBar();
        
        //menu principal
        JMenu modo = new JMenu("Modo");
        JMenu help = new JMenu("Help");
        //sub menu
        JMenuItem quit = new JMenuItem("Salir");
        JMenuItem cliente = new JMenuItem("Cliente");
        JMenuItem servidor = new JMenuItem("Servidor");
        JMenuItem acerca = new JMenuItem("About");
        //agregar submenus a menu
        modo.add(cliente);
        modo.add(servidor);
        modo.add(quit);
        help.add(acerca);
        //agregar los menus al menu bar:
        mb.add(modo);
        mb.add(Box.createHorizontalGlue());
        mb.add(help);
        //agregar menu al panel
        this.panel.add(mb);
        // eventos 
        servidor.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String response = JOptionPane.showInputDialog(panel, "Direccion IP a utilizar.");
                try {
                    Servidor servidor1 = new Servidor(response,1099);
                    JOptionPane.showMessageDialog(panel, "Servidor Iniciado Correctamente");
                    ActionListenerJavaChatRMI.appendString("\n *** ENTREGAR  IP:"+response+" A LOS CHACALITOS QUE SE QUIEREN CONECTAR *** ");
                } catch (RemoteException ex) {
                    Logger.getLogger(PanelSuperior.class.getName()).log(Level.SEVERE, null, ex);
                } catch (BadLocationException ex) {
                    Logger.getLogger(PanelSuperior.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
        });
        

    }
    public JPanel getPanel(){
        return this.panel;
    }
}
