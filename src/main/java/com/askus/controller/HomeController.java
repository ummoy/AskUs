package com.askus.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.askus.model.Comment;
import com.askus.model.Ip;
import com.askus.model.Post;
import com.askus.model.Tags;
import com.askus.service.CommentService;
import com.askus.service.IpService;
import com.askus.service.PersonService;
import com.askus.service.PostService;
import com.askus.service.TagsService;

@Controller
public class HomeController {
	private PersonService personService;
	private PostService postService;
	private CommentService commentService;
	private IpService ipService;
	private TagsService tagsService;
	@Autowired(required=true)
    @Qualifier(value="personService")

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	
	@Autowired(required=true)
    @Qualifier(value="postService")
	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	@Autowired(required=true)
    @Qualifier(value="commentService")
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	@Autowired(required=true)
    @Qualifier(value="tagsService")
	public void setTagsService(TagsService tagsService) {
		this.tagsService = tagsService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String Home(Model model) {
		model.addAttribute("listPost", this.postService.showALLPost());
		//System.out.println(this.postService.showALLPost());
        return "index";
    }

	@RequestMapping(value = "/question", method = RequestMethod.GET)
	public String AskUs(Model model) {
		model.addAttribute("post", new Post());
		return "ask";
	}
	@RequestMapping(value = "/post/add/{user_name}", method = RequestMethod.POST)
	public String confirmAskUs(@ModelAttribute("tags") Tags tags,@PathVariable("user_name") String user_name,@ModelAttribute("post") Post p) {
		String s=p.getPost_keywords();
		String[] parts=s.split(", ");
		String[] keywords=s.split(",");
		StringBuffer sb = new StringBuffer();
		for(String split : parts){
			List<Tags> t=this.tagsService.checkTags(split);
			if(t.size()==0) {
				tags.setTags_name(split);
				tags.setTags_count(1);
				this.tagsService.addTags(tags);
			}
			else {
				for(Tags taglist:t) {
					taglist.setTags_count(taglist.getTags_count()+1);
					this.tagsService.updateTags(taglist);
				}
			}
		}
		for(String post_keywords: keywords) {
			sb.append(post_keywords);
		}
		//s=sb.substring(0, sb.length()-3).toString();
		//System.out.println(s);
		p.setPost_keywords(sb.toString());
		Date dNow = new Date( );
	    SimpleDateFormat ft =  new SimpleDateFormat ("E',' MMMM dd',' yyyy 'at' hh:mma");
	    String d=ft.format(dNow).toString();
		p.setPost_by(user_name);
		p.setPost_date(d);
		p.setCat_name("programing");
		p.setPost_votes(0);
		p.setPost_views(0);
		p.setPost_answers(0);
		this.postService.addPost(p);
		return "redirect:/";
	} 
	@RequestMapping(value = "/posts/{post_id}/{post_title}", method = RequestMethod.GET)
	public String ShowPostDetails(@ModelAttribute("ip") Ip addip,@PathVariable("post_id") int post_id,@PathVariable("post_title") String post_title,Model model){
		InetAddress ip=null;
		try {
			ip = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Ip> iplist=this.ipService.getIpByAddress(ip.toString(),post_id);
		//System.out.println("Size:"+iplist.size());
		if(iplist.size() == 0){
			//addip=new Ip();
			addip.setPost_id(post_id);
			addip.setIpaddress(ip.toString());
			this.ipService.addIpAddress(addip);
			List<Post> p=this.postService.getPostById(post_id);
			for(Post post:p ){
				post.setPost_views(post.getPost_views()+1);
				this.postService.updatePost(post);
				break;
			}
			
		}
		model.addAttribute("showpost", this.postService.getPostById(post_id));
		model.addAttribute("showcomment", this.commentService.ShowComment(post_id));
		model.addAttribute("post_id",post_id);
		model.addAttribute("post_title",post_title);
		return "question_details";
	}
	@RequestMapping(value = "/posts/{post_id}/{post_title}/{user_name}", method = RequestMethod.POST)
	public String AddComments(@ModelAttribute("comment") Comment c,@PathVariable("post_id") int post_id,@PathVariable("post_title") String post_title,@PathVariable("user_name") String user_name,Model model){
		Date dNow = new Date( );
	    SimpleDateFormat ft =  new SimpleDateFormat ("E',' MMMM dd',' yyyy 'at' hh:mma");
	    String d=ft.format(dNow).toString();
		c.setPost_by(user_name);
		c.setPost_date(d);
		c.setPost_time("03:47PM");
		c.setParent_id(post_id);
		this.commentService.addComment(c);
		
		List<Post> p=this.postService.getPostById(post_id);
		for(Post post:p ){
			post.setPost_answers(post.getPost_answers()+1);
			//System.out.println("answer:"+post.getPost_answers());
			this.postService.updatePost(post);
			break;
		}
		//this.postService.addPost((Post) p);
		//System.out.println("MYPOST:"+p);
		return "redirect:/posts/{post_id}/{post_title}";
	}
	@RequestMapping(value = "/top", method = RequestMethod.GET)
	public String top(Model model){
		model.addAttribute("listPost", this.postService.showTopPost());
		return "top";
	}
	@RequestMapping(value = "/unanswered", method = RequestMethod.GET)
	public String unanswered(Model model){
		model.addAttribute("listPost", this.postService.showUnanswerPost());
		return "unanswered";
	}
	@RequestMapping(value = "/tags", method = RequestMethod.GET)
	public String tags(Model model){
		model.addAttribute("listtags", this.tagsService.showAllTags());
		return "tags";
	}
	@RequestMapping(value = "posts/{tags}", method = RequestMethod.GET)
	public String detailstags(@PathVariable("tags") String tags,Model model){
		model.addAttribute("listPost", this.postService.getPostByTags(tags));
			return "tagquestions";
	}
	@Autowired(required=true)
    @Qualifier(value="ipService")
	public void setIpService(IpService ipService) {
		this.ipService = ipService;
	}
	
	

}
