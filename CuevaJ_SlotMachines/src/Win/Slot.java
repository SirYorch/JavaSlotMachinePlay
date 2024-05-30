package Win;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Slot extends JPanel{
    JLabel label;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    int pos1;
    int pos2;
    int pos3;
    int pos4;
    ImageIcon icono;
    ImageIcon icono1;
    ImageIcon icono2;
    ImageIcon icono3;
    
            
    public Slot(){
        this.setLayout(null);
        icono = new ImageIcon("src/Slot/Oso.jpg");
        icono1 = new ImageIcon("src/Slot/siete.jpg"); 
        icono2 = new ImageIcon("src/Slot/sandia.jpg");
        icono3 = new ImageIcon("src/Slot/casco.jpg"); 
        
        label = new JLabel(icono);
        label1 = new JLabel(icono1);
        label2 = new JLabel(icono2);
        label3 = new JLabel(icono3);
        
        ArrayList<Integer> lista = new ArrayList();
        lista.add(-52);
        lista.add(52);
        lista.add(156);
        lista.add(260);
        
        int rand =(int) ((Math.round(Math.random()*3)));
        
        pos1 = lista.remove(rand);
        
        rand =(int) ((Math.round(Math.random()*2)));
        
        pos2 = lista.remove(rand);
        
        rand =(int) ((Math.round(Math.random()*1)));
        
        pos3 = lista.remove(rand); 
        
        pos4 = lista.remove(0);
        
        

            label.setBounds(0, pos1, icono.getIconWidth(), icono.getIconHeight());
            label1.setBounds(0, pos2, icono.getIconWidth(), icono.getIconHeight());
            label2.setBounds(0, pos3, icono.getIconWidth(), icono.getIconHeight());
            label3.setBounds(0, pos4, icono.getIconWidth(), icono.getIconHeight());
        
        
        
        
        
        this.add(label);
        this.add(label1);
        this.add(label2);
        this.add(label3);
        
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        label.setBounds(0, pos1, icono.getIconWidth(), icono.getIconHeight());
        label1.setBounds(0, pos2, icono.getIconWidth(), icono.getIconHeight());
        label2.setBounds(0, pos3, icono.getIconWidth(), icono.getIconHeight());
        label3.setBounds(0, pos4, icono.getIconWidth(), icono.getIconHeight());
    }
    
    
    public void rotar(){
        pos1+=4;
        pos2+=4;
        pos3+=4;
        pos4+=4;    
        if(pos1>=264){
            pos1 = -152;
        } else if(pos2>=264){
            pos2 = -152;
        } else if(pos3>=264){
            pos3 = -152;
        } else if(pos4>=264){
            pos4 = -152;
        }
    }
}