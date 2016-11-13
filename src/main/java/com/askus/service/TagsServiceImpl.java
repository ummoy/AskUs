package com.askus.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.askus.dao.TagsDAO;
import com.askus.model.Tags;

public class TagsServiceImpl implements TagsService {
	private TagsDAO tagsDAO;
	@Transactional
	public void addTags(Tags t) {
		this.tagsDAO.addTags(t);
		
	}
	@Transactional
	public List<Tags> showAllTags() {
		// TODO Auto-generated method stub
		return this.tagsDAO.showAllTags();
	}
	@Transactional
	public List<Tags> checkTags(String tags_name) {
		// TODO Auto-generated method stub
		return this.tagsDAO.checkTags(tags_name);
	}
	@Transactional
	public void updateTags(Tags t) {
		this.tagsDAO.updateTags(t);
		
	}
	public void setTagsDAO(TagsDAO tagsDAO) {
		this.tagsDAO = tagsDAO;
	}

}
