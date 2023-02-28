package com.son.gira.role.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupRoleDto {
	private long id;
	
	@NotBlank(message = "Group role name must not be blank")
	private String name;
	private String description;
}
