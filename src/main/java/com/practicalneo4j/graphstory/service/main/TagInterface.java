package com.practicalneo4j.graphstory.service.main;

import java.util.Set;

import com.practicalneo4j.graphstory.domain.Tag;
import com.practicalneo4j.graphstory.domain.User;
//import com.practicalneo4j.graphstory.repository.MappedContentTagRepository.MappedContentTag;

public interface TagInterface {

	// save tags from content
	public Set<Tag> saveTags(String tagText);

	// save a tag
	public Tag save(String tag);

	// MappedContentTag[] search(String q);

	// count tags in aggregate
	// GraphStory tagsInMyNetwork(GraphStory graphStory);
	
	// save a wikitag
	public boolean saveWikiTag(Tag wikitag  , User avtor);

}
