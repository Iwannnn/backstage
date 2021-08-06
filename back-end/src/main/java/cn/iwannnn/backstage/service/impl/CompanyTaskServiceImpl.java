package cn.iwannnn.backstage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.iwannnn.backstage.domain.entity.CompanyTask;
import cn.iwannnn.backstage.mapper.CompanyTaskMapper;
import cn.iwannnn.backstage.service.ICompanyTaskService;

public class CompanyTaskServiceImpl implements ICompanyTaskService {

	@Autowired
	CompanyTaskMapper taskMapper;

	@Override
	public List<CompanyTask> getTaskList() {
		return taskMapper.getTaskList();
	}
}
