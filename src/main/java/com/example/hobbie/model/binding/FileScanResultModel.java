package com.example.hobbie.model.binding;

import java.util.Date;

public class FileScanResultModel {
	
    private Long id;

    private Long scanId;
    private Long resultId;
    private String scanName;
    private Date scanTime;
    private Date defTime;
    private int scanResultI;
    private String threatFound;
    private Date createdDate;
    private Date updatedDate;
	public FileScanResultModel() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getScanId() {
		return scanId;
	}
	public void setScanId(Long scanId) {
		this.scanId = scanId;
	}
	public Long getResultId() {
		return resultId;
	}
	public void setResultId(Long resultId) {
		this.resultId = resultId;
	}
	public String getScanName() {
		return scanName;
	}
	public void setScanName(String scanName) {
		this.scanName = scanName;
	}
	public Date getScanTime() {
		return scanTime;
	}
	public void setScanTime(Date scanTime) {
		this.scanTime = scanTime;
	}
	public Date getDefTime() {
		return defTime;
	}
	public void setDefTime(Date defTime) {
		this.defTime = defTime;
	}
	public int getScanResultI() {
		return scanResultI;
	}
	public void setScanResultI(int scanResultI) {
		this.scanResultI = scanResultI;
	}
	public String getThreatFound() {
		return threatFound;
	}
	public void setThreatFound(String threatFound) {
		this.threatFound = threatFound;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
    
}
