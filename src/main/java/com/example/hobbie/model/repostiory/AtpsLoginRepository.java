package com.example.hobbie.model.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hobbie.model.entities.AtpsLoginEntity;

public interface AtpsLoginRepository extends JpaRepository<AtpsLoginEntity, Long> {

	AtpsLoginEntity findByUsername(String username);
 

}
