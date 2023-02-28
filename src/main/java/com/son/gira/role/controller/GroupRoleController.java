package com.son.gira.role.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.son.gira.common.util.ResponseHelper;
import com.son.gira.role.dto.GroupRoleDto;
import com.son.gira.role.dto.GroupRoleWithRoleDto;
import com.son.gira.role.service.GroupRoleService;

@RestController
@RequestMapping("/api/v1/group-roles")
public class GroupRoleController {

	@Autowired
	private GroupRoleService service;
	
	@PostMapping
	public Object saveGroupRole(@Valid @RequestBody GroupRoleDto dto, 
								BindingResult result) {
		if (result.hasErrors())
			return ResponseHelper.getErrorResponse(result, HttpStatus.BAD_REQUEST);
		
		GroupRoleDto newDto = service.save(dto);
		
		return ResponseHelper.getResponse(newDto, HttpStatus.CREATED);
	}
	
	@PutMapping("add-role/{roleId}/{groupId}")
	public Object addRole(@PathVariable("roleId") long roleId, 
							@PathVariable("groupId") long groupId) {
		
		GroupRoleWithRoleDto dto = service.addRole(groupId, roleId);
		
		return ResponseHelper.getResponse(dto, HttpStatus.OK);
	}
	
	@PutMapping("remove-role/{roleId}/{groupId}")
	public Object removeRole(@PathVariable("roleId") long roleId, 
							@PathVariable("groupId") long groupId) {
		
		GroupRoleWithRoleDto dto = service.removeRole(groupId, roleId);
		
		return ResponseHelper.getResponse(dto, HttpStatus.OK);
	}
}
