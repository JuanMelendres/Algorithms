/**
 *
 * @author juanantoniomelendresvilla
 */

import java.util.logging.Level;
import java.util.logging.Logger;

public class RaceCondition {
    
     public static void main(String[] args) {
         for (int i = 0; i < 3; i++){
            new Race(i).race();
        }
     }
    
    static class Race {
        private static final long LIMIT = Integer.MAX_VALUE * 3;
        private long count = 0;
        private final String name;
        
        public Race(int lap){
            this.name = "Lap" + lap + ": ";
        }
    
        void race() {

           Thread increase = new Thread() {
               @Override
               public void run() {
                   System.out.println(name + "Increase started");
                   for (int i = 0; i < LIMIT; i++) {
                       count += 1;
                   }
                   System.out.println(name + "Increase finished");
               }
           };

           Thread decrease = new Thread() {
               @Override
               public void run() {
                   System.out.println(name + "Decrease started");
                   for (int i = 0; i < LIMIT; i++) {
                       count -= 1;
                   }
                   System.out.println(name + "Decrease finished");
               }
           };

           increase.start();
           decrease.start();
           
            try {
                System.out.println(name + "increase join");
                increase.join();
                System.out.println(name + "Decrease join");
                decrease.join();
            } 
            catch (InterruptedException ex) {
                Logger.getLogger(RaceCondition.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(count);
        }
         private void print(String message){
            System.out.println(name + message);
        }
    }
}
