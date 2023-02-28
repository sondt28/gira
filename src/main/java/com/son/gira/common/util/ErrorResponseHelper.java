package com.son.gira.common.util;

import java.util.List;

import org.springframework.validation.BindingResult;

public class ErrorResponseHelper {

	public static List<String> getErrors(BindingResult errors) {
		
		return errors.getAllErrors()
					.stream()
					.map(t -> t.getDefaultMessage())
					.toList();
	}
}
