package com.son.gira.role.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDto {
	private long id;
	
	@NotBlank(message = "Name must not be blank")
	private String name;
	
	private String description;
}
