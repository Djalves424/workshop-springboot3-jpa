package com.educandoweb.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.demo.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
