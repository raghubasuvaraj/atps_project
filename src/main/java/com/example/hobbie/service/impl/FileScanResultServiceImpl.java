package com.example.hobbie.service.impl;

import com.example.hobbie.model.entities.FileScanResult;
import com.example.hobbie.model.repostiory.FileScanResultRepository;
import com.example.hobbie.service.FileScanResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileScanResultServiceImpl implements FileScanResultService {
	private final FileScanResultRepository fileScanResultRepository;

    @Autowired
    public FileScanResultServiceImpl(FileScanResultRepository fileScanResultRepository) {
        this.fileScanResultRepository = fileScanResultRepository;
    }

    @Override
    public List<FileScanResult> getAllFileScanResults() {
        return fileScanResultRepository.findAll();
    }
}

