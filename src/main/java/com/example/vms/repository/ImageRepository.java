package com.example.vms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vms.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Integer>{

}
