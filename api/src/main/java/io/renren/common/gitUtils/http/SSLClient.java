package io.renren.common.gitUtils.http;


import org.apache.http.client.CookieStore;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;

public class SSLClient {

    public static CloseableHttpClient sslClient() {
        return sslHandle().build();
    }

    //cookie
    public static CloseableHttpClient sslClient(CookieStore cookieStore){
        return sslHandle().setDefaultCookieStore(cookieStore).build();
    }

    //ssl
    public static HttpClientBuilder sslHandle(){
         try {
             // 在调用SSL之前需要重写验证方法，取消检测SSL
             X509TrustManager trustManager = new X509TrustManager() {
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
             SSLContext ctx = SSLContext.getInstance(SSLConnectionSocketFactory.TLS);
             ctx.init(null, new TrustManager[]{trustManager}, null);
             SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(ctx, NoopHostnameVerifier.INSTANCE);
             // 创建Registry
             RequestConfig requestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD_STRICT)
                     .setExpectContinueEnabled(Boolean.TRUE).setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST))
                     .setProxyPreferredAuthSchemes(Collections.singletonList(AuthSchemes.BASIC)).build();
             Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                     .register("http", PlainConnectionSocketFactory.INSTANCE)
                     .register("https", socketFactory).build();
             // 创建ConnectionManager，添加Connection配置信息
             PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
             return HttpClients.custom().setConnectionManager(connectionManager).setDefaultRequestConfig(requestConfig);
         } catch (KeyManagementException | NoSuchAlgorithmException ex) {
             throw new RuntimeException(ex);
         }
    }

}
