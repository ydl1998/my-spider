package edu.csuft.spider;

public class Film implements Comparable<Film> {
	/**
	 * 影片名称
	 * 
	 * @author machenike
	 */
	String title;
	/**
	 * 相关信息
	 */
	String info;
	/**
	 * 评分
	 */
	double rating;
	/**
	 * 评分人数
	 */
	int num;
	/**
	 * 影片排名
	 */
	int id;
	/**
	 * 海报
	 */
	String poster;
	/**
	 * 短评
	 */
	String qoute;
	/**
	 * 影片详细信息的链接
	 */
	String url;
	
	
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
				+ ", poster=" + poster + ", url=" + url + "]";
	}
	@Override
	public int compareTo(Film o) {
		return id - o.id;
		// TODO Auto-generated method stub
	}
	

}
