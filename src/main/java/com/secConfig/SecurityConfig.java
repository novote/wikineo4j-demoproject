//package com.config;
package com.secConfig;

import org.springframework.security.web.firewall.*;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import com.practicalneo4j.graphstory.service.main.MyUserDetailsService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfFilter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.web.servlet.FilterRegistrationBean;  
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import com.practicalneo4j.graphstory.service.main.TestFilter;
import com.practicalneo4j.graphstory.service.main.LoginSuccessHandler;
import org.springframework.security. authentication.RememberMeAuthenticationProvider;
import com.practicalneo4j.graphstory.service.main.filterHendler.MyTokenBasedRememberMeService;
import com.practicalneo4j.graphstory.service.main.filterHendler.AjaxAuthenticationSuccessHandler;
import com.practicalneo4j.graphstory.service.main.filterHendler.AjaxAuthenticationFailureHandler;
import com.practicalneo4j.graphstory.service.main.filterHendler.CsrfCookieGeneratorFilter;
import com.practicalneo4j.graphstory.service.main.filterHendler.AjaxLogoutSuccessHandler;
import com.practicalneo4j.graphstory.service.main.filterHendler.CustomAuthenticationEntryPoint;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;


@Configuration   //Configuration class


@EnableWebSecurity //To switch off the default web security
@EnableGlobalMethodSecurity(securedEnabled = true)      //ok   allows AOP @PreAuthorize and some other annotations to be applied to methods.


