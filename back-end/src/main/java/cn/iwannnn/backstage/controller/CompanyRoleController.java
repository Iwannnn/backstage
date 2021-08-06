
package cn.iwannnn.backstage.controller;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.iwannnn.backstage.domain.entity.CompanyRole;
import cn.iwannnn.backstage.domain.models.AjaxResult;
import cn.iwannnn.backstage.domain.models.PageRequest;
import cn.iwannnn.backstage.service.ICompanyRoleService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController("/company/role")
public class CompanyRoleController {

	@Autowired
	ICompanyRoleService roleService;

	@RequestMapping("/getRoleList")
	public AjaxResult getRoleList(@RequestBody PageRequest pageRequest) {
		log.info("getRoleList");
		PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
		List<CompanyRole> list = roleService.getRoleList();
		PageInfo<CompanyRole> pageInfo = new PageInfo<>(list);
		return AjaxResult.success(pageInfo);
	}
}
