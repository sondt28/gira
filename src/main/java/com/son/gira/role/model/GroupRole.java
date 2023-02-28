package com.son.gira.role.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "group_role")
public class GroupRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@ManyToMany
	@JoinTable(name = "role_group_role", 
				joinColumns = @JoinColumn(name = "group_role_id"),
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;
	
	public void addRole(Role role) {
		if (roles == null)
			roles = new ArrayList<>();
		
		roles.add(role);
		role.getGroupRoles().add(this);
	}
	
	public void removeRole(Role role) {
		roles.remove(role);
		role.getGroupRoles().remove(this);
	}
}
