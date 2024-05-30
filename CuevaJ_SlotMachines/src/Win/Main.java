package Win;

import java.util.logging.Level; 
import java.util.logging.Logger;

public class Main {
    MovementThread hilo1;
    MovementThread hilo2;
    MovementThread hilo3;
    public void Main(){
        
    }
    ///si quiere comprobar el tema de comprobar win, se encuentra en la segunda clase de Frame llamada botones
    ///con el nombre Comprobar win
    //y se la llama cada vez que todos los hilos esten detenidos, usando los botones
    
    

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                // este es el frame con los botones y los slots;
                Main n = new Main();
                Frame f = new Frame(n);
                //estos son los hilos; le mando cada uno de los Slots independiente para poder controlar desde dentro el movimiento de los paneles;
                n.hilo1 = new MovementThread(f.slots.cubo1,f,1);
                n.hilo2 = new MovementThread(f.slots.cubo2,f,2);
                n.hilo3 = new MovementThread(f.slots.cubo3,f,3);
            }
        });
    }
    
    public void iniciarHilo(int hilo){
        if(hilo== 1){
            try{hilo1.start();
            }catch(Exception e){
                hilo1.interrupt();
            }
        } else if(hilo ==2){
                try{hilo2.start();
        }catch(Exception e){
                hilo2.interrupt();
            }
        } else if(hilo ==3){
                try{hilo3.start();}
            catch(Exception e){
                hilo3.interrupt();
            }
        }
    }
    
    public void detenerHilo(int hilo){
        if(hilo== 1){
            hilo1.interrupt();
        } else if(hilo ==2){
            hilo2.interrupt();
        } else if(hilo ==3){
            hilo3.interrupt();
        }
        
    }

}
