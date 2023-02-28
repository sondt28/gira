package com.son.gira.role.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.son.gira.role.model.GroupRole;

@Repository
public interface GroupRoleRepository extends JpaRepository<GroupRole, Long> {

}
