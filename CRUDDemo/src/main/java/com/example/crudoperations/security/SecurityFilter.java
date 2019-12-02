/**
 * @author Akshay Moralwar
 * */
package com.example.crudoperations.security;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.codec.binary.Base64;

public class SecurityFilter {
	/*
	 * Returns array of String from the url.
	 * 
	 * @param request
	 * 
	 * @return values
	 */
	public String[] checkAuthentication(HttpServletRequest httpRequest) {
		System.out.println("In checkAuthentication method...");
		String[] values = null;
		final String authorization = httpRequest.getHeader("Authorization");
		if (authorization != null && authorization.toLowerCase().startsWith("basic")) {
			String base64Credentials = authorization.substring("Basic".length()).trim();
			String credentials = new String(Base64.decodeBase64(base64Credentials));
			values = credentials.split(":", 2);
		}
		System.out.println("Exiting checkAuthentication method...");
		return values;
	}
}
