package com.virtusa.travelline.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.travelline.models.User;

@Service("userDetailsService")
public class UserLoginServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userservice;

	@Autowired
	private RoleService roleService;

	@Transactional(readOnly = true)

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("UserName=" + username);

		User user = this.userservice.getUserById(username);

		UserBuilder builder = null;
		if (user != null) {

			builder = org.springframework.security.core.userdetails.User.withUsername(username);

			builder.disabled(false);

			builder.password(user.getPassword());
			String[] authorities = this.roleService.getUserRoleByName(username).stream()
					.map(a -> a.getRoleName()).toArray(String[]::new);
//this.userRoleService.getUserRoleByName(username).stream().map(a -> a.getRole()).toArray(String[]::new);

			builder.authorities(authorities);
		} else {
			throw new UsernameNotFoundException("User not found.");
		}
		return builder.build();

	}

}
