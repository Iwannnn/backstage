package cn.iwannnn.backstage.service;

import java.util.List;

import cn.iwannnn.backstage.domain.entity.CompanyUser;
import cn.iwannnn.backstage.domain.models.AjaxResult;
import cn.iwannnn.backstage.dto.RegisterDto;
import cn.iwannnn.backstage.dto.UserDto;

public interface ICompanyUserService {
	public AjaxResult login(UserDto data);

	public CompanyUser selectUserByUsername(String username);

	public List<CompanyUser> getUserList();

	public int insertUser(CompanyUser userForm);

	public void insertUser(List<CompanyUser> userList);

	public int delUser(Integer userId);

	public boolean checkExist(RegisterDto data);

	public int updateUser(CompanyUser updateForm);
}
