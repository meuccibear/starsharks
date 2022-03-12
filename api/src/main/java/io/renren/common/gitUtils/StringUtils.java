package io.renren.common.gitUtils;

import com.alibaba.fastjson.JSONObject;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: DemoJava
 * @description:
 * @author: Zhuozhuang.Lv
 * @create: 2020-01-06 16:20
 */

public class StringUtils {

    public static Boolean isEmpty(Object value) {
        return !notIsEmpty(value);
    }

    public static Boolean notIsEmpty(Object value) {
        if (value == null) {
            return false;
        } else if (value instanceof String) {
//            System.out.println("String");
            return ((String) value).length() > 0;
        } else if (value instanceof Integer) {
//            System.out.println("Integer");
            return (Integer) value > 0;
        }
        return true;
    }

    public static String substringSup(String str, String beginStr, String endStr) {
        beginStr = StringUtils.clearSpace(beginStr);
        endStr = StringUtils.clearSpace(endStr);
        return substring(str, beginStr, endStr);

    }

    public static String substring(String str, String beginStr, String endStr) {
        int beginIndex = str.indexOf(beginStr);
        if (beginIndex > -1) {
            String lastStr = str.substring(beginIndex + beginStr.length(), str.length());
            int lastIndex = lastStr.indexOf(endStr);
            if (StringUtils.notIsEmpty(lastIndex) && lastIndex > -1) {
                return lastStr.substring(0, lastIndex).toString().replaceAll(" ", "");
            } else {
                return "";
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(substring("ap:12)", "ap:", ")"));
    }

    public static String getString(String res, String regex) {
        regex = StringUtils.clearSpace(regex);

        // 定义一个样式模板，此中使用正则表达式，括号中是要抓的内容
        // 相当于埋好了陷阱匹配的地方就会掉下去
        Pattern pattern = Pattern.compile(regex);
        // 定义一个matcher用来做匹配
        Matcher matcher = pattern.matcher(res);
        // 如果找到了
        if (matcher.find()) {
            // 打印出结果
            return matcher.group(1);
        }

        return "";
    }

    public static String clearSpace(String str) {
        return str.replaceAll(" ", "");
    }

    public static boolean indexOf(String str, String indexOfStr) {
        int index = str.indexOf(".html");
        return index >= 0;
    }

    public static String toUrl(Object obj) {
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(obj);
        Iterator<String> iterator = jsonObject.keySet().iterator();
        StringBuilder stringBuilder = new StringBuilder();
        while (iterator.hasNext()) {
            String key = iterator.next();
            String value = (String) jsonObject.get(key);
            if (StringUtils.notIsEmpty(value)) {
                stringBuilder.append(String.format("%s=%s", key, value)).append("; ");
            }
        }
        return stringBuilder.toString();
    }

    public static String outStr(String str, Object... clos) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Object clo : clos) {
            stringBuffer.append(str);
            stringBuffer.append(clo);
        }
        return stringBuffer.toString();
    }


    public static void writeList(String str, Object... clos) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Object clo : clos) {
            stringBuffer.append(str);
            stringBuffer.append(clo);
        }
        System.out.println(stringBuffer.substring(1, stringBuffer.length()));
    }


    /**
     *
     * @param tempStr
     * @param str
     * @return
     */
    public static String toTempStr(String tempStr, String str) {
        int num = tempStr.length() - str.length();
        return tempStr.substring(0, num) + str;
    }

}
