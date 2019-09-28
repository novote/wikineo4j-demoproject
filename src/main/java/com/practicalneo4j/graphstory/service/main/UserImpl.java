package com.practicalneo4j.graphstory.service.main;

import java.util.LinkedList;
import java.util.List;
//import java.util.HashSet;
//import java.util.Set;
import java.util.ArrayList;


//import org.apache.commons.collections.CollectionUtils;
//import org.apache.log4j.Logger;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.neo4j.ogm.session.Session;
import org.springframework.context.annotation.Scope;
//import org.springframework.data.neo4j.annotation.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestPart;
//import org.springframework.web.servlet.ModelAndView;

import com.practicalneo4j.graphstory.domain.User;

//import com.practicalneo4j.graphstory.repository.Map;

import com.practicalneo4j.graphstory.service.GraphStoryService;
//import com.practicalneo4j.graphstory.util.GraphStoryConstants;
import org.springframework.stereotype.Component;
//neo4j
//import java.util.Collections;
//import java.util.Map;

//import com.config.Neo4jSessionFactory;
//import com.config.AppConfig;
//import com.practicalneo4j.securityconf.Authority;
//import com.practicalneo4j.graphstory.util.GraphStoryConstants;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Component
@Service("userInterface")
@Scope("prototype")
public class UserImpl extends GraphStoryService implements UserInterface {

	//static Logger log = Logger.getLogger(UserImpl.class);
	private static final Logger log = LogManager.getLogger(UserImpl.class);

	private User tempUser;
	
	@Autowired
	private Session  sessionNeo4j;
	
	//@Autowired
   // private BCryptPasswordEncoder bCryptPasswordEncoder;
	//@Autowired
	//public GraphStoryInterface graphStoryInterface;

	@Override
	public GraphStory save(GraphStory graphStory) throws Exception {

		//add to graph story  user pass, email, name  
		graphStory.getUser().setUsername(graphStory.getUser().getUsername().toLowerCase().trim());
		graphStory.getUser().setUserpassword(graphStory.getUser().getUserpassword().toLowerCase().trim());
		graphStory.getUser().setUseremail(graphStory.getUser().getUseremail().toLowerCase().trim());
		
		
		//implement for spring securety
		//set UserRole object
	//	UserRole roleObj = new UserRole();
	//	roleObj.setRole(GraphStoryConstants.roleUser);
	//	roleObj.setUser(graphStory.getUser());
		
	//	 Set <UserRole>	userRoles = new HashSet<>(); 
	//	 userRoles.addAll(roleObj);
		
	//	graphStory.getUser().setUserRole(roleObj);
		
	
		// in if() test on existing user in data base
		if (!userExists(graphStory.getUser())) {
			graphStory.setUser(userRepository.save(graphStory.getUser())); //save with CRUD Repository method
		} else {
			addErrorMsg(graphStory, "The username you entered already exists.");
		}

		return graphStory;

	}

	
	@Override
	public GraphStory saveWithbCrypt(GraphStory graphStory) throws Exception {

		//add to graph story  user pass, email, name  
		graphStory.getUser().setUsername(graphStory.getUser().getUsername().toLowerCase().trim());
		graphStory.getUser().setUserpassword(graphStory.getUser().getUserpassword().toLowerCase().trim());
		//graphStory.getUser().setUserpassword(bCryptPasswordEncoder.encode(graphStory.getUser().getUserpassword().toLowerCase().trim()));
		graphStory.getUser().setUseremail(graphStory.getUser().getUseremail().toLowerCase().trim());
		
	
		// in if() test on existing user in data base
		if (!userExists(graphStory.getUser())) {
			graphStory.setUser(userRepository.save(graphStory.getUser()));
		} else {
			addErrorMsg(graphStory, "The username you entered already exists.");
		}

		return graphStory;

	}


	@Override
	public  boolean checkRegUserEmailIsUnic( String userEmail){
		try {
			
			//compare to null  mean false is unic , true is duplication email was added before
			boolean u = userRepository.findByEmail( userEmail);
			 System.out.println("user  email UNIC --  " + u);

				return u;
		}
		catch (Exception e) {
			log.error(e);
			return true;
		}
		
	}
	
	
	
	 public GraphStory customSave(GraphStory graphStory) throws Exception {

			//add to graph story  user pass, email, name  
			graphStory.getUser().setUsername(graphStory.getUser().getUsername().toLowerCase().trim());
			graphStory.getUser().setUserpassword(graphStory.getUser().getUserpassword().toLowerCase().trim());
			graphStory.getUser().setUseremail(graphStory.getUser().getUseremail().toLowerCase().trim());
			
			
			//implement for spring securety
			//set UserRole object
			//Authority roleObj = new Authority();
			//roleObj.setRole(GraphStoryConstants.roleUser);
			//roleObj.setUser(graphStory.getUser());
			
			// Set <Authority>	userRoles = new HashSet<>(); 
			List<String> authorities = new ArrayList<>();
			authorities.add("ROLE_USER");
			
			//graphStory.getUser().setAuthorities(userRoles);
		//	graphStory.getUser().setAuthorities(authorities);
		
			// in if() test on existing user in data base
			if (!userExists(graphStory.getUser())) {
				graphStory.setUser(userRepository.save(graphStory.getUser()));
			} else {
				addErrorMsg(graphStory, "The username you entered already exists.");
			}

			return graphStory;

		}
	
	
	
	
	@Override
	public GraphStory login(GraphStory graphStory) throws Exception {
		tempUser = userRepository.findByUsername(graphStory.getUser().getUsername());
		if (tempUser != null) {
			graphStory.setUser(tempUser);
		} else {
			addErrorMsg(graphStory, "The username you entered does not exist.");
		}

		return graphStory;
	}

