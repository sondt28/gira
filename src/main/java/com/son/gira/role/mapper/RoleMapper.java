package com.son.gira.role.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.son.gira.role.dto.RoleDto;
import com.son.gira.role.model.Role;

@Mapper
public interface RoleMapper {

	RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
	
	RoleDto toDto(Role model);
	Role toModel(RoleDto dto);
}
