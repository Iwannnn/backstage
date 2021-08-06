package cn.iwannnn.backstage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.iwannnn.backstage.domain.entity.CompanyDept;
import cn.iwannnn.backstage.mapper.CompanyDeptMapper;
import cn.iwannnn.backstage.service.ICompanyDeptService;

public class CompanyDeptServiceImpl implements ICompanyDeptService {

	@Autowired
	CompanyDeptMapper deptMapper;

	@Override
	public List<CompanyDept> getDeptList() {
		return deptMapper.getDeptList();
	}
}
