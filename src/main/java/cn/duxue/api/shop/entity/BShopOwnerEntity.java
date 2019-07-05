package cn.duxue.api.shop.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 商家用户
 * Created by liang on 2019/1/5.
 */
@TableName("b_shop_owner")
@Data
public class BShopOwnerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	@TableId
	private Long shopOwnerId;
	/**
	 * 真实姓名
	 */
	private String shopOwnerName;
	/**
	 * 登录用户名
	 */
	private String loginName;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 简介
	 */
	private String remark;
	/**
	 * 状态：待审核（1），有效（1），无效（2）
	 */
	private String status;
	/**
	 * 创建者
	 */
	private String createBy;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新者
	 */
	private String updateBy;
	/**
	 * 修改时间
	 */
	private Date updateTime;


}
