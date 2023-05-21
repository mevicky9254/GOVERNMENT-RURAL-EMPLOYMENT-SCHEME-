package com.mgnrega.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mgnrega.model.GramPanchayatMember;

public interface GMPRepository extends JpaRepository<GramPanchayatMember,Integer> {

	
	
}
