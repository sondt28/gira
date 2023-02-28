package com.son.gira.role.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupRoleWithRoleDto {

	private long id;
	private String name;
	private String description;
	private List<RoleDto> roles;
}
