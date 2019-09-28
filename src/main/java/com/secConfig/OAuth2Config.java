package com.secConfig;




//import com.practicalneo4j.graphstory.domain.ErrorMessage;
import com.practicalneo4j.graphstory.repository.UserRepository;
//import com.practicalneo4j.securityconf.*;
//import javax.inject.*;
//port com.allanditzel.springframework.security.web.csrf.CsrfTokenResponseHeaderBuildingFilter; 
//import org.springframework.security.config.annotation.web.csrf.CsrfFilter;

import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.core.userdetails.UserDetails; 
import org.springframework.security.core.userdetails.UserDetailsService; 
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.core.Ordered;
//import org.springframework.core.annotation.EnableAuthorizationServer;

import org.springframework.security.config.annotation.web.servlet.configuration.*;
//import org.springframework.security.authentication.AuthenticationManager;

//import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;

import com.practicalneo4j.graphstory.service.main.GraphStoryInterface;
import com.practicalneo4j.graphstory.service.main.MyUserDetailsService;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfFilter;
import javax.servlet.FilterChain;
import javax.servlet.http.Cookie;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CsrfToken;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//csrf
import org.springframework.web.bind.annotation.RequestParam;
import java.util.UUID;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.web.filter.OncePerRequestFilter;

//import com.practicalneo4j.graphstory.service.main.TestFilter;
//import com.practicalneo4j.graphstory.service.main.LoginSuccessHandler;

import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security. authentication.RememberMeAuthenticationProvider;
import com.practicalneo4j.graphstory.service.main.filterHendler.MyTokenBasedRememberMeService;
//import com.practicalneo4j.graphstory.service.main.filterHendler.AjaxAuthenticationSuccessHandler;
//import com.practicalneo4j.graphstory.service.main.filterHendler.AjaxAuthenticationFailureHandler;
import com.practicalneo4j.graphstory.service.main.filterHendler.CsrfCookieGeneratorFilter;
//import com.practicalneo4j.graphstory.service.main.filterHendler.CookieNameGeneratorFilter;
//import com.practicalneo4j.graphstory.service.main.filterHendler.AjaxLogoutSuccessHandler;
import com.practicalneo4j.graphstory.service.main.filterHendler.CustomAuthenticationEntryPoint;
//import com.practicalneo4j.graphstory.service.main.CustomUserDetailsService;

import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;



//////@!!!!!!!!!TestOAuth2!!!!!!!!!!! + first add library to pom.xml

/*
@Configuration
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

	@Autowired
	@Qualifier("userDetailsService")
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Value("${gigy.oauth.tokenTimeout:3600}")
	private int expiration;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer configurer) throws Exception {
		configurer.authenticationManager(authenticationManager);
		configurer.userDetailsService(userDetailsService);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("gigy").secret("secret").accessTokenValiditySeconds(expiration)
				.scopes("read", "write").authorizedGrantTypes("password", "refresh_token").resourceIds("resource");
	}
}


*/