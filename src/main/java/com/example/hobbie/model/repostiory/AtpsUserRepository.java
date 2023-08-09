package com.example.hobbie.model.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hobbie.model.binding.AtpsSignupModel;
import com.example.hobbie.model.entities.AtpsUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository


public interface AtpsUserRepository extends JpaRepository<AtpsUserEntity, Long> {
    // Custom query methods can be added here if needed
	 AtpsUserEntity findByUsername(String username);
}


