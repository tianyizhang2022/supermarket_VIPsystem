package maketsimulation;

public class Thread1 implements Runnable{
	private int present_number = 100;
	boolean flag = false; //��Ʒ��û������
	public void run() {
		while(!flag) {
			getpresent();
		}
	}
	
	public synchronized void getpresent() {
		
		if (present_number<=0) {
			flag = true;
			return ;
		}
		present_number--;
		
	}
}
