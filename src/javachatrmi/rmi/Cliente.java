/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javachatrmi.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
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
            irm.registrar(nick);
            
            System.out.println("... registrado ...");
            //cliente ?? -- ??
//            InterfazRemotaCliente interfaz = new ObjetoClienteRemoto();
            //InterfazRemotaCliente stub = (InterfazRemotaCliente) UnicastRemoteObject.exportObject(interfaz, 0);
            //cliente ??
//            Registry registry = LocateRegistry.getRegistry();
//            String nombre_objeto_remoto = nick;
//            registry.rebind(nombre_objeto_remoto, interfaz);
//            System.out.println("Cliente " + nombre_objeto_remoto + " bound");
            
    }
}
