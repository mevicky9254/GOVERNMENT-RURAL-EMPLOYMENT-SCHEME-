package com.mgnrega.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mgnrega.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
