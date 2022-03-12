package io.renren.business.domin.device;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: HNTD
 * @ClassName Geocode
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-01-27 17:17
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Geocode {

    private String short_street;
    private String short_state;
    private String short_country;
    private String short_city;
    private String long_street;
    private String long_state;
    private String long_country;
    private String long_city;
    private String city_id;

}
