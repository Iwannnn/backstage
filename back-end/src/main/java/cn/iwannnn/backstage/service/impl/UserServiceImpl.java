package cn.iwannnn.backstage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.iwannnn.backstage.dto.LoginDto;
import cn.iwannnn.backstage.mapper.UserMapper;
import cn.iwannnn.backstage.models.AjaxResult;
import cn.iwannnn.backstage.service.IUserService;
import cn.iwannnn.backstage.utils.MD5Util;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserMapper userMapper;

	@Override
	public AjaxResult login(LoginDto loginForm) {
		loginForm.setPassword(MD5Util.MD5(loginForm.getPassword()));
		LoginDto loginRes = null;
		loginRes = userMapper.selectAccount(loginForm.getAccount());
		if (loginRes == null)
			return AjaxResult.error("帐号不存在");
		else if (!loginForm.getPassword().equals(loginRes.getPassword()))
			return AjaxResult.error("密码错误");
		log.info(loginForm);

		return AjaxResult.success("登陆成功");
	}
}
