package io.renren.business.domin.starsharks.vo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @program: starsharks
 * @ClassName Shark
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-03-03 11:11
 * @Version 1.0
 **/
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class Shark {

    public int shark_id;

    public int rent_cyc;

    public String rent_except_gain;

    public int next_rent_except_gain;
    public double sell_price;

}
