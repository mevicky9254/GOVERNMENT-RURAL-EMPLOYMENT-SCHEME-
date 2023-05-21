package com.mgnrega.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mgnrega.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}
