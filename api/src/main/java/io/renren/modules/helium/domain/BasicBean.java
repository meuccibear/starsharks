package io.renren.modules.helium.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: HNTD
 * @ClassName BasicBean
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-02-18 16:20
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasicBean {

    private String privateIp;
    private String publicIp;
    private String mac;
    private String network;
    private String hotspotsId;
    private Integer blacklistedBatch;
    private String index;

}
