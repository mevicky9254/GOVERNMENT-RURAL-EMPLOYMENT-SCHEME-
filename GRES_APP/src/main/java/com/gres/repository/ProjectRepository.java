package com.gres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gres.model.Project;


@Repository
public interface ProjectRepository extends JpaRepository<Project,Integer>{

}
