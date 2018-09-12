package cloud_servce.crawler.gifjia;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cloud_servce.dao.gifjia.IGifjiaTagsDao;
import cloud_servce.entity.gifjia.GifjiaTags;
import cloud_servce.util.MD5Util;


@Service
public class GifjiaCrawler {
	
	@Autowired
	private IGifjiaTagsDao gifDao;

	public GifjiaCrawler() {
		// TODO 自动生成的构造函数存根
	}
	public void start() {
		Connection conn = Jsoup.connect("https://www.gifjia5.com/tags/");
		try {
			Document doc = conn.get();
			Element body = doc.body();
			Elements tagslist = body.getElementsByClass("tagslist");
			Elements allItem = tagslist.select("li");
//			//操作元素：
			for (Element p : allItem) {
				//操纵元素：这里就类似于jQuery
				// 获取名称
				Element titleEm = p.getElementsByClass("name").first();
				String tagName = titleEm.text();
				// 获取链接
				String tagHref = titleEm.attr("href");
				// 获取数量
				String tagNum = p.select("small").text();
				// 获取副标题
				Elements disEm = p.getElementsByClass("tit");
				String tagDis = disEm.first().text();
				// 获取副标题链接
				String tagDisHref = disEm.first().attr("href");

				// 计算唯一标识符
				String identification = MD5Util.encrypt(String.format("%s-%s", tagName,tagHref));
				// 判断该数据是否已经存在
				GifjiaTags gifTag = gifDao.findByIdentification(identification);
				if (gifTag == null) { // 不存在
					gifTag = new GifjiaTags();
				}
				// 如果副标题不同，则为已更新
				if (!gifTag.getTagDisHref().equals(tagDisHref)) {
					gifTag.setIsNew(1);
				}else {
					gifTag.setIsNew(0);
				}
				gifTag.setIdentification(identification);
				gifTag.setTagName(tagName);
				gifTag.setTagHref(tagHref);
				gifTag.setTagDis(tagDis);
				gifTag.setTagDisHref(tagDisHref);
				gifTag.setTagNum(tagNum);
				gifDao.save(gifTag);
				
//				System.out.println("名称：" + tagName + "\t\t超链接：" + tagHref);
//				System.out.println("数量：" + tagNum);
//				System.out.println("副标题：" + tagDis);
//				System.out.println("副标题超链接：" + tagDisHref);
//				System.out.println("=====================");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
