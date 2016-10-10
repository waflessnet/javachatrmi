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
    
    public Servidor(String servidor,Integer port) throws RemoteException{
        System.out.println ("*** Iniciando Servidor ***");
        System.setProperty("java.rmi.server.hostname",servidor);
        Registry registry = LocateRegistry.createRegistry(port);
        registry.rebind("Server", new ObjetoRemoto());
    }
}
