package cn.iwannnn.backstage.service.impl;

import org.springframework.stereotype.Service;

import cn.iwannnn.backstage.dto.LoginDto;
import cn.iwannnn.backstage.service.IUserService;
import cn.iwannnn.backstage.utils.AxiosResult;

@Service
public class UserServiceImpl implements IUserService {

	@Override
	public AxiosResult login(LoginDto data) {
		return AxiosResult.success(202);
	}

}
