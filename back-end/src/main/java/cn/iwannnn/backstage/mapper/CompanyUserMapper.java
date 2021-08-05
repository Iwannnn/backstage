package cn.iwannnn.backstage.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.iwannnn.backstage.domain.entity.CompanyUser;

public interface CompanyUserMapper extends BaseMapper<CompanyUser> {
	CompanyUser selectByUsername(String username);

	List<CompanyUser> getUserList();
}
