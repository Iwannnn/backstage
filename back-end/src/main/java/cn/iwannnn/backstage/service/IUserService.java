package cn.iwannnn.backstage.service;

import cn.iwannnn.backstage.dto.UserDto;
import cn.iwannnn.backstage.models.AjaxResult;

public interface IUserService {
	public AjaxResult login(UserDto data);
}
