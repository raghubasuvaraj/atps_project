package com.example.hobbie.service;

import java.util.List;

import com.example.hobbie.model.binding.FileUploadModel;
import com.example.hobbie.model.entities.File_Upload;

public interface FileUploadService {
	FileUploadModel uploadFile(FileUploadModel fileUploadModel);
	List<File_Upload> getAllFiles();
  
}
