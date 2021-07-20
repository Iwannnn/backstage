package cn.iwannnn.backstage.service.impl;

import org.springframework.stereotype.Service;

import cn.iwannnn.backstage.dto.LoginDto;
import cn.iwannnn.backstage.models.AxiosResult;
import cn.iwannnn.backstage.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Override
	public AxiosResult login(LoginDto data) {
		return AxiosResult.success(202);
	}

}
