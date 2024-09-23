package com.yedam.app.board.service;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	private Date regdate;
	private Date updatedate;
	private String image;
	
}
