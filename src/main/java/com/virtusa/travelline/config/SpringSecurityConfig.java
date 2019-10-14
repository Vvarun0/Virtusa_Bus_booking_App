package com.virtusa.travelline.config;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.context.annotation.Configuration; 
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration 
@EnableWebSecurity 
public class SpringSecurityConfig   extends WebSecurityConfigurerAdapter {

@Autowired 
private UserDetailsService userDetailsService;

@Autowired 
private CustomSuccessHandler customSuccessHandler;

@Override protected void configure(AuthenticationManagerBuilder auth) throws
Exception {


auth.userDetailsService(userDetailsService).passwordEncoder(new  BCryptPasswordEncoder());

}

@Override protected void configure(HttpSecurity http) throws Exception {



	  http.csrf().disable().authorizeRequests()
		.antMatchers("/**").permitAll()
		//.access("hasRole('ROLE_ADMIN')")
		//.antMatchers(HttpMethod.GET, "/").hasRole("ADMIN")	    
		.and()
		 .formLogin()
	        .loginPage("/login").successHandler(customSuccessHandler)
	        .failureUrl("/loginError")
	      .and()
	        .logout()
	        .logoutSuccessUrl("/");

}


}
