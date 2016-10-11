/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javachatrmi.rmi;
import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
/**
 *
 * @author waflessnet
 */
public class ObjetoServidorRemoto extends UnicastRemoteObject implements InterfazRemotaServidor {
    
    /**
     *
     * @throws java.rmi.RemoteException
     */
    ArrayList<String> chacalitosRegistrados;
    
    public ObjetoServidorRemoto() throws RemoteException{
        chacalitosRegistrados = new ArrayList();
    }

    @Override
    public boolean registrar(String r) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void distribuirMensaje(String mensaje) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean desconectar(String login) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
