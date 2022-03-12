/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package io.renren.modules.job.task;

import io.renren.common.gitUtils.exception.MsgException;
import io.renren.modules.business.service.BusinessHotspottyService;
import io.renren.modules.business.service.BusinessWalletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 测试定时任务(演示Demo，可删除)
 * <p>
 * testTask为spring bean的名称
 *
 * @author Mark sunlightcs@gmail.com
 */
@Component("testTask")
public class TestTask implements ITask {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BusinessWalletService businessWalletService;

    @Autowired
    private BusinessHotspottyService businessHotspottyService;

    @Override
    public void run(String params) {
        logger.debug("TestTask定时任务正在执行，参数为：{}", params);
        try {
            businessWalletService.crawlingData();
        } catch (MsgException e) {
            e.printStackTrace();
        }
    }
}
