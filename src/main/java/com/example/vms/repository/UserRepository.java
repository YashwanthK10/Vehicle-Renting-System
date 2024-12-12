package com.example.vms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vms.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
