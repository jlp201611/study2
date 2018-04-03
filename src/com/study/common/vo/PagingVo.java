package com.study.common.vo;


//Vo로 공통적으로 활용
public class PagingVo {
	private int totalRowCount; 	//총 레코드 갯수 //DAO로 연결해서 DB에 서 정보를 갖어와야함 
	private int totalPageCount; // 총 페이지 갯수
	private int listSize;		// 한 페이지당 레코드 갯수
	private int startRow; 		// (페이지)시작 로우
	private int endRow; 		// (페이지) 마지막 로우
	private int currentPage;	// 현재 페이지
	//쪼금 안좋은점은.....맴버필드는 낙타식이고 페이지 변수들은 낙타식이 아니라 헷갈릴수도 있다
	
	//버튼관련
	private int startPage;
	private int endPage;
	private int pageSize;
	
	//초기화할 메서드
	public void setting(int rowCount) { // 생성자로 해도 되고 메서드로 해도 되고 자기 마음대로.....캬캬캬캬캬
		totalRowCount = rowCount;
		
		//초기화...ㅎㅎㅎ
		if(currentPage < 1) currentPage = 1;
		if(listSize < 1) listSize = 10;
		if(pageSize < 1) pageSize = 10;
				
		totalPageCount = (totalRowCount -1) / listSize +1 ; //
		startRow = ((currentPage-1) * listSize)+1; // 오라클 1부터 시작 // mySql은 0부터라서 +1삭제해야함
		endRow = currentPage * listSize;
		
		/**
		 * 쌤이해준것!!
		 */
		startPage = ((currentPage-1) / pageSize) * pageSize +1;
		endPage = startPage + pageSize -1;
		if(endPage > totalPageCount) endPage = totalPageCount;
		
		System.out.println(totalRowCount+" : "+totalPageCount+" : "+ listSize+" : "+startRow+" : "+endRow+" : "+currentPage	);
		
/*나의 뻘짓들ㅋㅋㅋㅋㅋㅋ
 * 					//버튼관련 초기화
					if(pageSize < 1) pageSize = 10;
					startPage = ((currentPage/pageSize) * pageSize)+1;
					endPage = startPage+pageSize-1;
					
					System.out.println("startPage나머지 : " + startPage % pageSize );
					
					//페이지 마지막에 갔을때
					if(currentPage >= totalPageCount ) {
						endPage = totalPageCount;
						startPage = startPage -pageSize;
					}
					
					//스타트가 
					System.out.println("스타트 나머지 : "+startPage % pageSize);
					if(startPage % pageSize != 0 || startPage < pageSize ) {
						startPage = startPage - pageSize;
						endPage = endPage-pageSize;
					}
					if(endPage == currentPage) {
						startPage = startPage + pageSize;
						endPage = endPage+pageSize;			
					}
					System.out.println("end : "+endPage % pageSize );
					
					//현재 페이지 -값 되면
					if(startPage < 0) startPage = 1;
					if(endPage == 0) endPage = pageSize;
					if(currentPage == totalPageCount) currentPage = totalPageCount;
					System.out.println("startPage : " + startPage);
					System.out.println("endPage : "+endPage);*/
		
	}//setting end

	
	//겟터 셋터ㅋㅋ
	public int getTotalRowCount() {
		return totalRowCount;
	}

	public void setTotalRowCount(int totalRowCount) {
		this.totalRowCount = totalRowCount;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public int getStartPage() {
		return startPage;
	}


	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}


	public int getEndPage() {
		return endPage;
	}


	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
	
}
