package cn.iwannnn.backstage.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.iwannnn.backstage.domain.entity.SysUser;

public interface SysUserMapper extends BaseMapper<SysUser> {
	SysUser selectByUsername(String username);

	List<SysUser> selectAll();

	List<SysUser> selectPage();
}
