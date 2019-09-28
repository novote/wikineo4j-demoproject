

/*
 * 
 * 
 * 
 * 
 *    Problem : Need to collect relevant word/definition  in format the explanatory dictionary and populate Neo4j database.

          Task: to scrap wiki pages.
  Environtment: Spring Boot. Neo4j.  Jsoup library to make  main lifting.
  
   Get it work: 1. Integrate  in your project . Add Jsop Library  for maven project  1.12.x or newest in dependency section  pom.xml file.
  	 
	<dependency>
         <groupId>org.jsoup</groupId>
         <artifactId>jsoup</artifactId>
         <version>1.12.1</version>
    </dependency>
  
   And one java class ParserTagsController.java  for the  operation with Neo4j  It was used  custom repository, need only two cipher query)
 
  Get it work: 2. To completing demo project.
  
  Use: Add  the last  path part of wiki page.
    Ex. For scrap  https://en.wikipedia.org/wiki/neo4j   set in form only the last  part of path neo4j
    Tuning: Set with property  limitrelevantLink  Limit link you to wont explore.   default 150.
    if you need specific language   set property url. https://en.wikipedia.org/wiki/ - English 
    https://ua.wikipedia.org/wiki/ - Ukraine
    
   Video: App  usability demonstration https://www.youtube.com/watch?v=sIFH-tGNKIc&feature=youtu.be

 */






package com.practicalneo4j.graphstory.controller;

import java.util.Locale;
import java.util.List;
import org.jsoup.HttpStatusException;
import java.io.IOException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import com.practicalneo4j.graphstory.util.GraphStoryConstants;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.servlet.ModelAndView;
import com.practicalneo4j.graphstory.domain.User;
import com.practicalneo4j.graphstory.domain.Tag;
import org.springframework.security.web.csrf.CsrfToken;




@Controller
public class ParserTagsController extends GraphStoryController {


	private static final Logger log = LogManager.getLogger(ParserTagsController.class);
	

	   int limitrelevantLink  = 150;
	   
	   String url    =  new String( "https://en.wikipedia.org/wiki/");
	
	
		@RequestMapping(value = "/tagsinter", method = GET)
		 public ModelAndView tagsMakeWithWiki(        HttpServletRequest request, 
				                                                  Locale locale,
                                     @ModelAttribute("currentuser") User currentuser) {
	 
	      ModelAndView modelAndViewTags = new ModelAndView("tags/tagsinterface");
	
	      modelAndViewTags.addObject("resources", request.getContextPath() + "/resources/");
	
	      modelAndViewTags.addObject("title", "Tags");
	
	  
          CsrfToken _csrf	= graphStoryInterface.getHelperInterface().addCsrfCookie(request);              
           modelAndViewTags.addObject("token", _csrf.getToken()); 
     


	return modelAndViewTags;
}

	 
		
