package io.renren.modules.business.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 钱包管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-07 19:34:07
 */
@Data
@TableName("business_wallet")
public class BusinessWalletEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 编号
	 */
	@TableId
	private Long walletId;
	/**
	 * 分组
	 */
	private Integer groupId;

	/**
	 * 钱包地址
	 */
	private String owner;
	/**
	 * 备注
	 */
	private String remarks;
	/**
	 * 创建者ID
	 */
	private Long createUserId;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 状态  0：禁用   1：正常
	 */
	private Integer status;

}
