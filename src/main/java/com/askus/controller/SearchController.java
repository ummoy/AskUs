package com.askus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.askus.model.Post;
import com.askus.service.PostService;

@Controller
public class SearchController {
	private PostService postService;
	@Autowired(required=true)
    @Qualifier(value="postService")
	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String AskUs(@ModelAttribute("post") Post p,Model model) {
		String post_keywords=p.getPost_keywords();
		model.addAttribute("listPost", this.postService.getSearchPost(post_keywords));
		return "search";
	}

}
