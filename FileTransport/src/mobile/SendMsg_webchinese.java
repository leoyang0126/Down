package mobile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
 
public class SendMsg_webchinese {
 
public static void main(String[] args) throws Exception {
 
//   HttpClient client = new HttpClient();
//   PostMethod post = new PostMethod("http://sms.webchinese.cn/web_api/");
//   post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");// 在头文件中设置转码
//   NameValuePair[] data = { new NameValuePair("Uid", "uuid"),  // 注册的用户名
//   new NameValuePair("Key", "670513"),  // 注册成功后,登录网站使用的密钥
//   new NameValuePair("smsMob", "13671621749"),  // 手机号码
//   new NameValuePair("smsText", "java程序发的信息!!，哈哈哈。。。。。。。") };
//   post.setRequestBody(data);
// 
//   client.executeMethod(post);
//   Header[] headers = post.getResponseHeaders();
//   int statusCode = post.getStatusCode();
//   System.out.println("statusCode:" + statusCode);
//   for (Header h : headers) {
//      System.out.println(h.toString());
//   }
//  String result = new String(post.getResponseBodyAsString().getBytes("gbk"));
//  System.out.println(result);
//  post.releaseConnection();
	Map<String,String> paramStr=new HashMap<>();
	paramStr.put("Uid", "uuid");
	paramStr.put("Key", "b515d8e1bdd5d045b2cd");
	paramStr.put("smsMob", "13671621749");
	paramStr.put("smsText", "java程序发的信息!!，哈哈哈。。。。。。。");
	String s=bulidGet(paramStr,true);
	String responseStr=sendPost("http://sms.webchinese.cn/web_api/", s);
	System.out.println("响应的报文："+responseStr);
  }

public static String bulidGet(Map<?, ?> map, boolean urlEncode) {
	StringBuffer sb = new StringBuffer(map.size() * 16);
	for (Map.Entry<?, ?> entry : map.entrySet()) {
		if (urlEncode)
			sb.append(String.valueOf(entry.getKey()) + "=" + URLEncoder.encode(String.valueOf(entry.getValue()))+"&");
		else
			sb.append(String.valueOf(entry.getKey()) + "=" + String.valueOf(entry.getValue())+"&");
	}
	String str = sb.toString();
	return str.substring(0, str.length() - 1);
}

/**
 * 向指定 URL 发送POST方法的请求
 * 
 * @param url
 *            发送请求的 URL
 * @param param
 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
 * @return 所代表远程资源的响应结果
 * @throws Exception
 */
private static String sendPost(String url, String param) throws Exception {
	PrintWriter out = null;
	BufferedReader in = null;
	String result = "";
	try {
		URL realUrl = new URL(url);
		// 打开和URL之间的连接
		URLConnection conn = realUrl.openConnection();
		// 设置通用的请求属性
		conn.setRequestProperty("accept", "*/*");
		conn.setRequestProperty("connection", "Keep-Alive");
		conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
		// 发送POST请求必须设置如下两行
		conn.setDoOutput(true);
		conn.setDoInput(true);
		// 获取URLConnection对象对应的输出流
		out = new PrintWriter(conn.getOutputStream());
		// 发送请求参数
		out.print(param);
		// flush输出流的缓冲
		out.flush();
		out.close();
		// 定义BufferedReader输入流来读取URL的响应
		in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		while ((line = in.readLine()) != null) {
			result += line;
		}
	} catch (Exception e) {
		System.out.println("发送 POST 请求出现异常！" + e);
		e.printStackTrace();
		throw e;
	} finally {
		try {
			if (out != null) {
				out.close();
			}
			if (in != null) {
				in.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	return result;
}
}
 
