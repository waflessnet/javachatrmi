/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javachatrmi.rmi;
import java.awt.Color;
import java.rmi.Remote;
import java.rmi.RemoteException;
import javachatrmi.Usuario;
/**
 *
 * @author waflessnet
 */
public interface InterfazRemotaServidor extends Remote {
 
  public void  distribuirMensaje(String mensaje,Color color) throws RemoteException;
  public Usuario registrar(String login,InterfazRemotaCliente cliente) throws RemoteException;
  public boolean desconectar(InterfazRemotaCliente cliente) throws RemoteException;
  public void actualizarListaUsuarios() throws RemoteException;
}
