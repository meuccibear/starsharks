package io.renren.common.gitUtils.http;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import io.renren.common.gitUtils.BeanUtils;
import io.renren.common.gitUtils.ObjectUtils;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.kdl.AuthFactory;
import io.renren.common.gitUtils.kdl.Client;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * 网络工具类
 */
public class HttpUtils {

//        <dependency>
//            <groupId>org.apache.httpcomponents</groupId>
//            <artifactId>httpcore</artifactId>
//            <version>4.4.10</version>
//        </dependency>
//
//        <!-- https://mvnrepository.com/artifact/org.apache.httpcomponents/httpclient -->
//        <dependency>
//            <groupId>org.apache.httpcomponents</groupId>
//            <artifactId>httpclient</artifactId>
//            <version>4.5.6</version>
//        </dependency>


    //1.get （url） File
    //2.get （url） 网页
    //3.post () 表单
    //4.post () 表单 json www/m

    public static final String CHARSET_UTF8 = "UTF-8";

    private final static Client client = AuthFactory.build();

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpUtils.class);


    // 代理 所需要的参数
    public static String hostname = "127.0.0.1";
    public static int port = 8866;
    public static boolean isProxy = false;
    public static String scheme = "http";


    // HttpClient 三种 Http Basic 验证方式 0、标准模式 1、抢先模式 2、原生 Http Basic 模式
    public static Integer authenticationType = 0;

    // 原生 Http Basic 模式 所需参数
    public static String userName = null, userPassword = "";


    /**
     * 设置 代理地址
     *
     * @param ip
     */
    public static void setProxyAddr(String ip) {
        if (ObjectUtils.notIsEmpty(ip) && ip.contains(":")) {
            String[] datas = ip.split(":");
            hostname = datas[0];
            port = Integer.parseInt(datas[1]);
            LOGGER.info("代理以设置为: " + String.format("%s:%s", hostname, port));
            isProxy = true;
        } else {
            isProxy = false;
        }
    }

    /**
     * 设置 Http Basic 用户验证
     *
     * @param userName
     * @param userPassword
     */
    public static void setUser(String userName, String userPassword) {
        authenticationType = 2;
        HttpUtils.userName = userName;
        HttpUtils.userPassword = userPassword;
    }

    /**
     * 发送GET请求
     *
     * @param url       请求url
     * @param parameter 请求参数
     * @param ip        ip
     * @param scheme    协议
     * @param headers   头部信息
     * @return JSON或者字符串
     * @ 异常信息
     */
    public static HttpResultData get(String url, Map<String, String> parameter, Map<String, String> headers) throws MsgException {


        //创建URIBuilder
        URIBuilder uriBuilder = null;
        try {
            uriBuilder = new URIBuilder(url);
        } catch (URISyntaxException e) {
            throw new MsgException("URI语法异常");
        }

        //设置参数
        uriBuilder.addParameters(ObjectUtils.isEmpty(parameter) ? new ArrayList<>() : buildHttpPost(parameter));


        headers.remove("content-length");
        headers.remove(":method");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36");

        //创建HttpGet
        HttpGet httpGet = null;
        try {
            httpGet = new HttpGet(uriBuilder.build());
        } catch (URISyntaxException e) {
            throw new MsgException("URI语法异常");
        }

        //代理
        if (isProxy) {
            httpGet.setConfig(RequestConfig.custom().setProxy(HttpHostFactory.build(hostname, port, scheme)).build());
        }

        HttpResultData httpResultData = send(httpGet, headers);

        //发送请求
        return httpResultData;

    }

    public static HttpResultData post(String url, Object parameter, String headers) throws MsgException, HttpHostConnectException {
        return post(url, parameter, headers);
    }

    public static HttpResultData post(String url, Object parameter, Map<String, String> headers) throws MsgException, HttpHostConnectException {

        //创建一个post对象
        HttpPost post = new HttpPost(url);

        //代理
        if (isProxy) {
            setPostProxy(post);
        }

        setEntity(post, parameter);

        //发送请求
        return send(post, headers);
    }

    /**
     * 获取文件
     *
     * @param url 链接
     * @return 字节流
     * @throws MsgException 异常信息
     */
    public static byte[] getFile(String url) throws MsgException {
        //通过输入流获取图片数据
        InputStream inStream = url(url);
        //得到图片的二进制数据，以二进制封装得到数据，具有通用性
        return readInputStream(inStream);
    }

    public static BufferedImage getImg(String url) throws MsgException {
        //得到图片的二进制数据，以二进制封装得到数据，具有通用性
        try {
            return ImageIO.read(url(url));
        } catch (IOException e) {
            throw new MsgException("数据流异常~");
        }
    }

    public static byte[] readInputStream(InputStream inStream) {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();

        if (ObjectUtils.notIsEmpty(inStream)) {
            //创建一个Buffer字符串
            byte[] buffer = new byte[1024];
            //每次读取的字符串长度，如果为-1，代表全部读取完毕
            int len = 0;
            //使用一个输入流从buffer里把数据读取出来
            while (true) {
                try {
                    if (!((len = inStream.read(buffer)) != -1)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
                outStream.write(buffer, 0, len);
            }
            //关闭输入流
            try {
                inStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //把outStream里的数据写入内存
        return outStream.toByteArray();
    }

    public static InputStream url(String url) throws MsgException {

        try {
            // 将string转成url对象
            URL realUrl = new URL(url);

            // 初始化一个链接到那个url的连接
            URLConnection connection = realUrl.openConnection();
//            connection.setConnectTimeout(100);
            // 开始实际的连接
            connection.connect();

            return connection.getInputStream();

        } catch (SocketException e) {
            throw new MsgException("链接不能访问~");
        } catch (FileNotFoundException e) {
            throw new MsgException("链接文件不存在~");
        } catch (UnknownHostException e) {
            if (isProxy) {
                throw new MsgException(String.format("代理：%s:%d 不能访问~", hostname, port));
            } else {
                throw new MsgException("链接不能访问~");
            }
        } catch (Exception e) {
            LOGGER.error("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }

        return null;
    }


    /**
     * 发送请求获取字符流
     *
     * @param url 链接
     * @return 返回的字符串
     */
    public static String getInputStream(String url) throws MsgException {

        InputStream inStream = url(url);

        // 定义一个字符串用来存储网页内容
        StringBuilder result = new StringBuilder();

        // 定义一个缓冲字符输入流
        BufferedReader in = null;
        try {
            // 初始化 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(inStream, StandardCharsets.UTF_8));

//             用来临时存储抓取到的每一行的数据
            String line;
            while ((line = in.readLine()) != null) {
                // 遍历抓取到的每一行并将其存储到result里面
                result.append(new String(line.getBytes(), StandardCharsets.UTF_8)).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 使用finally来关闭输入流
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return result.toString();
    }

    public static Map<String, String> oToMap(Object o) {

        if (null != o) {
            JSONObject jsonObject = (JSONObject) JSONObject.toJSON(o);
            return JSONObject.parseObject(jsonObject.toJSONString(), new TypeReference<Map<String, String>>() {
            });
        }
        return new HashMap<>();
    }

    public static Map<String, String> toMap(String json) {

        if (json == null) {
            return new HashMap<>();
        }
        String[] cooices = json.trim().split("&");

        Map<String, String> hashMap = new HashMap<>();

        for (String cooice : cooices) {
            String[] item = cooice.split("=");
            String name = "", value = "";
            if (!ObjectUtils.isEmpty(item) && item.length >= 1) {
                name = item[0];
                if (item.length >= 2) {
                    value = item[1];
                }
            }
            hashMap.put(name, value);
        }

        return hashMap;
    }

    /**
     * 获取外网IP
     *
     * @return ip
     */
    public static String getExtranetIP() throws MsgException {
        //参考网址
        //3、命令1：curl ipv4.icanhazip.com
        //
        //4、命令2：curl ifconfig.io
        //
        //5、命令3：curl httpbin.org/ip
        return getInputStream("http://ipv4.icanhazip.com/");
    }

    static List<String> headerKeys = new ArrayList<String>() {
        {
            add("content-length");
            add("Content-Length");
            add(":method");
            add("Authorization");
            add("Host");
        }
    };

    /**
     * 发送请求
     *
     * @param request 请求
     * @return 返回 HttpResultData 对象
     * @throws IOException 异常信息
     */
    private static HttpResultData send(HttpUriRequest request, Map<String, String> headers) throws MsgException {
        /*
         * ps：
         * Content-Type 请求头部编码
         * Accept 返回编码
         */
        //设置请求头信息
        if (null != headers) {
            for (String key : headers.keySet()) {
                if (!headerKeys.contains(key)) {
//                    System.out.println(key);
                    request.setHeader(new BasicHeader(key, headers.get(key)));
                }
            }
        }

        if (authenticationType == 2) {
            //String a = Base64.getUrlEncoder().encodeToString((username + ":" + password).getBytes());
            //添加http头信息
            request.addHeader("Authorization", "Basic " + Base64.getUrlEncoder().encodeToString((userName + ":" + userPassword).getBytes()));
            request.addHeader("Content-Type", "application/json");
            //httpPost.addHeader("Authorization","Basic "+a);
        }

        //创建一个httpclient对象
        CookieStore store = new BasicCookieStore();
        HttpClient client = SSLClient.sslClient(store);

        //执行请求
        HttpResponse response = null;
        try {
            response = client.execute(request);
        } catch (IOException e) {
            e.printStackTrace();
            throw new MsgException("IO异常");
        }

        //获取响应码
        int statusCode = response.getStatusLine().getStatusCode();

        //获取返回对象
        HttpEntity entity = response.getEntity();

        //通过EntityUitls获取返回内容
        String result = null;
        try {
            result = EntityUtils.toString(entity, "UTF-8");
        } catch (IOException e) {
            throw new MsgException("IO异常");
        }

        HttpResultData httpResultData = new HttpResultData(statusCode, result, getCookie(store));
        if (ObjectUtils.isEmpty(httpResultData)) {
            throw new MsgException("loginInfo 接口网络问题~");
        }

//        System.out.println(String.format("链接:%s \n结果: %s", request.getURI(), JSONObject.toJSONString(httpResultData)));

        return httpResultData;
    }


    private static void setEntity(HttpPost post, Object parameter) throws MsgException {

        //包装成一个Entity对象
        StringEntity stringEntity = null;

        //body请求
        if (parameter instanceof String) {
            stringEntity = new StringEntity((String) parameter, "UTF-8");
        }

        //url请求
        if (parameter instanceof Map) {
            try {
                stringEntity = new UrlEncodedFormEntity(buildHttpPost(parameter), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                throw new MsgException("不支持的编码异常");
            }
        }

        if (null == stringEntity) {
            throw new MsgException("为空！");
        }

        //设置请求的内容
        post.setEntity(stringEntity);
    }

    /**
     * 封装参数
     *
     * @param parameter 参数
     * @return List<NameValuePair>
     */
    public static List<NameValuePair> buildHttpPost(Object parameter) {

        Map<String, String> params = BeanUtils.toJavaObject(parameter, new TypeReference<Map<String, String>>() {
        });
        List<NameValuePair> ps = new ArrayList<>();
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                ps.add(new BasicNameValuePair(key, params.get(key)));
            }
        }
        return ps;
    }

    private static Map<String, String> getCookie(Object store) {
        CookieStore cookieStore = (CookieStore) store;
        Map<String, String> map = new HashMap<>();
        for (Cookie cookie : cookieStore.getCookies()) {
            map.put(cookie.getName(), cookie.getValue());
        }
        return map;
    }

    private static void setPostProxy(HttpPost post) {
        RequestConfig.Builder requestConfigBuilder = RequestConfig.custom();
        setPostProxy(requestConfigBuilder);
        post.setConfig(requestConfigBuilder.build());
    }

    private static void setPostProxy(RequestConfig.Builder requestConfigBuilder) {
        LOGGER.debug(String.format("%s:%s", hostname, port));
        HttpHost proxy = new HttpHost(hostname, port, "http"); //添加代理，IP为本地IP 8888就是fillder的端口
        requestConfigBuilder.setProxy(proxy);
    }


    /**
     * eadres str 转 对象
     *
     * @param headresStr
     * @return
     */
    public static Map<String, String> getHeadres(String headresStr) {
        headresStr = headresStr.trim();
        Map<String, String> result = new HashMap<>();

        if (ObjectUtils.isEmpty(headresStr)) {
            return result;
        }
        String[] headers = headresStr.split("\n");
        for (String header : headers) {
            if (ObjectUtils.notIsEmpty(header)) {
                String[] aa = header.split(":");
                if (aa.length == 2) {
                    if (ObjectUtils.isEmpty(aa[0]) || ObjectUtils.isEmpty(aa[1])) {
                        continue;
                    }
                    result.put(aa[0], aa[1]);
                }
            }
        }
        return result;
    }

    public static HttpResultData get(String url) throws MsgException {
        return get(url, null, "");
    }

    public static HttpResultData get(String url, Map<String, String> headers) throws MsgException {
        return get(url, null, headers);
    }

    public static HttpResultData get(String url, Object parameter, Map<String, String> headers) throws MsgException {
        return get(url, oToMap(parameter), headers);
    }

    public static HttpResultData get(String url, Object parameter, String headers) throws MsgException {
        return get(url, oToMap(parameter), getHeadres(headers));
    }

}
