/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javachatrmi.ventana;

import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

/**
 *
 * @author waflessnet
 */
public class ActionListenerJavaChatRMI  {
  
    public  void appendString(String str) throws BadLocationException
    {
     str = str + "\n";
     StyledDocument document = (StyledDocument) Ventana.editor.getDocument();
     document.insertString(document.getLength(), str, null);
                                                    // ^ or your style attribute  
    }

    
}
