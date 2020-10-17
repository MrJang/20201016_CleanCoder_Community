package com.board.cleancoder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	private long uno;
	private String id;
	private String pw;
	private String name;
	private String usertype;
}
