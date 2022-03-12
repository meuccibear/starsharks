package io.renren.modules.domain.dto;

import io.renren.common.gitUtils.PageRRDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: starsharks-pro
 * @ClassName HotspottyDTO
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-03-09 10:42
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotspottyDTO extends PageRRDTO {

    String owner;

    String online;

}
