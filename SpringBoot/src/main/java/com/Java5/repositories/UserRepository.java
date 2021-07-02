package com.Java5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Java5.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
