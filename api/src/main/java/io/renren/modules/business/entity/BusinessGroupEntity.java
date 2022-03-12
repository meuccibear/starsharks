package io.renren.modules.business.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 分组管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-07 19:34:07
 */
@Data
@TableName("business_group")
public class BusinessGroupEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 编号
	 */
	@TableId
	private Long groupId;
	/**
	 * 管理机
	 */
	private Integer mmId;
	/**
	 * 名称
	 */
	private String groupName;
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
