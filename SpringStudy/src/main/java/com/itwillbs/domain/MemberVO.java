package com.itwillbs.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class MemberVO {
	// MemberDTO(Data Transfer Object)
	// MemberVO(Value Object)
	
	private String userid;
	private String userpw;
	private String username;
	private String useremail;
	private Timestamp regdate;
	private Timestamp updateDate;
	
}
