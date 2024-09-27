package com.yedam.app.feed.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.app.feed.service.FeedService;
import com.yedam.app.feed.service.FeedVO;

@Controller
public class FeedController {
	
	@Autowired
	private FeedService feedService;
	
	public FeedController(FeedService feedService) {
		this.feedService = feedService;
	}
	
	@GetMapping("/")
	public String feedList(Model model) {
		List<FeedVO> feedList = feedService.feedListSelect();
		model.addAttribute("feedList", feedList);
		return "feed/mainfeed";
	}
}
