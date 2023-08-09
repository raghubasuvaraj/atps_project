package com.example.hobbie.model.binding;
import javax.persistence.*;
import java.util.Date;
public class FileUploadModel {
	 private Long user_id;
	    private String file_name;
	    private String file_format;
	    private Long file_data_id;
	    private String file_status;
		public FileUploadModel() {
			
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
	    

}
