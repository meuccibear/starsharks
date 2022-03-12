package io.renren.modules.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.business.dao.BusinessAnagementMachineDao;
import io.renren.modules.business.entity.BusinessAnagementMachineEntity;
import io.renren.modules.business.service.BusinessAnagementMachineService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("businessAnagementMachineService")
public class BusinessAnagementMachineServiceImpl extends ServiceImpl<BusinessAnagementMachineDao, BusinessAnagementMachineEntity> implements BusinessAnagementMachineService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Long createUserId = (Long)params.get("createUserId");


        IPage<BusinessAnagementMachineEntity> page = this.page(
                new Query<BusinessAnagementMachineEntity>().getPage(params),
                new QueryWrapper<BusinessAnagementMachineEntity>().eq(createUserId != null,"create_user_id", createUserId)
        );

        return new PageUtils(page);
    }

}
