/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javachatrmi.ventana;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javachatrmi.rmi.Servidor;
import javachatrmi.rmi.Cliente;
import javax.swing.Box;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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
        JMenuItem cliente = new JMenuItem("Conectar a Servidor");
        JMenuItem servidor = new JMenuItem("Iniciar como Servidor");
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
                
                 JList listIP = new JList(javachatrmi.ventana.ActionListenerJavaChatRMI.getIP());
                 
                JOptionPane.showMessageDialog(
                null, listIP, "Seleccione IP para iniciar como servidor", JOptionPane.PLAIN_MESSAGE);
                 //System.out.println(listIP.getSelectedValue().toString());
                 //System.out.println(Arrays.toString(listIP.getListSelectionListeners()));
                String response = listIP.getSelectedValue().toString();
                try {
                    Servidor servidor1 = new Servidor(response,1099);
                    JOptionPane.showMessageDialog(panel, "Servidor Iniciado Correctamente");
                    Color color = new Color(255,0,0);
                    ActionListenerJavaChatRMI.appendString("\n *** ENTREGAR  IP:"+response+" A LOS CHACALITOS QUE SE QUIEREN CONECTAR *** ",color);
                } catch (RemoteException | BadLocationException ex) {
                    Logger.getLogger(PanelSuperior.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
        });
        
        cliente.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField jtip = new JTextField();
                JTextField jtnick = new JTextField();
                JTextField jtPassword = new JTextField();
                Object[] message = {
                     "IP:",jtip,
                     "Nick:",jtnick,
                     "Password:",jtPassword
                        
                        
                };
                int option = JOptionPane.showConfirmDialog(panel, message, "Ingrese la IP y el Nick", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION)
                     {   
                         String ip = jtip.getText();
                         String nick = jtnick.getText();
                         String password = jtPassword.getText();
                    try {
                        Cliente cliente = new Cliente(ip,nick,password);
                        if(cliente.estado == 1){
                            JOptionPane.showMessageDialog(panel, "Conectado al servidor correctamente!");
                        }else{
                            //JOptionPane.showMessageDialog(panel, "El usuario ingresado ya esta regitrado!");
                        }
                        
                    } catch (RemoteException | NotBoundException | MalformedURLException ex) {
                        Logger.getLogger(PanelSuperior.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     }
                 }
            
        });
        quit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        
        });
        

    }
    public JPanel getPanel(){
        return this.panel;
    }
}
