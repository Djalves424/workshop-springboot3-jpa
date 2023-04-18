package com.educandoweb.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.demo.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
