package cn.iwannnn.backstage.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.iwannnn.backstage.domain.entity.CompanyDept;

public interface CompanyDeptMapper extends BaseMapper<CompanyDept> {

	List<CompanyDept> getDeptList();
}
