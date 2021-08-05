package cn.iwannnn.backstage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.iwannnn.backstage.domain.models.AjaxResult;
import cn.iwannnn.backstage.domain.models.PageRequest;
import cn.iwannnn.backstage.dto.UserDto;
import cn.iwannnn.backstage.service.ISysUserService;
import cn.iwannnn.backstage.utils.uuid.IdUtils;
import lombok.extern.log4j.Log4j2;

@Log4j2
@CrossOrigin
@RestController
@RequestMapping
public class SysUserController {

	@Autowired
	private ISysUserService userService;

	@RequestMapping("/login")
	public AjaxResult login(@RequestBody UserDto data) {
		log.info(data.toString());
		return userService.login(data);
	}

	@RequestMapping("/getUUID")
	public AjaxResult getUUID() {
		String uuid = IdUtils.fastUUID();
		return AjaxResult.success("uuid", uuid);
	}

	@RequestMapping("/getAllUser")
	public AjaxResult getAllUser(@RequestBody PageRequest pageRequest) {
		return AjaxResult.success(userService.findPage(pageRequest));
	}
}
