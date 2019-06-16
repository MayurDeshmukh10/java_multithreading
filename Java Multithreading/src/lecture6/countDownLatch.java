package lecture6;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Process implements Runnable {

    private CountDownLatch latch;

    public Process(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        System.out.println("Started.");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {}
        latch.countDown();
    }
}

public class countDownLatch {

	public static void main(String[] args) {
		 CountDownLatch latch = new CountDownLatch(3);
	        ExecutorService executor = Executors.newFixedThreadPool(3);
	        for (int i = 0; i < 3; i++) {
	            executor.submit(new Process(latch));
	        }
	        executor.shutdown();

	        try {
	            latch.await();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        System.out.println("Completed.");

	}

}
