package cn.iwannnn.backstage.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cn.iwannnn.backstage.domain.entity.SysUser;
import cn.iwannnn.backstage.domain.models.LoginUser;
import cn.iwannnn.backstage.service.ISysUserService;
import cn.iwannnn.backstage.utils.StringUtils;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Autowired
	private ISysUserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SysUser user = userService.selectUserByUsername(username);
		if (StringUtils.isNull(user)) {
			log.info("登录用户：{} 不存在.", username);
			throw new UsernameNotFoundException("登录用户：" + username + " 不存在");
		}

		return createLoginUser(user);
	}

	public UserDetails createLoginUser(SysUser user) {
		return new LoginUser(user);
	}
}
