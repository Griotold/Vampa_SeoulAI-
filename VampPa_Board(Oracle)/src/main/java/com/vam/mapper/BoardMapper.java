package com.vam.mapper;

import java.util.List;

import com.vam.model.BoardVO;

public interface BoardMapper {

	// mybatis를 쓰기 위해서 어떤 함수를 사용할 것인지 약속
	
	/* 글 등록 */
    public void enroll(BoardVO board);
    
    /* 게시글 목록 */
    public List<BoardVO> getList();
    
    /* 게시판 조회 */
    public BoardVO getPage(int bno);
    
    /* 게시글 수정 */
    public int modify(BoardVO board);
}
