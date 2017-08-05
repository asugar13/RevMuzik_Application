package com.company.security.jwt;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.company.model.entities.Authority;
import com.company.model.entities.User;
import com.company.repository.UserRepository;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

	@Autowired
	private UserRepository userRepository;
	
    public CustomAuthenticationProvider() {
        logger.info("*** CustomAuthenticationProvider created");
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    	
    	User user = userRepository.findByEmail( authentication.getName() );
    	
    	if ( user != null && authentication.getCredentials().toString().equals( user.getUserPassword() ) ) {
    		List<GrantedAuthority> grantedAuths = new ArrayList<>();
            for ( Authority authority : user.getProfile().getAuthorities() ) {
            	grantedAuths.add( new SimpleGrantedAuthority( authority.getName() ) );        
            }
            return new UsernamePasswordAuthenticationToken( authentication.getName(), authentication.getCredentials().toString(), grantedAuths );
        } else {
            return null;
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

}