package cn.iwannnn.backstage.service;

import cn.iwannnn.backstage.domain.entity.SysUser;
import cn.iwannnn.backstage.domain.models.AjaxResult;
import cn.iwannnn.backstage.dto.UserDto;

public interface ISysUserService {
	public AjaxResult login(UserDto data);

	public SysUser selectUserByUsername(String username);
}
