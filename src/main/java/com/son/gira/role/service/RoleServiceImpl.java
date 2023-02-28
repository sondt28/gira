package com.son.gira.role.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.son.gira.role.dto.RoleDto;
import com.son.gira.role.mapper.RoleMapper;
import com.son.gira.role.model.Role;
import com.son.gira.role.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository repository;

	@Override
	public RoleDto save(RoleDto dto) {
		Role role = RoleMapper.INSTANCE.toModel(dto);
		
		return RoleMapper.INSTANCE.toDto(repository.save(role));
	}
}
