package io.renren.modules.business.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.business.entity.BusinessHotspottyEntity;
import io.renren.modules.business.entity.HotspottyEntity;
import io.renren.modules.domain.dto.HotspottyDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 设备管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-07 19:34:07
 */
@Mapper
public interface BusinessHotspottyDao extends BaseMapper<BusinessHotspottyEntity> {

    List<HotspottyEntity> findAllByOwnerAndCreateUserId(HotspottyDTO hotspottyDTO);

    Integer findAllByOwnerAndCreateUserIdCount(HotspottyDTO hotspottyDTO);

    Long findHotspottyIdByAddress(@Param("address")String address);

    int insertSelective(BusinessHotspottyEntity businessHotspottyEntity);

    List<BusinessHotspottyEntity> findAll();

    List<Select> findOnlines();

}
