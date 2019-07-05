package cn.duxue.api.shop.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 验证码表
 * Created by liang on 2019/1/5.
 */
@Data
@TableName("sys_captcha")
public class SysCaptchaEntity extends BaseEntity {

	/**
	 * 主键ID
	 */
	@TableId
	private Long id;
	/**
	 * uuid
	 */
	private String uuid;
	/**
	 * 验证码
	 */
	private String code;
	/**
	 * 过期时间
	 */
	private Date expireTime;

}