package com.nguyencongsy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nguyencongsy.models.New;

@Repository
public interface INewRepository extends JpaRepository<New, String> {
}
