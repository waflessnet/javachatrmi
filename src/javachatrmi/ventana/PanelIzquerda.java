/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javachatrmi.ventana;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
/**
 *
 * @author waflessnet
 */
public final class PanelIzquerda {
    
    private final JTable jt;
    private final JScrollPane sp;
    private final JPanel panel;
    private ChatRMITablaModel TablaModel;
    public PanelIzquerda(){
        // Set data inside the table
        this.panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	
        
	this.jt = new JTable(this.definirTablaUsuarios());
        this.jt.setPreferredScrollableViewportSize(this.jt.getPreferredSize());
        this.jt.setFillsViewportHeight(true);
        
        this.jt.setEnabled(false);
	this.sp = new JScrollPane(this.jt);	
        this.panel.add(this.sp);
    }
    public JPanel getPanel(){
        return this.panel;
    }
    public ChatRMITablaModel definirTablaUsuarios(){
        this.TablaModel = new ChatRMITablaModel();
        Object[] chacalitos;
        chacalitos = new Object[2];
        chacalitos[0] = "waflessnet";
        
        this.TablaModel.addColumn("Chacalitos");
        this.TablaModel.addRow(chacalitos);
        chacalitos[0] = "chacalito2";
        this.TablaModel.addRow(chacalitos);
        return this.TablaModel;
    }
    
}
