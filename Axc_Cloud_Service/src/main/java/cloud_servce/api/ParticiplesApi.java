package cloud_servce.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import cloud_servce.service.ParticiplesService;

@RestController
@RequestMapping("word/")
@Api(tags = {"98_tripartite"})
public class ParticiplesApi {
	@Autowired
	private ParticiplesService participlesService;
	// 分词接口 - 无限制
	@ApiOperation(value = "中文分词", notes = "文本挖掘，分析", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@PostMapping("participles")
	public Object participles(Integer userId, String text){
		return participlesService.participles(userId, text);
	}

}
