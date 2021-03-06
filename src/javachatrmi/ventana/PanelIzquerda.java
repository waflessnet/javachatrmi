/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javachatrmi.ventana;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javachatrmi.Usuario;
/**
 *
 * @author waflessnet
 */
public final class PanelIzquerda {
    
    private final JTable jt;
    private final JScrollPane sp;
    private final JPanel panel;
    public static ChatRMITablaModel TablaModel;
    public PanelIzquerda(){
        // Set data inside the table
        this.panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	
        
	this.jt = new JTable(this.definirTablaUsuarios());
        //this.jt.setPreferredScrollableViewportSize(this.jt.getPreferredSize());
        this.jt.setFillsViewportHeight(true);
        this.jt.setPreferredScrollableViewportSize(new Dimension(200, 500));
        //this.jt.setAutoResizeMode(1);
        
        this.jt.setEnabled(false);
	this.sp = new JScrollPane(this.jt);	
        this.panel.add(this.sp);
        //this.panel.add(this.jt);
    }
    public JPanel getPanel(){
        return this.panel;
    }
    public synchronized ChatRMITablaModel definirTablaUsuarios(){
        PanelIzquerda.TablaModel = new ChatRMITablaModel();
        PanelIzquerda.TablaModel.addColumn("Chacalitos");
        return PanelIzquerda.TablaModel;
    }
    
    public static ChatRMITablaModel  modificarTablaUsuarios(ArrayList<Usuario> usuarios){
        //this.TablaModel.r
        PanelIzquerda.eliminarListaUsuarios();
       System.out.println("========================================================================================");
        System.out.println("== [ARRAY LIST USUARIOS ] [modificarTablaUsuarios]  == ");
        System.out.println("== CANTIDAD DE USUARIOS ENVIADOS DEL SERVER "+usuarios.size()+ " == ");
        System.out.println("== CANTIDAD DE USUARIOS EN LA LISTA DEL PANEL "+PanelIzquerda.TablaModel.getRowCount()+ " == ");
        for(int i = 0; i < usuarios.size(); i++){
               System.out.println("== DEBEN APARECER "+usuarios.get(i).getNick()+ " == ");
               PanelIzquerda.TablaModel.addRow(new Object[] {usuarios.get(i).getNick()} );
        }
        System.out.println("== [/ARRAY LIST USUARIOS ]  == ");
        System.out.println("========================================================================================");
        return PanelIzquerda.TablaModel;
    }
    private static void eliminarListaUsuarios(){
        int c = PanelIzquerda.TablaModel.getRowCount();
        System.out.println("========================================================================================");
        System.out.println("== [ELIMINAR] [eliminarListaUsuarios] == ");
        System.out.println("== CANTIDAD DE ROW == " +c );
        System.out.println("== CANTIDAD DE VECTOR == " + PanelIzquerda.TablaModel.getDataVector().size());
        for(int i=0;i<c;i++){
            System.out.println("ELIMINADO DE LA LISTA : "+ PanelIzquerda.TablaModel.getDataVector().elementAt(i));
            PanelIzquerda.TablaModel.removeRow(i);
        }
        System.out.println("== [/ELIMINAR]  == ");
        System.out.println("========================================================================================");
    }
    
}
