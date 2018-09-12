package cloud_servce.api.crawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud_servce.service.gifjia.GifjiaSevice;

import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("gifjia/")
@Api(tags = {"1_crawler"})
public class GifjiaApi {
	@Autowired
	private GifjiaSevice gifjiaSevice;
	// 黄金数据接口 - 100次/天
	@ApiOperation(value = "获取Gifjia分类列表", notes = "获取Gifjia分类列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@PostMapping("tags")
	public Object shgold(Integer userId,Integer page){
		return gifjiaSevice.getTags(userId,page);
	}

}
