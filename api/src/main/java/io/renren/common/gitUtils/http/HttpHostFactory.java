package io.renren.common.gitUtils.http;

import org.apache.http.HttpHost;

/**
 * @program: demo
 * @description:
 * @author: Zhuozhuang.Lv
 * @create: 2019-10-05 14:47
 */

public class HttpHostFactory {

    public static HttpHost build(String hostname, int port, String scheme) {
//        String hostname = null;
//        int port;
//        {
//            String beginIndexStr = ":";
//            int index = ip.indexOf(beginIndexStr);
//            hostname = ip.substring(0, index);
//            port = Integer.parseInt(ip.substring(index + beginIndexStr.length(), ip.length()));
//        }
        System.out.println(String.format("hostname:%s\tport:%s\tscheme:%s", hostname, port, scheme));
        return new HttpHost(hostname, port, scheme);
    }
}
