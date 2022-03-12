package io.renren.modules.business.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;

/**
 * @program: starsharks-pro
 * @ClassName JSONController
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-03-09 18:29
 * @Version 1.0
 **/
public class JSONController {


    @PostMapping("/json")
    public void arrRequestbigdecimal(@RequestBody Object o) {
        System.out.println(JSON.toJSONString(o));
    }

}
