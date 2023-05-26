package com.mgnrega.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mgnrega.model.GramPanchayatMember;
import com.mgnrega.model.User;

@Repository
public interface GMPRepository extends JpaRepository<GramPanchayatMember,Integer> {

 public GramPanchayatMember findByIdEmail(String userId);

	
	
}
