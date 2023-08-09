package com.example.hobbie.service;

import java.util.List;

import com.example.hobbie.model.entities.FileResults;

public interface FileResultService {
	 List<FileResults> getAllResults();
	 FileResults getResultById(Long id);
	 FileResults saveResult(FileResults result);
	    void deleteResult(Long id);
}
