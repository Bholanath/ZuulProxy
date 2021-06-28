package com.api.springcloud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.springcloud.security.entity.Role;


public interface RoleRepo extends JpaRepository<Role, Long> {

}
