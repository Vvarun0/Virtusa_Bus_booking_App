package com.virtusa.travelline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.travelline.models.User;

public interface UserRepository extends JpaRepository<User, String>{

}
