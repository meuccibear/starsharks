package io.renren.business.domin.device;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @program: HNTD
 * @ClassName Status
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-01-27 17:16
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Status {
    private Object timestamp;
    private String online;
    private List<String> listen_addrs;
    private long height;
}
