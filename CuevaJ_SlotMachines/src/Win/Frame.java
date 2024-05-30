package Win;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Frame extends JFrame{
    public SlotPane slots;
    public Botones botones;
    public Main m;
    
    public Frame(Main m){
        //esto es solo para colocar los Paneles de Botones y el Panel de Slots para el moviimento de la maquina 
        this.m = m;
        
        //JOptionPane.showInternalMessageDialog(null, "En este programa, Si no se coloca el tiempo, este sera el default, que esta probado con animaciones, \nen caso de colocar un numero por columna, este mientras mayor sea, sera más rapido, coloqué limites\npara que no pueda ser muy rapido. el numero en velocidad debe ser entre 1(lento) a 15(rapido)");
        Color background= new Color(220,220,220); //color de fondo, lo coloco en una variable
        
        this.setVisible(true);
        Insets i = this.getInsets();
        this.setLayout(null);
        this.setSize(450, 540+i.top);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p = new JPanel(){
            @Override
            public void paint(Graphics g){
                g.setColor(Color.red);
                g.drawRect(2, 83, 345, 103);
            }
        };
        p.setBounds(50,50,350,300);
        this.add(p);
        
        this.setTitle("Slot Machine"); 
        this.setResizable(false);

        
        slots = new SlotPane();
        slots.setBackground(background);
        slots.setBounds(50, 50, 350, 300);
        this.add(slots);
        
        botones = new Botones(this);
        botones.setBackground(background);
        botones.setBounds(50, 370, 350,120);
        this.add(botones);
        
        this.setLocationRelativeTo(null);
        
    }
    
}

class Botones extends JPanel implements ActionListener{
 
    public JButton inicio;
    
    public Frame f;
    
    public Botones(Frame f){
        
        this.f=f;
        this.setLayout(null);
        
        inicio = new JButton("Jugar");
        inicio.setBounds(20, 20, 310, 80);
        inicio.addActionListener(this);
        this.add(inicio);

        
    }
    
    //////todo el codigo aqui es para que solo se pueda iniciar con los botones de iniciar,
    ////y que solo se pueda detener con los botones de detener
    
    
    public boolean detenido1=true;
    public boolean detenido2=true;
    public boolean detenido3=true;

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==inicio){
            
            if(detenido1 &&detenido2 && detenido3){
                ///boton para iniciar todos los slots;
                inicio.setText("Detener");
                repaint();
                detenido1=false;
                f.m.iniciarHilo(1);
                detenido2=false;
                f.m.iniciarHilo(2);
                detenido3=false;
                f.m.iniciarHilo(3);
                
            } else if(!detenido1 &&!detenido2 && !detenido3){
                inicio.setText("Jugar");
                repaint();
                f.m.detenerHilo(1);
                f.m.detenerHilo(2);
                f.m.detenerHilo(3);
                
            }
        }
        
    }
    
    
    public void comprobarWin() {
        
        if((f.slots.cubo1.pos1 == f.slots.cubo2.pos1&& f.slots.cubo1.pos1==f.slots.cubo3.pos1 &&f.slots.cubo3.pos1 == 52)||(f.slots.cubo1.pos2 == f.slots.cubo2.pos2&& f.slots.cubo1.pos2==f.slots.cubo3.pos2  &&f.slots.cubo3.pos2 == 52)||(f.slots.cubo1.pos3 == f.slots.cubo2.pos3&& f.slots.cubo1.pos3==f.slots.cubo3.pos3 &&f.slots.cubo3.pos3 == 52)||(f.slots.cubo1.pos4 == f.slots.cubo2.pos4&& f.slots.cubo1.pos4==f.slots.cubo3.pos4 &&f.slots.cubo3.pos4 == 52)){
            JOptionPane.showMessageDialog(null, "Ganaste", "Win_Screen", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
}

class SlotPane extends JPanel{
    
    Slot cubo1;
    Slot cubo2;
    Slot cubo3;
    
    public SlotPane(){
        this.setLayout(null);
        Color b = new Color(100,100,100); // color entre los cubos
        cubo1 = new Slot();
        cubo1.setBounds(5, 33, 100, 225);
        cubo1.setBackground(b);
        this.add(cubo1);
        
        cubo2 = new Slot();
        cubo2.setBounds(125, 33, 100, 225);
        cubo2.setBackground(b);
        this.add(cubo2);
        
        cubo3 = new Slot();
        cubo3.setBounds(245, 33, 100, 225);
        cubo3.setBackground(b);
        this.add(cubo3);   
    }
}
