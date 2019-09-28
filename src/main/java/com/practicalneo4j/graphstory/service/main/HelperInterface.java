package com.practicalneo4j.graphstory.service.main;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.csrf.CsrfToken;

import com.practicalneo4j.graphstory.domain.User;

public interface HelperInterface {

	public Cookie addCookie(String name, String value);

	public Cookie removeCookie(String name);
	
	public Cookie removeCookieFirstAddCookie(String name, String value);
	
	public CsrfToken  addCsrfCookie(HttpServletRequest request);
	
	public boolean isUserAuthenticated(); 
	
    public String nameOfUserAuthenticated();
    
    public User  saveJsonUserToBase(String username, String userpassword, String useremail, String  divaiseId);

}
