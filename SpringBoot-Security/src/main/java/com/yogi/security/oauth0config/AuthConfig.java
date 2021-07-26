package com.yogi.security.oauth0config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
public class AuthConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManagerBean();
	}
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.oauth2Login();
    }
    
    private final LogoutHandler logoutHandler;

    public AuthConfig(LogoutHandler logoutHandler) {
        this.logoutHandler = logoutHandler;
    }

    protected void configure1(HttpSecurity http) throws Exception {
       http
          .oauth2Login()
          .and().logout()
          .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
          .addLogoutHandler(logoutHandler);
    }
}
