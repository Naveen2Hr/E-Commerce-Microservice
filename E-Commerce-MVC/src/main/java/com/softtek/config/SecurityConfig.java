package com.softtek.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService service;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(encoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Authorize requests
		http.authorizeHttpRequests().antMatchers("/shop/").permitAll()// No Authentication and no authorization
				.antMatchers("/user/register", "/user/showLogin").permitAll().antMatchers("/shop/").authenticated()// only
																													// authentication
				// Authentication + Authorization Customer and Manager role
				.antMatchers("/shop/productList").hasAnyAuthority("CUSTOMER", "MANAGER", "SELLER")
				// Authorization only for "MANAGER"
				.antMatchers("/showProductRegister", "/productRegister",
						"/shop/order", "/shop/register","/shop/add")
				.hasAnyAuthority("MANAGER", "SELLER").anyRequest().authenticated().and().formLogin()
				.defaultSuccessUrl("/shop/", true).loginPage("/user/showLogin").loginProcessingUrl("/login")
				.failureUrl("/user/showLogin?error")// Authentication Failed url
				.and().rememberMe().and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/signOut"))
				.logoutSuccessUrl("/user/showLogin?signOut")

				// exception/error/ Handling By redirecting to new page
				.and().exceptionHandling().accessDeniedPage("/denied")

				// add sessionMaxConcurrency count
				.and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);
	}
}
