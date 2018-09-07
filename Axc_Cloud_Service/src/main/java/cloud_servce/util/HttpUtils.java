package cloud_servce.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import com.alibaba.fastjson.JSON;

public class HttpUtils {

	
	public static HttpResponse doGet(
			String host,
			Map<String, String> params) 
					throws ClientProtocolException, IOException, KeyManagementException, NoSuchAlgorithmException{
		return HttpUtils.doGet(host, null, null, params);
	}
	/**
	 * get
	 * @param host
	 * @param path
	 * @param headers
	 * @param querys
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 * @throws Exception
	 */
	public static HttpResponse doGet(
			String host,
			String path,
			Map<String, String> headers,
			Map<String, String> querys) 
					throws ClientProtocolException, IOException, KeyManagementException, NoSuchAlgorithmException{
		HttpClient httpClient = wrapClient(host);
		HttpGet request = new HttpGet(buildUrl(host, path, querys));
		if (headers!=null) {
			for (Map.Entry<String, String> e : headers.entrySet()) {
				request.addHeader(e.getKey(), e.getValue());
			}
		}
		return httpClient.execute(request);
	}


	public static HttpResponse doPost(
			String host, 
			Map<String, String> params) 
					throws ClientProtocolException, IOException, KeyManagementException, NoSuchAlgorithmException
	{
		return HttpUtils.doPost(host, null, null, params, null);
	}
	/**
	 * post form
	 *
	 * @param host
	 * @param path
	 * @param method
	 * @param headers
	 * @param querys
	 * @param bodys
	 * @return
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 * @throws Exception
	 */
	public static HttpResponse doPost(
			String host, 
			String path,
			Map<String, String> headers,Map<String, String> params,
			Map<String, String> bodys) 
					throws ClientProtocolException, IOException, KeyManagementException, NoSuchAlgorithmException
	{
		HttpClient httpClient = wrapClient(host);

		HttpPost request = new HttpPost(buildUrl(host, path, params));
		if (headers!=null) {
			for (Map.Entry<String, String> e : headers.entrySet()) {
				request.addHeader(e.getKey(), e.getValue());
			}
		}
		if (bodys != null) {
			String data = new JSONObject(bodys).toString();
			StringEntity entity = new StringEntity(data, "utf-8");
			entity.setContentType("application/json");
			request.setEntity(entity);
		}
		return httpClient.execute(request);
	}

	private static String buildUrl(String host, String path, Map<String, String> querys) throws UnsupportedEncodingException {
		StringBuilder sbUrl = new StringBuilder();
		sbUrl.append(host);
		if (!StringUtils.isBlank(path)) {
			sbUrl.append(path);
		}
		if (null != querys) {
			StringBuilder sbQuery = new StringBuilder();
			for (Map.Entry<String, String> query : querys.entrySet()) {
				if (0 < sbQuery.length()) {
					sbQuery.append("&");
				}
				if (StringUtils.isBlank(query.getKey()) && !StringUtils.isBlank(query.getValue())) {
					sbQuery.append(query.getValue());
				}
				if (!StringUtils.isBlank(query.getKey())) {
					sbQuery.append(query.getKey());
					if (!StringUtils.isBlank(query.getValue())) {
						sbQuery.append("=");
						sbQuery.append(URLEncoder.encode(query.getValue(), "utf-8"));
					}
				}
			}
			if (0 < sbQuery.length()) {
				sbUrl.append("?").append(sbQuery);
			}
		}

		return sbUrl.toString();
	}

	private static HttpClient wrapClient(String host) throws KeyManagementException, NoSuchAlgorithmException {
		HttpClient httpClient = new DefaultHttpClient();
		if (host.startsWith("https://")) {
			sslClient(httpClient);
		}

		return httpClient;
	}

	private static void sslClient(HttpClient httpClient) throws KeyManagementException, NoSuchAlgorithmException {
		SSLContext ctx = SSLContext.getInstance("TLS");
		X509TrustManager tm = new X509TrustManager() {
			@Override
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}
			@Override
			public void checkClientTrusted(X509Certificate[] xcs, String str) {

			}
			@Override
			public void checkServerTrusted(X509Certificate[] xcs, String str) {

			}
		};
		TrustManager[] tmArray = new TrustManager[1];
		tmArray[0] = tm;
		ctx.init(null,tmArray, null);
		SSLSocketFactory ssf = new SSLSocketFactory(ctx);
		ssf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		ClientConnectionManager ccm = httpClient.getConnectionManager();
		SchemeRegistry registry = ccm.getSchemeRegistry();
		registry.register(new Scheme("https", 443, ssf));
	}
}
