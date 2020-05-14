package com.nguyencongsy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nguyencongsy.models.Role;

public interface IRoleRepository extends JpaRepository<Role, Integer> {
}
