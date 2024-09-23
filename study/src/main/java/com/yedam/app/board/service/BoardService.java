package com.yedam.app.board.service;

import java.util.List;

public interface BoardService {

	List<BoardVO> boardList();
	BoardVO boardInfo(BoardVO boardVO);
}
