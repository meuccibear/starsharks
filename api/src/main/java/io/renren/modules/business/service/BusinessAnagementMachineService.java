package io.renren.modules.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.business.entity.BusinessAnagementMachineEntity;

import java.util.Map;

/**
 * 管理机
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-07 19:34:07
 */
public interface BusinessAnagementMachineService extends IService<BusinessAnagementMachineEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

