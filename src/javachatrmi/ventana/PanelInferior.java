/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javachatrmi.ventana;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javachatrmi.rmi.Cliente;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author waflessnet
 */
public class PanelInferior {
    private final JPanel panel;
    public  PanelInferior() {
        this.panel = new JPanel(new GridLayout(0,2,5,5));
        ActionListenerJavaChatRMI al = new ActionListenerJavaChatRMI();
        final JTextField chat = new JTextField();
        JButton  btn   = new JButton("Enviar");
        btn.setPreferredSize(new Dimension(20, 20));
        
        btn.addActionListener(new ActionListener(){
            private String mensaje;
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                     this.mensaje = "<" +Cliente.Chacalito.getNick()+">:"+  chat.getText();
                    Cliente.servidor.distribuirMensaje(this.mensaje,Cliente.Chacalito.getColor());
                } catch (RemoteException ex) {
                    Logger.getLogger(PanelInferior.class.getName()).log(Level.SEVERE, null, ex);
                }
                chat.setText("");
            }
            
            
        });
        
        chat.addKeyListener(new KeyAdapter(){
            private String mensaje;
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    {
                        try {
                            this.mensaje = "<" +Cliente.Chacalito.getNick()+">:"+  chat.getText();
                             Cliente.servidor.distribuirMensaje(this.mensaje,Cliente.Chacalito.getColor());
                        } catch (RemoteException ex) {
                            Logger.getLogger(PanelInferior.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        chat.setText("");
                    }
            }
        });
        this.panel.add(chat,BorderLayout.WEST);
        this.panel.add(btn,BorderLayout.EAST);
        
        
        
        
    }
    public JPanel getPanel(){
        return this.panel;
    }
}
