package lecture14;

import java.util.concurrent.*;

public class interruptingThreads {

	public static void main(String[] args) {
		System.out.println("Starting.");

        ExecutorService executor = Executors.newCachedThreadPool();

        Future<?> fu = executor.submit(new Callable<Void>() {

            @Override
            public Void call() throws Exception {

                for (int i = 0; i < 1E8; i++) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.printf("Interrupted at %d !!!", i);
                        break;
                    }
                }

                return null;
            }
        });

        executor.shutdown();
        try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        executor.shutdownNow();

        try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Finished.");

	}

}
