package cn.iwannnn.backstage.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import cn.iwannnn.backstage.constants.Constants;
import cn.iwannnn.backstage.core.redis.RedisCache;
import cn.iwannnn.backstage.domain.models.LoginUser;
import cn.iwannnn.backstage.utils.StringUtils;
import cn.iwannnn.backstage.utils.uuid.IdUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

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

	private static final Long MILLIS_MINUTE_TEN = 20 * 60 * 1000L;

	@Autowired
	RedisCache redisCache;

	public String createToken(LoginUser loginUser) {
		String uuid = IdUtils.fastUUID();
		loginUser.setToken(uuid);
		refreshToken(loginUser);
		Map<String, Object> claims = new HashMap<>();
		claims.put(Constants.LOGIN_USER_KEY, uuid);
		return createToken(claims);
	}

	private String createToken(Map<String, Object> claims) {
		String token = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();
		return token;
	}

	public void verifyToken(LoginUser loginUser) {
		long expireTime = loginUser.getExpireTime();
		long currentTime = System.currentTimeMillis();
		if (expireTime - currentTime <= MILLIS_MINUTE_TEN) {
			refreshToken(loginUser);
		}
	}

	public void refreshToken(LoginUser loginUser) {
		loginUser.setLoginTime(System.currentTimeMillis());
		loginUser.setExpireTime(loginUser.getLoginTime() + expireTime * MILLIS_MINUTE);
		// 根据uuid将loginUser缓存
		String userKey = getTokenKey(loginUser.getToken());
		redisCache.setCacheObject(userKey, loginUser, expireTime, TimeUnit.MINUTES);
	}

	public LoginUser getLoginUser(HttpServletRequest request) {
		// 获取请求携带的令牌
		String token = getToken(request);
		if (StringUtils.isNotEmpty(token)) {
			Claims claims = parseToken(token);
			// 解析对应的权限以及用户信息
			String uuid = (String) claims.get(Constants.LOGIN_USER_KEY);
			String userKey = getTokenKey(uuid);
			LoginUser user;
			try {
				user = redisCache.getCacheObject(userKey);
			} catch (ClassCastException e) {
				return null;
			}
			return user;
		}
		return null;
	}

	private String getToken(HttpServletRequest request) {
		String token = request.getHeader(header);
		if (StringUtils.isNotEmpty(token) && token.startsWith(Constants.TOKEN_PREFIX)) {
			token = token.replace(Constants.TOKEN_PREFIX, "");
		}
		return token;
	}

	private Claims parseToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	public void delLoginUser(String token) {
		if (StringUtils.isNotEmpty(token)) {
			String userKey = getTokenKey(token);
			redisCache.deleteObject(userKey);
		}
	}

	private String getTokenKey(String uuid) {
		return Constants.LOGIN_TOKEN_KEY + uuid;
	}
}
