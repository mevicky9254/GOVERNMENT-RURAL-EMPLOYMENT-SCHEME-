package com.gres.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gres.model.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker,Integer> {

	@Query("SELECT W from Worker W WHERE W.adhar=?1")
	public Worker findByAdhar(String adhar);

	
}
