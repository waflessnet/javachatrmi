/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javachatrmi.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author waflessnet
 */
public class Cliente {
    public Cliente(String ipservidor,String nick) throws RemoteException, NotBoundException, MalformedURLException{
        
            InterfazRemotaServidor irm = (InterfazRemotaServidor) Naming.lookup("rmi://"+ipservidor+":1099/Server");
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(nick, irm);
            System.out.println("... registrado ...");
    }
}
