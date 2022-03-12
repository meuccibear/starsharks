package io.renren.modules.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.business.dao.BusinessGroupDao;
import io.renren.modules.business.entity.BusinessGroupEntity;
import io.renren.modules.business.service.BusinessGroupService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("businessGroupService")
public class BusinessGroupServiceImpl extends ServiceImpl<BusinessGroupDao, BusinessGroupEntity> implements BusinessGroupService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Long createUserId = (Long)params.get("createUserId");

        IPage<BusinessGroupEntity> page = this.page(
                new Query<BusinessGroupEntity>().getPage(params),
                new QueryWrapper<BusinessGroupEntity>().eq(createUserId != null,"create_user_id", createUserId)
        );

        return new PageUtils(page);
    }

    @Override
    public List<BusinessGroupEntity> queryNotButtonList() {
        return baseMapper.queryNotButtonList();
    }

}
