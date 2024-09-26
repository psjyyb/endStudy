package com.yedam.app.board.service;

import java.util.List;
import java.util.Map;

public interface BoardService {

	List<BoardVO> boardList();
	BoardVO boardInfo(BoardVO boardVO);
	Map<String, Object> boardDelete(BoardVO boardVO);
}
