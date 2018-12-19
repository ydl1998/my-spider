package edu.csuft.spider;

//import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ��������
 * @author machenike
 *
 */

public class App {
//	alt+/
	// ctrl+s
	public static void main(String[] args) {
		
		//�̳߳�
		//�̶���С
		ExecutorService pool = Executors.newFixedThreadPool(2);
		//���ޣ����棩
		pool = Executors.newCachedThreadPool();
		//һ���߳�
//		pool = Executors.newSingleThreadExecutor();
		
		ArrayList<Film> list = new ArrayList<>();
		String url = "https://movie.douban.com/top250?start";
		for (int i=0;i<10;i++) {
			String path = String.format("%s=%d",url,i*25);
			pool.submit(new Spider(path,list));	
		}
		pool.shutdown();
		System.out.println(pool.isTerminated());
		while(!pool.isTerminated()) {
			try {
				Thread.sleep(1000);
			    } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			    }
		}
		//��������
		Collections.sort(list);
		System.out.println(list.size());
		
		ExecutorService pool2 = Executors.newFixedThreadPool(4);
		
		
		for(Film film : list) {
			System.out.println(film.url);
			pool2.execute(new SpiderFilmDetail(film.url,null));
			
		}
		//д���ļ�
//		String file = "d:/film.csv";  //����·��
//		file = "film.csv"; //���·��
//		
//		//����
//		Collections.sort(list);
//		//io		
//		try (FileWriter out = new FileWriter(file)) {
//			//д����
//			for(Film film : list) {
//				out.write(film.toCSV());
//			}
//			System.out.println("ok");
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}		
				
	}
}
