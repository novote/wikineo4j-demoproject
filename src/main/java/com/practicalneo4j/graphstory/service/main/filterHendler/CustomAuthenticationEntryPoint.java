package com.practicalneo4j.graphstory.service.main.filterHendler;

import org.apache.commons.io.IOUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.BufferedReader;
import org.json.HTTP;
import org.json.JSONObject;
import org.json.JSONException;
/**
 * Created by avondersaar on 5/2/17.
 */
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {


    @Override
    public void commence(HttpServletRequest request, 
    		           HttpServletResponse response, 
    		  AuthenticationException authException)
            throws IOException, ServletException {
    	
    	
    	
    	
    	System.out.println("here IS  CustomAuthenEntryPoint filter"+IOUtils.toString(request.getReader()));
       
    	StringBuffer jb = new StringBuffer();
    	  String line = null;
    	  try {
    	    BufferedReader reader = request.getReader();
    	    while ((line = reader.readLine()) != null)
    	      jb.append(line);
    	  //  System.out.println("add new line");
    	       
    	  } catch (Exception e) { /*report an error*/ }

    	  try {
    	    JSONObject jsonObject =  HTTP.toJSONObject(jb.toString());
    	    
    	    System.out.println("jsonObject -" +jsonObject);
    	    //error get not existed property
    	   // System.out.println("jsonObject -" +jsonObject.getInt("intParamName"));
    	   // System.out.println("jsonObject -" +jsonObject.getString("username"));
    	  //  System.out.println("jsonObject -" +jsonObject.getJSONObject("username"));
    	  } catch (JSONException e) {
    	    // crash and burn
    	    throw new IOException("Error parsing JSON request string");
    	  }

    	  // Work with the data using methods like...
    	  // int someInt = jsonObject.getInt("intParamName");
    	  // String someString = jsonObject.getString("stringParamName");
    	  // JSONObject nestedObj = jsonObject.getJSONObject("nestedObjName");
    	  // JSONArray arr = jsonObject.getJSONArray("arrayParamName");
    	  // etc..
    	
    	
    	response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }
    
    
    
    
    
    
    
}
