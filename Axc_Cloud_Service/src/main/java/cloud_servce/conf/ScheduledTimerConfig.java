package cloud_servce.conf;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import cloud_servce.crawler.CnblogsCwawler;
import cloud_servce.crawler.gifjia.GifjiaCrawler;



@Configuration
@EnableScheduling
public class ScheduledTimerConfig {
	@Autowired
	CnblogsCwawler cnblogsCwawler;
	@Autowired
	GifjiaCrawler gifjiaCrawler;

	public ScheduledTimerConfig() {
		// TODO 自动生成的构造函数存根
	}
//	@Scheduled(cron = "0 0 6,14,22 * * ?") // 每天凌晨6点、中午2点、晚上10点执行数据刷新
//	@Scheduled(cron = "*/30 * * * * ?") // 每30s执行
	
	// 博客每小时进行刷新列表
	@Scheduled(cron = "0 0 */1 * * ?") // 每小时执行
	public void scheduledTimer() {
		cnblogsCwawler.start();
	}

	// 爬虫刷新gifTags列表
	@Scheduled(cron = "0 15 10 ? * *") // 每天上午10:15触发
	public void gif_scheduled() {
		gifjiaCrawler.start();
	}

}
