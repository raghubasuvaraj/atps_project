package com.example.hobbie.model.entities;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "FileUpload")
public class File_Upload {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long file_id;

    private Long user_id;
    private String file_name;
    private String file_format;
    private Long file_data_id;
    private String file_status;
    private Date created_date;
    private Date updated_date;
    public File_Upload() {
    
    }
	public Long getFile_id() {
		return file_id;
	}
	public void setFile_id(Long file_id) {
		this.file_id = file_id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getFile_format() {
		return file_format;
	}
	public void setFile_format(String file_format) {
		this.file_format = file_format;
	}
	public Long getFile_data_id() {
		return file_data_id;
	}
	public void setFile_data_id(Long file_data_id) {
		this.file_data_id = file_data_id;
	}
	public String getFile_status() {
		return file_status;
	}
	public void setFile_status(String file_status) {
		this.file_status = file_status;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public Date getUpdated_date() {
		return updated_date;
	}
	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}
    

}
