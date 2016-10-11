/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javachatrmi.rmi;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author waflessnet
 */
public interface InterfazRemotaServidor extends Remote {
 
  public void  distribuirMensaje(String mensaje) throws RemoteException;
  public boolean registrar(String login) throws RemoteException;
  public boolean desconectar(String login) throws RemoteException;
}
