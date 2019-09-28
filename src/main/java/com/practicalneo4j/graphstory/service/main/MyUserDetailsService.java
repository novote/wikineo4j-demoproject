
// package com.practicalneo4j.securityconf;
package com.practicalneo4j.graphstory.service.main;

/* */

import com.practicalneo4j.graphstory.repository.UserRepository;
//import javax.inject.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder; 
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.core.userdetails.UserDetails; 
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService; 
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.apache.log4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

import com.practicalneo4j.graphstory.service.main.GraphStoryInterface;
import com.practicalneo4j.graphstory.service.main.UserInterface;
//?? import com.practicalneo4j.securityconf.Authority;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
//import com.practicalneo4j.graphstory.service.main.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;




@Component
@Service("myUserDetailsService")
//@Scope("prototype")   couse  cercle error

public class MyUserDetailsService implements UserDetailsService {


	@Autowired  // Error creating bean with name 'scopedTarget.getSession': Scope 'session'
	public GraphStoryInterface graphStoryInterface;
//	public interface UserInterface;
	
	
    static final Logger LOG = LoggerFactory.getLogger(MyUserDetailsService.class);

    

   
    
    
    
  //  @Override
      public UserDetails loadUserByUsername0000(final String username)throws UsernameNotFoundException
      {
      	
      	System.out.println("auth with username  custom loadUserByUsername" );
         try{

      	     	   
          	com.practicalneo4j.graphstory.domain.User  user  = graphStoryInterface.getUserInterface().getByUserName(username)
          			;
          	 ;
          	 System.out.println(" 3 ");
             System.out.println("name:  " + user.getUsername());
          	
              if (user==null)
                  {
              	
                  LOG.error("Threw exception in MyUserDetailsService: getByUserName : User doesn't exist" );
                  throw new UsernameNotFoundException(username);
                  } 
              else{
                 
            	  
            	  
            	  
            	  List<GrantedAuthority> authorities = buildUserAuthority(user.getAuthorities());
                  System.out.println(" list authorities is call  " +authorities.size() );
                
                  //1.2 add to the interface UserDetails  username and  Authorit
                //  User  
                  UserDetails authuser = buildUserForAuthentication(user, authorities);
                  System.out.println("name:  " + authuser.getUsername());
                  System.out.println("Password:  " + authuser.getPassword());
                  System.out.println("Authorities:  " + authuser.getAuthorities());
                  System.out.println("isAccountNonExpired:  " + authuser.isAccountNonExpired());
                  System.out.println("AccountNonLocked:  " + authuser.isAccountNonLocked());
                  System.out.println("isEnabled:  " + authuser.isEnabled());
                  System.out.println("CredentialsNon:  " + authuser.isCredentialsNonExpired());
                  
                  
                
                  
                  
                  return authuser;
                  }
          }catch(Exception e)
              {
              LOG.error("error : " + e);  
          	}
          return null;
      }

    
    
    
    
    
    
    @Override
  //  @Transactional(readOnly=true)
 //   @Transactional
    public UserDetails loadUserByUsername(final String username)
    {
    	
    	System.out.println("spring securety calling custom loadUserByUsername" );
    	 System.out.println("parameter username is -  " + username);
       try{
    	   System.out.println(" 1 ");
    	 //1.1 find user in data base by username
    	   
            if ( graphStoryInterface != null){System.out.println(" 1/2 "); }
            if ( graphStoryInterface.getUserInterface() != null){System.out.println(" 1/4"); }
          
            
            //if ( userService != null){ 	
           // 	System.out.println(" 1/8");
           // 	String user = userService.findByName2(username);
           // 	System.out.println(" 1/16"+user ); }
            
           // if (  != null){System.out.println(" 1/16");
         //   com.practicalneo4j.graphstory.domain.User  user0= userImpl.getByUserName(username);
         //   System.out.println(" 1/16"+user0);
          //  com.practicalneo4j.graphstory.domain.User  user  =  userInterface.getByUserName(username);
          //  }
            
  //  String	as1  =  graphStoryInterface.getUserInterface().testUserInterface(username);
    	   System.out.println(" 2 ");   System.out.println(" user name - "+	username);
    	   
        	com.practicalneo4j.graphstory.domain.User  user  = graphStoryInterface.getUserInterface().getByUserName(username);
        	//SecurityUser  user  =(SecurityUser) graphStoryInterface.getUserInterface().getByUserName(username);
        	
        	
        	System.out.println(" 3 ");
        	 
        	 System.out.println("name:  " + user);
        	//com.practicalneo4j.graphstory.domain.User  user  = userRepository.findByUsername(username);
        	System.out.println("name:  " + user.getUsername());
            if (user==null)
                {
            	
                LOG.error("Threw exception in MyUserDetailsService: getByUserName : User doesn't exist" );
                throw new UsernameNotFoundException(username);
                } 
            else{
              //  List<GrantedAuthority> authorities = buildUserAuthority(user.getAuthorities());
                Collection<? extends GrantedAuthority> authorities = getUserAuthority(user.getAuthorities());
                System.out.println(" list authorities is call  " +authorities.size() );
              
                //1.2 add to the interface UserDetails  username and  Authorit
              //  User  
                UserDetails authuser = buildUserForAuthentication(user, authorities);
                System.out.println("name:  " + authuser.getUsername());
                System.out.println("Password:  " + authuser.getPassword());
                System.out.println("Authorities:  " + authuser.getAuthorities());
                System.out.println("isAccountNonExpired:  " + authuser.isAccountNonExpired());
                System.out.println("AccountNonLocked:  " + authuser.isAccountNonLocked());
                System.out.println("isEnabled:  " + authuser.isEnabled());
                System.out.println("CredentialsNon:  " + authuser.isCredentialsNonExpired());
                
                
                addAuthToken(
                		//username, 
                		//password, 
                		authuser); 
                
                
                return authuser;
                }
        }catch(Exception e)
            {
            LOG.error("error : " + e);  
        	}
        return null;
    }

    
    
    
  
