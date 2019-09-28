package com.practicalneo4j.graphstory.service.main;

import java.io.Serializable;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.practicalneo4j.graphstory.domain.User;

//import com.practicalneo4j.graphstory.repository.MappedContentRepository.MappedComment;









import org.springframework.stereotype.Component;

@Component
@Service("graphStory")
@Scope("prototype")
public class GraphStory implements Serializable {

	@JsonIgnore
	private static final long serialVersionUID = 1L;

	@JsonInclude(Include.NON_NULL)
	private User user;

	@JsonInclude(Include.NON_NULL)
	public String title;
	


	@JsonInclude(Include.NON_NULL)
	private List<String> errorMsgs;

	@JsonInclude(Include.NON_NULL)
	private List<User> users;
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getErrorMsgs() {
		return errorMsgs;
	}

	public void setErrorMsgs(List<String> errorMsgs) {
		this.errorMsgs = errorMsgs;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}


	


	
	
	

}
