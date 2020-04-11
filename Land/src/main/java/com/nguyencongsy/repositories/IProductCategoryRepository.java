package com.nguyencongsy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nguyencongsy.models.ProductCategory;

@Repository
public interface IProductCategoryRepository extends JpaRepository<ProductCategory, String> {
}