		private static Document connectLevev2(String url) {
		
		    Document doc = null;
		    try {
		        doc = Jsoup.connect(url)
		               .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
		               .referrer("http://www.google.com") 
		               .timeout(1000*6).ignoreHttpErrors(true)              
		               .get();
		    } catch (NullPointerException e) {
		        
		        e.printStackTrace();
		    } catch (HttpStatusException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		      
		        e.printStackTrace();
		    }
		    return doc;
		} 
		
		
		 public Tag  parseWikiPage( String url){
			 
			 Tag tagWords = new Tag();
			 
			  try {
				  Document doc =  connectLevev2(url);
		
			    if(doc!=null){
			    	
		        Element tbnbv000 = doc.select("h1.firstHeading").first();
                 
                 String titlePageWiki =  tbnbv000.text();
                 Element linkp = doc.select("p").first();
                 String firstParagraphWikiPage =  linkp.text();
                
          	   
                 
                 tagWords.setTitle(titlePageWiki);
                 tagWords.setText(firstParagraphWikiPage);
			    }
                 
		        
				}catch (Exception e) {log.error(e);}
			  
			 return tagWords;
		 }
		
		 
		 
		
		     @RequestMapping(value = { "/tags/search" },  method = RequestMethod.POST)
		     public ModelAndView searchWikiTagsNamePage ( 
	                                                     HttpServletRequest request, 
	         @CookieValue(GraphStoryConstants.graphstoryUserAuthKey) String username,
	                                    @ModelAttribute("currentuser") User currentuser,
	            @RequestPart(required = false, value="wikipagename") String wikiPageNameStr ) 
	         {
			
			
			 
			
	          ModelAndView modelWikiTags = new ModelAndView("tags/rendingconteinertags");
	          modelWikiTags.addObject("resources", request.getContextPath() + "/resources/");
	          modelWikiTags.addObject("title", "WikiTags");


	         
	          CsrfToken _csrf	= graphStoryInterface.getHelperInterface().addCsrfCookie(request);              
	          modelWikiTags.addObject("token", _csrf.getToken()); 
	       
		
	          try {
	

	     // -------------------------------test--------------------------------------- 
	        	  
	              if(wikiPageNameStr.contentEquals("111")){
	            	  System.out.println("test 111 ");
               	   List<Tag>testLinks = new ArrayList<>();
               	   int x = 0;
               	   while ( x < 20) 
               	   {
               	   x = x+ 1;
               	  Tag tagWords = new Tag();
                  tagWords.setTitle("titlePageWiki+"+x);
                  tagWords.setText("textWiki"+x);
               	   testLinks.add(tagWords);
               	  }
                 	 modelWikiTags.addObject("findedTagsHeader", true);
                     modelWikiTags.addObject("findedTags", testLinks);  
                     modelWikiTags.addObject("searchWord", wikiPageNameStr); 
                     modelWikiTags.addObject("numFindedTags", testLinks.size());
                     modelWikiTags.addObject("authorName", currentuser.getUsername());
                
                 
                     return modelWikiTags;
                  }
	       // -------------------------------test---------------------------------------	  
	              
	              
	              
	              
	              
	        	 
	        	
	        	String urlplus      = url.concat(wikiPageNameStr);
	        	
	        	
 				       
 				   Document doc = Jsoup.connect(urlplus).userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
 				                .referrer("http://www.google.com").ignoreHttpErrors(true).get();

       
 				   Element linkp = doc.select("p").first();
 	               String firstParagraphWikiPage =  linkp.text();
 	  			        
                   String pageTaglink   =  new String("wikipedia.org/wiki/Neo4j#");

      
                   Element tbnbv000 = doc.select("h1.firstHeading").first();
                   System.out.println("h1:+++ " +tbnbv000.text() );
                   String titlePageWiki =  tbnbv000.text();
                   


       
                         
                   
                   
                   
                   
                   
                         
                         List<Tag>tagWordsRawCollection = new ArrayList<>(); 
                  
                         List<String>relevantLinks = new ArrayList<>();
                    
                     
                         
                               Elements paragraphLinksAll = doc.select("p a");
                     
                         
                              for (Element paragraphLink : paragraphLinksAll) {
                                   
                                    
                                    print("All links  %s  ", paragraphLink.attr("abs:href"));
                              
                                  
                                  
                                  if(paragraphLink.attr("abs:href").contains(pageTaglink)){
                                	  
                                     print("NOT NEED LINK %s  ", paragraphLink.attr("abs:href"));
                                  }else{
                                  	
                                  	 print("FINE LINKS SIZE %s  ", relevantLinks.size());
                                  	
                                  	 if(relevantLinks.size()<limitrelevantLink){
                                  	 relevantLinks.add( paragraphLink.attr("abs:href") );
                                     print("FINE LINK  %s  ", paragraphLink.attr("abs:href"));
                                  		 
                                  	 }
                                  }
                  	     }
                        
                         print("relevantLinks before %s ", relevantLinks.size());
                
                           Tag tagWords = new Tag();
                           tagWords.setTitle(titlePageWiki);
                           tagWords.setText(firstParagraphWikiPage);
                           tagWordsRawCollection.add(tagWords);
                          
                         
                       //  3. 
                       
                      
                        
                           
                           if (relevantLinks.size() > 0 ) {
                        	   
                        	   for (String link : relevantLinks) 
                        	   {
                        		  
                        		    Tag tagsLevel2  = parseWikiPage(link);
                        		   if(tagsLevel2!= null){
                        		    System.out.println("2 LEVEL "+tagsLevel2.getTitle()); 
                        		   if(tagsLevel2.getText().isEmpty()){
                        			 
                        			 System.out.println("Bed tag without desc 2 LEVEL");  
                        		   }else{
                        		     tagWordsRawCollection.add(tagsLevel2); 
                        		   
                        		     
                        		   
                        		   }
                        		     }
                        		  
                        	   }
                        
                        	   
                              }
                          
                        
                           modelWikiTags.addObject("findedTagsHeader", true);
                           modelWikiTags.addObject("findedTags", tagWordsRawCollection);
                           modelWikiTags.addObject("searchWord", wikiPageNameStr);
                           modelWikiTags.addObject("numFindedTags", tagWordsRawCollection.size());
                        
                           
                  

	  	          }
	  	       catch (Exception e) { log.error(e);}


	  	       System.out.println("end-get tags from wiki" );

	  	          return modelWikiTags;
	  	    }
	  			
		
		
	 
	
    		  
    	 private static void print(String msg, Object... args) {
    		        System.out.println(String.format(msg, args));
    		    }

      
         
         

        
    	@RequestMapping(value="/tags/save", method=RequestMethod.POST)   //ok map
    	public ModelAndView update(      HttpServletRequest request, 
    		            @ModelAttribute("currentuser") User currentuser,
                                     @RequestBody List<Tag> json) {
      
    		
    		List<Tag> wikiTags =  new ArrayList<>();
    		
    		
    		json.stream().forEach(c -> c.getTitle( )) ; 
    		json.stream().forEach(c -> { 
    		String title  = c.getTitle().trim();
    		String text  = c.getText().trim();
    		 System.out.println("title  " +title );
       		 System.out.println("text  " +text);
       		 
             Tag tagWords = new Tag();
             tagWords.setTitle(title);
             tagWords.setText(text);
            
             wikiTags.add(tagWords);
    	
    	});
    	
    	
    	
    	
        ModelAndView modelWikiTags = new ModelAndView("tags/rendingconteinertags");
        modelWikiTags.addObject("resources", request.getContextPath() + "/resources/");
        modelWikiTags.addObject("title", "WikiTags");


       
        CsrfToken _csrf	= graphStoryInterface.getHelperInterface().addCsrfCookie(request);              
        modelWikiTags.addObject("token", _csrf.getToken()); 
                    
    	
    	int countSavedWikiTags = 0;
    	 List<Tag>tagWordsRawCollection = new ArrayList<>();
    	
    	try {		
       		           System.out.println("Your Data =>" + json);
       		           System.out.println("wikiTags N " +  wikiTags.size());
       		if(wikiTags.size()  > 0){
       			for( Tag t : wikiTags ){
       				if(t.getTitle().isEmpty()||t.getText().isEmpty()){
       				   System.out.println(" Tag Data => empty" );
       		    	}else{
       		    		System.out.println("Save wiki Tag Data =>" + t);
       		    		
       	
       		 		boolean  okNot = graphStoryInterface.getTagInterface().saveWikiTag(t, currentuser);
       		    	if(okNot){ 
       		    		countSavedWikiTags = countSavedWikiTags + 1; 
       		    		tagWordsRawCollection.add(t);
       		    		}
       		    	}
       		    	}
       			
       		}
       		
       	    modelWikiTags.addObject("countSavedtag", tagWordsRawCollection.size());
       	    modelWikiTags.addObject("savedtags",tagWordsRawCollection);
            modelWikiTags.addObject("authorName", currentuser.getUsername());
       	 
    	}
	 		catch (Exception e) {
	 			log.error(e);
	 		}
       		
       	    return   modelWikiTags;
       	}
   
} 

