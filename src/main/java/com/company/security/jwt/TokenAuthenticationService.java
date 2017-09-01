package com.company.security.jwt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenAuthenticationService {

     private final String secret = "anystringhere:78#4fg1(8lPfs2";
     private final String tokenPrefix = "Bearer ";
     private final String headerString = "Authorization";
     
     public void addAuthentication(HttpServletResponse response, Authentication authentication) {
    	 
    	 GregorianCalendar expiration = new GregorianCalendar();
    	 expiration.add(GregorianCalendar.HOUR_OF_DAY, 5);
    	 //expiration.add(GregorianCalendar.SECOND, 10);
    	 
    	 List<UserAuthority> authorities = new ArrayList<UserAuthority>();
    	 for( GrantedAuthority authority : authentication.getAuthorities() ) {
    		 authorities.add( new UserAuthority( authority.getAuthority() ) );
    	 }
    	 
    	 AuthenticatedUser authenticatedUser = new AuthenticatedUser( (String)authentication.getPrincipal(), authorities );
    	 String dataToGenerateToken;
		try {
			dataToGenerateToken = new ObjectMapper().writeValueAsString( authenticatedUser );
	         // We generate a token now
	         String generatedToken = Jwts.builder()
	             .setSubject( dataToGenerateToken )
	             .setExpiration( expiration.getTime() )
	             .signWith(SignatureAlgorithm.HS512, secret)
	             .compact();
	         response.addHeader(headerString, tokenPrefix + generatedToken);
	         response.addHeader("Access-Control-Expose-Headers", "Authorization");
	         response.getWriter().write( dataToGenerateToken );
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	 
     }

     public Authentication getAuthentication(HttpServletRequest request) {
         String token = request.getHeader(headerString); //.substring(7);
         if (token != null) {
             // parse the token.
             String userData = Jwts.parser()
                 .setSigningKey(secret)
                 .parseClaimsJws(token)
                 .getBody()
                 .getSubject();
             if (userData != null) // we managed to retrieve a user
             {
            	 AuthenticatedUser authenticatedUser;
				try {
					authenticatedUser = new ObjectMapper().readValue(userData, AuthenticatedUser.class);
					return authenticatedUser;
				} catch (JsonParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
             }
         }
         return null;
     }
 }