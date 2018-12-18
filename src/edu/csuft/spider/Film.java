package edu.csuft.spider;

public class Film implements Comparable<Film> {
	/**
	 * ӰƬ����
	 * 
	 * @author machenike
	 */
	String title;
	/**
	 * �����Ϣ
	 */
	String info;
	/**
	 * ����
	 */
	double rating;
	/**
	 * ��������
	 */
	int num;
	/**
	 * ӰƬ����
	 */
	int id;
	/**
	 * ����
	 */
	String poster;
	/**
	 * ����
	 */
	String qoute;
	
	public String toCSV()
	{
		return String.format("%d,%s,%d,%.1f\n", 
				id,
				title,
				num,
				rating);
	}
	@Override
	public String toString() {
		return "Film [title=" + title + ", info=" + info + ", rating=" + rating + ", num=" + num + ", id=" + id
				+ ", poster=" + poster + ", qoute=" + qoute + "]";
	}
	@Override
	public int compareTo(Film o) {
		return id - o.id;
		// TODO Auto-generated method stub
	}
	

}
