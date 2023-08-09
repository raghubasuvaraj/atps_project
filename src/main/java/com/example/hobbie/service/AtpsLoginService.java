package com.example.hobbie.service;

import java.util.List;

import com.example.hobbie.handler.InvalidCredentialsException;
import com.example.hobbie.model.binding.AtpsLoginModel;

public interface AtpsLoginService {
	List<AtpsLoginModel> getAll();
    AtpsLoginModel getByUsername(String username);
    AtpsLoginModel save(AtpsLoginModel atpsLoginModel);
    void validateLogin(String username, String password) throws InvalidCredentialsException;
}
