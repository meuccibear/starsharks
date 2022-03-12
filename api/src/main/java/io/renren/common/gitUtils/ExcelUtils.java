package io.renren.common.gitUtils;

import com.alibaba.fastjson.JSONObject;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.FileUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: HNTD
 * @ClassName Excel
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-02-22 11:27
 * @Version 1.0
 **/
public class ExcelUtils {



    public static void main(String[] args) throws MsgException {
//        List<JSONObject> jsonArray = readFile("./devices3.txt");
//
//        jsonArray.forEach(jsonO -> {
//            JSONObject jsonObject = (JSONObject) jsonO;
////            getHotspotsById();
//            System.out.println(jsonObject.get("address"));
//        });


        System.out.println(System.getProperty("user.dir"));
//        System.out.println(toTempStr("0000000000000000", "100"));

    }


    public static String toTempStr(String tempStr, String str) {
        int num = tempStr.length() - str.length();
        return tempStr.substring(0, num) + str;
    }

    public static String toTempStr1(String tempStr, int num) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            sb.append(tempStr);
        }
        return sb.toString();
    }


    public static List<JSONObject> readFile(String path) throws MsgException {
        List<String> strings = FileUtils.readLines(path);
        JSONObject jsonObject;
        List<JSONObject> jsonArray = new ArrayList<>();
        String tempStr;
        String[] cols = new String[0];
        String[] vals;
        for (int i = 0; i < strings.size(); i++) {
            tempStr = strings.get(i);
            if (ObjectUtils.notIsEmpty(tempStr)) {
                if (0 == i) {
                    cols = tempStr.split("\t");
                } else {
                    vals = tempStr.split("\t");
                    jsonObject = new JSONObject();
                    for (int i1 = 0; i1 < cols.length; i1++) {
                        jsonObject.put(cols[i1], vals[i1]);
                    }
                    jsonArray.add(jsonObject);
                }
            }
        }
        return jsonArray;
    }
}
