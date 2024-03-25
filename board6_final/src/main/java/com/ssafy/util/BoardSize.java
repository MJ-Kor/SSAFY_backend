package com.ssafy.util;

// enum = 상수 값을 나열할 때 사용
public enum BoardSize {
	
	LIST(20),
	NAVIGATION(10);
	
	private int boardSize;
	private BoardSize(int boardSize) {
		this.boardSize = boardSize;
	};
	
	public int getBoardSize() {
		return boardSize;
	}
	
}
