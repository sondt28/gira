package com.son.gira.role.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.son.gira.common.util.ResponseHelper;
import com.son.gira.role.dto.RoleDto;
import com.son.gira.role.service.RoleService;

@RestController
@RequestMapping("api/v1/role")
public class RoleController {

	@Autowired
	private RoleService service;
	
	@PostMapping
	public Object saveRole(@Valid @RequestBody RoleDto dto, 
							BindingResult result) {
		
		if (result.hasErrors())
			return ResponseHelper.getErrorResponse(result, HttpStatus.BAD_REQUEST);
		
		RoleDto newDto = service.save(dto);
		
		return ResponseHelper.getResponse(newDto, HttpStatus.OK);
	}
}
