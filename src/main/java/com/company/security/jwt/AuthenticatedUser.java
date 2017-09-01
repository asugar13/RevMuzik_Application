package com.company.security.jwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class AuthenticatedUser implements Authentication {

	private static final long serialVersionUID = 1L;
	
	private String principal;
	private List<UserAuthority> authorities;
    private boolean authenticated = true;    
    private String details;
    private String credentials;
    private String name;
    
    public AuthenticatedUser() {}
    
    public AuthenticatedUser(String principal, List<UserAuthority> authorities){
		super();
		this.principal = principal;
		this.authorities = authorities;
    }

    @Override
    public Collection<SimpleGrantedAuthority> getAuthorities() {
    	Collection<SimpleGrantedAuthority> authorityList = new ArrayList<SimpleGrantedAuthority>();
    	for ( UserAuthority authority : authorities ) {
    		authorityList.add( new SimpleGrantedAuthority( authority.getAuthority() ) );
    	}
        return authorityList;
    }

    @Override
    public Object getCredentials() {
        return credentials;
    }

    @Override
    public Object getDetails() {
        return details;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }

    @Override
    public boolean isAuthenticated() {
        return this.authenticated;
    }

	@Override
	public String getName() {
		return name;
	}
    
    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {
        this.authenticated = b;
    }

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public void setAuthorities(List<UserAuthority> authorities) {
		this.authorities = authorities;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public void setCredentials(String credentials) {
		this.credentials = credentials;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}