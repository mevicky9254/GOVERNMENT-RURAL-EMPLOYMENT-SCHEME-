package com.gres.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MyError {

	private LocalDateTime timeStamp;
	
	private String message;
	
	private String desc;
	
}
