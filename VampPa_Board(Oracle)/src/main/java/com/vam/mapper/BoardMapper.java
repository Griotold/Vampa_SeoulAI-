package com.vam.mapper;

import java.util.List;

import com.vam.model.BoardVO;
import com.vam.model.Criteria;

public interface BoardMapper {

	// mybatis를 쓰기 위해서 어떤 함수를 사용할 것인지 약속
	
	/* 글 등록 */
    public void enroll(BoardVO board);
    
    /* 게시글 목록 */
    public List<BoardVO> getList();
    
    /* 게시판 목록(페이징 적용) */
    public List<BoardVO> getListPaging(Criteria cri);
    //방금 정의한 Criteria 클래스를 파라미터로 부여
    
    /* 게시판 조회 */
    public BoardVO getPage(int bno);
    
    /* 게시글 수정 */
    public int modify(BoardVO board);
    
    /* 게시판 삭제 */
    public int delete(int bno);
    //삭제가 성공하면 1, 실패하면 0반환
    
    /* 게시글 총 갯수 */
    public int getTotal();
}
