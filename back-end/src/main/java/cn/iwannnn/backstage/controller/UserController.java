package cn.iwannnn.backstage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.iwannnn.backstage.dto.LoginDto;
import cn.iwannnn.backstage.models.AjaxResult;
import cn.iwannnn.backstage.service.impl.UserServiceImpl;
import cn.iwannnn.backstage.utils.UUIDUtil;
import lombok.extern.log4j.Log4j2;

@Log4j2
@CrossOrigin
@RestController()
@RequestMapping()
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@RequestMapping("/login")
	public AjaxResult login(@RequestBody LoginDto data) {
		log.info(data.toString());
		return userServiceImpl.login(data);
	}

	@RequestMapping("/getUUID")
	public AjaxResult getUUID() {
		String uuid = UUIDUtil.getUUID();
		return AjaxResult.success("uuid", uuid);
	}
}
