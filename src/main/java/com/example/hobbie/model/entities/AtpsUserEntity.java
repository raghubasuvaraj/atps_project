package com.example.hobbie.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.hobbie.model.entities.enums.AtpsUserRoleEnum;

import lombok.Data;
//@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Atpsusers")
public class AtpsUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private Long id;
	private String username;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private AtpsUserRoleEnum user_roles;
	
	public AtpsUserRoleEnum getUser_roles() {
		return user_roles;
	}
	public void setUserRole(AtpsUserRoleEnum user_roles) {
		this.user_roles = user_roles;
	}
	public AtpsUserEntity() {

	}
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}

