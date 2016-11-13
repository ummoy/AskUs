package com.askus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="POST")
public class Post {
		@Id
	    @Column(name="post_id")
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private int post_id;
	     
	    private String post_title;
	    
	    private String post_details;
	    
	    private String post_keywords;
	    
	    private String post_by;
	    
	    private String post_date;
	    
	    private String cat_name;
	    
	    private int post_views;
	    
	    private int post_votes;
	    
	    private int post_answers;

		public int getPost_id() {
			return post_id;
		}

		public void setPost_id(int post_id) {
			this.post_id = post_id;
		}

		public String getPost_title() {
			return post_title;
		}

		public void setPost_title(String post_title) {
			this.post_title = post_title;
		}

		public String getPost_details() {
			return post_details;
		}

		public void setPost_details(String post_details) {
			this.post_details = post_details;
		}

		public String getPost_keywords() {
			return post_keywords;
		}

		public void setPost_keywords(String post_keywords) {
			this.post_keywords = post_keywords;
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

		public String getCat_name() {
			return cat_name;
		}

		public void setCat_name(String cat_name) {
			this.cat_name = cat_name;
		}

		public int getPost_views() {
			return post_views;
		}

		public void setPost_views(int post_views) {
			this.post_views = post_views;
		}

		public int getPost_votes() {
			return post_votes;
		}

		public void setPost_votes(int post_votes) {
			this.post_votes = post_votes;
		}
		  
	    @Override
	    public String toString(){
	        return "id="+post_id+", title="+post_title+", details="+post_details+", keyword="+post_keywords+", post_by="+post_by+", date="+post_date+",catagory="+cat_name+", view="+post_views+", votes="+post_votes;
	    }

		public int getPost_answers() {
			return post_answers;
		}

		public void setPost_answers(int post_answers) {
			this.post_answers = post_answers;
		}	
 
	    
	   
}
