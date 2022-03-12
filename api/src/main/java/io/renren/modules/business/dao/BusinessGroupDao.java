package io.renren.modules.business.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.business.entity.BusinessGroupEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 分组管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-07 19:34:07
 */
@Mapper
public interface BusinessGroupDao extends BaseMapper<BusinessGroupEntity> {

    List<BusinessGroupEntity> queryNotButtonList();

}
