package com.practicalneo4j.graphstory.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.UUID;

//import org.apache.log4j.Logger;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
//import org.springframework.data.neo4j.template.Neo4jOperations;
//import org.neo4j.ogm.session.request.*;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedGenerator;



import com.practicalneo4j.graphstory.repository.TagRepository;

import com.practicalneo4j.graphstory.repository.UserRepository;


import com.practicalneo4j.graphstory.service.main.GraphStory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Transactional
//@PropertySource(value = "classpath:/com/practicalneo4j/graphstory/service/package.properties")
public class GraphStoryService {

	//static Logger log = Logger.getLogger(GraphStoryService.class);
	private static final Logger log = LogManager.getLogger(GraphStoryService.class); 
	
	//@Autowired // The dependencies of some of the beans in the application context form a cycle:
  //  private BCryptPasswordEncoder bCryptPasswordEncoder;


	



	

	

	









	

	


	@Autowired
	public TagRepository tagRepository;

	@Autowired
	public UserRepository userRepository;


	//@Autowired
//	public Neo4jOperations neo4jTemplate;

	@Autowired
	public Environment environment;

	public GraphStory addErrorMsg(GraphStory graphStory, String msg) {
		if (graphStory.getErrorMsgs() == null) {
			graphStory.setErrorMsgs(new LinkedList<String>());
		}
		graphStory.getErrorMsgs().add(msg);

		return graphStory;

	}

	public final TimeBasedGenerator uuidGenerator = Generators.timeBasedGenerator();

	public String uuidGen() {
		final UUID uuid = uuidGenerator.generate();
		final StringBuilder sb = new StringBuilder();
		sb.append(Long.toHexString(uuid.getMostSignificantBits())).append(Long.toHexString(uuid.getLeastSignificantBits()));

		return sb.toString();
	}

	public String uuidGenWithTimeStamp() {
		final StringBuilder sb = new StringBuilder();
		//sb.append(uuidGen());
		sb.append(String.valueOf(new Date().getTime()));
		return sb.toString();
	}

	public String distanceQueryAsString(Double lat, Double lon, Double distance) {
		StringBuilder lq = new StringBuilder();
		lq.append("withinDistance:[");
		lq.append(Double.toString(lat));
		lq.append(",");
		lq.append(Double.toString(lon));
		lq.append(",");
		lq.append(Double.toString(distance));
		lq.append("]");

		return lq.toString();
	}
	public String nodeIdAsString(Long nodeId) {
		StringBuilder lq = new StringBuilder();
		lq.append("");
		lq.append(Long.toString(nodeId));
		lq.append("");
		return lq.toString();
	}
}
