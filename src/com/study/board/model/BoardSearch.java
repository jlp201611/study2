package com.study.board.model;

import com.study.common.vo.PagingVo;

//페이징이 필요한 경우 거의 Search가 있다
public class BoardSearch extends PagingVo{ // PagingVo 상속
	
	// 업무화면(검색)의 검색어와 관련된.......
	private String searchWord = "";
	private String searchType = "";
	
	
	//겟터 셋터
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

}
