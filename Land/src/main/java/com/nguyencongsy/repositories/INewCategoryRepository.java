package com.nguyencongsy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nguyencongsy.models.NewCategory;

@Repository
public interface INewCategoryRepository extends JpaRepository<NewCategory, String> {
}
