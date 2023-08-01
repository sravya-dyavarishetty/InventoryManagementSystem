package com.psl.ims;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.psl.ims.entity.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Bean
	public UserDetailsService getUserDetailsService()
	{
		return new CustomUserDetailsService();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	@Bean
	public DaoAuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(this.getUserDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http.authorizeRequests()
		.antMatchers("/products/**").hasAnyRole("ADMIN","USER")
		.antMatchers("/users/**").hasRole("ADMIN")
		.antMatchers("/**").permitAll().and().formLogin().loginPage("/signin").and()
		.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/products");
	}
	
	
	

	//@Override
	/*
	 * protected void configure(HttpSecurity http) throws Exception {
	 * http.authorizeRequests() .antMatchers("/loginpage").permitAll()
	 * .antMatchers("/products").permitAll()
	 * .antMatchers("/registration").permitAll() .anyRequest() .authenticated()
	 * .and() .formLogin() .loginPage("/loginpage") .loginProcessingUrl("/doLogin")
	 * .usernameParameter("username") .passwordParameter("password")
	 * .defaultSuccessUrl("/products");
	 * 
	 * }
	 */
	
	//.
	//antMatchers("/home/**").hasAnyRole("USER","ADMIN")

	}

