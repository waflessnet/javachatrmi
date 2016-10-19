/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javachatrmi;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javachatrmi.rmi.Cliente;
import javachatrmi.rmi.ObjetoServidorRemoto;
import  javachatrmi.ventana.Ventana;
/**
 *
 * @author waflessnet
 */
public class JavaChatRMI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Ventana v = new Ventana();
        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            @Override
            public void run()
            {
                try {
                    Cliente.servidor.desconectar(Cliente.cliente);
                    System.out.println("== Desconectado del server ==");
                } catch (RemoteException ex) {
                    Logger.getLogger(JavaChatRMI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
       });
    }
    
}
