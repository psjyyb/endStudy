package com.yedam.app.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	private BoardMapper boardMapper;
	
	public BoardServiceImpl(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}
	
	@Override
	public List<BoardVO> boardList() {
		return boardMapper.listBoard();
	}
	@Override
	public BoardVO boardInfo(BoardVO boardVO) {
		return boardMapper.infoBoard(boardVO);
	}
}
