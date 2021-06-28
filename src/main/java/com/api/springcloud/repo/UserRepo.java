package com.api.springcloud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.springcloud.security.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
