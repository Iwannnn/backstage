package cn.iwannnn.backstage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.iwannnn.backstage.domain.entity.SystemMenu;
import cn.iwannnn.backstage.mapper.SystemMenuMapper;
import cn.iwannnn.backstage.service.ISystemMenuService;

@Service
public class SystemMenuServiceImpl implements ISystemMenuService {

	@Autowired
	SystemMenuMapper menuMapper;

	@Override
	public List<SystemMenu> getMenuList() {
		return menuMapper.selectAll();
	}
}
