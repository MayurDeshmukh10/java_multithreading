package module1;

class threadCreation1 extends Thread{

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

public class creatingThreadMethod1 {
	
	public static void main(String[] args) {
		threadCreation1 runner = new threadCreation1();
		runner.start();
	}

}
