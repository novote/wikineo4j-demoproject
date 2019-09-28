package com.practicalneo4j.graphstory.service.main;

import java.util.LinkedHashSet;
import java.util.Set;

//import org.apache.log4j.Logger;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.jsoup.Jsoup;
import org.neo4j.helpers.collection.Iterables;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.practicalneo4j.graphstory.domain.Tag;
import com.practicalneo4j.graphstory.domain.User;
// com.practicalneo4j.graphstory.repository.MappedContentTagRepository.MappedContentTag;
import com.practicalneo4j.graphstory.service.GraphStoryService;
import org.springframework.stereotype.Component;
@Component
@Service("tagInterface")
@Scope("prototype")
public class TagImpl extends GraphStoryService implements TagInterface {

	//static Logger log = Logger.getLogger(TagImpl.class);
	private static final Logger log = LogManager.getLogger(TagImpl.class);

	@Override
	public Set<Tag> saveTags(String tagText) {

		Set<Tag> tags = new LinkedHashSet<Tag>();

		tagText = Jsoup.parse(tagText.toLowerCase().trim()).text();
		String[] tagArray = tagText.split(",");
		Tag t;

		for (String tagVal : tagArray) {
			tagVal = tagVal.trim();
			if (!tagVal.isEmpty()) {
				//??? not implemented
				t = tagRepository.findByWordPhrase(tagVal);
				if (t == null) {
					
					//???old 3.0 SDN
					t = tagRepository.save(new Tag(tagVal));
				}
				tags.add(t);
			}
		}

		return tags;
	}

	@Override
	public Tag save(String tag) {

		Tag t = tagRepository.findByWordPhrase(tag);

		if (t !=null ) {
			//SDN must work
			t = tagRepository.save(new Tag(tag));
		}

		return t;
	}
	
	
	public boolean saveWikiTag(Tag wikitag, User avtor){
		 System.out.println("impl  " + wikitag.getTitle().trim());
		 System.out.println("impl trim  "+  wikitag.getTitle().trim());
	
		
		boolean t = tagRepository.findByWordPhraseWiki(wikitag.getTitle().trim());
		 System.out.println("t  "+  t);
		if (t ) {
			//SDN must work
			 System.out.println("t  "+  t +"wikitag.getTitle()"
					 +wikitag.getTitle()+"wikitag.getText()"+wikitag.getText()+"avtor.getUsername()"+avtor.getUsername());
			Tag saveTagWords = tagRepository.saveWikiTag(wikitag.getTitle(), wikitag.getText(),  avtor.getUsername());
			
			 System.out.println("saveTagWords  "+  saveTagWords.getNodeId());
			if(saveTagWords.getNodeId() > 0){ 
				
				return true;
			}
		}

		
		return  false;
	}
	
	
/*
	@Override
	public MappedContentTag[] search(String q) {
		q = q.trim().toLowerCase() + ".*";
		//return Iterables.toArray(MappedContentTag.class, mappedContentTagRepository.search(q));
		return Iterables.asArray(MappedContentTag.class, mappedContentTagRepository.search(q));
	}*/
/*
	@Override
	public GraphStory tagsInMyNetwork(GraphStory graphStory) {
		try {
			graphStory.setTagsInNetwork(Lists.newLinkedList(mappedContentTagRepository.tagsInNetwork(graphStory.getUser().getNodeId())));
			
			graphStory.setUserTags(Lists.newLinkedList(mappedContentTagRepository.userTags(graphStory.getUser().getNodeId())));

		}
		catch (Exception e) {
			log.error(e);
		}

		return graphStory;
	}*/

}
