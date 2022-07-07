package com.vam.model;

import lombok.Data;

@Data
public class Criteria {

	/* 현재 페이지 */
    private int pageNum;
    
    /* 한 페이지 당 보여질 게시물 갯수 */
    private int amount;
    
    /* 검색 키워드 */
    private String keyword;
    
    /* 검색 타입 */
    private String type;
    
    /* 검색 타입 배열 */
    private String[] typeArr;
    
    /* 기본 생성자 -> 기본 세팅 : pageNum = 1, amount = 10 */
    public Criteria() {
        this(1,10);
        //이거 정확히 이해되어야 된다.
        //여기서 this는 이 클래스로 만들어진 인스턴스 그놈
        //this() : 클래스이름에 괄호를 열고닫고 있으니 생성자
        //생성자인데 인자가 2개가 있으니까 밑의 생성자
        //기본 생성자를 호출하면 아래 생성자를 호출하고 있는 것.
        //정리하면, 아무 인자를 전달하지 않은 기본생성자로 객체를 만들경우,
        //1페이지, 한페이지당 10개 게시글 보이기로 만든다.
    }
    
    /* 생성자 => 원하는 pageNum, 원하는 amount */
    public Criteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }
    
    // 롬복으로 게터 세터 toString 메소드 생성
    // 맨위 클래스 선언부 위에 @Data 
    
    //setter는 수정
    public void setType(String type) {
    	this.type = type;
    	this.typeArr = type.split("");
    	//배열로 변환하기 위해서 String 타입의 데이터를 
    	//String 배열 타입 데이터로 변환해주는 
    	//split()메서드를 사용
    	
    }
    
    
}
