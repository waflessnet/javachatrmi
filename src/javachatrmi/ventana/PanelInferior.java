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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

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
            @Override
            public void actionPerformed(ActionEvent e) {
                ActionListenerJavaChatRMI a = new ActionListenerJavaChatRMI();
                try {
                    a.appendString(chat.getText());
                } catch (BadLocationException ex) {
                    Logger.getLogger(PanelInferior.class.getName()).log(Level.SEVERE, null, ex);
                }
                chat.setText("");
            }
            
            
        });
        
        chat.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    {
                      ActionListenerJavaChatRMI a = new ActionListenerJavaChatRMI();
                        try {
                            a.appendString(chat.getText());
                        } catch (BadLocationException ex) {
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
     public void appendString(String str) throws BadLocationException
    {
     str = str + "\n";
     StyledDocument document = (StyledDocument) Ventana.editor.getDocument();
     document.insertString(document.getLength(), str, null);
                                                    // agregar style 
    }
}
