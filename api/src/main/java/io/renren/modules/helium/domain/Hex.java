package io.renren.modules.helium.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @program: HNTD
 * @ClassName Hex
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-02-23 18:30
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hex {
    String hex ;

    List<String> hotspotIds ;
}
