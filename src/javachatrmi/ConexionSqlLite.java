/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javachatrmi;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author mayor
 */
public class ConexionSqlLite {
 Connection connect;
 public void connect(){
 try {
     Path currentRelativePath = Paths.get("");
     String s = currentRelativePath.toAbsolutePath().toString();
     String url = Paths.get(s+System.getProperty("file.separator") +"dbusuarios").toAbsolutePath().normalize().toString();
     connect = DriverManager.getConnection("jdbc:sqlite:"+url);
     if (connect!=null) {
         System.out.println("Conectado");
         this.checkiftable();
     }
 }catch (SQLException ex) {
     System.err.println("No se ha podido conectar a la base de datos\n"+ex.getMessage());
 }
}
 public void close(){
        try {
            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionSqlLite.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
 public void guardarUsuario(Usuario u ){
      try {
            PreparedStatement st = connect.prepareStatement("insert into usuario (nick, pass) values (?,?)");
            st.setString(1,u.getNick());
            st.setString(2, u.getPass());
            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
 }
 public boolean checkiftable(){
     String sql0 = "SELECT name FROM sqlite_master WHERE type='table' AND name='usuario';";
     try {
         Statement stmt = connect.createStatement();
         ResultSet rs = stmt.executeQuery(sql0);
         while ( rs.next() ) {
             return true;
         }
      stmt = connect.createStatement();
      String sql = "create table usuario(id integer primary key autoincrement,nick varchar(140),pass varchar(140));"; 
      stmt.executeUpdate(sql);
      stmt.close();
      rs.close();
      System.out.println("CREADA BASE DE DATOS");
      }catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
     return true;
     
 }
 public boolean checkUserPass(String nick,String pass){
     
     String sql0 = "SELECT id,nick FROM usuario WHERE nick='"+nick+"' AND pass='"+pass+"';";
        try {
         Statement stmt = connect.createStatement();
         ResultSet rs = stmt.executeQuery(sql0);
         while ( rs.next() ) {
            return true;
      }
      rs.close();
      stmt.close();
      //connect.close();
         
         
     }catch (SQLException ex) {
            System.err.println(ex.getMessage());
     }
     return false;
 }
}
