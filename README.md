# wikineo4j-demoproject
 Problem : Need to collect relevant word/definition  in format the explanatory dictionary and populate Neo4j database.

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
