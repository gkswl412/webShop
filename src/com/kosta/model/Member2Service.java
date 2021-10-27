package com.kosta.model;

public class Member2Service {
	Member2DAO dao = new Member2DAO();
	
	public Member2VO loginCheck(int mid, String mpassword) {
		return dao.loginCheck(mid, mpassword);
	}
}
	
