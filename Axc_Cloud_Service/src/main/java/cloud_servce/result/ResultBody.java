package cloud_servce.result;

/**
 *结果返回体
 * @author xiazhiyu
 */
public class ResultBody {
    /**
     * 响应代码
     */
    private String code;

    /**
     * 响应消息
     */
    private String message;
    /**
     * 数据总数
     */
    private Long count;
    /**
     * 响应结果
     */
    private Object data;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public ResultBody() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResultBody(Object data) {
		super();
		this.data = data;
	}
	
	public ResultBody(String code, String message, Long count, Object data) {
		super();
		this.code = code;
		this.message = message;
		this.count = count;
		this.data = data;
	}
	public ResultBody(String code, String message, Object data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}
	public ResultBody(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	public ResultBody(String message) {
		super();
		this.message = message;
	}
	public ResultBody(String code, Object data) {
		super();
		this.code = code;
		this.data = data;
	}	
	
}
