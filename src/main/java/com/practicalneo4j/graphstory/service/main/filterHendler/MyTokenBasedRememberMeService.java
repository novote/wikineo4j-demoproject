package com.practicalneo4j.graphstory.service.main.filterHendler;

import java.lang.String;

 
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;



//@Component
/**/
//@Service("myTokenBasedRememberMeService")


 public class MyTokenBasedRememberMeService extends TokenBasedRememberMeServices {


   private final static String TOKEN_STRING = "my_rememberme_token";
  //old variand with sesion cooke Tomcat//   private final static String TOKEN_STRING = "Cookie";

   public MyTokenBasedRememberMeService(String key, UserDetailsService userDetailsService) 
   {
     super(key, userDetailsService);
   }

    
   //Consider defining a bean of type 'java.lang.String' in your configuration.
    

   @Override
   protected int calculateLoginLifetime(HttpServletRequest request, Authentication authentication) {
       System.out.println("COOKIE: Process1!");
       return super.calculateLoginLifetime(request, authentication);
   }

   @Override
   protected boolean isTokenExpired(long tokenExpiryTime) {
       System.out.println("COOKIE: Process2!");
       return super.isTokenExpired(tokenExpiryTime);
   }

   @Override
   protected String makeTokenSignature(long tokenExpiryTime, String username, String password) {
       System.out.println("COOKIE: Process3!");
       return super.makeTokenSignature(tokenExpiryTime, username, password);
   }

   @Override
   protected String retrievePassword(Authentication authentication) {
       System.out.println("COOKIE: Process4!");
       return super.retrievePassword(authentication);
   }

   @Override
   protected String retrieveUserName(Authentication authentication) {
       System.out.println("COOKIE: Process5!");
       return super.retrieveUserName(authentication);
   }

   @Override
   protected UserDetails processAutoLoginCookie(String[] cookieTokens, HttpServletRequest request, HttpServletResponse response) {
       System.out.println("COOKIE: Process6!");
       return super.processAutoLoginCookie(cookieTokens, request, response);
   }    

   @Override
   public void onLoginSuccess(HttpServletRequest request, HttpServletResponse response, Authentication successfulAuthentication) {
       System.out.println("COOKIE: Process7!");
       super.onLoginSuccess(request, response, successfulAuthentication);
   }


    @Override
    protected String extractRememberMeCookie(HttpServletRequest request) {
        String token = request.getHeader(TOKEN_STRING);
        if ((token == null) || (token.length() == 0)) {
            return "";
        }
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
        		+ "!!!! "+"      "+token+"      "+"      " +"!!!!"+

        		"!!!! "+"      "+"      "+"      " +"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        
        return token;
    }
   
} 