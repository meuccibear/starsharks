package io.renren.modules.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.gitUtils.PageRRVO;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.utils.PageUtils;
import io.renren.modules.business.dao.Select;
import io.renren.modules.business.entity.BusinessHotspottyEntity;
import io.renren.modules.domain.dto.HotspottyDTO;
import io.renren.modules.helium.domain.Device;

import java.util.List;
import java.util.Map;

/**
 * 设备管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-07 19:34:07
 */
public interface BusinessHotspottyService extends IService<BusinessHotspottyEntity> {

    PageUtils queryPage(Map<String, Object> params);


    void addHotsPotty(Device device);

    void addNewHotsPotty(Long groupId, Long createUserId, String address) throws MsgException;

    PageRRVO getAll(HotspottyDTO hotspottyDTO);

    List<Select> findOnlines();

//    void addNewHotspotty(Long groupId, Long createUserId, String address) throws MsgException;


}

