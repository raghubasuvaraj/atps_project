package com.example.hobbie.model.binding;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.example.hobbie.model.entities.BaseEntity;
import com.example.hobbie.model.entities.enums.AtpsUserRoleEnum;
import com.sun.istack.NotNull;

public class AtpsSignupModel {
    public AtpsUserRoleEnum getUser_role() {
		return user_roles;
	}


	public void setUserRole(AtpsUserRoleEnum user_roles) {
		this.user_roles = user_roles;
	}

	private String username;
    private String email;
    private String password;
    //@Enumerated(EnumType.STRING)
    private AtpsUserRoleEnum user_roles;

    public AtpsSignupModel() {
        // Default constructor
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
