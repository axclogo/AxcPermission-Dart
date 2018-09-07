package cloud_servce.service;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cloud_servce.conf.ConstantConfig;
import cloud_servce.dao.IComicTypeDao;
import cloud_servce.dao.IUserDao;
import cloud_servce.entity.ComicType;
import cloud_servce.entity.User;
import cloud_servce.result.FailureResult;
import cloud_servce.result.ResultBody;
import cloud_servce.result.SuccessResult;
import cloud_servce.util.HttpUtils;
import cloud_servce.util.MD5Util;
import cloud_servce.util.decision_making.Permissions;

@Service
public class ComicService {
	@Autowired
	private IUserDao userDao;
	@Autowired
	private IComicTypeDao comicTypeDao;


	public ComicService() {
		// TODO 自动生成的构造函数存根
	}

	public Object comic_list(Integer userId, String page,Integer comicId){
		User user = userDao.findByUserId(userId); // 查看User对象
		ResultBody result;
		if (user == null) {
			result = new FailureResult("401",ConstantConfig.EMPTY_USER_PROMPT);
			return result;
		}
		// 检查是否有权限调用该接口
		boolean is_permissions = Permissions.userPermissions(user.getService(), "1");
		if (is_permissions) {
			// 根据ID获取漫画类型
			ComicType comicType = comicTypeDao.findByComicId(comicId);

			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
			String showapi_timestamp = formatter.format(new Date());
			String showapi_res_gzip = "0";
			String type = "/category/" + comicType.getComicType();

			HashMap<String, String> parm = new HashMap<>();
			parm.put("showapi_appid", ConstantConfig.SHOWAPI_APPID);
			parm.put("showapi_timestamp", showapi_timestamp);
			parm.put("showapi_res_gzip", showapi_res_gzip);
			parm.put("type", type);
			parm.put("page", page);
			// 字典排序
			SortedMap<String, String> sortedMap = new TreeMap<>(parm);	
			// 遍历拼接
			Iterator<Entry<String, String>> entries = sortedMap.entrySet().iterator();
			String sign = ""; 
			while (entries.hasNext()) { 
				Entry<String, String> entry = entries.next(); 
				sign = sign + entry.getKey() + entry.getValue();
			}
			sign = sign + ConstantConfig.SHOWAPI_SECRET;
			// 指纹签名
			String showapi_sign = MD5Util.encrypt(sign);
			parm.put("showapi_sign", showapi_sign);

			try {
				HttpResponse response = HttpUtils.doPost(
						ConstantConfig.SHOWAPI_URL, parm );
				// 得到返回数据
				String data = EntityUtils.toString(response.getEntity());
				// 字符转JsonObj
				JSONObject dataMap = JSON.parseObject(data);
				result = new SuccessResult("漫画接口请求成功", dataMap);

			} catch (Exception e) {
				// TODO: handle exception
				System.err.println(e);
				result = new FailureResult("漫画接口请求失败！");
			}

		}else {
			result = new FailureResult(ConstantConfig.USER_PERMISSIONS_PROMPT);
		}
		return result;
	}
	// 漫画所有类型
	public Object comic_type_list(){
		ResultBody result;
		List<ComicType>comicTypeList = comicTypeDao.findAll();
		if (comicTypeList != null) {
			result = new SuccessResult("漫画类型请求成功",comicTypeList);
		}else {
			result = new FailureResult("漫画类型接口请求失败！");
		}
		return result;
	}
}





