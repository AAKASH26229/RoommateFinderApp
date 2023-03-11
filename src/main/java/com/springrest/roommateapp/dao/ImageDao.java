package com.springrest.roommateapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.roommateapp.entities.Image;

public interface ImageDao extends JpaRepository<Image, Long> {

}
