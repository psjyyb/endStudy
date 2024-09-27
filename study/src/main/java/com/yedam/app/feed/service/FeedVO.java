package com.yedam.app.feed.service;

import java.util.Date;

import lombok.Data;

@Data
public class FeedVO {
	private int memberNo;
	private int feedNo;
	private String feedContent;
	private String feedHashtag;
	private Date feedWriteDate;
	private Date feedRevisionDate;
}
