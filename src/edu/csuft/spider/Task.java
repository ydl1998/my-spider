package edu.csuft.spider;
/**
 * ����һ�����Խ����߳�ִ�е�����
 * @author machenike
 *
 */

public class Task implements Runnable {
	
	//������
	int n;
	
	public Task(int n) {
		super();
		this.n = n;
	}




	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name + "��ʼ  :  " + n);
		//��ʱ
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name + "����  :  " + n);
		// TODO Auto-generated method stub
		
	}
	

}
