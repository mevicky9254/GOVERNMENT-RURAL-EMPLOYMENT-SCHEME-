package com.gres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gres.model.BlockDevelopmentOfficer;

@Repository
public interface BDORepository extends JpaRepository<BlockDevelopmentOfficer ,Integer> {

	public BlockDevelopmentOfficer findByEmail(String userId);

	
	
}
