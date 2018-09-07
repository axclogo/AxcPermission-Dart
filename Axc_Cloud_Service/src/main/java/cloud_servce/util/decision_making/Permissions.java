package cloud_servce.util.decision_making;

import java.util.Arrays;
import java.util.List;

public class Permissions {

	public static boolean userPermissions(String userServices,String serviceId) {
		// 检查是否有权限调用该接口
		boolean is_permissions = false;
		List<String> services = Arrays.asList(userServices.split(","));
		for (String string : services) {
			if (string.equals(serviceId)) { // 拥有权限
				is_permissions = true;
				break;	
			}
		}
		return is_permissions;
	}


}
