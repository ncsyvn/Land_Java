package com.nguyencongsy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nguyencongsy.models.UserRole;

public interface IUserRoleRepository extends JpaRepository<UserRole, String> {
}
