/*
 * Copyright [2011-2016] "Neo Technology"
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 *
 */
//package com.config;
//package com;
//package com;
package com.config;


import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.boot.SpringApplication;
////import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import org.neo4j.driver.v1.Driver;
//import org.neo4j.driver.v1.GraphDatabase;
//import org.neo4j.driver.v1.AuthTokens;
//import org.neo4j.ogm.drivers.bolt.driver.BoltDriver;
//import org.neo4j.ogm.service.Components;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.core.env.SimpleCommandLinePropertySource;

//for sdn 4.1.x  neo4j
//import org.springframework.data.neo4j.config.Neo4jConfiguration;
//import org.springframework.data.neo4j.server.Neo4jServer;
//import org.springframework.data.neo4j.server.RemoteServer;
//import com.config.Neo4jSessionFactory;

//import org.neo4j.graphdb.GraphDatabaseService;
//import org.neo4j.graphdb.factory.GraphDatabaseFactory;

//import org.springframework.data.neo4j.config.EnableNeo4jRepositories;

//import org.springframework.data.neo4j.core.GraphDatabase;
//import org.springframework.data.neo4j.rest.SpringCypherRestGraphDatabase;


import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.repository.query.QueryLookupStrategy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//mustach
////import org.springframework.core.io.ResourceLoader;
//import org.springframework.web.servlet.ViewResolver;

//config nashorn
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.GzipResourceResolver;
import org.springframework.web.servlet.resource.PathResourceResolver;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.script.ScriptTemplateConfigurer;
import org.springframework.web.servlet.view.script.ScriptTemplateViewResolver;

//multi paert
import javax.servlet.MultipartConfigElement;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.context.embedded.MultipartConfigFactory;

import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
//import org.springframework.data.neo4j.web.support.OpenSessionInViewInterceptor;

//

//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

//import com.Constants;
///import com.practicalneo4j.graphstory.util.NMustacheViewResolver;
import java.io.IOException;
import java.util.Arrays;

//add xml config
import org.springframework.context.support.FileSystemXmlApplicationContext;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
//import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

//
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mustache.MustacheAutoConfiguration;
import org.springframework.boot.autoconfigure.data.neo4j.Neo4jDataAutoConfiguration;
//controler
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//import com.github.mjeanroy.springmvc.view.mustache.core.ModelAndMustacheView;


import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.transaction.*;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.context.request.AsyncWebRequestInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.data.neo4j.config.Neo4jConfiguration;
//import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
//import org.springframework.data.neo4j.config.Neo4jConfiguration;
//import org.springframework.data.neo4j.template.Neo4jOperations;
//import org.springframework.data.neo4j.template.Neo4jTemplate;

import org.springframework.web.context.request.RequestContextListener;

import javax.servlet.ServletRequest;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import javax.servlet.Filter;
//import com.practicalneo4j.graphstory.service.main.TestFilter;


//import com.practicalneo4j.graphstory.service.main.MyTokenBasedRememberMeService;
import it.ozimov.springboot.mail.configuration.EnableEmailTools;
import it.ozimov.springboot.mail.service.EmailService;
import it.ozimov.springboot.mail.service.exception.CannotSendEmailException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.AbstractApplicationContext;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
//import com.practicalneo4j.graphstory.service.main.MailService;

import org.neo4j.ogm.annotation.*;
//import org.neo4j.graphdb.factory.GraphDatabaseFactory;
//import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
//import org.springframework.data.neo4j.config.Neo4jConfiguration;
//import org.springframework.data.neo4j.rest.SpringRestGraphDatabase;
//import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import java.io.File;
//import org.neo4j.kernel.EmbeddedGraphDatabase;
import java.nio.file.Files;
 

@Configuration 
@ImportResource("classpath*:/com/config/appContext.xml") //ok
@ComponentScan (basePackages={"com.practicalneo4j", "com.secConfig"}) 
@EnableWebMvc               
@SpringBootApplication

