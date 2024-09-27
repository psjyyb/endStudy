package com.yedam.app.feed.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.feed.mapper.FeedMapper;
import com.yedam.app.feed.service.FeedService;
import com.yedam.app.feed.service.FeedVO;

@Service
public class FeedServiceImpl implements FeedService{
	
	@Autowired
	private FeedMapper feedMapper;
	
	public FeedServiceImpl(FeedMapper feedMapper) {
		this.feedMapper = feedMapper;
	}
	
	@Override
	public List<FeedVO> feedListSelect() {
		return feedMapper.selectFeedList();
	}
}
