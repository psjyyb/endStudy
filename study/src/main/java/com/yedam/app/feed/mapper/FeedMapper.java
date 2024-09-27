package com.yedam.app.feed.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.app.feed.service.FeedVO;

@Mapper
public interface FeedMapper {
	List<FeedVO> selectFeedList();
}
