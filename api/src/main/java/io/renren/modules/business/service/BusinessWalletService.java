package io.renren.modules.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.gitUtils.PageRRVO;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.utils.PageUtils;
import io.renren.modules.business.entity.BusinessWalletEntity;
import io.renren.modules.domain.dto.WalletDTO;

import java.util.Map;

/**
 * 钱包管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-07 19:34:07
 */
public interface BusinessWalletService extends IService<BusinessWalletEntity> {

    PageUtils queryPage(Map<String, Object> params);


    PageRRVO getAll(WalletDTO walletDTO);

    /**
     *
     * @param userId
     */
    void crawlingWallData(Long userId) throws MsgException;

    /**
     *
     */
    void crawlingWallData() throws MsgException;

    void crawlingDatas();

    void crawlingData(Long userId) throws MsgException;

    void crawlingData() throws MsgException;

}

