package io.renren.common.gitUtils.kdl;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;

/**
 * 用于保存用户orderid, apiKey, 以及计算签名的对象。
 */
public class Auth {
    private static final String CHARSET = "UTF-8";

    private String orderId;
    private String apiKey;

    public Auth(String orderId, String apiKey) {
        this.orderId = orderId;
        this.apiKey = apiKey;
    }

    public Auth(String yourorderid) {
    }

    public String sign(String s) throws Exception {
        return sign(s, "HmacSHA1");
    }

    public String sign(String s, String method) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
        Mac mac = Mac.getInstance(method);
        SecretKeySpec secretKeySpec = new SecretKeySpec(this.apiKey.getBytes(CHARSET), mac.getAlgorithm());
        mac.init(secretKeySpec);
        byte[] hash = mac.doFinal(s.getBytes(CHARSET));
        return DatatypeConverter.printBase64Binary(hash);
    }

    public  String getStringToSign(String method, String endpoint, TreeMap<String, Object> params) {
        String s = method + endpoint.split(".com")[1] + "?";
        StringBuilder s2s = new StringBuilder();
        // 签名时要求对参数进行字典排序，此处用TreeMap保证顺序
        for (Map.Entry<String,Object> entry : params.entrySet()){
            s2s.append(entry.getKey()).append("=").append(entry.getValue().toString()).append("&");
        }
        return s + s2s.toString().substring(0, s2s.length() - 1);
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getApiKey() {
        return this.apiKey;
    }

}
