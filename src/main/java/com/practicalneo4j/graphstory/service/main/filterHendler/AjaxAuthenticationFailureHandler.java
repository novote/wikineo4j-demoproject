package com.practicalneo4j.graphstory.service.main.filterHendler;

import org.apache.commons.io.IOUtils;
import org.apache.commons.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Returns a 401 error code (Unauthorized) to the client, when Ajax authentication fails.
 */
@Component
public class AjaxAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	    private String jsonUsername;
	    private String jsonPassword;
	
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, 
    		                          HttpServletResponse response,
                                  AuthenticationException exception
        ) throws IOException, ServletException {

    	 System.out.println("AjaxAuthenticationFailureHandler   onAuthenticationFailure");
    
  
        String password = null; 

        if ("application/x-www-form-urlencoded".equals(request.getHeader("Content-Type"))) {
        	 System.out.println("Content-Type ?:  " + request.getHeader("Content-Type"));
        	 System.out.println("Content-Length ?:  " + request.getHeader("Content-Length"));
        	 System.out.println("Accept-Encoding ?:  " + request.getHeader("Accept-Encoding"));
        	 System.out.println("Host ?:  " + request.getHeader("Host"));
        	 System.out.println("Connection :  " + request.getHeader("Connection"));
        	 System.out.println("User-Agent:  " + request.getHeader("User-Agent"));
        	 
        	 System.out.println("username :  " + request.getHeader("username"));
        	 System.out.println("password:  " + request.getHeader("password"));
        	 
        	 
        	 String keyword = request.getParameter("username");//null
        	 System.out.println("keyword  " + keyword);//null
        	 System.out.println("reader  " +  request.getReader());//nr
        	//java 8.0 String body = request.getReader().lines().Collectors.joining("");
        	
        	 Map<String, String[]> parms = request.getParameterMap();//nr
        	 System.out.println("param:  " + parms); //nr
        	 
        }else{
           
            System.out.println("Filter Failure password:  " + request);
        }

    

      //  System.out.println("Filter Failure password:  " + response.toString());
        System.out.println(" remoutUser    " + request.getRemoteUser());//null
        System.out.println(" qs    " + request.getQueryString());//null
        
       //ok
        PrintWriter writer = response.getWriter();
        writer.write(exception.getMessage());
        System.out.println(" exp    " +  exception.getMessage());
       
        
        //??
        Map<String, String[]> map = request.getParameterMap();
        //Reading the Map
        //Works for GET && POST Method
        for(String paramName:map.keySet()) {
            String[] paramValues = map.get(paramName);

            //Get Values of Param Name
            for(String valueOfParam:paramValues) {
                //Output the Values
                System.out.println("Value of Param with Name "+paramName+": "+valueOfParam);
            }
        }
       
        //ok reading boody of request NSMutableDictionary Parameter
        System.out.println("with apatch  Failure "+IOUtils.toString(request.getReader()));
        
       
      //ok  response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication failed");
   //??
        super.onAuthenticationFailure(request, response, exception);
    }
   
    
    
    
    
    
    
    
    
    
    
    
}



