package com.askus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COMMENT")
public class Comment {

	@Id
    @Column(name="comment_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int comment_id;
     
    private String post_details;
    
    private String post_by;
    
    private String post_date;
    
    private String post_time;
    
    private int parent_id;

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public String getPost_details() {
		return post_details;
	}

	public void setPost_details(String post_details) {
		this.post_details = post_details;
	}

	public String getPost_by() {
		return post_by;
	}

	public void setPost_by(String post_by) {
		this.post_by = post_by;
	}

	public String getPost_date() {
		return post_date;
	}

	public void setPost_date(String post_date) {
		this.post_date = post_date;
	}

	public String getPost_time() {
		return post_time;
	}

	public void setPost_time(String post_time) {
		this.post_time = post_time;
	}

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
    
}
