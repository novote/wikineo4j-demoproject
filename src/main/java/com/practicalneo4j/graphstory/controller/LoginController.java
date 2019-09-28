package com.practicalneo4j.graphstory.controller;



import org.apache.commons.collections.CollectionUtils;  
import org.apache.logging.log4j.Logger;
import org.neo4j.ogm.session.Session;
import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import com.practicalneo4j.graphstory.service.main.GraphStory;
import com.practicalneo4j.graphstory.util.GraphStoryConstants;
import com.github.mjeanroy.springmvc.view.mustache.core.ModelAndMustacheView;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import java.net.URI;
import java.util.Locale;
import org.springframework.http.HttpHeaders;
import com.practicalneo4j.graphstory.domain.User;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.core.Authentication;
import javax.servlet.http.Cookie;
import org.springframework.ui.Model;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;




@Controller
public class LoginController extends GraphStoryController {

	
	private static final Logger log = LogManager.getLogger(LoginController.class);
	 
	@Autowired
	private Session  sessionNeo4j;

	 
	 @Autowired
	    private BCryptPasswordEncoder bCryptPasswordEncoder;

	 
	 
	 @RequestMapping(value = "/login", method = { RequestMethod.POST})
	    public String
	    login(
	    		@RequestParam("username") String username, 
	    		@RequestParam("password") String password,
	    		//@RequestPart(required = false, value="username") String username,
	    		//@RequestPart(required = false, value="password") String password
	    	    HttpServletResponse response,  
	    		HttpServletRequest request, 
	    		@ModelAttribute("graphStory") GraphStory graphStory
	    		) {
	      
		 
		 System.out.println("login cintroller hendler /login");
		 ModelAndMustacheView modelAndView = new ModelAndMustacheView("social/posts");

		 System.out.println("before try");
			try {
				
				if(isRememberMeAuthenticated()){
					System.out.println("RememberMeAuthenticat");	
					
				}else{ System.out.println("DONT WORK!!!! - RememberMeAuthenticat"); }
				
				graphStory = graphStoryInterface.getUserInterface().loginforCookie(graphStory, username);
				System.out.println("after check user in graphStory ");
				
				if (CollectionUtils.isEmpty(graphStory.getErrorMsgs())) {
					response.addCookie(graphStoryInterface.getHelperInterface().addCookie(GraphStoryConstants.graphstoryUserAuthKey, graphStory.getUser().getUsername()));
					System.out.println("after get graphStory2");
					
				}
				
				
				 //1. find user in database
				 System.out.println("userNodeProfile :  " + graphStory.getUser().getUsername());
			       
			        	if (graphStory.getUser().getUsername() == null) {
				        		
			        	modelAndView.addObject("error", "Invalid username or password");
			        	 URI uri = new URI("http://localhost:8080/");
			        	HttpHeaders httpHeaders = new HttpHeaders();
					    httpHeaders.setLocation(uri);
					    System.out.println("redirect to sign in page/" );
			        	  return  "redirect:/";  
			        }
			        	
				    User userNodeProfile  =  graphStory.getUser();
			        System.out.println("in login");
			        System.out.println("pass:  " + userNodeProfile.getPassword());
			        System.out.println("name:  " + userNodeProfile.getUsername());
			        
			        
			      
				  
				   return  "redirect:/tagsinter";
				  
			    
			}catch (Exception e) {
					log.error(e);
				return null;
			}
		
	        
	    
	    }

		private boolean isRememberMeAuthenticated() {

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (authentication == null) {
				return false;
			}
           return false;
		} 
	 
	 
	 

	    @GetMapping("/logout")
	    public String logout(HttpServletRequest request, HttpServletResponse response) {
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null) {
	            new SecurityContextLogoutHandler().logout(request, response, auth);
	            
	         System.out.println("nulling cookei1");
	         
	         
	        
	      
	         if( graphStory.getUser() != null ){
	              User userNodeProfile  =  graphStory.getUser();
		        System.out.println("name:  " + userNodeProfile.getUsername());
	            response.addCookie(graphStoryInterface.getHelperInterface().removeCookie(userNodeProfile.getUsername()));
	            }
	       

	         
	         Cookie[] cookies = request.getCookies();
	         if(cookies!=null)
	         for (int i = 0; i < cookies.length; i++) {
	          cookies[i].setMaxAge(0);
	          response.addCookie(cookies[i]);
	         }
	        }
	    
	       
	      
	        return "redirect:/";
	    }
	
	
	
	    
		
		@RequestMapping(value = "/registration", method = GET)
		public ModelAndMustacheView homeNewUserRegistrationSeppage(
				                                                   Locale locale, 
				                                                    Model model, 
				                                                   String error, 
				                                                   String logout, 
				                                       HttpServletRequest request, 
				                                      HttpServletResponse response) {
	
			
			
		 	
        ModelAndMustacheView modelAndViewHome = new ModelAndMustacheView("home/registration");
        modelAndViewHome.addObject("resources", request.getContextPath() + "/resources/");
       
		modelAndViewHome.addObject("id", 100);
	
       
		
		return modelAndViewHome;
       }
	
	    
	    
	    
	    
	//reg s otdelnoy stranici
	//paraminer from Ajax sand by 
	@RequestMapping(value = "/registration/user", method = RequestMethod.POST)
	public @ResponseBody ModelAndView  regNewUsr(
				        @RequestParam("userNikeName")       String userNikeName, 
				        @RequestParam("userEmail")          String userEmail,
	    		        @RequestParam("userPassword")       String userPassword,
	    		        @RequestParam("userPasswordConfirm")String userPasswordConfirm,
				         @ModelAttribute("graphStory")  GraphStory graphStory,
				                                HttpServletRequest request,
				                               HttpServletResponse response ) 
		{

		
		
	        ModelAndMustacheView modelAndViewRegistration;
	       
	        modelAndViewRegistration = new ModelAndMustacheView("home/index");
	        modelAndViewRegistration.addObject("resources", request.getContextPath() + "/resources/");
			
			try {
				
			
				
			if(userPassword.equals(userPasswordConfirm))
			{
				
				modelAndViewRegistration.addObject("title", " Yours passwords  NOT some ");
				
				
			
			
		
				boolean	nikeNameUnic = graphStoryInterface.getUserInterface().checkRegUserDataIsUnic(userNikeName);
				
				if(false == nikeNameUnic )
				  {
					
				  modelAndViewRegistration.addObject("nikeNameError", "name reserved" );
					
				  }else{
				
				  
				     String passEncoden = bCryptPasswordEncoder.encode(userPassword);
				     User createdUser = graphStoryInterface.getHelperInterface().saveJsonUserToBase(
				        		                                                       userNikeName, 
				          						                                        passEncoden,
				          						                                          userEmail, 
			          						                           "divaisId not implement iet" );			
				             				
				       
				             				
				        sessionNeo4j.clear();   		                 	 
				  
				        
				  
				  
					     modelAndViewRegistration.addObject("resources", request.getContextPath() + "/resources/");
					     modelAndViewRegistration.addObject("regUserNikName", createdUser.getUsername());
					     modelAndViewRegistration.addObject("regUserEmail", createdUser.getUseremail());
					    
					 
				    }
			    
			}else{
				
				 modelAndViewRegistration.addObject("passError", "pass " );
				 modelAndViewRegistration.addObject("emailError", null );
				 modelAndViewRegistration.addObject("regUserNikName", null);
				
			}
			
				return modelAndViewRegistration;
					
			}
			catch (Exception e) {
				log.error(e);
				return null;
			}

		}

	
}
