package cloud_servce.conf;

public class ConstantConfig {
	public static final int PAGE_SIZE = 10;
	public static final String SUCCESS_CODE = "0";
	public static final String FAILURE_CODE = "400";
	public static final String AVATAR = "http://a-news.oss-cn-hangzhou.aliyuncs.com/avatar.jpg";
	public static final int TOKEN_EXPRESS_SECONDS = 3600;//token 有效时间

	public static final String EMPTY_PHONE_PROMPT = "手机号不能为空！";
	public static final String EMPTY_USER_PROMPT = "用户不存在！";
	public static final String USER_PERMISSIONS_PROMPT = "该用户没有足够的权限调用这个接口";

	// 万维易源数据接口
	public static final String SHOWAPI_SECRET = "ccf53b91497d4eeb993c443d90068ad9";
	public static final String SHOWAPI_APPID = "74453";
	// 漫画数据 失效时间：2019-09-07 | 3次/秒
	public static final String SHOWAPI_URL = "http://route.showapi.com/958-1";

	// iDataApi数据接口
	public static final String IDATA_APIKEY = "DTa9ggRDVwjwU4HRWaS8Sn1nJB6j1AW7UIIAUgBrVsoGXqaHyjJNIWRNwHDQpeK1";
	// 分词接口 - 无限制
	public static final String IDATA_PARTICIPLES_URL = "http://120.76.205.241:8000/nlp/segment/bitspaceman";

	// 聚合数据接口
	public static final String JUHE_APIKEY = "5024fea94ccc9e49b3c56c9c5e579de5";
	// 上海黄金交易所 - 黄金数据 | 100次/天
	public static final String JUHE_GOLD_URL = "http://web.juhe.cn:8080/finance/gold/shgold";
	
	
}
