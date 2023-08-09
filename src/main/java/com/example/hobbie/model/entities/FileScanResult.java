package com.example.hobbie.model.entities;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "FileScanResults")
public class FileScanResult {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scan_id;

    private Long result_id;
    private String scan_name;
    private Date scan_time;
    private Date def_time;
    private int scan_result_i;
    private String threat_found;
    private Date created_date;
    private Date updated_date;
    public  FileScanResult() {}
	public Long getScan_id() {
		return scan_id;
	}
	public void setScan_id(Long scan_id) {
		this.scan_id = scan_id;
	}
	public Long getResult_id() {
		return result_id;
	}
	public void setResult_id(Long result_id) {
		this.result_id = result_id;
	}
	public String getScan_name() {
		return scan_name;
	}
	public void setScan_name(String scan_name) {
		this.scan_name = scan_name;
	}
	public Date getScan_time() {
		return scan_time;
	}
	public void setScan_time(Date scan_time) {
		this.scan_time = scan_time;
	}
	public Date getDef_time() {
		return def_time;
	}
	public void setDef_time(Date def_time) {
		this.def_time = def_time;
	}
	public int getScan_result_i() {
		return scan_result_i;
	}
	public void setScan_result_i(int scan_result_i) {
		this.scan_result_i = scan_result_i;
	}
	public String getThreat_found() {
		return threat_found;
	}
	public void setThreat_found(String threat_found) {
		this.threat_found = threat_found;
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
