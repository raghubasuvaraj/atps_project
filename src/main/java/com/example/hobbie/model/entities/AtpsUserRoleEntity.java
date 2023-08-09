package com.example.hobbie.model.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.example.hobbie.model.entities.enums.AtpsUserRoleEnum;


@Entity
@Table(name = "Atpsroles")
public class AtpsUserRoleEntity extends BaseEntity{
	  private AtpsUserRoleEnum roles;
	  
	    @Enumerated(EnumType.STRING)
	    public AtpsUserRoleEnum getRole() {
	        return roles;
	    }

	  public void setRole(AtpsUserRoleEnum roles) {
	        this.roles = roles;
	    }
}
