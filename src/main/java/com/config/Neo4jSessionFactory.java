package com.config;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.stereotype.Service;

//@Component
@Service
public class Neo4jSessionFactory {

	@Autowired
	private final static SessionFactory sessionFactory = new SessionFactory("com.practicalneo4j.graphstory.domain");
	
	private static Neo4jSessionFactory factory = new Neo4jSessionFactory();

	public static Neo4jSessionFactory getInstance() {
		return factory;
	}

	private Neo4jSessionFactory() {
	}

	public Session getNeo4jSession() {
		//return sessionFactory.openSession("http://localhost:7474");
		return sessionFactory.openSession();
	}
}
/**/