package edu.csuft.spider;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class SpiderFilmDetail  implements Runnable{
	/**
	 * ӰƬ��URL
	 */
	String url;
	/**
	 * ӰƬ�б�
	 */
	List<Film> list;

	public SpiderFilmDetail(String url, List<Film> list) {
		super();
		this.url = url;
		this.list = list;
	}
	@Override
	public void run() {
		try {
			Document doc = Jsoup.connect(url).get();
			Element e = doc.getElementById("content");
			String name = e.selectFirst("h1 span").text();
			String year = e.selectFirst(".year").text();
			String director = e.select("#info span").get(0).selectFirst(".attrs a").text();
			String script = e.select("#info .attrs").get(1).text();
			String actor = e.select("#info .actor .attrs").text();
			
			System.out.printf("%s,%s,%s,%s\n",
					year,
					name,
					director,
					script);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}

}
