package com.example.healthcare.healthcare.repository;

import com.example.healthcare.healthcare.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {


    UserEntity findByUsername(String username);
    List<UserEntity> findByRole(String role);
    List<UserEntity> findByExpertise(String expertise);
    List<UserEntity> findByName(String name);




}
