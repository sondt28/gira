package com.son.gira.role.service;

import com.son.gira.role.dto.GroupRoleDto;
import com.son.gira.role.dto.GroupRoleWithRoleDto;

public interface GroupRoleService {

	GroupRoleDto save(GroupRoleDto dto);
	GroupRoleWithRoleDto addRole(long groupId, long roleId);
	GroupRoleWithRoleDto removeRole(long groupId, long roleId);
}
