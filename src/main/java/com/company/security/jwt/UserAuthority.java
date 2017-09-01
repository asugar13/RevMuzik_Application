package com.company.security.jwt;


public class UserAuthority {
	
	private String authority;
	
	public UserAuthority() {}

	public UserAuthority(String authority) {
		super();
		this.authority = authority;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
