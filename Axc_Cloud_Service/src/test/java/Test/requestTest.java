package Test;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.util.EntityUtils;
import org.hibernate.annotations.CreationTimestamp;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonFormat;

import cloud_servce.conf.ConstantConfig;
import cloud_servce.dao.IComicTypeDao;
import cloud_servce.entity.ComicType;
import cloud_servce.result.SuccessResult;
import cloud_servce.util.HttpUtils;
import cloud_servce.util.MD5Util;

public class requestTest {
	@CreationTimestamp
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date createDate;

	@Autowired
	private IComicTypeDao comicTypeDao;

	public requestTest() {
		// TODO 自动生成的构造函数存根



	}

	@Test
	public void method1(){ 
		try {
			//			HttpResponse response = HttpUtils.doGet("http://118.24.164.128/test/get_array", null, null, null);
			//			String data = EntityUtils.toString(response.getEntity());
			//			List<Object> dataList = JSON.parseArray(data);
			//			for (Object object : dataList) {
			//				System.out.println(object);
			//			}

			HashMap<String, String> parm = new HashMap<>();
			parm.put("text", "你觉得这条新闻如何？");
			parm.put("apikey", ConstantConfig.IDATA_APIKEY);
			HttpResponse response = HttpUtils.doPost(
					ConstantConfig.IDATA_PARTICIPLES_URL, parm );
			// 得到返回数据
			String data = EntityUtils.toString(response.getEntity());
			// 字符转JsonObj
//			JSONObject dataMap = JSON.parseObject(data);
			System.out.println(data);


		} catch (KeyManagementException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

}
