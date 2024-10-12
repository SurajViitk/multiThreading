package ThreadLocalTest;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalMemory {

    private static ExecutorService threadPool = Executors.newFixedThreadPool(10);

    // This will take around 1 GB of memory as each task defines its own  local variable
    public static void main(String[] args) throws InterruptedException {
        for (int i=0; i< 1_000_000; i++){
            threadPool.submit(() ->{
                        String birthDate = new ThreadLocalMemory().birthDate(100);
                        System.out.println(birthDate);
                    });
        }
        Thread.sleep(1000);
    }

    public String birthDate(int userId) {
        Date birthDate = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
        return df.format(birthDate);
    }
}
