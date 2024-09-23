package com.yedam.app.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.app.board.service.BoardVO;

@Mapper
public interface BoardMapper {

	List<BoardVO> listBoard();
	BoardVO infoBoard(BoardVO boardVO);
}
