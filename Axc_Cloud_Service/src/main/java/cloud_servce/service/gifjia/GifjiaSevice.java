package cloud_servce.service.gifjia;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cloud_servce.conf.ConstantConfig;
import cloud_servce.dao.IUserDao;
import cloud_servce.dao.gifjia.IGifjiaTagsDao;
import cloud_servce.entity.ComicType;
import cloud_servce.entity.User;
import cloud_servce.result.FailureResult;
import cloud_servce.result.ResultBody;
import cloud_servce.result.SuccessResult;
import cloud_servce.util.HttpUtils;
import cloud_servce.util.MD5Util;
import cloud_servce.util.decision_making.Permissions;

@Service
public class GifjiaSevice {
	@Autowired
	private IUserDao userDao;
	@Autowired
	private IGifjiaTagsDao gifjiaTagsDao;

	public GifjiaSevice() {
		// TODO 自动生成的构造函数存根
	}
	public Object getTags(Integer userId, Integer page){
		User user = userDao.findByUserId(userId); // 查看User对象
		ResultBody result;
		if (user == null) {
			result = new FailureResult("401",ConstantConfig.EMPTY_USER_PROMPT);
			return result;
		}
		// 检查是否有权限调用该接口
		boolean is_permissions = Permissions.userPermissions(user.getService(), "9");
		if (is_permissions) {
			result = new SuccessResult("gif发源地标签请求成功", gifjiaTagsDao.findAll());
		}else {
			result = new FailureResult(ConstantConfig.USER_PERMISSIONS_PROMPT);
		}
		return result;
	}
	
	/*
	 * 
			if (page < 1) {
				page = 1;
			}
		    Pageable pageable = new PageRequest(page - 1, 10);
	 * */
	
}
