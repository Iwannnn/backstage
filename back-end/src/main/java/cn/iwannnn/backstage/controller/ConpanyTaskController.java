package cn.iwannnn.backstage.controller;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.iwannnn.backstage.domain.entity.CompanyTask;
import cn.iwannnn.backstage.domain.models.AjaxResult;
import cn.iwannnn.backstage.domain.models.PageRequest;
import cn.iwannnn.backstage.service.ICompanyTaskService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController("/company/task")
public class ConpanyTaskController {

	@Autowired
	ICompanyTaskService taskService;

	@RequestMapping("/getTaskList")
	public AjaxResult getTaskList(@RequestBody PageRequest pageRequest) {
		log.info("getTaskList");
		PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
		List<CompanyTask> list = taskService.getTaskList();
		PageInfo<CompanyTask> pageInfo = new PageInfo<>(list);
		return AjaxResult.success(pageInfo);
	}
}
