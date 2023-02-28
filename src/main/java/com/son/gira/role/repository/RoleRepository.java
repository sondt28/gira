package com.son.gira.role.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.son.gira.role.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
