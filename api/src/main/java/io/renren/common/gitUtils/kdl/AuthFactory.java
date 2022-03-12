package io.renren.common.gitUtils.kdl;


import java.util.HashMap;

/**
 * 用于保存用户orderid, apiKey, 以及计算签名的对象。
 */
public class AuthFactory {

    private static final String orderId = "937188407716475";
    private static final String apiKey = "0fly27iakrr32ozrs2q0wbetpdak9p7t";

    public static Client build() {
        Auth auth = new Auth(orderId, apiKey);
        return new Client(auth);
    }

    public static void main(String[] args) {
        try {
            System.out.println(AuthFactory.build().get_dps(1,new HashMap<>()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
