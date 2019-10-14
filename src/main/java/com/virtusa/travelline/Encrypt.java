package com.virtusa.travelline;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encrypt {

	public String encrypt(String password)
	{
		return new BCryptPasswordEncoder().encode(password);
	}
}
