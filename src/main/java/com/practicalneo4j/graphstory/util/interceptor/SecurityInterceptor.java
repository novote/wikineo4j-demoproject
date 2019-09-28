package com.practicalneo4j.graphstory.util.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.log4j.Logger;
//import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
//import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//import com.practicalneo4j.graphstory.service.main.RestJsonImpl;
import com.practicalneo4j.graphstory.util.GraphStoryConstants;


public class SecurityInterceptor extends HandlerInterceptorAdapter {



	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		boolean hasLoginCookie = false;

		if (request.getCookies() != null)
		{
			for (Cookie c : request.getCookies()) {
				if (c.getName().equals(GraphStoryConstants.graphstoryUserAuthKey))
				{
					hasLoginCookie = true;
					break;
				}
			}
		}

		if (hasLoginCookie) {
			return true;

		}else {
			response.sendRedirect("/msg?msg=Please login from SecuretyInterceptor");
			//for login from / page custom my form //hack
			//response.sendRedirect("/");
			return false;
		}

	}
}
