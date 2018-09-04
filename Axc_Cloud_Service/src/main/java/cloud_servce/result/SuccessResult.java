package cloud_servce.result;

import cloud_servce.conf.ConstantConfig;

public class SuccessResult extends ResultBody {
	
	
	public SuccessResult(String message) {
		super(ConstantConfig.SUCCESS_CODE, message);
		// TODO Auto-generated constructor stub
	}
	
	public SuccessResult(Object data) {
		super(ConstantConfig.SUCCESS_CODE, data);
		// TODO Auto-generated constructor stub
	}
	
	public SuccessResult(String message, Object data) {
		super(ConstantConfig.SUCCESS_CODE, message, data);
		// TODO Auto-generated constructor stub
	}
	
	public SuccessResult(String message,Long count, Object data) {
		super(ConstantConfig.SUCCESS_CODE, message,count, data);
		// TODO Auto-generated constructor stub
	}
	
}
