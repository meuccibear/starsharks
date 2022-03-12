package io.renren.common.gitUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * List 转换类
 *
 * @Description:
 * @Date: Created in 2018/8/14 21:53
 * @Author: Wangll
 */
public class BeanUtils {

    protected final Log logger = LogFactory.getLog(BeanUtils.class);


    /**
     * 首字母转大写
     *
     * @param s 字符串
     * @return stirng
     * update wmk
     */
    private static String toUpcase(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1, s.length());
    }

    /**
     * 多个实体类的属性，合并到一个实体类
     * eg:
     * RiderUserBaseInfo riderUserBaseInfo = new RiderUserBaseInfo();
     * OrderStatistics orderStatistics = new OrderStatistics();
     * riderUserBaseInfo.setHeadImageUrl("asdasdasd");
     * orderStatistics.setOrderAmountTotal(1);
     * System.out.println(JSONObject.toJSONString(mergeObjects(RiderMyPageVO.class,riderUserBaseInfo,orderStatistics)));
     *
     * @param clazz
     * @param values 需要合并的实体类
     * @return Object
     */
    public static <T> T mergeObjects(Class<T> clazz, Object... values) {
        if (null == clazz) {
            return null;
        }
        JSONObject jsonObject = new JSONObject();
        if (values != null) {
            for (Object o : values) {
                if (null != o) {
                    jsonObject.putAll(toJSON(o));
                }
            }
        }
        String jsonStr = jsonObject.toJSONString();
        return JSONObject.parseObject(jsonStr, clazz);
    }

    /**
     * 将一个实体类集合 换成 另一种实体类集合
     * eg:
     * List<AreaDistance> areaDistances = new ArrayList<>();
     * AreaDistance areaDistance = new AreaDistance();
     * areaDistance.setAmount(BigDecimal.valueOf(11));
     * areaDistances.add(areaDistance);
     * <p>
     * List<AreaDistanceVO> areaDistanceVOS = (List<AreaDistanceVO>) BeanUtils.exchangeObjectToList(AreaDistanceVO.class, areaDistances);
     *
     * @param clazz
     * @param list
     * @return
     */
    public static <T> List<T> exchangeObjectToList(Class<T> clazz, List<?> list) {
        List<T> objects = new ArrayList<T>();
        if (null != list) {
            for (Object object : list) {
                objects.add(mergeObjects(clazz, object));
            }
        }
        return objects;
    }

    /**
     * Object 转 任意实体类 或者 Map
     * eg:
     * Data result = BeanUtils.toJavaObject(xprinterResult.getResult(), new TypeReference<Data>() {});
     *
     * @param obj  实体类
     * @param type 类型
     * @param <T>  任意实体类 或者 Map
     * @return
     */
    public static <T> T toJavaObject(Object obj, TypeReference<T> type) {
        String text = "";
        if (obj instanceof String) {
            text = (String) obj;
            if (ObjectUtils.isEmpty(text)) {
                text = "{}";
            }

        } else {
            text = JSON.toJSONString(obj);
        }

        return JSONObject.parseObject(text, type);
    }


    public static JSONObject toJSON(Object data) {
        String json;
        if (data instanceof String) {
            json = (String) data;
        } else {
            json = JSONObject.toJSONString(data);
        }

        return JSONObject.parseObject(json);
    }


    public static Object getData(JSONObject jsonObject, String str) {
        String[] colNames = str.split("\\.");

        JSONObject resultData = null;
        for (int i = 0; i < colNames.length; i++) {
            if (i + 1 == colNames.length) {
                if(ObjectUtils.notIsEmpty(resultData)){
                    return resultData.get(colNames[i]);
                }else{
                    return jsonObject.get(colNames[i]);
                }
            } else {
                resultData = jsonObject.getJSONObject(colNames[i]);
            }
        }
        return null;
    }

    public static Integer getInt(JSONObject jsonObject, String str) {
        String[] colNames = str.split("\\.");

        JSONObject resultData = null;
        for (int i = 0; i < colNames.length; i++) {
            if (i + 1 == colNames.length) {
                if(ObjectUtils.notIsEmpty(resultData)){
                    return resultData.getInteger(colNames[i]);
                }else{
                    return jsonObject.getInteger(colNames[i]);
                }
            } else {
                resultData = jsonObject.getJSONObject(colNames[i]);
            }
        }
        return 0;
    }
    public static Double getDouble(JSONObject jsonObject, String str) {
        String[] colNames = str.split("\\.");

        JSONObject resultData = null;
        for (int i = 0; i < colNames.length; i++) {
            if (i + 1 == colNames.length) {
                if(ObjectUtils.notIsEmpty(resultData)){
                    return resultData.getDouble(colNames[i]);
                }else{
                    return jsonObject.getDouble(colNames[i]);
                }
            } else {
                resultData = jsonObject.getJSONObject(colNames[i]);
            }
        }
        return 0.00;
    }

    public static JSONObject getJSONObject(JSONObject jsonObject, String str) {
        String[] colNames = str.split("\\.");

        JSONObject resultData = null;
        for (int i = 0; i < colNames.length; i++) {
            resultData = jsonObject.getJSONObject(colNames[i]);
        }
        return resultData;
    }

    public static JSONArray getJSONArray(JSONObject jsonObject, String str) {
        String[] colNames = str.split("\\.");
        JSONObject resultData = null;
        for (int i = 0; i < colNames.length; i++) {
            if (i + 1 == colNames.length) {
                if(ObjectUtils.notIsEmpty(resultData)){
                    return resultData.getJSONArray(colNames[i]);
                }else{
                    return jsonObject.getJSONArray(colNames[i]);
                }
            } else {
                resultData = jsonObject.getJSONObject(colNames[i]);
            }
        }
        return new JSONArray();
    }

}
