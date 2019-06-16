package lecture12;

import java.util.concurrent.Semaphore;

public class connnection {
	
	private static connnection instance = new connnection();

    private Semaphore sem = new Semaphore(10, true);

    private connnection() {
    }

    public static connnection getInstance() {
        return instance;
    }

    public void connect() {
        try {

            sem.acquire();

            System.out.printf("%s:: Current connections (max 10 allowed): %d\n",
                    Thread.currentThread().getName(),
                    sem.availablePermits());

          
            System.out.printf("%s:: WORKING...\n",
                    Thread.currentThread().getName());
            Thread.sleep(2000);

            System.out.printf("%s:: Connection released. Permits Left = %d\n",
                    Thread.currentThread().getName(),
                    sem.availablePermits());

        } catch (InterruptedException ignored) {
        } finally {
          
            sem.release();
        }
    }

}
