package Test;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;




public class CrawlerTest {

	public CrawlerTest() {
		// TODO 自动生成的构造函数存根
	}


	@Test
	public void jiexi() {
		Document doc = this.getHtmlDoc();
		Element body = doc.body();
		Element headline_blockDiv = body.getElementById("post_list");
		Elements all_post_item = headline_blockDiv.getElementsByClass("post_item");
		//操作元素：
		for (Element p : all_post_item) {
			//操纵元素：这里就类似于jQuery
			// 获取推荐数量
			String recommend = p.getElementsByClass("diggnum").text();
			// 获取标题
			Element element_title = p.getElementsByClass("titlelnk").first();
			String title = element_title.text();
			// 获取超链接
			String linkHref = element_title.attr("href");
			// 获取简介
			String dis = p.getElementsByClass("post_item_summary").text();
			// 获取作者
			String author = p.getElementsByClass("lightblue").text();
			// 获取时间戳等
			String date = p.getElementsByClass("post_item_foot").text();
			
			System.out.println("推荐数：" + recommend + "\t\t超链接：" + linkHref);
			System.out.println("标题：" + title);
			System.out.println("简介摘要：" + dis);
			System.out.println("作者：" + author + date);
			
			System.out.println("=====================");
//			String text = p.text();
//			System.out.println(text);
			}
	}	

	public Document getHtmlDoc() {
		//通过URL获得连接：Connection对象
		Connection conn = Jsoup.connect("https://www.cnblogs.com/");
		//以下为主要方法，多数返回Connection
		//		conn.data("query", "Java");   // 请求参数
		//		conn.userAgent("I ’ m jsoup"); // 设置 User-Agent 
		//		conn.cookie("auth", "token"); // 设置 cookie 
		//		conn.timeout(3000);           // 设置连接超时时间
		//发送请求，获得HTML文档：Document对象
		try {
			Document doc = conn.get();
			return doc;
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
		//		Document doc = conn.post();
	}


}
