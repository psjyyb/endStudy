package com.yedam.app.board.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
	@PostMapping("/boardDelete")
	@ResponseBody
	public Map<String, Object> boardDelete(BoardVO boardVO) {
		return boardService.boardDelete(boardVO);
	}
	@GetMapping("/boardInsert")
	public String boardInsert () {
		return "board/boardInsert";
	}
	@PostMapping("/boardInsert")
	@ResponseBody
	public Map<String, Object> boardInsert(BoardVO boardVO,@RequestPart(value = "imagesFile", required = false) MultipartFile[] imagesFile){
		System.out.println(boardVO);
		for(MultipartFile imageFile : imagesFile) {
			System.out.println(imageFile);
		}
		return null;
	}
	

}
