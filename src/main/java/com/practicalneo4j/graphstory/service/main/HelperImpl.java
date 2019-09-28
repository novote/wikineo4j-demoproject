package com.practicalneo4j.graphstory.service.main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Service;
import com.practicalneo4j.graphstory.domain.User;
import com.practicalneo4j.graphstory.service.GraphStoryService;
import org.springframework.stereotype.Component;
@Component
@Service("helperInterface")
@Scope("prototype")
public class HelperImpl extends GraphStoryService implements HelperInterface {


	public final static String ROOTPATH = "/";

	public final static int dayexpiry = 24 * 60 * 60;

	public final static int twoWeekExpiry = 14 * dayexpiry;

	@Override
	public Cookie addCookie(String name, String value) {
		Cookie cookie = new Cookie(name, value);
		cookie.setPath(ROOTPATH);
		cookie.setMaxAge(twoWeekExpiry);
		return cookie;
	}

	@Override
	public Cookie removeCookie(String name) {
		Cookie cookie = new Cookie(name, "");
		cookie.setPath(ROOTPATH);
		cookie.setMaxAge(0);
		return cookie;
	}
	
	@Override
	public Cookie removeCookieFirstAddCookie(String name, String value) {
		
		
		
		Cookie cookie = new Cookie(name, value);
		cookie.setPath(ROOTPATH);
		cookie.setMaxAge(twoWeekExpiry);
		return cookie;
	}
	
	@Override

	public CsrfToken  addCsrfCookie(HttpServletRequest request){
			
		
		
	 	CsrfToken _csrf = (CsrfToken) request.getAttribute("_csrf");
	 
		
		return  _csrf;
	}
	
	@Override
	 public boolean isUserAuthenticated() {

       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
     
       return !Objects.equals(authentication.getName(), "anonymousUser");
   }
	 
	 
	@Override
	 public String nameOfUserAuthenticated() {
		  


      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
   
      
      return authentication.getName();
  }
	 
	

		@Override
		 public User  saveJsonUserToBase(String username, String userpassword, String useremail, String  divaiseId){
		
			
			 User  user = new User();
			 Set<String> authorities = new HashSet<>();
			authorities.add("ROLE_USER");
			user.setAuthorities(authorities);
			user.setLangKey("ukr"); 
			user.setReputation(0);
			user.setEnabled(true);
			 String  activationKey = uuidGen(); 
			user.setActivationKey(activationKey);
            user.setPassword(userpassword); 
			
	
			 Calendar calNow = Calendar.getInstance();
			 SimpleDateFormat dformatter = new SimpleDateFormat("yyyyMMddss");
			 java.util.Date dt = calNow.getTime();
			 String calendarplus1 = dformatter.format(dt);
			Long  timeRegistration  =  Long.valueOf(calendarplus1);
			user.setTimestamp(timeRegistration);
			
			String groupNmae = new String("Friends");
		
			String profileImageDefault = new String ("Users/topclub88/Documents/workspace 1.8 practic/veloshtorm/src/main/webapp/resources/core/images/profiles/0000.jpg"); 
			
			User newUser = userRepository.createNewUser(         username, 
					                                       user.getPassword(), 
					                                                useremail,  
					                                                divaiseId, 
					                                    user.getAuthorities(), 
					                                        user.getLangKey(),
					                                     user.getReputation(), 
					                                         user.isEnabled(), 
					                                  user.getActivationKey(), 
					                                      user.getTimestamp(), 
					                                      profileImageDefault,
					                                                groupNmae,
					                                                        0
					                                      );
			
			
			
			 return newUser;
		
		}
	
	

}
