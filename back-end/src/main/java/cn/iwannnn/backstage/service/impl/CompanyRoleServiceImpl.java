
package cn.iwannnn.backstage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.iwannnn.backstage.domain.entity.CompanyRole;
import cn.iwannnn.backstage.mapper.CompanyRoleMapper;
import cn.iwannnn.backstage.service.ICompanyRoleService;

@Service
public class CompanyRoleServiceImpl implements ICompanyRoleService {

	@Autowired
	CompanyRoleMapper roleMapper;

	@Override
	public List<CompanyRole> getRoleList() {
		return roleMapper.getRoleList();
	}
}
