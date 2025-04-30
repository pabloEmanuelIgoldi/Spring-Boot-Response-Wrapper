package com.respwrapper.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponseDTO<T> {
	
	private boolean success;
    private String message;
    private int code;
    private LocalDateTime timestamp;
    private T data;
}
