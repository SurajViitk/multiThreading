import java.util.ArrayList;
import java.util.List;

public class MyRunnable implements Runnable{

    private int count = 0;

    @Override
    public void run() {

        System.out.println(Vehicle.class.isAssignableFrom(Car.class));
        System.out.println(Car.class.isAssignableFrom(Car.class));


//            for (int i = 0; i < 1_000_000; i++) {
////                synchronized (this) {
//                    this.count++;
////                }
//            }
//            System.out.println(
//                    Thread.currentThread().getName()
//                            + " : " + this.count);
    }

    public static void main(String[] args) {

        List<String> hosts = new ArrayList<>();
        System.out.println(hosts.toArray(String[]::new));
    }
}
