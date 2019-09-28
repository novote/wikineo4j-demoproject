package com.practicalneo4j.graphstory.service.main;

import java.util.List;
import java.util.Map;

import org.springframework.data.repository.query.Param;

import com.practicalneo4j.graphstory.domain.User;



public interface UserInterface {



	public GraphStory login(GraphStory graphStory) throws Exception;
	public GraphStory loginforCookie(GraphStory graphStory, String username) throws Exception;
	                 
	public  User getByUserName(String username) throws Exception;
	public  User getByUserName2(String username);
	public  User getByUser(User user);
	public  User getUserProfilByNodeId(Long userNodeId);
	public  String getOrigUserNameByID(Long UserID);

	public  Boolean updateUserID(String UserNodeId, String newUsername);
  //  public  User getUserByNodeID(String casePostId)throws Exception;
 
	public GraphStory save(GraphStory graphStory) throws Exception;  // with CRUD  ?? 
	
	public GraphStory saveWithbCrypt(GraphStory graphStory) throws Exception; //with CRUD ?? //move to loginbCryptService
	
	public GraphStory customSave(GraphStory graphStory) throws Exception; // with CRUD ??

	public  boolean checkRegUserDataIsUnic(String userNikeName);
    public String testUserInterface(String username) throws Exception;
	public User getByUserNameAndPass(String username, String userpass) throws Exception;
	public User getByUserEmailAndPass(String useremail, String userpass) throws Exception; 
    public List<User> searchByUsername(String currentusername, String username) throws Exception;

   
	
    public  boolean checkRegUserEmailIsUnic( String userEmail);
	








}
/**/