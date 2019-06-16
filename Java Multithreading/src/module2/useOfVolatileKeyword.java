package module2;

import java.util.Scanner;

class Processor extends Thread {

    private volatile boolean running = true;

    public void run() {
        while (running) {
            System.out.println("Running");

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        running = false;
    }
    
}

public class useOfVolatileKeyword {

	public static void main(String[] args) {
		 Processor p = new Processor();
	        p.start();
	        System.out.println("Enter something to stop the thread,\nVolatile variable running will be forced to true :");
	        new Scanner(System.in).nextLine();
	        p.shutdown();
	    }


}
