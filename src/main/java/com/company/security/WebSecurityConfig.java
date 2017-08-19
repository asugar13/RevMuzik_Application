package com.company.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.company.security.jwt.CustomAuthenticationProvider;
import com.company.security.jwt.JWTAuthenticationFilter;
import com.company.security.jwt.JWTLoginFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomAuthenticationProvider customAuthenticationProvider;

	@Autowired
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(this.customAuthenticationProvider);
	}

     @Override
     protected void configure(HttpSecurity http) throws Exception {
         // disable caching
    	 http.headers().cacheControl();
         
    	 /*ROUTING SECURITY*/
         http.csrf().disable() // disable csrf for our requests.
         	 .cors().and()
             .authorizeRequests()
             .antMatchers("/").permitAll()
             
             //shows
             .antMatchers( "/api/v1/venues/**" ).hasAnyAuthority("VENUES_LIST,VENUES_CREATE,VENUES_EDIT,VENUES_DELETE")
             .antMatchers( "/api/v1/users/**" ).hasAnyAuthority("USERS_LIST,USERS_CREATE,USERS_EDIT,USERS_DELETE")
             
                          
             //login 
             .antMatchers(HttpMethod.POST, "/api/v1/login").permitAll()
             //landinpage
             .antMatchers(HttpMethod.GET, "/api/v1/landinpage").permitAll()
             
            // .anyRequest().authenticated()
             .anyRequest().permitAll();
             //.and()
             // We filter the api/login requests
            // .addFilterBefore(new JWTLoginFilter("/api/v1/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
             // And filter other requests to check the presence of JWT in header
            // .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
     }
}