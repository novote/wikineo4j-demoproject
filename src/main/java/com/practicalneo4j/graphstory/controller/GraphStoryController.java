package com.practicalneo4j.graphstory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.practicalneo4j.graphstory.domain.User;
import com.practicalneo4j.graphstory.service.main.GraphStory;
import com.practicalneo4j.graphstory.service.main.GraphStoryInterface;
import com.practicalneo4j.graphstory.util.GraphStoryConstants;

//test spring securety import com.practicalneo4j.securityconf.service.SecurityService;

@Controller
public class GraphStoryController {

	@Autowired
	public GraphStoryInterface graphStoryInterface;

	@Autowired
    public GraphStory graphStory;

	@ModelAttribute("currentuser")
	public User currentuser(@CookieValue(value = GraphStoryConstants.graphstoryUserAuthKey, required = false) String graphstoryUserAuthKey) throws Exception {

		if (graphstoryUserAuthKey != null) {
			return graphStoryInterface.getUserInterface().getByUserName(graphstoryUserAuthKey);
		} else {
			//test ok
		
			return null;
		}

	}

}