    // Converts com.users.model.User user to
    // org.springframework.security.core.userdetails.User
   // private User buildUserForAuthentication(com.domain.User user, List<GrantedAuthority> authorities) 
  //  private User buildUserForAuthentication(com.practicalneo4j.graphstory.domain.User user, List<GrantedAuthority> authorities) 
    private User buildUserForAuthentication(com.practicalneo4j.graphstory.domain.User user, Collection<? extends GrantedAuthority> authorities) 
    
    {
    	 System.out.println("buildUserForAuthentication");
    	 User  authuser = new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
    	 System.out.println("authuser  "+authuser.getUsername() );
    	 
    	// return new User( user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
    	 return authuser;
    }

      
    
    
 
   // private List<GrantedAuthority> buildUserAuthority(Set<Authority> userRoles)  {
           private List<GrantedAuthority> buildUserAuthority(Set<String> authorities)  {
    	System.out.println("buildUserAuthority");
        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
        Collection<GrantedAuthority> authorities2 = new ArrayList<GrantedAuthority>();

        // Build user's authorities
       for (String userRole : authorities) 
      //  for (Authority userRole : userRoles)
           {
    	    System.out.println("userRole " +userRole);
           // setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
            setAuths.add(new SimpleGrantedAuthority(userRole));

           }

        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

        return Result;
  
   
   }
 
           
            public Collection<? extends GrantedAuthority> getUserAuthority(Set<String> authorities)  {
           	System.out.println("buildUserAuthority");
           	
              
               Collection<GrantedAuthority> author = new ArrayList<GrantedAuthority>();
               System.out.println("size  " +authorities.size());
               // Build user's authorities
              for (String userRole : authorities) 
                  {
           	    System.out.println("userRole " +userRole);

                   SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole);
                   author.add(authority);
                  }

               return author;
         
          
          }     
           
           
         
           
       public void addAuthToken(
    		   //String username, 
    		  // String password,
    		   UserDetails userDetails) {
           	
         
           	 System.out.println("addAuthToken!");
              	String password = "1111";
               
               //2. make usernamePasswordAuthenticationToken
               UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                       new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
               System.out.println("UPAToken " +usernamePasswordAuthenticationToken );
              
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
               
               Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

              
             
               if (principal instanceof UserDetails) {
                 String usernameP = ((UserDetails)principal).getUsername();
                 System.out.println("principal username" +usernameP);
                 String passwordP = ((UserDetails)principal).getPassword();
                 System.out.println("principal password" +passwordP);
               } else {
                 String usernameP = principal.toString();
                 System.out.println("xxxxxxxxaddprincipal " +usernameP);
               }
         
           
            

           }
     
           
           
           
           
           
    
    public void autologin(String username, String password) {
    	
    	//1.call  loadUserByUsername
    	//  final AuthenticationManager am = new AuthenticationManager();
    	 System.out.println("autologin!");
    	 
        UserDetails userDetails = loadUserByUsername(username);
        
        //2. make usernamePasswordAuthenticationToken
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        System.out.println("autologin after manager " +usernamePasswordAuthenticationToken );
       
         SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

       
      
        if (principal instanceof UserDetails) {
          String usernameP = ((UserDetails)principal).getUsername();
          System.out.println("up " +usernameP);
          String passwordP = ((UserDetails)principal).getPassword();
          System.out.println("up " +passwordP);
        } else {
          String usernameP = principal.toString();
          System.out.println("up " +usernameP);
        }
      //  manager.authenticate(usernamePasswordAuthenticationToken);
        System.out.println("setAuthentication " );
        
     
        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
           // logger.debug(String.format("Auto login %s successfully!", username));
       
            System.out.println("Auto login %s successfully!" +username);
        }
    }


    
 public com.practicalneo4j.graphstory.domain.User findByUsername(String username) {
    	
	 com.practicalneo4j.graphstory.domain.User   profile = new com.practicalneo4j.graphstory.domain.User();
    	
    	try {
    	//	 profile   = graphStoryInterface.getUserInterface().getByUserName(username);
		
		}
		catch (Exception e) {
			LOG.error("error in findByUsername method");
		}

        return profile;
    }

    
    
    
}

/**/
