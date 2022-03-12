package io.renren.business.starsharks;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import io.renren.business.domin.starsharks.vo.Shark;
import io.renren.business.domin.starsharks.vo.StarsharksResult;
import io.renren.common.gitUtils.BeanUtils;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.HttpResultData;
import io.renren.common.gitUtils.http.HttpUtils;
import org.apache.http.conn.HttpHostConnectException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 集市
 */
public class Market {

    private static Logger logger = LoggerFactory.getLogger(Market.class);


    public static void main(String[] args) {
        StarsharksResult starsharksResult = new Market().starsharks(1, 100);

        System.out.println(BeanUtils.toJSON(starsharksResult));
    }

    public StarsharksResult starsharks(int page, int page_size) {
        JSONObject result = new Market().sharks(page, page_size);
        JSONObject data = BeanUtils.getJSONObject(result, "data");
        JSONArray sharks = BeanUtils.getJSONArray(data, "sharks");

        JSONObject jsonObject;

        List<Shark> sharkList = new ArrayList<>();
        for (int i = 0; i < sharks.size(); i++) {
            jsonObject = sharks.getJSONObject(i);

            sharkList.add(new Shark(BeanUtils.getInt(jsonObject, "sheet.shark_id"), BeanUtils.getInt(jsonObject, "sheet.rent_cyc"),
                    BeanUtils.getData(jsonObject, "sheet.rent_except_gain").toString(), BeanUtils.getInt(jsonObject, "sheet.next_rent_except_gain"), BeanUtils.getDouble(jsonObject,"sheet.sell_price")));

        }

        return new StarsharksResult(BeanUtils.getInt(data, "curr_page"),
                BeanUtils.getInt(data, "total_page"),
                BeanUtils.getInt(data, "total_count"),
                BeanUtils.getData(data, "sort_by").toString(), sharkList);
    }

    /**
     * 鲨鱼
     *
     * @param page
     * @return
     */
    public JSONObject sharks(int page, int page_size) {

        String headStr =
                "Connection: keep-alive\n" +
                        "sec-ch-ua: \" Not A;Brand\";v=\"99\", \"Chromium\";v=\"98\", \"Google Chrome\";v=\"98\"\n" +
                        "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NDczNTg5MTksImp0aSI6IjB4ODI2NmIzYmIyNDI4YTU1NDlhOWM5MGI0OGY2ZTQxOTE3ZTg4MDQwMyIsInN1YiI6IndlYiJ9.VmliLhir_qMGXteMKya-1md2Rq0sg5I3vuELTv0TgSE\n" +
                        "Content-Type: application/json\n" +
                        "sec-ch-ua-mobile: ?0\n" +
                        "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.102 Safari/537.36\n" +
                        "sec-ch-ua-platform: \"Windows\"\n" +
                        "Accept: */*\n" +
                        "Origin: https://starsharks.com\n" +
                        "Sec-Fetch-Site: same-origin\n" +
                        "Sec-Fetch-Mode: cors\n" +
                        "Sec-Fetch-Dest: empty\n" +
                        "Referer: https://starsharks.com/zh-Hant/market?tab=rent\n" +
                        "Accept-Language: zh-CN,zh;q=0.9\n" +
                        "Cookie: _ga=GA1.1.1524215088.1646148198; _ga_EKLPQL67GF=GS1.1.1646148198.1.1.1646151377.0";

        String data = "{\"class\":[],\"star\":0,\"pureness\":0,\"hp\":[0,200],\"speed\":[0,200],\"skill\":[0,200],\"morale\":[0,200],\"body\":[],\"parts\":[],\"rent_cyc\":0,\"rent_except_gain\":[0,0],\"skill_id\":[0,0,0,0],\"page\":%d,\"filter\":\"rent\",\"sort\":\"PriceAsc\",\"page_size\":36}";
        try {
            Map<String, String> headres = HttpUtils.getHeadres(headStr);
//            HttpUtils.setProxyAddr("127.0.0.1:8866");
            HttpResultData resultData = HttpUtils.post("https://starsharks.com/go/api/market/sharks", String.format(data, page), headres);
            return BeanUtils.toJavaObject(resultData.getResult(), new TypeReference<JSONObject>() {
            });


        } catch (MsgException e) {
            info(e.getMessage());
        } catch (HttpHostConnectException e) {
            info("Http主机连接异常!");
        }
        return null;
    }

    void info(String msg) {
        logger.info("msg:\t" + msg);
    }

}
