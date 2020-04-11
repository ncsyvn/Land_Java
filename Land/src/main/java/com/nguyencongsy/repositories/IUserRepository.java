package com.nguyencongsy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nguyencongsy.models.User;

@Repository
public interface IUserRepository extends JpaRepository<User, String> {
}
