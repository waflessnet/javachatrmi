/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javachatrmi.ventana;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author waflessnet
 */
public class ActionListenerJavaChatRMI  {
  
    public static void appendString(String str,Color color) throws BadLocationException
    {
     SimpleAttributeSet set = new SimpleAttributeSet();
     StyleConstants.setFontFamily(set, "Monospace");
     //StyleConstants.setFontSize(set, 22);
     StyleConstants.setBold(set, true);
     StyleConstants.setItalic(set, true);
     StyleConstants.setForeground(set,color);
     
     str = str + "\n";
     StyledDocument document = (StyledDocument) Ventana.editor.getDocument();
     document.insertString(document.getLength(), str, set);
                                                    // ^ or your style attribute  
    }

    
}
