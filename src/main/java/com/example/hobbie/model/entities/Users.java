package com.example.hobbie.model.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users_atps")
public class Users {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id", nullable=false)
    private Long user_id;
	@Column(name="user_name", nullable=false)
    private String user_name;
	@Column(name="user_email", nullable=false)
    private String user_email;
	@Column(name="user_password", nullable=false)
    private String user_password;
	
    private LocalDateTime created_date;
    private LocalDateTime updated_date;
    @OneToMany(mappedBy = "user")
    private List<userRole_atps> roles;
    public Users()
    {}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public LocalDateTime getCreated_date() {
		return created_date;
	}
	public void setCreated_date(LocalDateTime created_date) {
		this.created_date = created_date;
	}
	public LocalDateTime getUpdated_date() {
		return updated_date;
	}
	public void setUpdated_date(LocalDateTime updated_date) {
		this.updated_date = updated_date;
	}
	public List<userRole_atps> getRoles() {
		return roles;
	}
	public void setRoles(List<userRole_atps> roles) {
		this.roles = roles;
	}
}
