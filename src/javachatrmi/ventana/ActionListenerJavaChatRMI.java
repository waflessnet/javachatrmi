/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javachatrmi.ventana;

import java.awt.Color;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
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
    public static Object[] getIP(){
        ArrayList  ips = new ArrayList();
       try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface iface = interfaces.nextElement();
               /* if (iface.isLoopback() || !iface.isUp() || iface.isVirtual() || iface.isPointToPoint()) {
                    continue;
                }*/
               
                Enumeration<InetAddress> addresses = iface.getInetAddresses();
                while(addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();

                    final String ip = addr.getHostAddress();
                    if(Inet4Address.class == addr.getClass()) {
                       ips.add(ip);
                    }
                }
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
        Object[] axu =  ips.toArray(new String[ips.size()]);
       return axu;
    }

    
}
