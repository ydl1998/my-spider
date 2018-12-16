package edu.csuft.spider;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * 程序的入口
 * @author machenike
 *
 */

public class App {
//	alt+/
	// ctrl+s
	public static void main(String[] args) {
		//目标 UML
		String url ="https://movie.douban.com/top250";
		//使用 JSOUP抓取文档
		try {
			Document doc = Jsoup.connect(url).get();
			Elements es = doc.select("img");
//			Elements es = doc.select("img[src]");
			System.out.println(es.size());
			for (Element e :es) {
//				System.out.println(e.attr("src"));
				System.out.println(e);
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
