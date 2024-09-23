package com.yedam.app.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;

	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}

	@GetMapping("/")
	public String boardList(Model model) {
		List<BoardVO> boardList = boardService.boardList();
		model.addAttribute("boardList",boardList);
		return "board/boardList";
	}
	@GetMapping("/boardInfo")
	public String boardInfo(Model model, BoardVO boardVO) {
		BoardVO boardInfo = boardService.boardInfo(boardVO);
		model.addAttribute("boardInfo", boardInfo);
		return "board/boardInfo";
	}
	

}
