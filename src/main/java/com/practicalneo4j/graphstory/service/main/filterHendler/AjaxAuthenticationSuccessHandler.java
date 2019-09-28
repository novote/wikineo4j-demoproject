package com.practicalneo4j.graphstory.service.main.filterHendler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Spring Security success handler, specialized for Ajax requests.
 */
@Component
public class AjaxAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
        Authentication authentication)
        throws IOException, ServletException {
    	
    	 System.out.println("AjaxAuthenticationSuccessHandler   onAuthenticationSuccess");
    	//need test
    	 // response.getWriter().append("Authorized");
       //  clearAuthenticationAttributes(request);
    	 System.out.println("!!!!!!Filter Success Http request :  " + request);
    	 System.out.println("!!!!!!Filter Success Http response :  " + request);

        response.setStatus(HttpServletResponse.SC_OK);
    }
}
