package cn.iwannnn.backstage.service;

import cn.iwannnn.backstage.domain.entity.CompanyUser;
import cn.iwannnn.backstage.domain.models.AjaxResult;
import cn.iwannnn.backstage.domain.models.PageRequest;
import cn.iwannnn.backstage.domain.models.PageResult;
import cn.iwannnn.backstage.dto.UserDto;

public interface ICompanyUserService {
	public AjaxResult login(UserDto data);

	public CompanyUser selectUserByUsername(String username);

	public PageResult findPage(PageRequest pageRequest);
}
