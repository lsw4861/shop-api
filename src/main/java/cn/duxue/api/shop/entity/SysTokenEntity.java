package cn.duxue.api.shop.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 认证Token表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-06-26 14:35:16
 */

@Data
@TableName("sys_token")
public class SysTokenEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	@TableId
	private Long id;
	/**
	 * 主键ID
	 */
	private Long sourceId;
	/**
	 * token值
	 */
	private String token;
	/**
	 * 过期时间
	 */
	private Date expireTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;


}
