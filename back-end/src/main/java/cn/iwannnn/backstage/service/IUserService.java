package cn.iwannnn.backstage.service;

import cn.iwannnn.backstage.dto.LoginDto;
import cn.iwannnn.backstage.models.AjaxResult;

public interface IUserService {
	public AjaxResult login(LoginDto data);
}
