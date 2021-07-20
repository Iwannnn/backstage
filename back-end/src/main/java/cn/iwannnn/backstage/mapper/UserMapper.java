package cn.iwannnn.backstage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.iwannnn.backstage.domain.User;
import cn.iwannnn.backstage.dto.LoginDto;

public interface UserMapper extends BaseMapper<User> {
	LoginDto selectAccount(String account);
}
