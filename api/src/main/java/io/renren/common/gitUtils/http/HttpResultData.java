package io.renren.common.gitUtils.http;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HttpResultData {

    //状态
    private int status;

    public static final int SUCCESS = 200;

    /**
     * 返回信息
     */
    private String result;

    /**
     * Cookie
     */
    private Map<String, String> cookie;

    /**
     * 转Json对象
     * @return
     */
    public JSONObject toResultJsonObject(){
        System.out.println(getResult());
        return JSONObject.parseObject(getResult());
    }

}
