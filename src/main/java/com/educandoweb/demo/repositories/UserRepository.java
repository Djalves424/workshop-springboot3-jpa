package com.educandoweb.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
