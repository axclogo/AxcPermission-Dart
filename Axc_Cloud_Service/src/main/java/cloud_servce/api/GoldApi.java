package cloud_servce.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import cloud_servce.service.GoldService;

@RestController
@RequestMapping("gold/")
@Api(tags = {"gold"})
public class GoldApi {
	@Autowired
	private GoldService goldService;

	@ApiOperation(value = "黄金数据", notes = "上海黄金交易所 - 黄金数据 - 100次/天", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@PostMapping("shgold")
	public Object shgold(Integer userId){
		return goldService.shgold(userId);
	}


}
