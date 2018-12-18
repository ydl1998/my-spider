package edu.csuft.spider;

import java.util.ArrayList;
//import java.io.IOException;
//import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;


/**
 * ��������
 * @author machenike
 *
 */

public class App {
//	alt+/
	// ctrl+s
	public static void main(String[] args) {
		
		//�߳�
//		Thread thread1 = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				while(true) {
//				    System.out.println("����");
//				    // TODO Auto-generated method stub
//				}
//			}
//		});
//		Thread thread2 = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				while(true) {
//					System.out.println("��");
//					// TODO Auto-generated method stub
//					}
//			}
//		});
//		thread1.start();
//		thread2.start();
		
		//�̳߳�
		//�̶���С
		ExecutorService pool = Executors.newFixedThreadPool(8);
		//���ޣ����棩
		pool = Executors.newCachedThreadPool();
		//һ���߳�
//		pool = Executors.newSingleThreadExecutor();
		
		ArrayList<Film> list = new ArrayList();
		String url = "https://movie.douban.com/top250?start";
		for (int i = 0; i < 10; i++) {
			String path = String.format("%s=%d",url,i*25);
			pool.submit(new Spider(path,list));
			
		}
		
		
		//Ŀ�� UML
//		String url ="https://movie.douban.com/top250";
//		//ʹ��JSOUPץȡ�ĵ�
//		try {
//			Document doc = Jsoup.connect(url).get();
//			Elements es = doc.select(".grid_view .item");
////			Elements es = doc.select("img[src]");
////			Elements es = doc.select("img");
//			System.out.println(es.size());
//			
//			//����һ��ӰƬ���б�
//			ArrayList<Film> list = new ArrayList<>();
//			for (Element e :es) {
//				Film f = new Film();
//				//ÿһ��ӰƬ
//				
////				Element t = e.select(".title").first();
////				String num = e.select(".star span").last().text();
////				System.out.println(e.attr("src"));
////				System.out.println(e);
////				System.out.println(t.text() + "," + num);
//				
//				f.id = Integer.parseInt(e.select(".pic em").first().text());
//				f.poster = e.select("img").first().attr("src");
//				f.info = e.select(".bd p").first().text();
//				f.title = e.select(".title").first().text();
//				f.rating = Double.parseDouble(e.select(".rating_num").first().text());
//				String num = e.select(".star span").last().text();
//				f.num = Integer.parseInt(num.substring(0,num.length() - 3));
//				f.qoute = e.select(".inq").first().text();
////				f.id
////				f.title
//				System.out.println(f);
//				list.add(f);
//				
//			}
//			
////			String title = doc.title();
////			String data = doc.data();
//			
////			System.out.println(title);
////			System.out.println(data);
//			
//		} catch (IOException e) {
//			// TODO: Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
