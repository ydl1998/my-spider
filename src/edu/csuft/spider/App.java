package edu.csuft.spider;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * ��������
 * @author machenike
 *
 */

public class App {
//	alt+/
	// ctrl+s
	public static void main(String[] args) {
		//Ŀ�� UML
		String url ="https://movie.douban.com/top250";
		//ʹ�� JSOUPץȡ�ĵ�
		try {
			Document doc = Jsoup.connect(url).get();
			Elements es = doc.select(".grid_view .item");
//			Elements es = doc.select("img[src]");
//			Elements es = doc.select("img");
			System.out.println(es.size());
			
			//����
			ArrayList<Film> list = new ArrayList<>();
			for (Element e :es) {
				Film f = new Film();
				//ÿһ��ӰƬ
				Element t = e.select(".title").first();
				String num = e.select(".star span").last().text();
//				System.out.println(e.attr("src"));
//				System.out.println(e);
				System.out.println(t.text() + "," + num);
				
//				f.id
//				f.title
				list.add(f);
				
			}
			
//			String title = doc.title();
//			String data = doc.data();
			
//			System.out.println(title);
//			System.out.println(data);
			
		} catch (IOException e) {
			// TODO: Auto-generated catch block
			e.printStackTrace();
		}
	}
}
