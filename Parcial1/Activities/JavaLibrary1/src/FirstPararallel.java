
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juanantoniomelendresvilla
 */
public class FirstPararallel {
    public static void main(String[] args) {
        
        Thread numbers = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep((int) (Math.random() * 100));
                    } 
                    catch (InterruptedException ex) {
                        Logger.getLogger(FirstPararallel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
                
        Thread letters = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println((char)(i+64));
                    try {
                        Thread.sleep((int) (Math.random() * 100));
                    } 
                    catch (InterruptedException ex) {
                        Logger.getLogger(FirstPararallel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        
        numbers.start();
        try {
            numbers.join();
        } 
        catch (InterruptedException ex) {
            Logger.getLogger(FirstPararallel.class.getName()).log(Level.SEVERE, null, ex);
        }
        letters.start();
                
    }
}
