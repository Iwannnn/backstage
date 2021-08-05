package cn.iwannnn.backstage.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;

@Data
public class SystemMenu {

	@TableId(value = "id")
	private String menuId;

	private String menuName;

	private String parentId;

	private String orderNum;

	private String path;

	private String component;

	private String isCache;

	private String menuType;

	private String icon;

	private String createTime;

	private String updateTime;

	private String remark;
}
