/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javachatrmi.rmi;
import java.awt.Color;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author waflessnet
 */
public interface InterfazRemotaCliente extends Remote {
  
  public void  mostrarMensaje(String mensaje,Color color) throws RemoteException;

}
