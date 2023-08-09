package com.example.hobbie.model.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



import lombok.Data;

import java.time.LocalDateTime;

@Entity
public class userRole_atps {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="role_id", nullable=false)
	private Long role_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
    @Column(name="role_name", nullable=false)
    private String role_name;
    private LocalDateTime created_date;
    private LocalDateTime updated_date;
    public userRole_atps() {}
	public Long getRole_id() {
		return role_id;
	}
	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
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
    
}
