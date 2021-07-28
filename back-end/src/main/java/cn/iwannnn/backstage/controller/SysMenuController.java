package cn.iwannnn.backstage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.iwannnn.backstage.domain.models.AjaxResult;
import cn.iwannnn.backstage.service.ISysMenuService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@CrossOrigin
@RestController
@RequestMapping
public class SysMenuController {
	@Autowired
	private ISysMenuService menuService;

	@RequestMapping("/getMenuList")
	private AjaxResult getMenuList() {
		log.info("getMenuList request");
		return AjaxResult.success(menuService.getMenuList());
	}
}
