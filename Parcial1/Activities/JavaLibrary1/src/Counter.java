import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanantoniomelendresvilla
 */

public class Counter {
    private int count;
    private static final long LIMIT = Integer.MAX_VALUE * 3;
    
    public void increment() {
        count++;
    }
    public void decrement() {
        count--;
    }
    
    public int  getCount() {
        return count;
    }
    
    public void race() {

           Thread increase = new Thread() {
               @Override
               public void run() {
                   System.out.println( "Increase started");
                   for (int i = 0; i < LIMIT; i++) {
                       count += 1;
                   }
                   System.out.println("Increase finished");
               }
           };

           Thread decrease = new Thread() {
               @Override
               public void run() {
                   System.out.println("Decrease started");
                   for (int i = 0; i < LIMIT; i++) {
                       count -= 1;
                   }
                   System.out.println("Decrease finished");
               }
           };

           increase.start();
           decrease.start();
           
            try {
                System.out.println("increase join");
                increase.join();
                System.out.println("Decrease join");
                decrease.join();
            } 
            catch (InterruptedException ex) {
                Logger.getLogger(RaceCondition.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(count);
        }
         private void print(String message){
            System.out.println(message);
        }
}
