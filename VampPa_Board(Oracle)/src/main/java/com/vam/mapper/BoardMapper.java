package com.vam.mapper;

import com.vam.model.BoardVO;

public interface BoardMapper {

	// mybatis를 쓰기 위해서 어떤 함수를 사용할 것인지 약속
	
	/* 글 등록 */
    public void enroll(BoardVO board);
}
