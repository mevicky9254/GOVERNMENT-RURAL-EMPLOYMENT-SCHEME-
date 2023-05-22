package com.mgnrega.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mgnrega.model.BlockDevelopmentOfficer;

@Repository
public interface BDORepository extends JpaRepository<BlockDevelopmentOfficer ,Integer> {

	
	
}
