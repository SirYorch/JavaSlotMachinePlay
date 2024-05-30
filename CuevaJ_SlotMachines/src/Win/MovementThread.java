package Win;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MovementThread extends Thread{
    Slot s;
    Frame f;
    int velocidad;
    int numero;
    public MovementThread(Slot s,Frame f,int numero){
        this.f = f;
        this.s=s;
        velocidad = 1;
        this.numero = numero;
    }
    
    @Override
    public void run() 
    {
        while (true) 
        {   
            s.rotar();
            s.repaint();
            
            try {
                sleep(velocidad);
            } catch (InterruptedException ex) {
                
                ///este es un metodo para que el slot se detenga en un dato especifico
                //y de forma mas lenta()
                
                interrumpir();
                
                while(true){
                    try {
                        sleep(2000);                       
                        
                    } catch (InterruptedException ex1) {
                        
                        break;
                        
                    }
                }
            }
            
        }
    }
    
    public void interrumpir(){
        int valor = (int) (1+(Math.round(Math.random()*3)));
        int vel = velocidad;
        if(valor== 1){
            while(s.pos1!=52){
               vel = rotar(vel);
            }   
        } else if( valor ==2){
            while(s.pos2 !=52){
                vel = rotar(vel);
            }
        } else if (valor ==3){
            while(s.pos3!=52){
                vel = rotar(vel);
            }
        }else if(valor == 4){
            while(s.pos4!=52){
                vel = rotar(vel);
            }
        }
        
        if(numero ==1){
            f.botones.detenido1 =true;
        }
        if(numero ==2){
            f.botones.detenido2 =true;
        }
        if(numero ==3){
            f.botones.detenido3 =true;
        }
        
        if(f.botones.detenido1 ==true && f.botones.detenido2 ==true&& f.botones.detenido3 ==true ){
            f.botones.comprobarWin();
        }
        
    }
    private int rotar(int velocidad){
            s.rotar();
            s.repaint();
            try {
                sleep(velocidad);
            } catch (InterruptedException ex) {
                Logger.getLogger(MovementThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(velocidad <36){
                velocidad = (int) Math.ceil(velocidad*1.00005);
            }
            return velocidad;
    }
}
