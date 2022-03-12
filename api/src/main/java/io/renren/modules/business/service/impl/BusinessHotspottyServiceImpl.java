package io.renren.modules.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.gitUtils.ObjectUtils;
import io.renren.common.gitUtils.PageRRVO;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.FileUtils;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.business.dao.BusinessHotspottyDao;
import io.renren.modules.business.dao.Select;
import io.renren.modules.business.entity.BusinessHotspottyEntity;
import io.renren.modules.business.entity.HotspottyEntity;
import io.renren.modules.business.service.BusinessHotspottyService;
import io.renren.modules.domain.dto.HotspottyDTO;
import io.renren.modules.helium.HeliumUtils;
import io.renren.modules.helium.domain.Device;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;


@Service("businessHotspottyService")
public class BusinessHotspottyServiceImpl extends ServiceImpl<BusinessHotspottyDao, BusinessHotspottyEntity> implements BusinessHotspottyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BusinessHotspottyEntity> page = this.page(
                new Query<BusinessHotspottyEntity>().getPage(params),
                new QueryWrapper<BusinessHotspottyEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void addHotsPotty(Device device) {
        System.out.println(device.getAddress());
        Long id = baseMapper.findHotspottyIdByAddress(device.getAddress());
        BusinessHotspottyEntity businessHotspotty = new BusinessHotspottyEntity();

        if (ObjectUtils.notIsEmpty(id)) {
            System.out.println("修改");
            businessHotspotty.setUpdateDevice(id, device);
            updateById(businessHotspotty);
        } else {
            System.out.println("新增");
            businessHotspotty.setAddDevice(device);
            businessHotspotty.setHotspottyId(null);
            baseMapper.insertSelective(businessHotspotty);
        }
    }


    @Override
    public void addNewHotsPotty(Long groupId, Long createUserId, String address) throws MsgException {

        Device device = HeliumUtils.getHotspotsById(address);
        if (ObjectUtils.notIsEmpty(device)) {
            device.setTotal(HeliumUtils.getHotspotsTotal(2, device.getAddress()));
            Long id = baseMapper.findHotspottyIdByAddress(device.getAddress());

            BusinessHotspottyEntity businessHotspotty = new BusinessHotspottyEntity();
            businessHotspotty.setCreateUserId(createUserId);
            businessHotspotty.setGroupId(groupId);

            if (ObjectUtils.notIsEmpty(id)) {
                System.out.println("修改");
                businessHotspotty.setUpdateDevice(id, device);
                updateById(businessHotspotty);
            } else {
                System.out.println("新增");
                businessHotspotty.setAddDevice(device);
                businessHotspotty.setHotspottyId(null);
                baseMapper.insertSelective(businessHotspotty);
            }
        } else {
            FileUtils.write("addhotspotty.log", address);
        }
    }

    @Override
    public PageRRVO getAll(HotspottyDTO hotspottyDTO) {
        List<HotspottyEntity> hotspottyEntities = baseMapper.findAllByOwnerAndCreateUserId(hotspottyDTO);
        int totalCount = baseMapper.findAllByOwnerAndCreateUserIdCount(hotspottyDTO);
        return PageRRVO.build(hotspottyDTO, hotspottyEntities, totalCount);
    }

    @Override
    public List<Select> findOnlines() {
        return baseMapper.findOnlines();
    }

}
