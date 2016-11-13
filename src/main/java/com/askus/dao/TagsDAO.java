package com.askus.dao;

import java.util.List;

import com.askus.model.Tags;


public interface TagsDAO {
	public void addTags(Tags t);
	public List<Tags> showAllTags();
	public List<Tags> checkTags(String tags_name);
	public void updateTags(Tags t);
	
}