@EnableAutoConfiguration   
(exclude = {MustacheAutoConfiguration.class, Neo4jDataAutoConfiguration.class})



	
//Then add to your Spring Boot configuration class these annotations:
@EnableNeo4jRepositories(basePackages = "com.practicalneo4j.graphstory.repository", queryLookupStrategy = QueryLookupStrategy.Key.CREATE_IF_NOT_FOUND)
@EntityScan(basePackages = "com.practicalneo4j.graphstory.domain, com.practicalneo4j.graphstory.domain.pojo, com.practicalneo4j.graphstory.domain.rest, com.practicalneo4j.graphstory.domain.relatioship, ")
@EnableTransactionManagement

@Controller

//for sdn 4.1.x
public class AppConfig implements WebMvcConfigurer {

//	public class AppConfig  extends WebMvcConfigurerAdapter {

    private final Logger log = LoggerFactory.getLogger(AppConfig.class);

   
    @Autowired
    private Environment env;
  
    



  @Bean
  public org.neo4j.ogm.config.Configuration configuration() {

       org.neo4j.ogm.config.Configuration configuration = new org.neo4j.ogm.config.Configuration.Builder()
        		.uri("bolt://neo4j:password@localhost") 
        		.uri("bolt://localhost:7687") 
               .credentials("neo4j", "Neo4j")
            .build();
    
    
       return configuration;
  }
    

  @Bean
  public SessionFactory sessionFactory() {
      return new SessionFactory(configuration(), "com.practicalneo4j" ); 
  }
  
	@Bean
	public Neo4jTransactionManager transactionManager() {
		return new Neo4jTransactionManager(sessionFactory());
	}
	

    
    ////////////////////////////////////////////config for SDN 5.0/////////////////////////////////////////////
     
 
    @Bean
    public org.springframework.web.filter.CharacterEncodingFilter characterEncodingFilter() {
        org.springframework.web.filter.CharacterEncodingFilter characterEncodingFilter = new org.springframework.web.filter.CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }
//////////////////////////////////end config filter/////////////////////////////////////////      
 
    
    @Bean public RequestContextListener requestContextListener(){
        return new RequestContextListener();
    } 
  
    
    
    @Bean
    public ScriptTemplateConfigurer configurer() {
        ScriptTemplateConfigurer configurer = new ScriptTemplateConfigurer();
        
        //1. Nashorn jdk8 script engine.
        configurer.setEngineName("nashorn");
        
        //2. Add mustache.min.js and custom render.js to Nashorn
        configurer.setScripts("/static/js/mustache.min.js", "/static/js/render.js");
        
        //3. Ask Nashorn to run this function "render()"
        configurer.setRenderFunction("render");
        return configurer;
    }

    
   
    @PostConstruct
    public void initApplication() throws IOException {
        if (env.getActiveProfiles().length == 0) {
            log.warn("No Spring profile configured, running with default configuration");
        } else {
            log.info("Running with Spring profile(s) : {}", Arrays.toString(env.getActiveProfiles()));
        }
    }

    
 


    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(AppConfig.class);

        app.run(args);
    } 


	

    @Bean
    public ViewResolver viewResolver() {
        ScriptTemplateViewResolver viewResolver = new ScriptTemplateViewResolver();
        viewResolver.setPrefix("/static/templates/");
        viewResolver.setSuffix(".html");
        return viewResolver;
    }

		 @Override
		    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		        System.out.println("WebMvcConfigurer - addResourceHandlers() function get loaded...");
		        registry.addResourceHandler("/resources/**")
		                .addResourceLocations("/resources/", "classpath:/webapp/resources/");
		            
		        registry
		            .addResourceHandler("/js/**")
		            .addResourceLocations("/js/")
		            .setCachePeriod(3600)
		            .resourceChain(true)
		            //.addResolver(new GzipResourceResolver())
		            .addResolver(new PathResourceResolver());
		    }

		
		
		

		 //multipart request ?????
		    @Bean  
		    public UrlBasedViewResolver setupViewResolver() {  
		        UrlBasedViewResolver resolver = new UrlBasedViewResolver();  
		        resolver.setPrefix("/static/templates/");  
		        resolver.setSuffix(".html");  
		        resolver.setViewClass(JstlView.class);
		        return resolver;  
		    }
		
		


}


