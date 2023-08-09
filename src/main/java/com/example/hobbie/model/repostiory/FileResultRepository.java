package com.example.hobbie.model.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hobbie.model.entities.FileResults;

public interface FileResultRepository extends JpaRepository<FileResults, Long>  {

}
