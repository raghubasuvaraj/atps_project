package com.example.hobbie.model.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hobbie.model.entities.Users;

@Repository

public interface UserRepositoryAtps extends JpaRepository<Users, Long> {

}
