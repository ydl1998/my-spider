package edu.csuft.spider;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class App2 {
	public static void main(String[] args) {
		//1 ·��
		String url = "https://music.163.com/#/discover/toplist?id=3779629";
		
		//2 JSOUP
		try {
			//�����ҳ�е����� ��DOM ����
			Document d = Jsoup.connect(url).get();
			// ���� �������
			Elements es = d.select("");
			Element e = d.selectFirst("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
