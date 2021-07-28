package cn.iwannnn.backstage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.iwannnn.backstage.domain.entity.SysMenu;
import cn.iwannnn.backstage.mapper.SysMenuMapper;
import cn.iwannnn.backstage.service.ISysMenuService;

@Service
public class SysMenuServiceImpl implements ISysMenuService {

	@Autowired
	SysMenuMapper menuMapper;

	@Override
	public List<SysMenu> getMenuList() {
		return menuMapper.selectAll();
	}
}
