package io.renren.modules.business.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 管理机
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-07 19:34:07
 */
@Data
@TableName("business_anagement_machine")
public class BusinessAnagementMachineEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 编号
	 */
	@TableId
	private Long mmId;
	/**
	 * 名称
	 */
	private String mmName;
	/**
	 * 网段
	 */
	private String networkSegment;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 创建者ID
	 */
	private Long createUserId;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 备注
	 */
	private String remarks;

}
