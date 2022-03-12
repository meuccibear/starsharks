/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package io.renren;

import com.alibaba.fastjson.JSONObject;
import io.renren.common.gitUtils.ExcelUtils;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.modules.business.dao.BusinessHotspottyDao;
import io.renren.modules.business.entity.BusinessHotspottyEntity;
import io.renren.modules.business.service.BusinessHotspottyService;
import io.renren.modules.helium.HeliumUtils;
import io.renren.modules.helium.domain.Device;
import io.renren.service.DynamicDataSourceTestService;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 多数据源测试
 *
 * @author Mark sunlightcs@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AddHeliumDevice {
    @Autowired
    BusinessHotspottyService hotspottyService;


    @SneakyThrows
    @Test
    public void test() {
        // 成都-程总  2, 2, "./data/cd-cz.txt"
        // 成都-李总  3, 3, "./data/cd-lz.txt"
        // 湖南-陈总  4, 4, "./data/hn-cz.txt"
        // 湖南-陈总-罗总  4, 4, "./data/hn-cz_l-z.txt"
        // 湖南-陈总-杨举  4, 4, "./data/hn-cz_yj.txt"
        // 深圳-谢总  5, 5, "./data/sz-xz.txt"
        // 上海-陈总  6, 6, "./data/sh-cz.txt"

        addNewHotspotty(4, 4, "./data/hn-cz_yj.txt");
    }

    public void addNewHotspotty(int groupId, int createUserId, String path) throws MsgException {
        List<JSONObject> jsonArray = ExcelUtils.readFile(path);
        for (JSONObject jsonO : jsonArray) {
            System.out.println(jsonO.get("address"));
            hotspottyService.addNewHotsPotty(new Long(groupId), new Long(createUserId), (String) jsonO.get("address"));
        }
    }

}
