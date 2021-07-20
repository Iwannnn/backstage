package cn.iwannnn.backstage.service;

import cn.iwannnn.backstage.dto.LoginDto;
import cn.iwannnn.backstage.utils.AxiosResult;

public interface IUserService {
	public AxiosResult login(LoginDto data);
}
