package com.InternSearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.InternSearch.entity.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

	Candidate findByUsername(@Param("username") String username);

}
