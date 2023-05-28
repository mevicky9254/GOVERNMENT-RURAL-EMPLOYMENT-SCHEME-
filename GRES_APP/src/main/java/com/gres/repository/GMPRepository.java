package com.gres.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gres.model.GramPanchayatMember;
import com.gres.model.User;

@Repository
public interface GMPRepository extends JpaRepository<GramPanchayatMember,Integer> {

 public GramPanchayatMember findByEmail(String userId);

	
	
}
