package io.renren.modules.helium.domain;

import io.renren.common.gitUtils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @program: HNTD
 * @ClassName HotspotsProfit
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-02-14 17:35
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotspotsProfit {

    private Object timestamp;
    private long sum;
    private double stddev;
    private double min;
    private double median;
    private double max;
    private double avg;
    private double total;


    public LocalDateTime getTimestamp() {
        if (timestamp instanceof String) {
            setTimestamp(DateUtils.asLocalDateTime(DateUtils.toDate((String) timestamp)));
        }
        return (LocalDateTime) timestamp;
    }
}
