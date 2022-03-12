package io.renren.modules.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.business.entity.BusinessGroupEntity;

import java.util.List;
import java.util.Map;

/**
 * 分组管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-07 19:34:07
 */
public interface BusinessGroupService extends IService<BusinessGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<BusinessGroupEntity> queryNotButtonList();

}

