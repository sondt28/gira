package com.son.gira.role.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.son.gira.common.exception.GiraAppException;
import com.son.gira.role.dto.GroupRoleDto;
import com.son.gira.role.dto.GroupRoleWithRoleDto;
import com.son.gira.role.mapper.GroupRoleMapper;
import com.son.gira.role.model.GroupRole;
import com.son.gira.role.model.Role;
import com.son.gira.role.repository.GroupRoleRepository;
import com.son.gira.role.repository.RoleRepository;

@Service
public class GroupRoleServiceImpl implements GroupRoleService {

	@Autowired
	private GroupRoleRepository repository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public GroupRoleDto save(GroupRoleDto dto) {
		GroupRole groupRole = GroupRoleMapper.INSTANCE.toModel(dto);
		
		return GroupRoleMapper.INSTANCE.toDto(repository.save(groupRole));
	}

	@Override
	public GroupRoleWithRoleDto addRole(long groupId, long roleId) {
		GroupRole group = repository.findById(groupId)
				.orElseThrow(() -> new GiraAppException("Group not found!"));
		Role role = roleRepository.findById(roleId)
				.orElseThrow(() -> new GiraAppException("Role not found!"));
		group.addRole(role);
		
		return GroupRoleMapper.INSTANCE
							.toGroupRoleWithRoleDto(repository.save(group));
	}

	@Override
	public GroupRoleWithRoleDto removeRole(long groupId, long roleId) {
		GroupRole group = repository.findById(groupId)
				.orElseThrow(() -> new GiraAppException("Group not found!"));
		Role role = roleRepository.findById(roleId)
				.orElseThrow(() -> new GiraAppException("Role not found!"));
		
		if (!group.getRoles().contains(role)) {
			throw new GiraAppException("Role has not contain in this group.");
		}
		group.removeRole(role);
		
		return GroupRoleMapper.INSTANCE
							.toGroupRoleWithRoleDto(repository.save(group));
	}

}
