package cn.iwannnn.backstage.service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.iwannnn.backstage.domain.entity.CompanyUser;
import cn.iwannnn.backstage.domain.models.AjaxResult;
import cn.iwannnn.backstage.domain.models.LoginUser;
import cn.iwannnn.backstage.domain.models.PageRequest;
import cn.iwannnn.backstage.domain.models.PageResult;
import cn.iwannnn.backstage.dto.UserDto;
import cn.iwannnn.backstage.mapper.CompanyUserMapper;
import cn.iwannnn.backstage.service.ICompanyUserService;
import cn.iwannnn.backstage.service.TokenService;
import cn.iwannnn.backstage.utils.Md5Utils;
import cn.iwannnn.backstage.utils.PageUtils;

@Service
public class CompanyUserServiceImpl implements ICompanyUserService {

	@Autowired
	CompanyUserMapper userMapper;

	@Autowired
	TokenService tokenService;

	@Override
	public AjaxResult login(UserDto loginForm) {
		CompanyUser user = null;
		LoginUser loginUser;
		String token;
		loginForm.setPassword(Md5Utils.createMD5(loginForm.getPassword()));
		user = userMapper.selectByUsername(loginForm.getUsername());
		// log.info(user);
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
	public PageResult findPage(PageRequest pageRequest) {
		return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
	}

	private PageInfo<CompanyUser> getPageInfo(PageRequest pageRequest) {
		int pageNum = pageRequest.getPageNum();
		int pageSize = pageRequest.getPageSize();
		PageHelper.startPage(pageNum, pageSize);
		List<CompanyUser> sysMenus = userMapper.selectPage();
		return new PageInfo<CompanyUser>(sysMenus);
	}

}
