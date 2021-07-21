package cn.iwannnn.backstage.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import cn.iwannnn.backstage.constants.Constants;
import cn.iwannnn.backstage.dto.UserDto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * token验证处理
 *
 * @author ruoyi
 */
@Component
public class TokenService {
	// 令牌自定义标识
	@Value("${token.header}")
	private String header;

	// 令牌秘钥
	@Value("${token.secret}")
	private String secret;

	// 令牌有效期（默认30分钟）
	@Value("${token.expireTime}")
	private int expireTime;

	protected static final long MILLIS_SECOND = 1000;

	protected static final long MILLIS_MINUTE = 60 * MILLIS_SECOND;

	public String createToken(UserDto userDto) {
		String account = userDto.getAccount();
		Map<String, Object> claims = new HashMap<>();
		claims.put(Constants.LOGIN_USER_KEY, account);
		return createToken(claims);
	}

	private String createToken(Map<String, Object> claims) {
		String token = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();
		return token;
	}

}
