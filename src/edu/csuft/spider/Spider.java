package edu.csuft.spider;
/**
 * ץȡҳ����ӰƬ��Ϣ�����棨����
 * @author machenike
 *
 */

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Spider implements Runnable {
	
	/**
	 * ҳ���·����URL��
	 */
	String url;
	
	/**
	 * �洢ץȡ������
	 */
	ArrayList<Film> list;
	

	/**
	 * ��������
	 * @param url  ҳ���·��
	 * @param list  �洢���ݵ��б�
	 */
	public Spider(String url, ArrayList<Film> list) {
		super();
		this.url = url;
		this.list = list;
	}


	@Override
	public void run() {
		//���ִ�и�������̵߳�����
		String name = Thread.currentThread().getName();
		System.out.println(name + " �̣߳����� " + url);
		// TODO Auto-generated method stub
		
		//JSOUP
		try {
			Document doc = Jsoup.connect(url).get();
			
			// ���ĵ��������в��ҽڵ�
			Elements es = doc.select(".grid_view .item");
			
			// ����Ԫ���б�
			for (Element e :es) {
				Film f = new Film();
				//ÿһ��ӰƬ
				
				f.id = Integer.parseInt(e.select(".pic em").first().text());
				f.poster = e.select("img").first().attr("src");
				f.info = e.select(".bd p").first().text();
				f.title = e.select(".title").first().text();
				f.rating = Double.parseDouble(e.select(".rating_num").first().text());
				String num = e.select(".star span").last().text();
				f.num = Integer.parseInt(num.substring(0,num.length() - 3));
				f.qoute = e.select(".inq").first().text();

//				System.out.println(name + ":" + f);
				list.add(f);
				
			}
			System.out.println(name + " �̣߳���ɣ� " + url);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
