package com.askus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TAGS")
public class Tags {
	@Id
    @Column(name="tags_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int tags_id;
	private String tags_name;
	private int tags_count;
	public int getTags_id() {
		return tags_id;
	}
	public void setTags_id(int tags_id) {
		this.tags_id = tags_id;
	}
	public String getTags_name() {
		return tags_name;
	}
	public void setTags_name(String tags_name) {
		this.tags_name = tags_name;
	}
	public int getTags_count() {
		return tags_count;
	}
	public void setTags_count(int tags_count) {
		this.tags_count = tags_count;
	}

}
