/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javachatrmi.rmi;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 *
 * @author waflessnet
 */
public class Servidor {
    static Registry  registry;
    static String[] boundNames;
    public Servidor(String servidor,Integer port) throws RemoteException{
        System.out.println ("*** Iniciando Servidor ***");
        System.setProperty("java.rmi.server.hostname",servidor);
        Servidor.registry = LocateRegistry.createRegistry(port);
        Servidor.registry.rebind("Server", new ObjetoServidorRemoto());
        // = Servidor.registry.list();
        
    }
}
