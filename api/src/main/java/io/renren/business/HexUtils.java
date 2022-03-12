package io.renren.business;

import com.alibaba.fastjson.JSONObject;
import io.renren.business.domin.device.CompletedRewardsBean;
import io.renren.common.gitUtils.BeanUtils;
import io.renren.common.gitUtils.ExcelUtils;
import io.renren.common.gitUtils.ObjectUtils;
import io.renren.common.gitUtils.exception.MsgException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: HNTD
 * @ClassName HexUtils
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-02-23 18:31
 * @Version 1.0
 **/
public class HexUtils {

    Map<String, CompletedRewardsBean> hexMap = new HashMap<>();

    public HexUtils(String path) {
//        Stirng.for
//        "Hexs.txt"
        initHexsFile(path);
    }

    public CompletedRewardsBean getHex(String hex) {
        return hexMap.get(hex);
    }

    /**
     * 获取Hex
     *
     * @param path
     */
    public void initHexsFile(String path) {
        List<JSONObject> jsonArray = null;
        try {
            jsonArray = ExcelUtils.readFile(path);
        } catch (MsgException e) {
            System.out.println(e.getMessage());
        }

        if (ObjectUtils.notIsEmpty(jsonArray)) {
            for (JSONObject jsonObject : jsonArray) {
                CompletedRewardsBean completedRewardsBean = BeanUtils.mergeObjects(CompletedRewardsBean.class, jsonObject.get("json"));
                hexMap.put((String) jsonObject.get("hex"), completedRewardsBean);
            }
        }
    }

}
