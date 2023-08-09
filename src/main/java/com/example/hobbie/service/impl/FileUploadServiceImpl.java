package com.example.hobbie.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hobbie.model.binding.FileUploadModel;
import com.example.hobbie.model.entities.File_Upload;
import com.example.hobbie.model.repostiory.FileUploadRepository;
import com.example.hobbie.service.FileUploadService;

import java.util.List;
@Service
public class FileUploadServiceImpl implements FileUploadService{
	private final FileUploadRepository fileUploadRepository;

    @Autowired
    public FileUploadServiceImpl(FileUploadRepository fileUploadRepository) {
        this.fileUploadRepository = fileUploadRepository;
    }

    @Override
    public FileUploadModel uploadFile(FileUploadModel fileUploadModel) {
        return fileUploadRepository.save(fileUploadModel);
    }

    @Override
    public List<File_Upload> getAllFiles() {
        return fileUploadRepository.findAll();
    }
    
    // Implement other service methods as needed
}

