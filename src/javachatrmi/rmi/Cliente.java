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
import javachatrmi.Usuario;

/**
 *
 * @author waflessnet
 */
public class Cliente {
        public static  InterfazRemotaServidor servidor;
        public static  InterfazRemotaCliente  cliente;
        public static  Usuario Chacalito;
    public Cliente(String ipservidor,String nick) throws RemoteException, NotBoundException, MalformedURLException{
        
            Cliente.servidor = (InterfazRemotaServidor) Naming.lookup("rmi://"+ipservidor+":1099/Server");
            Cliente.cliente = new ObjetoClienteRemoto();
            Cliente.Chacalito = Cliente.servidor.registrar(nick,Cliente.cliente);
            System.out.println("... registrado al server...");
            System.out.println("=== Registrado con nick" +Cliente.Chacalito.getNick());
            System.out.println("=== Asignado color" +Cliente.Chacalito.getColor().toString());
            System.out.println("=== Asignado index " +Cliente.Chacalito.getIndex());

    }
}
