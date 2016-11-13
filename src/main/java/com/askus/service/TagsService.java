package com.askus.service;

import java.util.List;

import com.askus.model.Tags;

public interface TagsService {
	public void addTags(Tags t);
	public List<Tags> showAllTags();
	public List<Tags> checkTags(String tags_name);
	public void updateTags(Tags t);

}
