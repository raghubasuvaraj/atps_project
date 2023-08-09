package com.example.hobbie.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hobbie.model.entities.FileResults;
import com.example.hobbie.model.repostiory.FileResultRepository;
import com.example.hobbie.service.FileResultService;

import java.util.List;

@Service
public class FileResultServiceImpl implements FileResultService{
	@Autowired
    private FileResultRepository resultRepository;

    @Override
    public List<FileResults> getAllResults() {
        return resultRepository.findAll();
    }

    @Override
    public FileResults getResultById(Long id) {
        return resultRepository.findById(id).orElse(null);
    }

    @Override
    public FileResults saveResult(FileResults result) {
        return resultRepository.save(result);
    }

    @Override
    public void deleteResult(Long id) {
        resultRepository.deleteById(id);
    }
}
	
