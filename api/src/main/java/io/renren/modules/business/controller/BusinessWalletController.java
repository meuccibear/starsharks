package io.renren.modules.business.controller;

import io.renren.common.gitUtils.ObjectUtils;
import io.renren.common.gitUtils.PageRRVO;
import io.renren.common.utils.Constant;
import io.renren.common.utils.R;
import io.renren.modules.business.entity.BusinessWalletEntity;
import io.renren.modules.business.service.BusinessWalletService;
import io.renren.modules.domain.dto.WalletDTO;
import io.renren.modules.helium.HeliumUtils;
import io.renren.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;


/**
 * 钱包管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-07 19:34:07
 */
@RestController
@RequestMapping("business/businesswallet")
public class BusinessWalletController extends AbstractController {
    @Autowired
    private BusinessWalletService businessWalletService;

    /**
     * 列表
     */
//    @RequestMapping("/list")
//    @RequiresPermissions("business:businesswallet:list")
//    public R list(@RequestParam Map<String, Object> params) {
//        PageUtils page = businessWalletService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }
    @RequestMapping("/list")
    @RequiresPermissions("business:businesswallet:list")
    public R list(@ModelAttribute WalletDTO walletDTO) {
        //如果不是超级管理员，则只查询自己创建的角色列表
        if(getUserId() != Constant.SUPER_ADMIN){
            walletDTO.setCreateUserId(getUserId());
        }
        PageRRVO page = businessWalletService.getAll(walletDTO);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{walletId}")
    @RequiresPermissions("business:businesswallet:info")
    public R info(@PathVariable("walletId") Long walletId) {
        BusinessWalletEntity businessWallet = businessWalletService.getById(walletId);

        return R.ok().put("businessWallet", businessWallet);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("business:businesswallet:save")
    public R save(@RequestBody BusinessWalletEntity businessWallet) {

        businessWallet.setCreateUserId(getUserId());
        businessWallet.setCreateTime(new Date());
        String[] owners = businessWallet.getOwner().trim().split("\n");

        for (String owner : owners) {
            if (ObjectUtils.notIsEmpty(owner)) {
                businessWallet.setOwner(owner);
                businessWalletService.save(businessWallet);
            }
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("business:businesswallet:update")
    public R update(@RequestBody BusinessWalletEntity businessWallet) {
        businessWalletService.updateById(businessWallet);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("business:businesswallet:delete")
    public R delete(@RequestBody Long[] walletIds) {
        businessWalletService.removeByIds(Arrays.asList(walletIds));

        return R.ok();
    }


//    public void asd(){
//        HeliumUt
//
//
//        ils.getHotspotsByWalletId();
//
//
//
//    }


}
