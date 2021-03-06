package cn.iwannnn.backstage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.iwannnn.backstage.domain.entity.CompanyUser;
import cn.iwannnn.backstage.domain.models.AjaxResult;
import cn.iwannnn.backstage.domain.models.LoginUser;
import cn.iwannnn.backstage.dto.RegisterDto;
import cn.iwannnn.backstage.dto.UserDto;
import cn.iwannnn.backstage.mapper.CompanyUserMapper;
import cn.iwannnn.backstage.service.ICompanyUserService;
import cn.iwannnn.backstage.service.TokenService;
import cn.iwannnn.backstage.utils.Md5Utils;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CompanyUserServiceImpl implements ICompanyUserService {

	@Autowired
	CompanyUserMapper userMapper;

	@Autowired
	TokenService tokenService;

	@Override
	public AjaxResult login(UserDto loginForm) {
		CompanyUser user = null;
		LoginUser loginUser = null;
		String token;
		loginForm.setPassword(Md5Utils.createMD5(Md5Utils.createMD5(loginForm.getPassword())));
		user = userMapper.selectByUsername(loginForm.getUsername());
		log.info(user);
		log.info(loginForm);
		if (user == null)
			return AjaxResult.error("帐号不存在");
		else if (!loginForm.getPassword().equals(user.getPassword()))
			return AjaxResult.error("密码错误");
		loginUser = new LoginUser(user);
		token = tokenService.createToken(loginUser);
		return AjaxResult.success("登陆成功", token);
	}

	@Override
	public CompanyUser selectUserByUsername(String username) {
		return userMapper.selectByUsername(username);
	}

	@Override
	public List<CompanyUser> getUserList() {
		return userMapper.getUserList();
	}

	@Override
	public int insertUser(CompanyUser userForm) {
		log.info(userForm.toString());
		return userMapper.insert(userForm);
	}

	@Override
	public boolean checkExist(RegisterDto data) {
		return userMapper.checkExist(data).toString() == "[]";
	}

	@Override
	public void insertUser(List<CompanyUser> userList) {
		for (int i = 0; i < userList.size(); i++) {
			userMapper.insert(userList.get(i));
		}
	}

	@Override
	public int delUser(Integer userId) {
		return userMapper.deleteById(userId);
	}

	@Override
	public int updateUser(CompanyUser updateForm) {
		return userMapper.updateById(updateForm);
	}
}
