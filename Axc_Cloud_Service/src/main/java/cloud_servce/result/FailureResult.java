package cloud_servce.result;

import cloud_servce.conf.ConstantConfig;

public class FailureResult extends ResultBody {
	public FailureResult(String message) {
		super(ConstantConfig.FAILURE_CODE, message);
		// TODO Auto-generated constructor stub
	}

	public FailureResult(String code,String message) {
		super(code, message);
		// TODO Auto-generated constructor stub
	}

	public FailureResult(String message, Object data) {
		super(ConstantConfig.FAILURE_CODE, message, data);
		// TODO Auto-generated constructor stub
	}

	public FailureResult(String code,String message, Object data) {
		super(code, message, data);
		// TODO Auto-generated constructor stub
	}

}
