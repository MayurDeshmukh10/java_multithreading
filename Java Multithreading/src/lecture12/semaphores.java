package lecture12;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class semaphores {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 20; i++) { //200 hundred times will be called
            executor.submit(new Runnable() {
                public void run() {
                    connnection.getInstance().connect();
                }
            });
        }

        executor.shutdown();
        try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
