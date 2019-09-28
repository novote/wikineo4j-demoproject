package com.practicalneo4j.graphstory.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
//import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.Neo4jRepository; //from SDN 4.2
import org.springframework.data.repository.query.Param;

import com.practicalneo4j.graphstory.domain.User;

import com.practicalneo4j.graphstory.util.GraphStoryConstants;
//import com.config.Neo4jSessionFactory;
//neo4j
import java.util.Collections;
import java.util.Map;
import java.util.Set;


public interface UserRepository extends Neo4jRepository<User, Long> {

	//1v loget and signup user
	//User findByUsername(String username);
	@Query("MATCH (n:User { username: {u} }) RETURN n")
	User findByUsername(@Param("u")String username);
	
	@Query("OPTIONAL MATCH (u:User {useremail: {uemail}, username:{un} } ) "
			+ "RETURN  u IS NULL")
	boolean findByUsernameAndEmail(
			                       @Param("un")String username, 
			                       @Param("uemail")String userEmail
			                      );
	
	
	@Query("OPTIONAL MATCH (u:User  {username:{un}}  ) "
			+ "RETURN  u IS NULL")
	boolean findByUsernameBollean( 
			              @Param("un")String username
                        );
	


	@Query("OPTIONAL MATCH (u:User {useremail: {uemail} } ) "
			+ "RETURN  u IS NULL")
  	boolean findByEmail(
			              @Param("uemail")String userEmail
			            );
	
	@Query("START user=node({u})  RETURN user")
	User findByUser(@Param("u")User user);
	
	@Query("START user=node({u})  RETURN user")
	User findByUserNodeId(@Param("u")Long nodeId);
	
	@Query("START user=node({u})  RETURN user.username")
	String findByUserNameByID(@Param("u")Long ID);
	



	


	


	
	@Query("MATCH (n:User { username: {u} }) "
			+ "SET n.authorities = {rightIds} RETURN n")
	User  testAddRolesByUsername(@Param("u")String username,
			                       @Param("rightIds") List<String> rightIds);
	
	@Query("MATCH (n:User { username: {u} }) "
			+ "RETURN n.username")
	String  testByUsername(@Param("u")String username);
	//2v
	@Query("MATCH (n:User { username: {u}, userpassword: {p} }) RETURN n")
	User findByUsernameUserPass(@Param("u")String username, @Param("p")String userpass);
	//3v
	@Query("MATCH (n:User {useremail: {e}, userpassword: {p} }) RETURN n")
	User findByUsernameUserEmailAndPass(  @Param("e")String email, @Param("p")String userpass);


	
	
	// match users and user(looking for) by username via param 'c'
	@Query(" MATCH (n:User), (user { username:{c}}) " +

			// where n.username WILDCARD on param 'u'
			// but is not the current user
			" WHERE (n.username =~ {u} AND n <> user) " +

			// and don't return users already being followed
			" AND (NOT (:User)-[:FOLLOWS]->(n)) " +
			" RETURN n")
	List<User> searchByUsername(@Param("c") String currentusername, @Param("u") String username);

	
	
	@Query(" MATCH (n:User) return n  ORDER BY n.reputation DESC")
	List<User> allActivUsers(@Param("c") String currentusername);



	 
  @Query( "MATCH (n:User { username: {un} })"		    
		    + "WITH n MATCH (l:Location{nodeId:{rez}}) "
		    + "WITH n, l MATCH (n)-[c:HAS_RESIDENTION]->(:Location)  Delete c "
		    + "WITH n, l MERGE (n)-[:HAS_RESIDENTION]->(l) "
		    + "WITH n, l  SET n.residention =   l.name + {probel}+ l.oblast "
		    + "RETURN n")
User editUserResidention(
			@Param("un") String username,
			@Param("rez")  int locationId,
			@Param("probel") String probelString
			);
  
  @Query( "MATCH (n:User { username: {un} }) "		    
		   // + "WITH n  MATCH (n)-[df:HAS_RESIDENTION]->(:Location) DELETE df "
		    + "WITH n MATCH (l:Location{nodeId:{rez}}) "
		    + "WITH n, l MERGE (n)-[:HAS_RESIDENTION]->(l) "
		    + "WITH n, l  SET n.residention =   l.name + {probel}+ l.oblast "
		    + "RETURN n")
User setUserResidention(
			@Param("un") String username,
			@Param("rez")  int locationId,
			@Param("probel") String probelString
			);
 
  @Query("OPTIONAL MATCH (n:User { nodeId: {un} })-[c:HAS_RESIDENTION]->(:Location) "
			+ "RETURN  c IS NULL")
	boolean userResidentionResidention(
			                       @Param("un") Long userId 
			                       //@Param("rez")  int locationId
			                      );
  
  
  @Query( "MATCH (n:User { username: {un} }) "
  	        + "WITH n  MATCH (n)-[rl:HAS_RESIDENTION]->(l:Location) "
    		+ "RETURN TOSTRING(ID(rl))")
           // + "RETURN l")
    String checkUserResidention(@Param("un") String username);
  
  
   @Query( "START user=node({id}) "
  		    + "SET user.username = {un}  "
		    + "RETURN user")
    User saveNewUserId( @Param("id") Long userNodeId, 
    		            @Param("un") String username);
  
  

  
        
        
  
        
        
        
        
        @Query(" CREATE (u:User { username:{username}, password:{password}, "
    			+ "useremail:{useremail}, divaiceId:{divaiceId}, "
    			+ "authorities:{authorities}, langKey:{langKey}, fotoLocalUrl:{prImg}, "
    			+ "reputation:{reputation}, enabled:{enabled}, activationKey:{activationKey}, timestamp:{TimeRegUser} }) "
    			+ "SET u.nodeId = ID(u),  u.userNodeId = TOSTRING(ID(u)) "
    			+ "WITH u CREATE (g:Groupe { groupname:{grname}, numberOfMember:{nummemb} }) WITH u, g  MERGE (u)-[:HAVEGROUP]-(g) "
    			+ "RETURN u")
    	User createNewUser(
    			@Param("username")String username, 
    			@Param("password")String userpassword, 
                @Param("useremail")String useremail,
                @Param("divaiceId")String divaiceId, 
                @Param("authorities")Set<String> authorities, 
    			@Param("langKey")String langKey, 
                @Param("reputation")int reputation,
                @Param("enabled")boolean enabled,  
                @Param("activationKey")String activationKey,
                @Param("TimeRegUser")Long timeStamp,
                @Param("prImg")String urlPassToprofileImageDefault,
                @Param("grname")String groupName,
                @Param("nummemb")int groupMember
                );
        
        
        
        
        
        
        
        
        
        
        
        
	

}

