package com.InternSearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.InternSearch.entity.JPUser;

public interface JPUserRepository extends JpaRepository<JPUser, Long> {

	JPUser findByUsernameIgnoreCase(@Param("username") String username);

}