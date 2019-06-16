package lecture10;

public class reentrantLock {

	public static void main(String[] args) {
		
		final runner runner = new runner();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    runner.firstThread();
                } catch (InterruptedException ignored) {
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    runner.secondThread();
                } catch (InterruptedException ignored) {
                }
            }
        });

        t1.start();
        t2.start();
        try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
        runner.finished();
		

	}

}
