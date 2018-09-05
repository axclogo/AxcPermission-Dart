package cloud_servce.api;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("test/")
@Api(tags = {"test"})
public class TestApi {
	
	@ApiOperation("Post返回Json_Map")
	@PostMapping("post_map")
	public Object post_map() {
		HashMap<String, String> map = new HashMap<>();
		map.put("name", "AxcLogo");
		map.put("pass","123");
		return map;
	}
	
	@ApiOperation("Post返回Json_Array")
	@PostMapping("post_array")
	public Object post_array() {
		List<String> array_list = new ArrayList<String>();
		for (int i = 0; i < 20; i++) {
			array_list.add(String.format("%d",i));
		}
		return array_list;
	}
	
	@ApiOperation("Get返回Json_Map")
	@GetMapping("get_map")
	public Object get_map() {
		HashMap<String, String> map = new HashMap<>();
		map.put("name", "AxcLogo");
		map.put("pass","123");
		return map;
	}
	
	@ApiOperation("Get返回Json_Array")
	@GetMapping("get_array")
	public Object get_array() {
		List<String> array_list = new ArrayList<String>();
		for (int i = 0; i < 20; i++) {
			array_list.add(String.format("%d",i));
		}
		return array_list;
	}

}
