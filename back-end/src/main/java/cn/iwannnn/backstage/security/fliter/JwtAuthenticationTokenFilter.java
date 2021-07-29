package cn.iwannnn.backstage.security.fliter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import cn.iwannnn.backstage.domain.models.LoginUser;
import cn.iwannnn.backstage.service.TokenService;
import cn.iwannnn.backstage.utils.StringUtils;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
	@Autowired
	private TokenService tokenService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		LoginUser loginUser = tokenService.getLoginUser(request);
		log.info(loginUser);
		if (StringUtils.isNotNull(loginUser)) {
			tokenService.verifyToken(loginUser);
		}
		chain.doFilter(request, response);
	}
}
