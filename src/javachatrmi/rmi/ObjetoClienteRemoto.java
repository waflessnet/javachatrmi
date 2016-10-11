/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javachatrmi.rmi;
import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javachatrmi.ventana.ActionListenerJavaChatRMI;
import javax.swing.text.BadLocationException;
/**
 *
 * @author waflessnet
 */
public class ObjetoClienteRemoto extends UnicastRemoteObject implements InterfazRemotaCliente {
    
    /**
     *
     * @throws java.rmi.RemoteException
     */
    
    public ObjetoClienteRemoto() throws RemoteException{
        
    }
    @Override
    public void mostrarMensaje(String mensaje) throws RemoteException {
        try {
            ActionListenerJavaChatRMI.appendString(mensaje);
        } catch (BadLocationException ex) {
            Logger.getLogger(ObjetoClienteRemoto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
