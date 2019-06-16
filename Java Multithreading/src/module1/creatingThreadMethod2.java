package module1;

class threadCreation2 implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<10;i++)
		{
			System.out.println("Hello "+i);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}

public class creatingThreadMethod2 {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new threadCreation2());
		Thread t2 = new Thread(new threadCreation2());
		
		t1.start();
		t2.start();
		

	}

}
