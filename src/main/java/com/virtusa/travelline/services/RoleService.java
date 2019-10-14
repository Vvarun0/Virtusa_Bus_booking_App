package com.virtusa.travelline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.travelline.models.Role;
import com.virtusa.travelline.repositories.RoleRepository;

@Service
public class RoleService {
	@Autowired
	private RoleRepository roleRepository;
	public List<Role> getUserRoleByName(String userName)
	{
		return roleRepository.getUserRolesByName(userName);
	}
	
	public List<Role> getAllUserRole() {
		return roleRepository.findAll();
	}

	public Role getUserRoleById(int roleId) {
		return roleRepository.findById(roleId).orElse(null);
	}

	public Role addUserRole(Role role) {
		return roleRepository.save(role);
	}

	public boolean deleteUserRole(int roleId) {
		boolean status = false;
		roleRepository.deleteById(roleId);
		status = true;
		return status;
	}

	public Role updateUserRole(Role userRole) {
		return roleRepository.save(userRole);
	}
}