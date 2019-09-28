package com.practicalneo4j.graphstory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import com.github.mjeanroy.springmvc.view.mustache.core.ModelAndMustacheView;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import com.practicalneo4j.graphstory.util.GraphStoryConstants;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import java.util.*;


@Controller
@RequestMapping("/")
public class HomeController extends GraphStoryController {


	

	@RequestMapping(value = "/", method = GET)
	public ModelAndMustacheView homeWithSecAuthentication(Locale locale, 
			Model model, String error, String logout, 
			HttpServletRequest request, 
			HttpServletResponse response) {

		
		if (error != null)
              model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
              model.addAttribute("message", "You have been logged out successfully.");
		
	 	     CsrfToken _csrf = (CsrfToken) request.getAttribute("_csrf");
	 	
	 	 
	    if (isUserAuthenticated()) {
        	
        	 ModelAndMustacheView modelAndViewWasLogin = new ModelAndMustacheView("social/posts"); // ???
        	 modelAndViewWasLogin.addObject("resources", request.getContextPath() + "/resources/");
        	 modelAndViewWasLogin.addObject("token", _csrf.getToken());
 	       
        	
 	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	       
	        org.springframework.security.core.userdetails.User currentUser =  (org.springframework.security.core.userdetails.User)authentication.getPrincipal();
	   		

				System.out.println("cookie cheak");
				
			     Cookie[] cookies = request.getCookies();
		       if(cookies!=null)
		       {
		         for (int i = 0; i < cookies.length; i++)
		         {
		        	 System.out.println("cookie name -- "+cookies[i].getName());
		           if ( cookies[i].getName().equals(currentUser.getUsername()))
		            {
		        	   System.out.println("cookie del");
		        	   cookies[i].setMaxAge(0);
		        	 response.addCookie(graphStoryInterface.getHelperInterface().removeCookie(currentUser.getUsername()));
				   		 
		            } 		      
		         }
		
		       
		       response.addCookie(graphStoryInterface.getHelperInterface().addCookie(GraphStoryConstants.graphstoryUserAuthKey, currentUser.getUsername()));
				
				
			}
	   		 
 	        return modelAndViewWasLogin;
 	   
        	
        }else{
        	
        ModelAndMustacheView modelAndViewHome = new ModelAndMustacheView("home/index");
        modelAndViewHome.addObject("resources", request.getContextPath() + "/resources/");
        modelAndViewHome.addObject("token", _csrf.getToken());
		modelAndViewHome.addObject("id", 100);
		modelAndViewHome.addObject("content", "content from spring to iOS app");
        return modelAndViewHome;
        }
		
	}
			
	
	
	 private boolean isUserAuthenticated() {
   	 
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return !Objects.equals(authentication.getName(), "anonymousUser");
   }
	
		
		   
		 

		
	
}