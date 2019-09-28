package com.practicalneo4j.graphstory.repository;

//import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.Neo4jRepository; //from SDN 4.2


import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.annotation.QueryResult;
//import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.Neo4jRepository; //from SDN 4.2
import org.springframework.data.repository.query.Param;

import com.practicalneo4j.graphstory.domain.User;



import com.practicalneo4j.graphstory.domain.Tag;

public interface TagRepository extends Neo4jRepository<Tag, Long> {

	Tag findByWordPhrase(String wordPhrase);
	
	
	@Query
	("OPTIONAL MATCH (u:Tag {title: {tt}}) RETURN u  IS NULL ")
	boolean findByWordPhraseWiki(@Param("tt")String title);
	
	
	@Query
	(" CREATE (t:Tag {title: {tt}, text:{tx}, creator:{un} })  "
			+ "SET t.nodeId = ID(t) "
			+ "RETURN  t ")
	Tag saveWikiTag(       @Param("tt")String title, 
			               @Param("tx")String text,
			               @Param("un")String avtorName);

}
