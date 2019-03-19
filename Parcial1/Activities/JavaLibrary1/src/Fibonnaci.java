
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import org.apache.commons.lang.time.StopWatch;

/**
 *
 * @author juanantoniomelendresvilla
 */
public class Fibonnaci {
    
    public static class Sequential {
        public long calculate (long n) {
            if (n <= 1) {
                return n;
            }
            else {
                return calculate(n - 1) + calculate(n - 2);
            }
        }
    }
    
    public static class Parallel extends RecursiveTask<Long> {
        
        private long n;
        public Parallel (long n) {
            this.n = n;
        }
        
        public Long compute () {
            if (n <= 1) {
                return n;
            }
            else {
                Parallel fib1 = new Parallel(n - 1);
                Parallel fib2 = new Parallel(n - 2);
                ForkJoinTask.invokeAll(fib1, fib2);
                
                return fib1.getRawResult() + fib2.getRawResult();
            }
        }
    }
    
    public static void main(String[] args) {
        long numbers[] ={10, 30, 35, 40, 45};
        for(int i =0; i < numbers.length; i++){
            long number = numbers[i];
            StopWatch stopwatchSeq = new StopWatch();
            stopwatchSeq.start();
            long fib = new Sequential().calculate(number);
            stopwatchSeq.stop();
            System.out.printf("Sequenti Fibonnaci of %d is % 11d, calculated in %5d miliseconds \n", number, fib, stopwatchSeq.getTime());
        
            StopWatch stopwatchPar = new StopWatch();
            stopwatchPar.start();
            ForkJoinPool pool = new ForkJoinPool();
            long fibPar =  pool.invoke(new Parallel(number));
            stopwatchPar.stop();
            System.out.printf("Parallel Fibonnaci of %d is % 11d, calculated in %5d miliseconds \n", number, fibPar, stopwatchPar.getTime());
        }   
    }
    
}
