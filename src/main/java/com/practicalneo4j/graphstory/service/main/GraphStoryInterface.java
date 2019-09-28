package com.practicalneo4j.graphstory.service.main;
import org.springframework.stereotype.Component;



@Component

public interface GraphStoryInterface {


	public HelperInterface getHelperInterface();

	public void setHelperInterface(HelperInterface helperInterface);
	


	public TagInterface getTagInterface();

	public void setTagInterface(TagInterface tagInterface);
	


	public UserInterface getUserInterface();

	public void setUserInterface(UserInterface userInterface);
	


}
