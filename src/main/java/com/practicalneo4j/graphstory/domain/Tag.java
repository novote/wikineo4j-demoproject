package com.practicalneo4j.graphstory.domain;

import org.springframework.data.annotation.Transient;
import org.springframework.data.annotation.TypeAlias;
//import org.springframework.data.neo4j.annotation.GraphId;
//import org.springframework.data.neo4j.annotation.Indexed;
//import org.springframework.data.neo4j.annotation.NodeEntity;

import org.neo4j.ogm.annotation.NodeEntity;

import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;

@NodeEntity
@TypeAlias("Tag")
public class Tag extends Entity{
	
	
	//@GraphId
	private Long nodeId;

	//@Indexed(unique = true)
	private String wordPhrase;

	@Transient
	private Integer tagCount;  //chislo raz ispolzovano  polzovayelymi
	
	private String text;
	
	private String title;
	
	private String creator;
	
	private  Set<String> links;  ///???  url vneshie  url wiki page
	
	//The OGM requires an public no-args constructor
	public Tag() {

			}

		public Tag(String wordPhrase) {
			this.setWordPhrase(wordPhrase);
		}


	public Long getNodeId() {
		return nodeId;
	}

	public void setNodeId(Long nodeId) {
		this.nodeId = nodeId;
	}

	public String getWordPhrase() {
		return wordPhrase;
	}

	public void setWordPhrase(String wordPhrase) {
		this.wordPhrase = wordPhrase;
	}

	public Integer getTagCount() {
		return tagCount;
	}

	public void setTagCount(Integer tagCount) {
		this.tagCount = tagCount;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<String> getLinks() {
		return links;
	}

	public void setLinks(Set<String> links) {
		this.links = links;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	
	
	
}
