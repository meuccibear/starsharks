package io.renren.business.domin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: starsharks
 * @ClassName ParamsBean
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-03-04 03:47
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParamsBean {

    long t;

    int page;

    int limit;
}