	@Override
	public GraphStory loginforCookie (GraphStory graphStory, String username) throws Exception
	{
		
		tempUser = userRepository.findByUsername(username);
		if (tempUser != null) {
			graphStory.setUser(tempUser);
		} else {
			addErrorMsg(graphStory, "The username you entered does not exist.");
		}

		return graphStory;
		
	}
	//v1
	@Override
	public User getByUserName(String username) throws Exception 
	{

		try {
			 User u = userRepository.findByUsername(username);

				return u;
		}
		catch (Exception e) {
			log.error(e);
			return null;
		}
	
	}
	
	

	


	

	
	
	
	
	@Override
	public  boolean checkRegUserDataIsUnic(String userNikeName){
		try {
			
			//compare to null  mean false is unic , true is duplication email was added before
			//boolean u = userRepository.findByEmail( userEmail);
		//	if(false == u)
		//	{
				//cheack name if email not exist in database
			boolean  u = userRepository.findByUsernameBollean(userNikeName);
				 
				 System.out.println("user nike  UNIC  ");
				
		//	 }

				return u;
		}
		catch (Exception e) {
			log.error(e);
			return true;
		}
		
	}
	
	
	
	@Override
	public User getByUserName2(String username)
	{

		try {
			 User u = userRepository.findByUsername(username);

				return u;
		}
		catch (Exception e) {
			log.error(e);
			return null;
		}
	
	}
	@Override
	public  User getByUser(User user){
		
		
		try {
			 User u = userRepository.findByUser(user);

				return u;
		}
		catch (Exception e) {
			log.error(e);
			return null;
		}
		
		
	}
	
	@Override
	public  User getUserProfilByNodeId(Long userNodeId){
		
		
		try {
			 User u = userRepository.findByUserNodeId(userNodeId);

				return u;
		}
		catch (Exception e) {
			log.error(e);
			return null;
		}
		
		
	}
	@Override
	public Boolean updateUserID(String userNodeId, String newUsername){
		
		
		Boolean nameOccupied;
		
		try {
			    ;
			nameOccupied  = userRepository.findByUsernameBollean(newUsername);
			if(nameOccupied  == true){
				//ID is free 
				
				User user =  userRepository.saveNewUserId(Long.valueOf(userNodeId), newUsername);
				System.out.println("++UserImpl++ User Id  UPDATED OK " +user );
			}else{
				//duplication user with this name existed /ID is nameOccupied 
				nameOccupied = false;
				
			}
			 

				
		}
		catch (Exception e) {
			log.error(e);
			return null;
		}
		
		return nameOccupied;
	}
	
	
	@Override
	public  String getOrigUserNameByID(Long UserID){
		
		
		try {
			 String userName = userRepository.findByUserNameByID(UserID);

				return userName ;
		}
		catch (Exception e) {
			log.error(e);
			return null;
		}
		
		
	}
	
	
	
	
	
	public String testUserInterface(String username) throws Exception
	{
		try {
			

				return username+"test interface";
		}
		catch (Exception e) {
			log.error(e);
			return null;
		}
		
	}
	
	//v2
	@Override
	public User getByUserNameAndPass(String username, String userpass) throws Exception {

		User u = userRepository.findByUsernameUserPass(username ,userpass);

		return u;
	}
	//v3
	@Override
	public User getByUserEmailAndPass(String useremail, String userpass) throws Exception {

		User u = userRepository.findByUsernameUserEmailAndPass(useremail, userpass);

		return u;
	}

	private boolean userExists(User user) throws Exception {
		boolean userFound = false;

	//	if (getByUserName(user.getUsername()) != null) {
	//		userFound = true;}

		//ok name and pass
	//	if ((getByUserNameAndPass(user.getUsername(), user.getUserpassword()) != null ) || (getByUserName(user.getUsername()) != null)) {
	//		userFound = true;}
		
		if ((getByUserNameAndPass(user.getUsername(), user.getUserpassword()) != null ) || (getByUserEmailAndPass(user.getUseremail(), user.getUserpassword() ) != null)) {
			userFound = true;
		}
		return userFound;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
 //  @Override
    public Class<User> getEntityType() {
        return User.class;
    }

	@Override
	public List<User> searchByUsername(String currentusername, String username) throws Exception {

		//???username = username.toLowerCase() + ".*";

		LinkedList<User> users = new LinkedList<User>(userRepository.searchByUsername(currentusername, username));
		return users;
	}
	

}