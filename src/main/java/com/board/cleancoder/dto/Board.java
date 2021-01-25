package com.board.cleancoder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {
	private long bno;
	private long uno;
	private String writer;
	private String title;
	private String content;
	private String regdate;
	private String updatedate;
	private long hit;
}
