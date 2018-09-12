
package cloud_servce.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud_servce.service.ComicService;

import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("comic/")
@Api(tags = {"98_tripartite"})
public class ComicApi {
	@Autowired
	private ComicService comicService;
	// 漫画接口 失效时间：2019-09-07 | 3次/秒
	@ApiOperation(value = "黑白漫画所有类型", notes = "漫画所有类型列表接口", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@PostMapping("comic_type_list")
	public Object comic_type_list(){
		return comicService.comic_type_list();
	}
	
	@ApiOperation(value = "黑白漫画", notes = "漫画列表接口", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@PostMapping("comic_list")
	public Object comic_list(Integer userId, String page,Integer comicId){
		return comicService.comic_list(userId, page, comicId);
	}
	
	
}
