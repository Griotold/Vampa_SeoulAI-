package com.vam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vam.model.BoardVO;
import com.vam.model.Criteria;
import com.vam.model.PageMakerDTO;
import com.vam.service.BoardService;

@Controller
@RequestMapping("/board/*") //매칭을 요청 //board 뒤에 어떤 요청을 하더라도
public class BoardController {

	 private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	 
	 @Autowired
	 private BoardService bservice;
	 
	 /* 게시판 목록 페이지 접속(페이징 적용) */
	 @GetMapping("/list")
	 public String boardListGET(Model model, Criteria cri) {
		 log.info("게시판 목록 페이지 진입");
		 //사실 return "list";를 실행중이다.
		 //왜 String과 void 리턴타입이 같게 나올까?
		 //servlet-context.xml파일에서
		 //view.resolver가 앞에는 "/WEB-INF/views/"
		 //뒤에는 ".jsp" />를 자동으로 붙여주면서 화면에 전달해주기 때문에
		 
		 model.addAttribute("list", bservice.getListPaging(cri));
		 
		 int total = bservice.getTotal(cri);
		 
		 PageMakerDTO pageMake = new PageMakerDTO(cri, total);
	        
	     model.addAttribute("pageMaker", pageMake); //화면에 전달
		 
		 return "board/list";
	 }
	 
	 
	 
	 @GetMapping("/enroll")
	 public void boardEnrollGET() {
		 log.info("게시판 등록 페이지 진입");
	 }
	 
	 @GetMapping("/custom")
	 public void boardCustomGET() {
		 log.info("커스텀 페이지 진입");
	 }
	 
	 /* 게시판 등록 */
    @PostMapping("/enroll")
    public String boardEnrollPOST(BoardVO board, RedirectAttributes rttr) {
        
        log.info("BoardVO : " + board);
                
        bservice.enroll(board);
        rttr.addFlashAttribute("result", "enroll success");
        return "redirect:/board/list"; //
    }

    /* 게시판 상세조회 */
    /* GET요청은 페이지이동이 거듭되는동안 이전 페이지들의 요청정보
     * 를 기억하고 있어야 한다.
     * URL에 파라미터가 누적되어 전달되는데 이런 기법을
     * URL Rewrite처리라고 한다.*/
    @GetMapping("/get")
    public void boardGetPageGET(int bno, Model model, Criteria cri) {
    	//value 객체 : bservice.getPage(bno)를
    	//"pageInfo"에 추가한다.
    	//View에서는 name으로 지정한 "pageInfo"를 통해서 value 객체를 사용한다.
        model.addAttribute("pageInfo", bservice.getPage(bno));
        //마찬가지로 cri라는 value객체를 
        //"cri"에 추가한다.
        //view에서 "cri"를 통해서 value 객체를 사용한다.
        model.addAttribute("cri", cri);
        
    }
    
    /* 수정 페이지 이동 */
    @GetMapping("/modify")
    public void boardModifyGET(int bno, Model model, Criteria cri) {
    	//value 객체 : bservice.getPage(bno)를
    	//"pageInfo"에 추가한다.
    	//View에서는 name으로 지정한 "pageInfo"를 통해서 value 객체를 사용한다.
        model.addAttribute("pageInfo", bservice.getPage(bno));
        //마찬가지로 cri라는 value객체를 
        //"cri"에 추가한다.
        //view에서 "cri"를 통해서 value 객체를 사용한다.
        model.addAttribute("cri", cri);
        
    }
    /* 페이지 수정 */
    @PostMapping("/modify")
    public String boardModifyPOST(BoardVO board, RedirectAttributes rttr) {
        
        bservice.modify(board);
        
        rttr.addFlashAttribute("result", "modify success");
        
        return "redirect:/board/list";
        
    }
    
    /* 페이지 삭제 */
    @PostMapping("/delete")
    public String boardDeletePOST(int bno, RedirectAttributes rttr) {
        
        bservice.delete(bno);
        
        rttr.addFlashAttribute("result", "delete success");
        
        return "redirect:/board/list";
    }

}
