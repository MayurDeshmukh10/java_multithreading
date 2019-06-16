package lecture3;

public class useOfSynchronizeKeyword {

    private int count = 0;

    public static void main(String[] args) {
    	useOfSynchronizeKeyword obj = new useOfSynchronizeKeyword();
        obj.doWork();
    }
    
    
    public synchronized void increment() throws InterruptedException {
        count++;
        
    }

    public void doWork() {
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        increment();
                    } catch (InterruptedException ex) {
                    	System.out.println("Error");
                        
                    }
                }
            }
        });
        thread1.start();
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        increment();
                    } catch (InterruptedException ex) {
                    	System.out.println("Error");
                    }
                }
            }
        });
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
        	System.out.println("Error");
        }
        System.out.println("Count is: " + count);
    }
}

