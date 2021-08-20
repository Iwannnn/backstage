package cn.iwannnn.backstage.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.iwannnn.backstage.domain.entity.CompanyUser;
import cn.iwannnn.backstage.domain.models.AjaxResult;
import cn.iwannnn.backstage.domain.models.PageRequest;
import cn.iwannnn.backstage.dto.RegisterDto;
import cn.iwannnn.backstage.dto.UserDto;
import cn.iwannnn.backstage.service.ICompanyUserService;
import cn.iwannnn.backstage.utils.ExcelUtils;
import cn.iwannnn.backstage.utils.uuid.IdUtils;
import lombok.extern.log4j.Log4j2;

@Log4j2
@CrossOrigin
@RestController
@RequestMapping("/company/user")
public class CompanyUserController {

	@Autowired
	private ICompanyUserService userService;

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

	@RequestMapping("/getUserList")
	public AjaxResult getAllUser(@RequestBody PageRequest pageRequest) {
		// log.info("getUserList");
		PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
		List<CompanyUser> list = userService.getUserList();
		PageInfo<CompanyUser> pageInfo = new PageInfo<>(list);
		return AjaxResult.success(pageInfo);
	}

	@RequestMapping("/addUser")
	public AjaxResult addUser(@RequestBody CompanyUser userForm) {
		return userService.insertUser(userForm) == 0 ? AjaxResult.error() : AjaxResult.success();
	}

	@RequestMapping("/delUser")
	public AjaxResult delUser(Integer userId) {
		log.info(userId);
		return userService.delUser(userId) == 0 ? AjaxResult.error() : AjaxResult.success();
	}

	@RequestMapping("updateUser")
	public AjaxResult updateUser(@RequestBody CompanyUser updateForm) {
		log.info(updateForm);
		return userService.updateUser(updateForm) == 0 ? AjaxResult.error() : AjaxResult.success();

	}

	@RequestMapping("/checkExist")
	public AjaxResult checkExist(@RequestBody RegisterDto data) {
		return userService.checkExist(data) == true ? AjaxResult.success() : AjaxResult.success("exist");
	}

	@RequestMapping("/importData")
	public AjaxResult importData(MultipartFile file) throws IOException, InstantiationException, IllegalAccessException,
			NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		log.info(file.toString());
		List<CompanyUser> list = ExcelUtils.importData(file, CompanyUser.class);
		System.out.println(list.toString());
		userService.insertUser(list);
		return AjaxResult.success("上传成功");
	}
}
