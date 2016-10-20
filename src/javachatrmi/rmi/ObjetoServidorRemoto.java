/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javachatrmi.rmi;
import java.awt.Color;
import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import javachatrmi.Usuario;

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
    public static ArrayList clienteList;
    public static ArrayList<Usuario> usuariosList;
    
    public ObjetoServidorRemoto() throws RemoteException{
        this.chacalitosRegistrados = new ArrayList();
        ObjetoServidorRemoto.clienteList = new ArrayList();
        ObjetoServidorRemoto.usuariosList = new ArrayList();
        
    }
    @Override
    public synchronized Usuario  registrar(String login,InterfazRemotaCliente cliente) throws RemoteException {
        
        Usuario userAux = new Usuario("",new Color(1,1,1),-1);
        if(!this.chacalitosRegistrados.contains(login)) {
            if (!(ObjetoServidorRemoto.clienteList.contains(cliente))){
                this.chacalitosRegistrados.add(login);
                ObjetoServidorRemoto.clienteList.add(cliente);
                userAux = new Usuario(login,this.obtenerColor(),ObjetoServidorRemoto.clienteList.size()-1);
                ObjetoServidorRemoto.usuariosList.add(userAux);
                
            }
        }
        return  userAux;
    }
    /**
     * actualiza  la lista de usuarios en todos los clientes
     * @throws java.rmi.RemoteException
     */
    @Override
    public synchronized void actualizarListaUsuarios() throws RemoteException{
        for(int i=0;i<ObjetoServidorRemoto.clienteList.size();i++){
            InterfazRemotaCliente clientes =  (InterfazRemotaCliente) ObjetoServidorRemoto.clienteList.get(i);
            clientes.listarUsuarios(ObjetoServidorRemoto.usuariosList);
        }
    }

    @Override
    public synchronized void distribuirMensaje(String mensaje,Color color) throws RemoteException {
        
        for(int i=0;i<ObjetoServidorRemoto.clienteList.size();i++){
            InterfazRemotaCliente clientes =  (InterfazRemotaCliente) ObjetoServidorRemoto.clienteList.get(i);
            clientes.mostrarMensaje(mensaje,color);
        }
    }
    @Override
    public boolean desconectar(InterfazRemotaCliente cliente) throws RemoteException {
         
         for(int i=0; i < ObjetoServidorRemoto.clienteList.size();i++ ){
                if(ObjetoServidorRemoto.clienteList.get(i).equals(cliente)){
                    System.out.println("========================================================================================");
                    System.out.println("==SERVER: desconectar usuario [DESCONECTAR] ");
                    System.out.println("==SERVER: cantidad de usuarios  " +ObjetoServidorRemoto.clienteList.size() );
                    System.out.println("==SERVER: Desconectando a objava server  ==" + ObjetoServidorRemoto.clienteList.get(i).toString() );
                    System.out.println("==SERVER: Desconectando a objava cliente ==" + cliente.toString() );
                    ObjetoServidorRemoto.clienteList.remove(i);
                    System.out.println("==SERVER: cantidad de usuarios  " +ObjetoServidorRemoto.clienteList.size() );
                    System.out.println("==SERVER: Desconectado del server ==");
                    System.out.println("========================================================================================");
                }
         }
        return true;
    }
    public Color obtenerColor(){
        int R = (int) (Math.random( )*256);
        int G = (int)(Math.random( )*256);
        int B= (int)(Math.random( )*256);
        Color randomColor = new Color(R, G, B);
        return randomColor;
        
    }
    
}
