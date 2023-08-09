package com.example.hobbie.model.binding;



import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class FileResultModel {

private Long result_id;

private Long file_id;
private int progress_percentage;
private long file_size;
private String file_type_category;
private String file_type_description;
private String file_type_extension;
private String display_name;
private int total_scan_engine;
private int total_detected_thread;
private String scan_all_result;

@Temporal(TemporalType.TIMESTAMP)
private Date created_date;

@Temporal(TemporalType.TIMESTAMP)
private Date updated_date;

public FileResultModel() {
}

public Long getResult_id() {
	return result_id;
}

public void setResult_id(Long result_id) {
	this.result_id = result_id;
}

public Long getFile_id() {
	return file_id;
}

public void setFile_id(Long file_id) {
	this.file_id = file_id;
}

public int getProgress_percentage() {
	return progress_percentage;
}

public void setProgress_percentage(int progress_percentage) {
	this.progress_percentage = progress_percentage;
}

public long getFile_size() {
	return file_size;
}

public void setFile_size(long file_size) {
	this.file_size = file_size;
}

public String getFile_type_category() {
	return file_type_category;
}

public void setFile_type_category(String file_type_category) {
	this.file_type_category = file_type_category;
}

public String getFile_type_description() {
	return file_type_description;
}

public void setFile_type_description(String file_type_description) {
	this.file_type_description = file_type_description;
}

public String getFile_type_extension() {
	return file_type_extension;
}

public void setFile_type_extension(String file_type_extension) {
	this.file_type_extension = file_type_extension;
}

public String getDisplay_name() {
	return display_name;
}

public void setDisplay_name(String display_name) {
	this.display_name = display_name;
}

public int getTotal_scan_engine() {
	return total_scan_engine;
}

public void setTotal_scan_engine(int total_scan_engine) {
	this.total_scan_engine = total_scan_engine;
}

public int getTotal_detected_thread() {
	return total_detected_thread;
}

public void setTotal_detected_thread(int total_detected_thread) {
	this.total_detected_thread = total_detected_thread;
}

public String getScan_all_result() {
	return scan_all_result;
}

public void setScan_all_result(String scan_all_result) {
	this.scan_all_result = scan_all_result;
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
