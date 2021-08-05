package cn.iwannnn.backstage.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import cn.iwannnn.backstage.security.fliter.JwtAuthenticationTokenFilter;
import cn.iwannnn.backstage.security.handle.AuthenticationEntryPointImpl;

@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	/**
	 * 自定义用户认证逻辑
	 */
	@Autowired
	private UserDetailsService userDetailsService;

	/**
	 * 认证失败处理类
	 */
	@Autowired
	private AuthenticationEntryPointImpl unauthorizedHandler;

	/**
	 * token认证过滤器
	 */
	@Autowired
	private JwtAuthenticationTokenFilter authenticationTokenFilter;

	/**
	 * 解决 无法直接注入 AuthenticationManager
	 *
	 * @return
	 * @throws Exception
	 */
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				// CSRF禁用，因为不使用session
				.csrf().disable()
				// 认证失败处理类
				.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
				// 基于token，所以不需要session
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				// 过滤请求
				.authorizeRequests()
				// 对于登录login 验证码captchaImage 允许匿名访问
				.antMatchers("/login").anonymous().antMatchers("/system/**", "/company/**").anonymous()
				.antMatchers("/druid/**").permitAll()
				// 除上面外的所有请求全部需要鉴权认证
				.anyRequest().authenticated().and().headers().frameOptions().disable();
		// 添加JWT filter
		httpSecurity.addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
	}

	/**
	 * 强散列哈希加密实现
	 */
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * 身份认证接口
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
}
