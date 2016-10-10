/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javachatrmi.ventana;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author waflessnet
 */
public class ChatRMITablaModel extends DefaultTableModel {

   
    @Override
    public boolean isCellEditable(int row, int column) {
       //all cells false
       return false;
    }
    
}
