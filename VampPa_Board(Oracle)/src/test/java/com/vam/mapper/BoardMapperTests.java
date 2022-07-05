package com.vam.mapper;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vam.model.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTests {
 
     private static final Logger log = LoggerFactory.getLogger(BoardMapperTests.class);
     
     @Autowired
     private BoardMapper mapper;
 
     @Test
     public void testEnroll() {
         
         BoardVO vo = new BoardVO();
         
         vo.setTitle("mapper test");
         vo.setContent("mapper test");
         vo.setWriter("mapper test");
         
         mapper.enroll(vo);
         
     }
     
     /* 게시판 목록 테스트 */
     @Test
     public void testGetList() {
         
         
         List list = mapper.getList();
         
         
        /* 일반적 for문
         for(int i = 0; i< list.size();i++) {
         	log.info("" + list.get(i));
         }*/ 
         
        /* foreach문(향상된 for문) */
         for(Object a : list) {
             log.info("" + a);
         }
         
         /* foreach문 & 람다식 
          list.forEach(board -> log.info("" + board));
          * */
         
     }
     
     /* 게시판 조회 */
     @Test
    public void testGetPage() {
        
        /* 실제 존재하는 페이지 */
        int bno = 8;
        
        log.info("" + mapper.getPage(bno));
        
    }
     
     /* 게시글 수정 */
     @Test
     public void testModify() {
    	 //프로세스가 3단계 
    	 //준비, 실행, 리턴활용
    	 //1. 이미 있는 데이터를 준비
    	 //DB에 존재하는 bno를 where로 걸어야 한다.
    	 BoardVO board = new BoardVO();
    	 board.setBno(8);
    	 //2. 그 데이터를 다른 데이터로 변경
    	 board.setTitle("junit에서 바꾼 제목");
    	 board.setContent("junit에서 바꾼 내용");
    	 
    	 int result = mapper.modify(board);
    	 //3. 변경된 결과 활용
    	 log.info("junit수정결과 : "+result);
    	 
    	 
    	 
    	 
    	 
    	 
     }
 
}
