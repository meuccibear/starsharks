package io.renren.common.gitUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Mr.Lv
 * @Date 2020/8/31 11:10
 */
public class JSONUtils {

    public static Object toJson(String json)  {
        if(StringUtils.isEmpty(json)){
            return new JsonObject();
        }

        String subStr = json.substring(0, 1);
        switch (subStr){
            case "[":
                return JSONArray.parseArray(json);
            case "{":
                return JSONObject.parseObject(json);
            default:
                return new JsonObject();
        }

    }

}
