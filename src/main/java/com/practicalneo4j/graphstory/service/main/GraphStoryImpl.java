package com.practicalneo4j.graphstory.service.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import org.springframework.stereotype.Component;
@Component
@Service("graphStoryInterface")
@Scope("prototype")
public class GraphStoryImpl implements GraphStoryInterface {

	

	private HelperInterface helperInterface;

	private TagInterface tagInterface;

	private UserInterface userInterface;
	


	//ContentInterface contentInterface,
	@Autowired
	public GraphStoryImpl(   
			HelperInterface helperInterface,  
			
			TagInterface tagInterface,  
			UserInterface userInterface ) {
	
		this.helperInterface = helperInterface;
		this.tagInterface = tagInterface;
		this.userInterface = userInterface;
	
	}


	@Override
	public HelperInterface getHelperInterface() {
		return helperInterface;
	}

	@Override
	public void setHelperInterface(HelperInterface helperInterface) {
		this.helperInterface = helperInterface;
	}
	

	@Override
	public TagInterface getTagInterface() {
		return tagInterface;
	}

	@Override
	public void setTagInterface(TagInterface tagInterface) {
		this.tagInterface = tagInterface;
	}

	@Override
	public UserInterface getUserInterface() {
		return userInterface;
	}

	@Override
	public void setUserInterface(UserInterface userInterface) {
		this.userInterface = userInterface;
	}
	
	
	

	

}
