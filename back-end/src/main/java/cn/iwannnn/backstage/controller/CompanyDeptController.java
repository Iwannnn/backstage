package cn.iwannnn.backstage.controller;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.iwannnn.backstage.domain.entity.CompanyDept;
import cn.iwannnn.backstage.domain.models.AjaxResult;
import cn.iwannnn.backstage.domain.models.PageRequest;
import cn.iwannnn.backstage.service.ICompanyDeptService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@CrossOrigin
@RestController
@RequestMapping("/company/dept")
public class CompanyDeptController {

	@Autowired
	ICompanyDeptService deptService;

	@RequestMapping("/getDeptList")
	public AjaxResult getDeptList(@RequestBody PageRequest pageRequest) {
		log.info("getDeptList");
		PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
		List<CompanyDept> list = deptService.getDeptList();
		PageInfo<CompanyDept> pageInfo = new PageInfo<>(list);
		return AjaxResult.success(pageInfo);
	}
}
