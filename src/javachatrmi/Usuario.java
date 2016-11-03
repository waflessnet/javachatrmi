/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javachatrmi;

import java.awt.Color;
import java.io.Serializable;

/**
 *
 * @author waflessnet
 */
public class Usuario implements Serializable{
     private String nick;
     private Color color ;
     private final int  index; 

     private String pass;
     
     public Usuario(String nick,Color color,int index){
         this.color = color;
         this.nick  = nick;
         this.index = index;
     }
     
    public void setColor(Color color) {
        this.color = color;
    }
    public Color getColor() {
        return this.color;
    }
    public String getNick() {
        return this.nick;
    }
    public void setNick(String nick) {
        this.nick = nick;
    }
    public int getIndex(){
        return this.index;
    }
    public void setPass(String pass){
        this.pass = pass;
    }
    
    public String getPass() {
        return this.pass;
    }
}