public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	
	 
	//private final static String TOKEN_STRING = "my_token";
    private final static String COOKIE_STRING = "my_cookie";
  //  private final static String TOKEN_STRING = "Cookie";
  //  private final static String COOKIE_STRING = "Cookie";
	
    private final static String TOKEN_STRING = "my_rememberme_token";
	

	
	   //  @Autowired
         private MyTokenBasedRememberMeService tokenSvc;
         
         @Autowired
         private RememberMeAuthenticationProvider rememberMeProvider;
        
         
         @Autowired
         private MyUserDetailsService myUserDetailsService;
      
         @Autowired
         private AjaxAuthenticationSuccessHandler ajaxAuthenticationSuccessHandler;
         
         @Autowired
         private AjaxAuthenticationFailureHandler ajaxAuthenticationFailureHandler;
         
         @Autowired
         private AjaxLogoutSuccessHandler ajaxLogoutSuccessHandler;

         
         @Autowired
         private Environment env;
         
        @Autowired
        CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
         
         
         
         @Autowired
     	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        	 auth.userDetailsService(myUserDetailsService).passwordEncoder(bCryptPasswordEncoder());
        	
        	  auth.authenticationProvider(rememberMeProvider);
        	  auth.eraseCredentials(false);
     		}

         
  
         
         //! error Not show but  have error - No mapping found for HTTP request with URI [/resources//core/js/lib/select2-3.5.4/select2.css
         @Bean
         public HttpFirewall defaultHttpFirewall() {
             return new DefaultHttpFirewall();
         }
         
         
         @Bean
         @Override
         public AuthenticationManager authenticationManagerBean() throws Exception {
             return super.authenticationManagerBean();
         }

         
         
         //   @Bean
        //    public PersistentTokenBasedRememberMeServices getPersistentTokenBasedRememberMeServices() {
        //        PersistentTokenBasedRememberMeServices persistenceTokenBasedservice = new PersistentTokenBasedRememberMeServices("rememberme", myUserDetailsService, persistenceTokenRepository);
        //        persistenceTokenBasedservice.setAlwaysRemember(true);
        //        return persistenceTokenBasedservice;
        //      }
            
       //  @Bean
     //    public RememberMeAuthenticationFilter rememberMeAuthenticationFilter() throws Exception {
     //        return new RememberMeAuthenticationFilter(authenticationManager(), tokenBasedRememberMeService());
     //    }

         @Bean
         public RememberMeAuthenticationProvider rememberMeAuthenticationProvider() {
             return new RememberMeAuthenticationProvider(TOKEN_STRING);
         }
         
         @Bean
         public MyTokenBasedRememberMeService tokenBasedRememberMeService() {
             MyTokenBasedRememberMeService service = new MyTokenBasedRememberMeService(TOKEN_STRING, myUserDetailsService);
             service.setAlwaysRemember(true);
             service.setCookieName(COOKIE_STRING);
             return service;
         }
      
         
         
         @Bean
         public BCryptPasswordEncoder bCryptPasswordEncoder() {
             return new BCryptPasswordEncoder();
         }
         


    private CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setHeaderName("X-XSRF-TOKEN");
        System.out.println("CsrfTokenRepo -- "+ repository);
        //repository.setSessionAttributeName(("X-XSRF-TOKEN"));
        return repository;
    }

    @Bean
    FilterRegistrationBean testFilter() {
    	FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new TestFilter());
     // In case you want the filter to apply to specific URL patterns only
        registration.addUrlPatterns("/login");
        return registration;
    }
    
    @Bean
    public LoginSuccessHandler loginSuccessHandler(){
        return new LoginSuccessHandler();
    }
    
   
                                          
   
    @Override
    public void configure(WebSecurity web) throws Exception {
    	super.configure(web);
        web.ignoring().antMatchers("/registration","/registration/user");
      //  web.httpFirewall(allowUrlEncodedSlashHttpFirewall());
        //give anonymous access to work.
        //And remove that line from the HttpSecurity part. 
        //This will tell Spring Security to ignore this URL and don't apply any filters to them.
    }
    
    
    		
    @Override
    public void configure(HttpSecurity http) throws Exception {
       
    	   
    	
   	 List<String> unsecureUrlforCsrf = new ArrayList<String>();
   	 unsecureUrlforCsrf.add("/hello/ios");
   	 unsecureUrlforCsrf.add("/");
   	
   	 
   	  // Build the request matcher for CSFR protection
       RequestMatcher csrfRequestMatcher = new RequestMatcher() {

         // Disable CSFR protection on the following urls:
       	 
           private AntPathRequestMatcher[] 
           		requestMatchers = {
                                new AntPathRequestMatcher("/logout"),
                                new AntPathRequestMatcher("/registration")
                                     };

        
           
           
           
           @Override
         public boolean matches(HttpServletRequest request) {
           // If the request match one url the CSFR protection will be disabled
       	  for (AntPathRequestMatcher rm : requestMatchers) {
                 if (rm.matches(request)) { return false; }
           }
           return true;
         } // method matches
         
         
         

                                                               }; // new RequestMatcher
   	
   	    	
                                                               
                                                               
                                                               
                                                               
                                                        
    	http.exceptionHandling()
         .authenticationEntryPoint(customAuthenticationEntryPoint);
    	
    	http
    	 .addFilterAfter(new CsrfCookieGeneratorFilter(), CsrfFilter.class)
         .csrf()
	     .ignoringAntMatchers("/login")
	     .ignoringAntMatchers("/login/rest2")
	     .ignoringAntMatchers("/userpoi")
	     .ignoringAntMatchers("/signup/restuser")
	     .and()
         .exceptionHandling()
         .and()
    	 .authorizeRequests()
         .antMatchers("/resources/**","/webapp/resources/core/**", "/webapp/resources/core/wysihtml5/**", "/webapp/resources/core/summernote/**", "/webapp/resources/core/images/**").permitAll().anyRequest().permitAll()
         .antMatchers("/signupBcrypt").permitAll() 
         .antMatchers("/login/rest2", "/registration").permitAll() 
         .antMatchers("/signup/restuser").permitAll()
         .antMatchers(" home/regerror").permitAll()
         .anyRequest().authenticated()
         .and()
         .formLogin()
         .loginPage("/")
         .loginProcessingUrl("/login")
         .successHandler(ajaxAuthenticationSuccessHandler)
         .failureHandler(ajaxAuthenticationFailureHandler)
         .usernameParameter("username")
         .passwordParameter("password")
         .permitAll()
         .defaultSuccessUrl("/", true) 
		 .and()
		 .authorizeRequests()
         .antMatchers("/hello") 
         .permitAll()
         .and()
         .logout()
         .logoutUrl("/logout")
         .logoutSuccessHandler(ajaxLogoutSuccessHandler)
         .deleteCookies("JSESSIONID", "CSRF-TOKEN")
         .permitAll()
         .and()
         .rememberMe()
         .tokenValiditySeconds(1209600)
         .rememberMeParameter("_spring_security_remember_me")  
         .rememberMeServices(tokenSvc);
    	  
    
      
    }
}
 
    
	