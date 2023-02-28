package com.son.gira.common.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public class ResponseHelper {

	public static Object getResponse(Object obj, HttpStatus status) {
		Map<String, Object> map = new HashMap<>();
		map.put("status", "ok");
		map.put("content", obj);
		
		return new ResponseEntity<>(map, status);
	}
	
	public static Object getErrorResponse(BindingResult result, HttpStatus status) {
		Map<String, Object> map = new HashMap<>();
		map.put("status", "error");
		map.put("errors", ErrorResponseHelper.getErrors(result));
		
		return new ResponseEntity<>(map, status);
	}
}
