package com.vam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vam.mapper.BoardMapper;
import com.vam.model.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{

	// 속성, setter, constructor
	// 아래는 속성(field)
	// 주입하려고 하는 객체의 타입이 일치하는 객체를 자동으로 주입
	//private BoardMapper = new BoardMapper();와 아래 코드는 동일
	//싱글톤디자인패턴.
	//스프링은 관리하는 객체(빈), 싱글톤디자인패턴으로 관리한다.
	//즉, 1개의 인스턴스가 유지된다.
	//Autowired를 통해서 new 생성자로 호출 없이 그 객체를 사용할 수 있다.
	
	
	@Autowired
	private BoardMapper mapper;
	
	//enroll함수안에서는 BoardMapper의 인스턴스를 사용해야하는데,
	//그 인스턴스를 enroll함수안에서 생성하는 것이 아니라 
	//외부에서 생성된 것을 주입받아서 사용하고 있다.
	//왜 enroll함수안에서 생성해서 사용하지 않고 외부에서 만든 것을 주입받아서 사용하나요?
	//높은 응집도(속성이 비슷한 것 끼리 뭉쳐있다.),
	//낮은 결합도를 위해서(의존성이 줄어든다.).
	//안에서 생성하게 되면, 어떤 생성자를 쓸지, 어떻게 생성할지 등을 
	//enroll을 만드는 개발자가 알아야 한다.
	//그런데, 주입받게 되면 어떻게 만들어졌는지는 관심이 없다.
	//만들어져있는 것을 쓰기만 할거다.
	@Override
	public void enroll(BoardVO board) {
		mapper.enroll(board);
	}
	/* 게시판 목록 */
	@Override
    public List<BoardVO> getList() {
        
        return mapper.getList();
    }
	
	/* 게시판 조회 */
    @Override
    public BoardVO getPage(int bno) {
         
        return mapper.getPage(bno);
    }  
    
    /* 게시판 수정 */
    @Override
    public int modify(BoardVO board) {
        
        return mapper.modify(board);
    }
}
