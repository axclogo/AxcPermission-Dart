package cloud_servce.crawler;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import cloud_servce.dao.IBlogDao;
import cloud_servce.entity.Blog;
import cloud_servce.util.MD5Util;


@Service
public class CnblogsCwawler {
	@Autowired
	private IBlogDao blogDao;

	public CnblogsCwawler() {
		// TODO 自动生成的构造函数存根
	}

	public void start() {
		Connection conn = Jsoup.connect("https://www.cnblogs.com/");
		try {
			Document doc = conn.get();
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
				
				// 计算唯一标识符
				String identification = MD5Util.encrypt(String.format("%s-%s", author,linkHref));
				// 判断该数据是否已经存在
				Blog blog = blogDao.findByOnlyIdentification(identification);
				if (blog == null) { // 不存在
					blog = new Blog();
				}
				blog.setBlogRecommend(recommend);
				blog.setBlogTitle(title);
				blog.setBlogHref(linkHref);
				blog.setBlogDis(dis);
				blog.setBlogAuthor(author);
				blog.setBlogDate(date);
				blog.setOnlyIdentification(identification);
				blogDao.save(blog);

				System.out.println("推荐数：" + recommend + "\t\t超链接：" + linkHref);
				System.out.println("标题：" + title);
				System.out.println("简介摘要：" + dis);
				System.out.println("作者：" + author + date);
				System.out.println("=====================");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
