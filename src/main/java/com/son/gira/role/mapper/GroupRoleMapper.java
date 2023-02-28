package com.son.gira.role.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.son.gira.role.dto.GroupRoleDto;
import com.son.gira.role.dto.GroupRoleWithRoleDto;
import com.son.gira.role.model.GroupRole;

@Mapper
public interface GroupRoleMapper {

	GroupRoleMapper INSTANCE = Mappers.getMapper(GroupRoleMapper.class);
	
	GroupRoleDto toDto(GroupRole model);
	GroupRole toModel(GroupRoleDto dto);
	GroupRoleWithRoleDto toGroupRoleWithRoleDto(GroupRole model);
}
