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
public interface InterfazRemota extends Remote {
 
  public void  mostrarMensaje(String r) throws RemoteException;
  public boolean registrar(String r) throws RemoteException;
}
