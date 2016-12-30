package com.dachlab.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserDetailServiceImpl userDetailServiceImpl;

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		log.info("Initializing security userDetailService.");
		auth.userDetailsService(userDetailServiceImpl);
	}

}
