//package com.myspringproject.configuration;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SpringSecConfig extends WebSecurityConfigurerAdapter {
//
//
//	@Override
//	protected void configure(HttpSecurity httpSecurity) throws Exception {
//		/*
//		 * httpSecurity.authorizeRequests().antMatchers("/",
//		 * "/swagger-resources").permitAll(); httpSecurity.csrf().disable();
//		 * httpSecurity.headers().frameOptions().disable();
//		 */
//		httpSecurity.httpBasic().and().csrf().disable();
//
//	}
//
//	
//
//}