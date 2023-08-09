package com.example.hobbie.model.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hobbie.model.entities.FileScanResult;

public interface  FileScanResultRepository extends JpaRepository<FileScanResult, Long>  {

}
