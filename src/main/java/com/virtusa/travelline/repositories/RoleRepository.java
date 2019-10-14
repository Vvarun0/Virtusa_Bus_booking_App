package com.virtusa.travelline.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.virtusa.travelline.models.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	//custom jpa method
		@Query("SELECT ur FROM Role ur WHERE ur.user.email = :name")
		List<Role> getUserRolesByName(@Param("name") String name);
}
