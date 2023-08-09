package com.example.hobbie.model.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hobbie.model.binding.FileUploadModel;
import com.example.hobbie.model.entities.File_Upload;

public interface FileUploadRepository extends JpaRepository<File_Upload, Long> {

	FileUploadModel save(FileUploadModel fileUploadModel);



}
